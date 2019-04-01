package net.scub.hubicc.batch.services;

import net.scub.hubicc.batch.model.Formation;
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
public class RDFFormation extends AbstractRDF<Formation> {

    @Override
    public Optional<Character> getDelimiter() {
        return Optional.of(';');
    }

    @Override
    protected Class<Formation> getClazz() {
        return Formation.class;
    }

    @Override
    public int getCsvLineToSkip() {
        return 4;
    }

    @Override
    public String getCsvFilePath() {
        return "files/INSECT-Répertoire des Formations M2 ICC.csv";
    }

    @Override
    public Predicate<Formation> predicateExcludeItem() {
        return (Formation lab) -> StringUtils.isNotEmpty(lab.getUniversity());
    }

    @Override
    public Consumer<ImmutablePair<Model, Formation>> convertItemToRDF(final Resource typeResource) {
        return (ImmutablePair<Model, Formation> pair) -> {
            final var model = pair.left;
            final var item = pair.right;

            final var aboutUrl = getICCNamespace() + "formation/";
            final var resource = model.createResource(aboutUrl + item.getId());

            resource.addProperty(RDF.type, typeResource);

            final var dboCity = model.createProperty("http://dbpedia.org/ontology/city");

            getUniversityResource(item.getUniversity()).forEach(uni -> addResource(model, resource, ORG.unitOf, uni));

            addProperty(resource, SKOS.prefLabel, item.getIntitule());

            addProperty(resource, ORG.classification, item.getNiveau());
            addProperty(resource, ORG.classification, item.getDomaineDiplome());
            addProperty(resource, ORG.classification, item.getMentionDiplome());
            addProperty(resource, ORG.classification, item.getSpecialiteDiplome());
            addProperty(resource, ORG.classification, item.getParcoursDiplome());

            getCityResource(item.getLieuFormation()).forEach(uni -> addResource(model, resource, dboCity, uni));

            final var propertyFormationInitiale = unknowProperty(model, "formationInitiale");
            final var propertyFormationContinue = unknowProperty(model, "formationContinue");
            final var propertyContratApprentissage = unknowProperty(model, "contratApprentissage");
            final var propertyContratProfessionnalisation = unknowProperty(model, "contratProfessionnalisation");
            final var propertyVoieRecherche = unknowProperty(model, "voieRecherche");

            addProperty(resource, propertyFormationInitiale, item.getFormationInitiale()); // TODO
            addProperty(resource, propertyFormationContinue, item.getFormationContinue()); // TODO
            addProperty(resource, propertyContratApprentissage, item.getContratApprentissage()); // TODO
            addProperty(resource, propertyContratProfessionnalisation, item.getContratProfessionnalisation()); // TODO
            addProperty(resource, propertyVoieRecherche, item.getVoieRecherche()); // TODO

            final var propertyTypeDeStage = unknowProperty(model, "typeDeStage");
            final var propertyDureeStage = unknowProperty(model, "dureeStage");
            final var propertyDateDebut = unknowProperty(model, "dateDebut");
            final var propertyDateFinObligatoire = unknowProperty(model, "dateFinObligatoire");
            final var propertyServiceStageEmploi = unknowProperty(model, "serviceStageEmploi");

            addProperty(resource, propertyTypeDeStage, item.getTypeDeStage()); // TODO
            addProperty(resource, propertyDureeStage, item.getDureeStage()); // TODO
            addProperty(resource, propertyDateDebut, item.getDateDebut()); // TODO
            addProperty(resource, propertyDateFinObligatoire, item.getDateFinObligatoire()); // TODO
            addProperty(resource, propertyServiceStageEmploi, item.getServiceStageEmploi()); // TODO

            addProperty(resource, VCARD4.url, item.getSiteInternetStageEmploi());

            addProperty(resource, DC_11.subject, item.getExempleSujetMemoire1());
            addProperty(resource, DC_11.subject, item.getExempleSujetMemoire2());
            addProperty(resource, DC_11.subject, item.getExempleSujetMemoire3());

            addProperty(resource, FOAF.name, item.getResponsablePedagogique());

            addProperty(resource, VCARD4.email, item.getCourrielSecretariatFormation());

            addProperty(resource, VCARD4.tel, item.getTelephone());
            addProperty(resource, ORG.siteAddress, formatAddress(item.getAdresse(), item.getCodePostal(), item.getCommune()));

            addProperty(resource, VCARD4.street_address, item.getAdresse());
            addProperty(resource, VCARD4.postal_code, item.getCodePostal());
            addProperty(resource, VCARD4.region, item.getCommune());

            addProperty(resource, VCARD4.url, item.getSiteInternet());

            addProperty(resource, ORG.unitOf, item.getRattachementLaboratoire1());
            addProperty(resource, ORG.unitOf, item.getRattachementLaboratoire2());
            addProperty(resource, ORG.unitOf, item.getRattachementLaboratoire3());

            final var propertyInformationsComplementaires = unknowProperty(model, "informationsComplementaires");

            addProperty(resource, propertyInformationsComplementaires, item.getInformationsComplementaires()); // TODO

            addResource(model, resource, VCARD4.country_name, "http://dbpedia.org/resource/France");

        };
    }
}
