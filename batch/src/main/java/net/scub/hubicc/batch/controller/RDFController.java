package net.scub.hubicc.batch.controller;

import net.scub.hubicc.batch.model.Laboratoire;
import net.scub.hubicc.batch.tools.csv.CsvBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rdf")
public class RDFController {

    private final Map<String, List<String>> mapUniversity;

    /**
     * Constructor.
     */
    public RDFController() {
        this.mapUniversity = new HashMap<>();
        mapUniversity.put("poitiers", List.of("http://fr.dbpedia.org/resource/University_of_Poitiers"));
        mapUniversity.put("poitiers et limoges", List.of("http://fr.dbpedia.org/resource/University_of_Poitiers", "http://dbpedia.org/resource/University_of_Limoges"));
        mapUniversity.put("bordeaux montaigne", List.of("http://dbpedia.org/resource/Bordeaux_Montaigne_University"));
        mapUniversity.put("bordeaux", List.of("http://dbpedia.org/resource/University_of_Bordeaux_1"));
        mapUniversity.put("limoges", List.of("http://dbpedia.org/resource/University_of_Limoges"));
        mapUniversity.put("la rochelle", List.of("http://dbpedia.org/resource/University_of_La_Rochelle"));

    }

    @GetMapping("/labs")
    public void laboratory(final HttpServletResponse response) throws IOException {
        final String csvFilePath = "files/INSECT-Répertoire des Laboratoires ICC.csv";
        final int csvLineToSkip = 4;

        final Consumer<ImmutablePair<Model, Laboratoire>> consumer = (ImmutablePair<Model, Laboratoire> pair) -> {
            final Model model = pair.left;
            final Laboratoire item = pair.right;

            final String aboutUrl = "http://universite.poitiers.fr/";
            final Resource resource = model.createResource(aboutUrl + item.getId());

            // Identité
            addProperty(resource, ORG.classification, item.getChampDeRecherche());

            getUniversityResource(item.getUniversity()).forEach(uni -> addResource(model, resource, ORG.unitOf, uni));

            addProperty(resource, SKOS.prefLabel, item.getIntitule());
            addProperty(resource, SKOS.altLabel, item.getIntituleAbrege());

            addProperty(resource, SKOS.prefLabel, item.getReferenceLaboratoire());

            addProperty(resource, ORG.unitOf, item.getStructureRattachement());
            addProperty(resource, ORG.unitOf, item.getRattachementExterne());

            //Recherche
            addProperty(resource, RDFS.label, item.getNombreChercheurs()); // TODO
            addProperty(resource, RDFS.label, item.getAssociationCnrs()); // TODO
            addProperty(resource, RDFS.label, item.getAxeRecherche1()); // TODO
            addProperty(resource, RDFS.label, item.getAxeRecherche2()); // TODO
            addProperty(resource, RDFS.label, item.getAxeRecherche3()); // TODO
            addProperty(resource, RDFS.label, item.getAxeRecherche4()); // TODO
            addProperty(resource, RDFS.label, item.getAxeRecherche5()); // TODO
            addProperty(resource, RDFS.label, item.getAxeRecherche6()); // TODO
            addProperty(resource, RDFS.label, item.getAxeRecherche7()); // TODO
            addProperty(resource, RDFS.label, item.getAxeRecherche8()); // TODO

            // Coordonnées
            addProperty(resource, FOAF.name, item.getDirection());
            addProperty(resource, VCARD4.url, item.getSiteInternet());

            addProperty(resource, VCARD4.email, item.getCourrielSecretariat());
            addProperty(resource, VCARD4.tel, item.getTelephone());

            final String address = List.of(item.getAdresse(), item.getCodePostal(), item.getCommune())
                    .stream()
                    .filter(StringUtils::isNoneEmpty)
                    .collect(Collectors.joining(" "));

            addProperty(resource, ORG.siteAddress, address);


            addResource(model, resource, VCARD4.country_name, "http://dbpedia.org/resource/France");

        };

        generateRdf(Laboratoire.class, csvFilePath, csvLineToSkip, (Laboratoire lab) -> StringUtils.isNotEmpty(lab.getUniversity()), consumer, response);
    }

    private void addResource(Model model, Resource resource, Property property, String uni) {
        if (StringUtils.isNotEmpty(uni))
            resource.addProperty(property, model.createResource(uni));
    }

    /**
     * Generate rdf.
     *
     * @param csvClazz      cvs class
     * @param csvFilePath   csv file path
     * @param csvLineToSkip csv line to skip
     * @param <T>           object with csv annotation
     * @return string
     * @throws IOException
     */
    private <T> void generateRdf(final Class<T> csvClazz, final String csvFilePath, final int csvLineToSkip, final Predicate<T> predicateCsv, final Consumer<ImmutablePair<Model, T>> consumer, final HttpServletResponse response) throws IOException {
        final Model model = ModelFactory.createDefaultModel();

        CsvBuilder
                .readCsvFile(csvFilePath, csvLineToSkip, csvClazz)
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

    private void addProperty(Resource resource, Property label, String field) {
        if (StringUtils.isNotEmpty(field))
            resource.addProperty(label, field.trim());
    }


    private List<String> getUniversityResource(String university) {
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

}
