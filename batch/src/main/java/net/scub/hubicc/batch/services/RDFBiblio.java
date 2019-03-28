package net.scub.hubicc.batch.services;

import net.scub.hubicc.batch.model.BiblioCad;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.VCARD4;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Component
public class RDFBiblio extends AbstractRDF<BiblioCad> {

    @Override
    protected String getRDFFileName() {
        return "generatedOwl/rdf-biblio";
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
    public Consumer<ImmutablePair<Model, BiblioCad>> convertItemToRDF() {
        return (ImmutablePair<Model, BiblioCad> pair) -> {
            var model = pair.left;
            var item = pair.right;

            var aboutUrl = getICCNamespace() + "biblio/";
            var resource = model.createResource(aboutUrl + item.getKey());

            var biboDoi = model.createProperty("http://purl.org/ontology/bibo/doi");
            var biboEissn = model.createProperty("http://purl.org/ontology/bibo/eIssn");
            var biboIsbn = model.createProperty("http://purl.org/ontology/bibo/isbn");
            var biboCreated = model.createProperty("http://purl.org/ontology/bibo/created");

            addProperty(resource, DC.identifier, item.getKey());
            addProperty(resource, DCTerms.type, item.getItemType());

            addProperty(resource, DCTerms.created, item.getPublicationYear());
            addProperty(resource, DCTerms.creator, item.getAuthor());
            addProperty(resource, DCTerms.title, item.getTitle());
            addProperty(resource, DCTerms.title, item.getPublicationTitle());

            addProperty(resource, biboIsbn, item.getISBN());
            addProperty(resource, biboEissn, item.getISSN());
            addProperty(resource, biboDoi, item.getDOI());

            addProperty(resource, VCARD4.url, item.getUrl());

            addProperty(resource, DCTerms.abstract_, item.getAbstractNote());

            addProperty(resource, biboCreated, item.getDate());
            
            addProperty(resource, unknowProperty(model, "dateAdded"), item.getDateAdded()); // TODO 
            addProperty(resource, unknowProperty(model, "dateModified"), item.getDateModified()); // TODO 
            addProperty(resource, unknowProperty(model, "accessDate"), item.getAccessDate()); // TODO 

            addProperty(resource, unknowProperty(model, "pages"), item.getPages()); // TODO 
            addProperty(resource, unknowProperty(model, "numPages"), item.getNumPages()); // TODO 
            addProperty(resource, unknowProperty(model, "issue"), item.getIssue()); // TODO 
            addProperty(resource, unknowProperty(model, "volume"), item.getVolume()); // TODO 
            addProperty(resource, unknowProperty(model, "numberOfVolumes"), item.getNumberOfVolumes()); // TODO 

            addProperty(resource, unknowProperty(model, "journalAbbreviation"), item.getJournalAbbreviation()); // TODO 
            
            addProperty(resource, DCTerms.alternative, item.getShortTitle());
            
            addProperty(resource, unknowProperty(model, "series"), item.getSeries()); // TODO 
            addProperty(resource, unknowProperty(model, "seriesNumber"), item.getSeriesNumber()); // TODO 
            addProperty(resource, unknowProperty(model, "seriesText"), item.getSeriesText()); // TODO 
            addProperty(resource, unknowProperty(model, "seriesTitle"), item.getSeriesTitle()); // TODO 
            addProperty(resource, unknowProperty(model, "publisher"), item.getPublisher()); // TODO 
            addProperty(resource, unknowProperty(model, "place"), item.getPlace()); // TODO 

            addProperty(resource, DCTerms.language, item.getLanguage());

            addProperty(resource, unknowProperty(model, "rights"), item.getRights()); // TODO 
            addProperty(resource, unknowProperty(model, "type"), item.getType()); // TODO 
            addProperty(resource, unknowProperty(model, "archive"), item.getArchive()); // TODO 
            addProperty(resource, unknowProperty(model, "archiveLocation"), item.getArchiveLocation()); // TODO 
            addProperty(resource, unknowProperty(model, "libraryCatalog"), item.getLibraryCatalog()); // TODO 
            addProperty(resource, unknowProperty(model, "callNumber"), item.getCallNumber()); // TODO 
            addProperty(resource, unknowProperty(model, "extra"), item.getExtra()); // TODO 
            addProperty(resource, unknowProperty(model, "notes"), item.getNotes()); // TODO 
            addProperty(resource, unknowProperty(model, "fileAttachments"), item.getFileAttachments()); // TODO 
            addProperty(resource, unknowProperty(model, "linkAttachments"), item.getLinkAttachments()); // TODO 
            addProperty(resource, unknowProperty(model, "manualTags"), item.getManualTags()); // TODO 
            addProperty(resource, unknowProperty(model, "automaticTags"), item.getAutomaticTags()); // TODO 
            addProperty(resource, unknowProperty(model, "editor"), item.getEditor()); // TODO 
            addProperty(resource, unknowProperty(model, "seriesEditor"), item.getSeriesEditor()); // TODO 
            addProperty(resource, unknowProperty(model, "translator"), item.getTranslator()); // TODO 
            addProperty(resource, FOAF.name, item.getContributor());
            addProperty(resource, unknowProperty(model, "attorneyAgent"), item.getAttorneyAgent()); // TODO
            addProperty(resource, DCTerms.creator, item.getBookAuthor());
            addProperty(resource, unknowProperty(model, "castNumber"), item.getCastMember()); // TODO 
            addProperty(resource, unknowProperty(model, "commenter"), item.getCommenter()); // TODO 
            addProperty(resource, unknowProperty(model, "composer"), item.getComposer()); // TODO 
            addProperty(resource, unknowProperty(model, "cosponsor"), item.getCosponsor()); // TODO 
            addProperty(resource, unknowProperty(model, "counsel"), item.getCounsel()); // TODO 
            addProperty(resource, unknowProperty(model, "interviewer"), item.getInterviewer()); // TODO 
            addProperty(resource, unknowProperty(model, "producer"), item.getProducer()); // TODO 
            addProperty(resource, unknowProperty(model, "recipient"), item.getRecipient()); // TODO 
            addProperty(resource, unknowProperty(model, "reviewedAuthor"), item.getReviewedAuthor()); // TODO 
            addProperty(resource, unknowProperty(model, "scriptWriter"), item.getScriptwriter()); // TODO 
            addProperty(resource, unknowProperty(model, "wordsBy"), item.getWordsBy()); // TODO 
            addProperty(resource, unknowProperty(model, "guest"), item.getGuest()); // TODO 
            addProperty(resource, unknowProperty(model, "number"), item.getNumber()); // TODO 
            addProperty(resource, unknowProperty(model, "edition"), item.getEdition()); // TODO 
            addProperty(resource, unknowProperty(model, "runningTime"), item.getRunningTime()); // TODO 
            addProperty(resource, unknowProperty(model, "scale"), item.getScale()); // TODO 
            addProperty(resource, unknowProperty(model, "medium"), item.getMedium()); // TODO 
            addProperty(resource, unknowProperty(model, "artworkSize"), item.getArtworkSize()); // TODO 
            addProperty(resource, unknowProperty(model, "filingDate"), item.getFilingDate()); // TODO 
            addProperty(resource, unknowProperty(model, "applicationNumber"), item.getApplicationNumber()); // TODO 
            addProperty(resource, unknowProperty(model, "assignee"), item.getAssignee()); // TODO 
            addProperty(resource, unknowProperty(model, "issuingAuthority"), item.getIssuingAuthority()); // TODO 
            addProperty(resource, unknowProperty(model, "country"), item.getCountry()); // TODO 
            addProperty(resource, unknowProperty(model, "meetingName"), item.getMeetingName()); // TODO 
            addProperty(resource, unknowProperty(model, "conferenceName"), item.getConferenceName()); // TODO 
            addProperty(resource, unknowProperty(model, "court"), item.getCourt()); // TODO 
            addProperty(resource, unknowProperty(model, "references"), item.getReferences()); // TODO 
            addProperty(resource, unknowProperty(model, "reporter"), item.getReporter()); // TODO 
            addProperty(resource, unknowProperty(model, "legalStatus"), item.getLegalStatus()); // TODO 
            addProperty(resource, unknowProperty(model, "priorityNumbers"), item.getPriorityNumbers()); // TODO 
            addProperty(resource, unknowProperty(model, "programmingLanguage"), item.getProgrammingLanguage()); // TODO 
            addProperty(resource, unknowProperty(model, "version"), item.getVersion()); // TODO 
            addProperty(resource, unknowProperty(model, "system"), item.getSystem()); // TODO 
            addProperty(resource, unknowProperty(model, "code"), item.getCode()); // TODO 
            addProperty(resource, unknowProperty(model, "codeNumber"), item.getCodeNumber()); // TODO 
            addProperty(resource, unknowProperty(model, "section"), item.getSection()); // TODO 
            addProperty(resource, unknowProperty(model, "session"), item.getSession()); // TODO 
            addProperty(resource, unknowProperty(model, "committee"), item.getCommittee()); // TODO 
            addProperty(resource, unknowProperty(model, "history"), item.getHistory()); // TODO 
            addProperty(resource, unknowProperty(model, "legislativeBody"), item.getLegislativeBody()); // TODO 

        };
    }
}
