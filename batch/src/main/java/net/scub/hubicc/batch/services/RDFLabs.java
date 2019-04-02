package net.scub.hubicc.batch.services;

import net.scub.hubicc.batch.model.HtmlItem;
import net.scub.hubicc.batch.model.Laboratoire;
import net.scub.hubicc.batch.tools.thymeleaf.ThymeleafBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class RDFLabs extends AbstractRDF<Laboratoire> {

    private final ThymeleafBuilder thymeleafBuilder;

    public RDFLabs(ThymeleafBuilder thymeleafBuilder) {
        super(thymeleafBuilder);
        this.thymeleafBuilder = thymeleafBuilder;
    }

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
    public String getHtmlFilePath() {
        return "html/labs";
    }

    @Override
    public Function<ImmutablePair<Model, Laboratoire>, ImmutablePair<String, List<HtmlItem>>> convertItemToRDF(final Resource typeResource) {
        return (ImmutablePair<Model, Laboratoire> pair) -> {
            final var model = pair.left;
            final var item = pair.right;

            final var aboutUrl = getICCNamespace() + "labs/";
            final var aboutUrlId = aboutUrl + item.getId();
            final var resource = model.createResource(aboutUrlId);
            resource.addProperty(RDF.type, typeResource);

            final var tmpHtmlItems = new ArrayList<HtmlItem>();

            tmpHtmlItems.add(new HtmlItem(RDF.type.getNameSpace() + RDF.type.getLocalName(), typeResource.getURI()));

            // Identité
            tmpHtmlItems.add(addProperty(resource, ORG.classification, item.getChampDeRecherche()));

            getUniversityResource(item.getUniversity()).forEach(uni -> tmpHtmlItems.add(addResource(model, resource, ORG.unitOf, uni)));

            tmpHtmlItems.add(addProperty(resource, SKOS.prefLabel, item.getIntitule()));
            tmpHtmlItems.add(addProperty(resource, SKOS.altLabel, item.getIntituleAbrege()));

            tmpHtmlItems.add(addProperty(resource, DC_11.identifier, item.getReferenceLaboratoire()));

            tmpHtmlItems.add(addProperty(resource, ORG.unitOf, item.getStructureRattachement()));
            tmpHtmlItems.add(addProperty(resource, ORG.unitOf, item.getRattachementExterne()));

            //Recherche
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "nombreChercheurs"), item.getNombreChercheurs())); // TODO
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "associationCnrs"), item.getAssociationCnrs())); // TODO

            tmpHtmlItems.add(addProperty(resource, DC_11.subject, item.getAxeRecherche1()));
            tmpHtmlItems.add(addProperty(resource, DC_11.subject, item.getAxeRecherche2()));
            tmpHtmlItems.add(addProperty(resource, DC_11.subject, item.getAxeRecherche3()));
            tmpHtmlItems.add(addProperty(resource, DC_11.subject, item.getAxeRecherche4()));
            tmpHtmlItems.add(addProperty(resource, DC_11.subject, item.getAxeRecherche5()));
            tmpHtmlItems.add(addProperty(resource, DC_11.subject, item.getAxeRecherche6()));
            tmpHtmlItems.add(addProperty(resource, DC_11.subject, item.getAxeRecherche7()));
            tmpHtmlItems.add(addProperty(resource, DC_11.subject, item.getAxeRecherche8()));

            // Coordonnées
            tmpHtmlItems.add(addProperty(resource, FOAF.name, item.getDirection()));
            tmpHtmlItems.add(addProperty(resource, VCARD4.url, item.getSiteInternet()));

            tmpHtmlItems.add(addProperty(resource, VCARD4.email, item.getCourrielSecretariat()));
            tmpHtmlItems.add(addProperty(resource, VCARD4.tel, item.getTelephone()));

            tmpHtmlItems.add(addProperty(resource, ORG.siteAddress, formatAddress(item.getAdresse(), item.getCodePostal(), item.getCommune())));

            tmpHtmlItems.add(addProperty(resource, VCARD4.street_address, item.getAdresse()));
            tmpHtmlItems.add(addProperty(resource, VCARD4.postal_code, item.getCodePostal()));
            tmpHtmlItems.add(addProperty(resource, VCARD4.region, item.getCommune()));

            tmpHtmlItems.add(addResource(model, resource, VCARD4.country_name, "http://dbpedia.org/resource/France"));

            return new ImmutablePair<>(aboutUrlId, tmpHtmlItems.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList()));
        };
    }

}
