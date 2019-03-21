package net.scub.hubicc.batch.controller;

import net.scub.hubicc.batch.tools.csv.CsvBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class AbstractController<T> {


    private final Map<String, List<String>> mapUniversity;

    /**
     * Constructor.
     */
    public AbstractController() {
        this.mapUniversity = new HashMap<>();
        mapUniversity.put("poitiers", List.of("http://fr.dbpedia.org/resource/University_of_Poitiers"));
        mapUniversity.put("poitiers et limoges", List.of("http://fr.dbpedia.org/resource/University_of_Poitiers", "http://dbpedia.org/resource/University_of_Limoges"));
        mapUniversity.put("bordeaux montaigne", List.of("http://dbpedia.org/resource/Bordeaux_Montaigne_University"));
        mapUniversity.put("bordeaux", List.of("http://dbpedia.org/resource/University_of_Bordeaux_1"));
        mapUniversity.put("limoges", List.of("http://dbpedia.org/resource/University_of_Limoges"));
        mapUniversity.put("la rochelle", List.of("http://dbpedia.org/resource/University_of_La_Rochelle"));

    }


    protected void addResource(Model model, Resource resource, Property property, String uni) {
        if (StringUtils.isNotEmpty(uni))
            resource.addProperty(property, model.createResource(uni));
    }

    private void generateRdf(final String csvFilePath, final int csvLineToSkip, final Predicate<T> predicateCsv, final Consumer<ImmutablePair<Model, T>> consumer, final HttpServletResponse response) throws IOException {
        final Model model = ModelFactory.createDefaultModel();

        CsvBuilder
                .readCsvFile(csvFilePath, csvLineToSkip, getClazz())
                .stream()
                .filter(predicateCsv)
                .map(item -> new ImmutablePair(model, item))
                .forEach(pair -> consumer.accept(pair));

        try {
            model.write(response.getWriter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void addProperty(Resource resource, Property label, String field) {
        if (StringUtils.isNotEmpty(field))
            resource.addProperty(label, field.trim());
    }


    protected List<String> getUniversityResource(String university) {
        if (StringUtils.isEmpty(university)) {
            return new ArrayList<>();
        }

        final String tmpUniversity = university.trim().toLowerCase();

        if (mapUniversity.containsKey(tmpUniversity)) {
            return mapUniversity.get(tmpUniversity);
        } else {
            System.out.println(tmpUniversity);
            return new ArrayList<>();
        }
    }


    @GetMapping("/_export")
    public void laboratory(final HttpServletResponse response) throws IOException {
        final String csvFilePath = getCsvFilePath();
        final int csvLineToSkip = getCsvLineToSkip();

        generateRdf(csvFilePath, csvLineToSkip, predicateExcludeItem(), convertItemToRDF(), response);
    }


    protected abstract Class<T> getClazz();

    public abstract Consumer<ImmutablePair<Model, T>> convertItemToRDF();

    public abstract int getCsvLineToSkip();

    public abstract String getCsvFilePath();

    public abstract Predicate<T> predicateExcludeItem();
}
