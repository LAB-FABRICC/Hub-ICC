package net.scub.hubicc.batch.controller;

import net.scub.hubicc.batch.model.Formation;
import net.scub.hubicc.batch.model.Formation;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class RDFFormation extends AbstractRDF<Formation> {

    @Override
    protected String getRDFFileName() {
        return "generatedOwl/rdf-formations";
    }

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
    public Consumer<ImmutablePair<Model, Formation>> convertItemToRDF() {
        return (ImmutablePair<Model, Formation> pair) -> {
            final Model model = pair.left;
            final Formation item = pair.right;

            final String aboutUrl = "http://universite.poitiers.fr/formation/";
            final Resource resource = model.createResource(aboutUrl + item.getId());

            getUniversityResource(item.getUniversity()).forEach(uni -> addResource(model, resource, ORG.unitOf, uni));

            addProperty(resource, SKOS.prefLabel, item.getIntitule());

            addProperty(resource, RDFS.label, item.getNiveau()); // TODO
            addProperty(resource, RDFS.label, item.getDomaineDiplome()); // TODO 
            addProperty(resource, RDFS.label, item.getMentionDiplome()); // TODO
            addProperty(resource, RDFS.label, item.getSpecialiteDiplome()); // TODO
            addProperty(resource, RDFS.label, item.getParcoursDiplome()); // TODO
            addProperty(resource, RDFS.label, item.getLieuFormation()); // TODO
            addProperty(resource, RDFS.label, item.getFormationInitiale()); // TODO
            addProperty(resource, RDFS.label, item.getFormationContinue()); // TODO
            addProperty(resource, RDFS.label, item.getContratApprentissage()); // TODO
            addProperty(resource, RDFS.label, item.getContratProfessionnalisation()); // TODO
            addProperty(resource, RDFS.label, item.getVoieRecherche()); // TODO
            addProperty(resource, RDFS.label, item.getTypeDeStage()); // TODO
            addProperty(resource, RDFS.label, item.getDureeStage()); // TODO
            addProperty(resource, RDFS.label, item.getDateDebut()); // TODO
            addProperty(resource, RDFS.label, item.getDateFinObligatoire()); // TODO
            addProperty(resource, RDFS.label, item.getServiceStageEmploi()); // TODO

            addProperty(resource, VCARD4.url, item.getSiteInternetStageEmploi());

            addProperty(resource, RDFS.label, item.getExempleSujetMemoire1()); // TODO
            addProperty(resource, RDFS.label, item.getExempleSujetMemoire2()); // TODO
            addProperty(resource, RDFS.label, item.getExempleSujetMemoire3()); // TODO

            addProperty(resource, FOAF.name, item.getResponsablePedagogique());

            addProperty(resource, VCARD4.email, item.getCourrielSecretariatFormation());

            addProperty(resource, VCARD4.tel, item.getTelephone());
            addProperty(resource, ORG.siteAddress, formatAddress(item.getAdresse(), item.getCodePostal(), item.getCommune()));

            addProperty(resource, VCARD4.url, item.getSiteInternet());

            addProperty(resource, ORG.unitOf, item.getRattachementLaboratoire1());
            addProperty(resource, ORG.unitOf, item.getRattachementLaboratoire2());
            addProperty(resource, ORG.unitOf, item.getRattachementLaboratoire3());

            addProperty(resource, RDFS.label, item.getInformationsComplementaires()); // TODO

            addResource(model, resource, VCARD4.country_name, "http://dbpedia.org/resource/France");

        };
    }
}
