package net.scub.hubicc.batch.services;

import net.scub.hubicc.batch.model.Laboratoire;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.*;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Component
public class RDFLabs extends AbstractRDF<Laboratoire> {

    @Override
    public Optional<Character> getDelimiter() {
        return Optional.of(';');
    }

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
    public Consumer<ImmutablePair<Model, Laboratoire>> convertItemToRDF(final Resource typeResource) {
        return (ImmutablePair<Model, Laboratoire> pair) -> {
            final var model = pair.left;
            final var item = pair.right;

            final var propertyNombreChercheurs = unknowProperty(model, "nombreChercheurs");
            final var propertyAssociationCnrs = unknowProperty(model, "associationCnrs");

            final var aboutUrl = getICCNamespace() + "labs/";
            final var resource = model.createResource(aboutUrl + item.getId());
            resource.addProperty(RDF.type, typeResource);

            // Identité
            addProperty(resource, ORG.classification, item.getChampDeRecherche());

            getUniversityResource(item.getUniversity()).forEach(uni -> addResource(model, resource, ORG.unitOf, uni));

            addProperty(resource, SKOS.prefLabel, item.getIntitule());
            addProperty(resource, SKOS.altLabel, item.getIntituleAbrege());

            addProperty(resource, DC_11.identifier, item.getReferenceLaboratoire());

            addProperty(resource, ORG.unitOf, item.getStructureRattachement());
            addProperty(resource, ORG.unitOf, item.getRattachementExterne());

            //Recherche
            addProperty(resource, propertyNombreChercheurs, item.getNombreChercheurs()); // TODO
            addProperty(resource, propertyAssociationCnrs, item.getAssociationCnrs()); // TODO

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

            addProperty(resource, ORG.siteAddress, formatAddress(item.getAdresse(), item.getCodePostal(), item.getCommune()));

            addProperty(resource, VCARD4.street_address, item.getAdresse());
            addProperty(resource, VCARD4.postal_code, item.getCodePostal());
            addProperty(resource, VCARD4.region, item.getCommune());

            addResource(model, resource, VCARD4.country_name, "http://dbpedia.org/resource/France");


        };
    }

}
