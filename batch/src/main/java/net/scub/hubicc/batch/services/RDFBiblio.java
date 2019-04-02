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
        return Optional.of(',');
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

            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "dateAdded"), item.getDateAdded())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "dateModified"), item.getDateModified())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "accessDate"), item.getAccessDate())); // TODO 

            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "pages"), item.getPages())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "numPages"), item.getNumPages())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "issue"), item.getIssue())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "volume"), item.getVolume())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "numberOfVolumes"), item.getNumberOfVolumes())); // TODO 

            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "journalAbbreviation"), item.getJournalAbbreviation())); // TODO 

            tmpHtmlItems.add(addProperty(resource, DCTerms.alternative, item.getShortTitle()));

            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "series"), item.getSeries())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "seriesNumber"), item.getSeriesNumber())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "seriesText"), item.getSeriesText())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "seriesTitle"), item.getSeriesTitle())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "publisher"), item.getPublisher())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "place"), item.getPlace())); // TODO 

            tmpHtmlItems.add(addProperty(resource, DCTerms.language, item.getLanguage()));

            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "rights"), item.getRights())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "type"), item.getType())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "archive"), item.getArchive())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "archiveLocation"), item.getArchiveLocation())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "libraryCatalog"), item.getLibraryCatalog())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "callNumber"), item.getCallNumber())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "extra"), item.getExtra())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "notes"), item.getNotes())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "fileAttachments"), item.getFileAttachments())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "linkAttachments"), item.getLinkAttachments())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "manualTags"), item.getManualTags())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "automaticTags"), item.getAutomaticTags())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "editor"), item.getEditor())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "seriesEditor"), item.getSeriesEditor())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "translator"), item.getTranslator())); // TODO 
            tmpHtmlItems.add(addProperty(resource, FOAF.name, item.getContributor()));
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "attorneyAgent"), item.getAttorneyAgent())); // TODO
            tmpHtmlItems.add(addProperty(resource, DCTerms.creator, item.getBookAuthor()));
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "castNumber"), item.getCastMember())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "commenter"), item.getCommenter())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "composer"), item.getComposer())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "cosponsor"), item.getCosponsor())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "counsel"), item.getCounsel())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "interviewer"), item.getInterviewer())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "producer"), item.getProducer())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "recipient"), item.getRecipient())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "reviewedAuthor"), item.getReviewedAuthor())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "scriptWriter"), item.getScriptwriter())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "wordsBy"), item.getWordsBy())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "guest"), item.getGuest())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "number"), item.getNumber())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "edition"), item.getEdition())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "runningTime"), item.getRunningTime())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "scale"), item.getScale())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "medium"), item.getMedium())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "artworkSize"), item.getArtworkSize())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "filingDate"), item.getFilingDate())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "applicationNumber"), item.getApplicationNumber())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "assignee"), item.getAssignee())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "issuingAuthority"), item.getIssuingAuthority())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "country"), item.getCountry())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "meetingName"), item.getMeetingName())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "conferenceName"), item.getConferenceName())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "court"), item.getCourt())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "references"), item.getReferences())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "reporter"), item.getReporter())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "legalStatus"), item.getLegalStatus())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "priorityNumbers"), item.getPriorityNumbers())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "programmingLanguage"), item.getProgrammingLanguage())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "version"), item.getVersion())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "system"), item.getSystem())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "code"), item.getCode())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "codeNumber"), item.getCodeNumber())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "section"), item.getSection())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "session"), item.getSession())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "committee"), item.getCommittee())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "history"), item.getHistory())); // TODO 
            tmpHtmlItems.add(addProperty(resource, unknowProperty(model, "legislativeBody"), item.getLegislativeBody())); // TODO

            return new ImmutablePair<>(aboutUrlId, tmpHtmlItems.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList()));

        };
    }
}
