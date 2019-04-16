package net.scub.hubicc.batch.services;

import net.scub.hubicc.batch.model.BiblioCad;
import net.scub.hubicc.batch.model.HtmlItem;
import net.scub.hubicc.batch.tools.thymeleaf.ThymeleafBuilder;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.VCARD4;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class RDFBiblio extends AbstractRDF<BiblioCad> {
    private final ThymeleafBuilder thymeleafBuilder;

    public RDFBiblio(ThymeleafBuilder thymeleafBuilder) {
        super(thymeleafBuilder);
        this.thymeleafBuilder = thymeleafBuilder;
    }

    @Override
    public String getHtmlFilePath() {
        return "html/biblio";
    }

    @Override
    public Optional<Character> getDelimiter() {
        return Optional.of(';');
    }

    @Override
    protected Class<BiblioCad> getClazz() {
        return BiblioCad.class;
    }

    @Override
    public int getCsvLineToSkip() {
        return 1;
    }

    @Override
    public String getCsvFilePath() {
        return "files/biblio_cad.csv";
    }

    @Override
    public Predicate<BiblioCad> predicateExcludeItem() {
        return (BiblioCad biblioCad) -> true;
    }

    @Override
    public Function<ImmutablePair<Model, BiblioCad>, ImmutablePair<String, List<HtmlItem>>> convertItemToRDF(final Resource typeResource) {
        return (ImmutablePair<Model, BiblioCad> pair) -> {
            final var model = pair.left;
            final var item = pair.right;

            final var aboutUrl = getICCNamespace() + "biblio/";
            final var aboutUrlId = aboutUrl + item.getKey();
            final var resource = model.createResource(aboutUrlId);

            resource.addProperty(RDF.type, typeResource);

            final var tmpHtmlItems = new ArrayList<HtmlItem>();

            tmpHtmlItems.add(new HtmlItem(RDF.type.getNameSpace() + RDF.type.getLocalName(), typeResource.getURI()));


            final var biboDoi = model.createProperty("http://purl.org/ontology/bibo/doi");
            final var biboEissn = model.createProperty("http://purl.org/ontology/bibo/eIssn");
            final var biboIsbn = model.createProperty("http://purl.org/ontology/bibo/isbn");
            final var biboCreated = model.createProperty("http://purl.org/ontology/bibo/created");

            tmpHtmlItems.add(addProperty(resource, DC.identifier, item.getKey()));
            tmpHtmlItems.add(addProperty(resource, DCTerms.type, item.getItemType()));

            tmpHtmlItems.add(addProperty(resource, DCTerms.created, item.getPublicationYear()));
            tmpHtmlItems.add(addProperty(resource, DCTerms.creator, item.getAuthor()));
            tmpHtmlItems.add(addProperty(resource, DCTerms.title, item.getTitle()));
            tmpHtmlItems.add(addProperty(resource, DCTerms.title, item.getPublicationTitle()));

            tmpHtmlItems.add(addProperty(resource, biboIsbn, item.getISBN()));
            tmpHtmlItems.add(addProperty(resource, biboEissn, item.getISSN()));
            tmpHtmlItems.add(addProperty(resource, biboDoi, item.getDOI()));

            tmpHtmlItems.add(addProperty(resource, VCARD4.url, item.getUrl()));
            tmpHtmlItems.add(addProperty(resource, DCTerms.abstract_, item.getAbstractNote()));
            tmpHtmlItems.add(addProperty(resource, biboCreated, item.getDate()));
            tmpHtmlItems.add(addProperty(resource, DCTerms.alternative, item.getShortTitle()));
            tmpHtmlItems.add(addProperty(resource, DCTerms.language, item.getLanguage()));
            tmpHtmlItems.add(addProperty(resource, FOAF.name, item.getContributor()));
            tmpHtmlItems.add(addProperty(resource, DCTerms.creator, item.getBookAuthor()));

            return new ImmutablePair<>(aboutUrlId, tmpHtmlItems.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList()));

        };
    }
}
