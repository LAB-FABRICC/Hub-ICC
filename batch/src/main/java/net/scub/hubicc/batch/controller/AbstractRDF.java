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

    /**
     * Constructor.
     */
    public AbstractRDF() {
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


    protected List<String> getUniversityResource(String university) {
        if (StringUtils.isEmpty(university)) {
            return new ArrayList<>();
        }

        final String tmpUniversity = university.trim().toLowerCase();

        if (mapUniversity.containsKey(tmpUniversity)) {
            return mapUniversity.get(tmpUniversity);
        } else {
            System.out.println("not managed university : " + tmpUniversity);
            return new ArrayList<>();
        }
    }

    public Property unknowProperty(Model model, String propertyName) {
        return model.createProperty("http://unknow-property.fr#" + propertyName);
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
