package net.scub.hubicc.batch.controller;

import net.scub.hubicc.batch.tools.csv.CsvBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class AbstractRDF<T> {


    private final Map<String, List<String>> mapUniversity;
    private final Map<String, List<String>> mapCity;

    /**
     * Constructor.
     */
    public AbstractRDF() {
        this.mapCity = new HashMap<>();

        this.mapCity.put("angoulême", List.of("http://dbpedia.org/resource/Angoulême"));
        this.mapCity.put("poitiers", List.of("http://dbpedia.org/resource/Poitiers"));
        this.mapCity.put("paris", List.of("http://dbpedia.org/resource/Paris"));
        this.mapCity.put("la rochelle", List.of("http://dbpedia.org/resource/La_Rochelle"));
        this.mapCity.put("limoges", List.of("http://dbpedia.org/resource/Limoges"));
        this.mapCity.put("bordeaux", List.of("http://dbpedia.org/resource/Bordeaux"));
        this.mapCity.put("pessac", List.of("http://dbpedia.org/resource/Pessac"));
        this.mapCity.put("pau", List.of("http://dbpedia.org/resource/Pau"));
        
        this.mapUniversity = new HashMap<>();
        final String poitiers = "http://fr.dbpedia.org/resource/University_of_Poitiers";
        final String laRochelle = "http://dbpedia.org/resource/University_of_La_Rochelle";

        mapUniversity.put("poitiers", List.of(poitiers));
        mapUniversity.put("poitiers et limoges", List.of(poitiers, "http://dbpedia.org/resource/University_of_Limoges"));
        mapUniversity.put("bordeaux montaigne", List.of("http://dbpedia.org/resource/Bordeaux_Montaigne_University"));
        mapUniversity.put("bordeaux", List.of("http://dbpedia.org/resource/University_of_Bordeaux_1"));
        mapUniversity.put("limoges", List.of("http://dbpedia.org/resource/University_of_Limoges"));
        mapUniversity.put("la rochelle", List.of(laRochelle));

//        mapUniversity.put("cnam, cfa poitiers", List.of(""));
//        mapUniversity.put("cnam, gobelins", List.of(""));
//        mapUniversity.put("cnam", List.of(""));
        mapUniversity.put("la rochelle, poitiers, cnam", List.of(laRochelle, poitiers));
//        mapUniversity.put("pau et pays de l'adour", List.of(""));


    }

    protected String getICCNamespace() {
        return "http://fabricc.univ-poitiers.fr/";
    }

    protected String formatAddress(String adresse, String codePostal, String commune) {
        final Function<String, String> toString = (String item) -> Optional.ofNullable(item).orElse("");

        return List.of(
                toString.apply(adresse),
                toString.apply(codePostal),
                toString.apply(commune)
        )
                .stream()
                .filter(StringUtils::isNoneEmpty)
                .collect(Collectors.joining(" "));
    }


    protected void addResource(Model model, Resource resource, Property property, String uni) {
        if (StringUtils.isNotEmpty(uni))
            resource.addProperty(property, model.createResource(uni));
    }

    private void generateRdf(final String csvFilePath, final int csvLineToSkip, final Predicate<T> predicateCsv, final Consumer<ImmutablePair<Model, T>> consumer) throws IOException {
        var model = ModelFactory.createDefaultModel();

        CsvBuilder
                .readCsvFile(csvFilePath, getDelimiter(), csvLineToSkip, getClazz())
                .stream()
                .filter(predicateCsv)
                .map(item -> new ImmutablePair(model, item))
                .forEach(consumer::accept);

        model.write(new FileWriter(getRDFFileName() + ".owl"));
    }

    protected abstract String getRDFFileName();

    public abstract Optional<Character> getDelimiter();

    protected void addProperty(Resource resource, Property property, String field) {
        if (StringUtils.isNotEmpty(field))
            resource.addProperty(property, field.trim());
    }

    protected void addProperty(Resource resource, Property property, Boolean field) {
        if (field != null)
            resource.addProperty(property, field.toString(), XSDDatatype.XSDboolean);
    }

    protected void addProperty(Resource resource, Property property, Integer field) {
        if (field != null)
            resource.addProperty(property, field.toString(), XSDDatatype.XSDinteger);
    }

    protected void addProperty(Resource resource, Property property, Date field) {
        if (field != null)
            resource.addProperty(property, field.toString(), XSDDatatype.XSDdate);
    }


    protected List<String> getUniversityResource(String university) {
        return getValueFromMap(university, mapUniversity, "not managed university : ");
    }

    protected List<String> getCityResource(String city) {
        return getValueFromMap(city, mapCity, "not managed city : ");
    }

    private List<String> getValueFromMap(String city, Map<String, List<String>> mapCity, String s) {
        if (StringUtils.isEmpty(city)) {
            return new ArrayList<>();
        }

        final String tmpCity = city.trim().toLowerCase();

        if (mapCity.containsKey(tmpCity)) {
            return mapCity.get(tmpCity);
        } else {
            System.out.println(s + tmpCity);
            return new ArrayList<>();
        }
    }

    public Property unknowProperty(Model model, String propertyName) {
        return model.createProperty(getICCNamespace() + "#" + propertyName);
    }

    public void export() throws IOException {
        var csvFilePath = getCsvFilePath();
        var csvLineToSkip = getCsvLineToSkip();

        generateRdf(csvFilePath, csvLineToSkip, predicateExcludeItem(), convertItemToRDF());
    }


    protected abstract Class<T> getClazz();

    public abstract Consumer<ImmutablePair<Model, T>> convertItemToRDF();

    public abstract int getCsvLineToSkip();

    public abstract String getCsvFilePath();

    public abstract Predicate<T> predicateExcludeItem();
}
