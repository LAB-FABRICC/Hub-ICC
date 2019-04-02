package net.scub.hubicc.batch.services;

import net.scub.hubicc.batch.model.HtmlItem;
import net.scub.hubicc.batch.tools.csv.CsvBuilder;
import net.scub.hubicc.batch.tools.thymeleaf.ThymeleafBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class AbstractRDF<T> {


    private final Map<String, List<String>> mapUniversity;
    private final Map<String, List<String>> mapCity;

    private final ThymeleafBuilder thymeleafBuilder;

    /**
     * Constructor.
     *
     * @param thymeleafBuilder
     */
    public AbstractRDF(ThymeleafBuilder thymeleafBuilder) {
        this.thymeleafBuilder = thymeleafBuilder;
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

    public String getICCNamespace() {
        return "http://fabricc.univ-poitiers.fr/def/";
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


    protected HtmlItem addResource(Model model, Resource resource, Property property, String uni) {
        if (StringUtils.isNotEmpty(uni)) {
            resource.addProperty(property, model.createResource(uni));
            return new HtmlItem(property.getNameSpace() + property.getLocalName(), uni);
        }

        return null;
    }

    private void generateRdf(final Model model, final String csvFilePath, final int csvLineToSkip, final Predicate<T> predicateCsv, final Function<ImmutablePair<Model, T>, ImmutablePair<String, List<HtmlItem>>> consumer) throws IOException {
        CsvBuilder
                .readCsvFile(csvFilePath, getDelimiter(), csvLineToSkip, getClazz())
                .stream()
                .filter(predicateCsv)
                .map(item -> new ImmutablePair(model, item))
                .map(pair -> (ImmutablePair<String, List<HtmlItem>>) consumer.apply(pair))
                .forEach(pair -> {
                    final var aboutUrlId = pair.left;
                    final String template = thymeleafBuilder.buildTemplate(aboutUrlId, pair.right);

                    final String fileName = aboutUrlId.substring(aboutUrlId.lastIndexOf("/"));

                    try {
                        final var file = new File("target/" + getHtmlFilePath() );
                        file.mkdirs();

                        var fileWriter = new FileWriter("target/" + getHtmlFilePath() + fileName);
                        fileWriter.write(template);

                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    public abstract Optional<Character> getDelimiter();

    protected HtmlItem addProperty(Resource resource, Property property, String field) {
        if (StringUtils.isNotEmpty(field)) {
            resource.addProperty(property, field.trim());

            return new HtmlItem(property.getNameSpace() + property.getLocalName(), field.trim());
        }

        return null;
    }

    protected HtmlItem addProperty(Resource resource, Property property, Boolean field) {
        if (field != null) {
            resource.addProperty(property, field.toString(), XSDDatatype.XSDboolean);

            return new HtmlItem(property.getNameSpace() + property.getLocalName(), field.toString());
        }

        return null;
    }

    protected HtmlItem addProperty(Resource resource, Property property, Integer field) {
        if (field != null) {
            resource.addProperty(property, field.toString(), XSDDatatype.XSDinteger);

            return new HtmlItem(property.getNameSpace() + property.getLocalName(), field.toString());
        }

        return null;
    }

    protected HtmlItem addProperty(Resource resource, Property property, Date field) {
        if (field != null) {
            final var dateFormated = new SimpleDateFormat("YYYY-MM-dd").format(field);
            resource.addProperty(property, dateFormated, XSDDatatype.XSDdate);
            return new HtmlItem(property.getNameSpace() + property.getLocalName(), dateFormated);
        }

        return null;
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

        final var tmpCity = city.trim().toLowerCase();

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

    public void export(final Model model, final Resource typeResource) throws IOException {
        final var csvFilePath = getCsvFilePath();
        final var csvLineToSkip = getCsvLineToSkip();

        generateRdf(model, csvFilePath, csvLineToSkip, predicateExcludeItem(), convertItemToRDF(typeResource));
    }


    protected abstract Class<T> getClazz();

    public abstract Function<ImmutablePair<Model, T>, ImmutablePair<String, List<HtmlItem>>> convertItemToRDF(final Resource typeResource);

    public abstract int getCsvLineToSkip();

    public abstract String getCsvFilePath();

    public abstract Predicate<T> predicateExcludeItem();

    public abstract String getHtmlFilePath();
}
