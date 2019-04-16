package net.scub.hubicc.batch.services;

import net.scub.hubicc.batch.model.Formation;
import net.scub.hubicc.batch.model.HtmlItem;
import net.scub.hubicc.batch.tools.thymeleaf.ThymeleafBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class RDFFormation extends AbstractRDF<Formation> {
    private final ThymeleafBuilder thymeleafBuilder;

    public RDFFormation(ThymeleafBuilder thymeleafBuilder) {
        super(thymeleafBuilder);
        this.thymeleafBuilder = thymeleafBuilder;
    }

    @Override
    public String getHtmlFilePath() {
        return "html/formation";
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
    public Function<ImmutablePair<Model, Formation>, ImmutablePair<String, List<HtmlItem>>> convertItemToRDF(final Resource typeResource) {
        return (ImmutablePair<Model, Formation> pair) -> {
            final var model = pair.left;
            final var item = pair.right;

            final var aboutUrl = getICCNamespace() + "formation/";
            final var aboutUrlId = aboutUrl + item.getId();
            final var resource = model.createResource(aboutUrlId);

            resource.addProperty(RDF.type, typeResource);

            final var tmpHtmlItems = new ArrayList<HtmlItem>();

            tmpHtmlItems.add(new HtmlItem(RDF.type.getNameSpace() + RDF.type.getLocalName(), typeResource.getURI()));

            final var dboCity = model.createProperty("http://dbpedia.org/ontology/city");

            getUniversityResource(item.getUniversity()).forEach(uni -> tmpHtmlItems.add(addResource(model, resource, ORG.unitOf, uni)));

            tmpHtmlItems.add(addProperty(resource, SKOS.prefLabel, item.getIntitule()));

            tmpHtmlItems.add(addProperty(resource, ORG.classification, item.getNiveau()));
            tmpHtmlItems.add(addProperty(resource, ORG.classification, item.getDomaineDiplome()));
            tmpHtmlItems.add(addProperty(resource, ORG.classification, item.getMentionDiplome()));
            tmpHtmlItems.add(addProperty(resource, ORG.classification, item.getSpecialiteDiplome()));
            tmpHtmlItems.add(addProperty(resource, ORG.classification, item.getParcoursDiplome()));

            getCityResource(item.getLieuFormation()).forEach(uni -> tmpHtmlItems.add(addResource(model, resource, dboCity, uni)));

            final var propertyFormationInitiale = unknowProperty(model, "formationInitiale");
            final var propertyFormationContinue = unknowProperty(model, "formationContinue");
            final var propertyContratApprentissage = unknowProperty(model, "contratApprentissage");
            final var propertyContratProfessionnalisation = unknowProperty(model, "contratProfessionnalisation");

            tmpHtmlItems.add(addProperty(resource, propertyFormationInitiale, item.getFormationInitiale())); // TODO
            tmpHtmlItems.add(addProperty(resource, propertyFormationContinue, item.getFormationContinue())); // TODO
            tmpHtmlItems.add(addProperty(resource, propertyContratApprentissage, item.getContratApprentissage())); // TODO
            tmpHtmlItems.add(addProperty(resource, propertyContratProfessionnalisation, item.getContratProfessionnalisation())); // TODO

            final var propertyDureeMinStage = unknowProperty(model, "dureeMinStage");
            final var propertyDureeMaxStage = unknowProperty(model, "dureeMaxStage");

            tmpHtmlItems.add(addProperty(resource, propertyDureeMinStage, item.getDureeMinStage())); // TODO
            tmpHtmlItems.add(addProperty(resource, propertyDureeMaxStage, item.getDureeMaxStage())); // TODO

            tmpHtmlItems.add(addProperty(resource, VCARD4.url, item.getCoordonneesServiceStage()));

            tmpHtmlItems.add(addProperty(resource, FOAF.name, item.getResponsablePedagogique()));

            tmpHtmlItems.add(addProperty(resource, VCARD4.email, item.getCourrielSecretariatFormation()));

            tmpHtmlItems.add(addProperty(resource, VCARD4.tel, item.getTelephone()));
            tmpHtmlItems.add(addProperty(resource, ORG.siteAddress, formatAddress(item.getAdresse(), item.getCodePostal(), item.getCommune())));

            tmpHtmlItems.add(addProperty(resource, VCARD4.street_address, item.getAdresse()));
            tmpHtmlItems.add(addProperty(resource, VCARD4.postal_code, item.getCodePostal()));
            tmpHtmlItems.add(addProperty(resource, VCARD4.region, item.getCommune()));

            tmpHtmlItems.add(addProperty(resource, VCARD4.url, item.getSiteInternet()));

            tmpHtmlItems.add(addProperty(resource, ORG.unitOf, item.getRattachementLaboratoire1()));
            tmpHtmlItems.add(addProperty(resource, ORG.unitOf, item.getRattachementLaboratoire2()));
            tmpHtmlItems.add(addProperty(resource, ORG.unitOf, item.getRattachementLaboratoire3()));

            final var propertyInformationsComplementaires = unknowProperty(model, "informationsComplementaires");

            tmpHtmlItems.add(addProperty(resource, propertyInformationsComplementaires, item.getInformationsComplementaires())); // TODO

            tmpHtmlItems.add(addResource(model, resource, VCARD4.country_name, "http://dbpedia.org/resource/France"));

            final var propertyCompetenceUniversitaire = unknowProperty(model, "competenceUniversitaire");
            final var propertyCompetencePro = unknowProperty(model, "competencePro");
            final var propertyMetier = unknowProperty(model, "metier");

            buildList(
                    item.getCompetenceUniversitaire1(),
                    item.getCompetenceUniversitaire2(),
                    item.getCompetenceUniversitaire3(),
                    item.getCompetenceUniversitaire4(),
                    item.getCompetenceUniversitaire5(),
                    item.getCompetenceUniversitaire6(),
                    item.getCompetenceUniversitaire7(),
                    item.getCompetenceUniversitaire8(),
                    item.getCompetenceUniversitaire9(),
                    item.getCompetenceUniversitaire10()
            ).forEach(competence ->
                    tmpHtmlItems.add(addProperty(resource, propertyCompetenceUniversitaire, competence))
            );

            buildList(
                    item.getCompetencePro1(),
                    item.getCompetencePro2(),
                    item.getCompetencePro3(),
                    item.getCompetencePro4(),
                    item.getCompetencePro5(),
                    item.getCompetencePro6(),
                    item.getCompetencePro7(),
                    item.getCompetencePro8(),
                    item.getCompetencePro9(),
                    item.getCompetencePro10()
            ).forEach(competence ->
                    tmpHtmlItems.add(addProperty(resource, propertyCompetencePro, competence))
            );

            buildList(
                    item.getMetierVise1(),
                    item.getMetierVise2(),
                    item.getMetierVise3(),
                    item.getMetierVise4(),
                    item.getMetierVise5()
            ).forEach(metier ->
                    tmpHtmlItems.add(addProperty(resource, propertyMetier, metier))
            );


            return new ImmutablePair<>(aboutUrlId, tmpHtmlItems.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList()));

        };
    }

    private List<String> buildList(String... items) {
        return Arrays.stream(items)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
