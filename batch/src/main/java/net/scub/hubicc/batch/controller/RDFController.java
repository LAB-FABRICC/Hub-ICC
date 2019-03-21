package net.scub.hubicc.batch.controller;

import net.scub.hubicc.batch.model.Laboratoire;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rdf/labs")
public class RDFController extends AbstractController<Laboratoire> {

    @Override
    protected Class<Laboratoire> getClazz() {
        return Laboratoire.class;
    }

    @Override
    public int getCsvLineToSkip() {
        return 4;
    }

    @Override
    public String getCsvFilePath() {
        return "files/INSECT-Répertoire des Laboratoires ICC.csv";
    }

    @Override
    public Predicate<Laboratoire> predicateExcludeItem() {
        return (Laboratoire lab) -> StringUtils.isNotEmpty(lab.getUniversity());
    }

    @Override
    public Consumer<ImmutablePair<Model, Laboratoire>> convertItemToRDF() {
        return (ImmutablePair<Model, Laboratoire> pair) -> {
            final Model model = pair.left;
            final Laboratoire item = pair.right;

            final String aboutUrl = "http://universite.poitiers.fr/";
            final Resource resource = model.createResource(aboutUrl + item.getId());

            // Identité
            addProperty(resource, ORG.classification, item.getChampDeRecherche());

            getUniversityResource(item.getUniversity()).forEach(uni -> addResource(model, resource, ORG.unitOf, uni));

            addProperty(resource, SKOS.prefLabel, item.getIntitule());
            addProperty(resource, SKOS.altLabel, item.getIntituleAbrege());

            addProperty(resource, DC_11.identifier, item.getReferenceLaboratoire());

            addProperty(resource, ORG.unitOf, item.getStructureRattachement());
            addProperty(resource, ORG.unitOf, item.getRattachementExterne());

            //Recherche
            addProperty(resource, RDFS.label, item.getNombreChercheurs()); // TODO
            addProperty(resource, RDFS.label, item.getAssociationCnrs()); // TODO

            addProperty(resource, DC_11.subject, item.getAxeRecherche1());
            addProperty(resource, DC_11.subject, item.getAxeRecherche2());
            addProperty(resource, DC_11.subject, item.getAxeRecherche3());
            addProperty(resource, DC_11.subject, item.getAxeRecherche4());
            addProperty(resource, DC_11.subject, item.getAxeRecherche5());
            addProperty(resource, DC_11.subject, item.getAxeRecherche6());
            addProperty(resource, DC_11.subject, item.getAxeRecherche7());
            addProperty(resource, DC_11.subject, item.getAxeRecherche8());

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
    }
}
