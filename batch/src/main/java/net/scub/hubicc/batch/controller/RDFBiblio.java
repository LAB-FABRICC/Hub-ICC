package net.scub.hubicc.batch.controller;

import net.scub.hubicc.batch.model.BiblioCad;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.*;
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
            final Model model = pair.left;
            final BiblioCad item = pair.right;

            final String aboutUrl = getICCNamespace() + "biblio/";
            final Resource resource = model.createResource(aboutUrl + item.getKey());

            final Property biboDoi = model.createProperty("http://purl.org/ontology/bibo/doi");
            final Property biboEissn = model.createProperty("http://purl.org/ontology/bibo/eIssn");
            final Property biboIsbn = model.createProperty("http://purl.org/ontology/bibo/isbn");
            final Property biboCreated = model.createProperty("http://purl.org/ontology/bibo/created");

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
            
            addProperty(resource, unknowProperty(model, "dateAdded"), item.getDateAdded());
            addProperty(resource, unknowProperty(model, "dateModified"), item.getDateModified());
            addProperty(resource, unknowProperty(model, "accessDate"), item.getAccessDate());

            addProperty(resource, unknowProperty(model, "pages"), item.getPages());
            addProperty(resource, unknowProperty(model, "numPages"), item.getNumPages());
            addProperty(resource, unknowProperty(model, "issue"), item.getIssue());
            addProperty(resource, unknowProperty(model, "volume"), item.getVolume());
            addProperty(resource, unknowProperty(model, "numberOfVolumes"), item.getNumberOfVolumes());

            addProperty(resource, unknowProperty(model, "journalAbbreviation"), item.getJournalAbbreviation());
            
            addProperty(resource, DCTerms.alternative, item.getShortTitle());
            
            addProperty(resource, unknowProperty(model, "series"), item.getSeries());
            addProperty(resource, unknowProperty(model, "seriesNumber"), item.getSeriesNumber());
            addProperty(resource, unknowProperty(model, "seriesText"), item.getSeriesText());
            addProperty(resource, unknowProperty(model, "seriesTitle"), item.getSeriesTitle());
            addProperty(resource, unknowProperty(model, "publisher"), item.getPublisher());
            addProperty(resource, unknowProperty(model, "place"), item.getPlace());

            addProperty(resource, DCTerms.language, item.getLanguage());

            addProperty(resource, unknowProperty(model, "rights"), item.getRights());
            addProperty(resource, unknowProperty(model, "type"), item.getType());
            addProperty(resource, unknowProperty(model, "archive"), item.getArchive());
            addProperty(resource, unknowProperty(model, "archiveLocation"), item.getArchiveLocation());
            addProperty(resource, unknowProperty(model, "libraryCatalog"), item.getLibraryCatalog());
            addProperty(resource, unknowProperty(model, "callNumber"), item.getCallNumber());
            addProperty(resource, unknowProperty(model, "extra"), item.getExtra());
            addProperty(resource, unknowProperty(model, "notes"), item.getNotes());
            addProperty(resource, unknowProperty(model, "fileAttachments"), item.getFileAttachments());
            addProperty(resource, unknowProperty(model, "linkAttachments"), item.getLinkAttachments());
            addProperty(resource, unknowProperty(model, "manualTags"), item.getManualTags());
            addProperty(resource, unknowProperty(model, "automaticTags"), item.getAutomaticTags());
            addProperty(resource, unknowProperty(model, "editor"), item.getEditor());
            addProperty(resource, unknowProperty(model, "seriesEditor"), item.getSeriesEditor());
            addProperty(resource, unknowProperty(model, "translator"), item.getTranslator());
            addProperty(resource, FOAF.name, item.getContributor());
            addProperty(resource, unknowProperty(model, "attorneyAgent"), item.getAttorneyAgent());
            addProperty(resource, DCTerms.creator, item.getBookAuthor());
            addProperty(resource, unknowProperty(model, "castNumber"), item.getCastMember());
            addProperty(resource, unknowProperty(model, "commenter"), item.getCommenter());
            addProperty(resource, unknowProperty(model, "composer"), item.getComposer());
            addProperty(resource, unknowProperty(model, "cosponsor"), item.getCosponsor());
            addProperty(resource, unknowProperty(model, "counsel"), item.getCounsel());
            addProperty(resource, unknowProperty(model, "interviewer"), item.getInterviewer());
            addProperty(resource, unknowProperty(model, "producer"), item.getProducer());
            addProperty(resource, unknowProperty(model, "recipient"), item.getRecipient());
            addProperty(resource, unknowProperty(model, "reviewedAuthor"), item.getReviewedAuthor());
            addProperty(resource, unknowProperty(model, "scriptWriter"), item.getScriptwriter());
            addProperty(resource, unknowProperty(model, "wordsBy"), item.getWordsBy());
            addProperty(resource, unknowProperty(model, "guest"), item.getGuest());
            addProperty(resource, unknowProperty(model, "number"), item.getNumber());
            addProperty(resource, unknowProperty(model, "edition"), item.getEdition());
            addProperty(resource, unknowProperty(model, "runningTime"), item.getRunningTime());
            addProperty(resource, unknowProperty(model, "scale"), item.getScale());
            addProperty(resource, unknowProperty(model, "medium"), item.getMedium());
            addProperty(resource, unknowProperty(model, "artworkSize"), item.getArtworkSize());
            addProperty(resource, unknowProperty(model, "filingDate"), item.getFilingDate());
            addProperty(resource, unknowProperty(model, "applicationNumber"), item.getApplicationNumber());
            addProperty(resource, unknowProperty(model, "assignee"), item.getAssignee());
            addProperty(resource, unknowProperty(model, "issuingAuthority"), item.getIssuingAuthority());
            addProperty(resource, unknowProperty(model, "country"), item.getCountry());
            addProperty(resource, unknowProperty(model, "meetingName"), item.getMeetingName());
            addProperty(resource, unknowProperty(model, "conferenceName"), item.getConferenceName());
            addProperty(resource, unknowProperty(model, "court"), item.getCourt());
            addProperty(resource, unknowProperty(model, "references"), item.getReferences());
            addProperty(resource, unknowProperty(model, "reporter"), item.getReporter());
            addProperty(resource, unknowProperty(model, "legalStatus"), item.getLegalStatus());
            addProperty(resource, unknowProperty(model, "priorityNumbers"), item.getPriorityNumbers());
            addProperty(resource, unknowProperty(model, "programmingLanguage"), item.getProgrammingLanguage());
            addProperty(resource, unknowProperty(model, "version"), item.getVersion());
            addProperty(resource, unknowProperty(model, "system"), item.getSystem());
            addProperty(resource, unknowProperty(model, "code"), item.getCode());
            addProperty(resource, unknowProperty(model, "codeNumber"), item.getCodeNumber());
            addProperty(resource, unknowProperty(model, "section"), item.getSection());
            addProperty(resource, unknowProperty(model, "session"), item.getSession());
            addProperty(resource, unknowProperty(model, "committee"), item.getCommittee());
            addProperty(resource, unknowProperty(model, "history"), item.getHistory());
            addProperty(resource, unknowProperty(model, "legislativeBody"), item.getLegislativeBody());

        };
    }
}
