package net.scub.hubicc.batch.controller;

import net.scub.hubicc.batch.model.BiblioCad;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDFS;
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

            final String aboutUrl = "http://fabricc.univ-poitiers.fr/biblio/";
            final Resource resource = model.createResource(aboutUrl + item.getKey());


            addProperty(resource, RDFS.label, item.getKey());
            addProperty(resource, RDFS.label, item.getItemType());
            addProperty(resource, RDFS.label, item.getPublicationYear());
            addProperty(resource, RDFS.label, item.getAuthor());
            addProperty(resource, RDFS.label, item.getTitle());
            addProperty(resource, RDFS.label, item.getPublicationTitle());
            addProperty(resource, RDFS.label, item.getISBN());
            addProperty(resource, RDFS.label, item.getISSN());
            addProperty(resource, RDFS.label, item.getDOI());
            addProperty(resource, RDFS.label, item.getUrl());
            addProperty(resource, RDFS.label, item.getAbstractNote());
            addProperty(resource, RDFS.label, item.getDate());
            addProperty(resource, RDFS.label, item.getDateAdded());
            addProperty(resource, RDFS.label, item.getDateModified());
            addProperty(resource, RDFS.label, item.getAccessDate());
            addProperty(resource, RDFS.label, item.getPages());
            addProperty(resource, RDFS.label, item.getNumPages());
            addProperty(resource, RDFS.label, item.getIssue());
            addProperty(resource, RDFS.label, item.getVolume());
            addProperty(resource, RDFS.label, item.getNumberOfVolumes());
            addProperty(resource, RDFS.label, item.getJournalAbbreviation());
            addProperty(resource, RDFS.label, item.getShortTitle());
            addProperty(resource, RDFS.label, item.getSeries());
            addProperty(resource, RDFS.label, item.getSeriesNumber());
            addProperty(resource, RDFS.label, item.getSeriesText());
            addProperty(resource, RDFS.label, item.getSeriesTitle());
            addProperty(resource, RDFS.label, item.getPublisher());
            addProperty(resource, RDFS.label, item.getPlace());
            addProperty(resource, RDFS.label, item.getLanguage());
            addProperty(resource, RDFS.label, item.getRights());
            addProperty(resource, RDFS.label, item.getType());
            addProperty(resource, RDFS.label, item.getArchive());
            addProperty(resource, RDFS.label, item.getArchiveLocation());
            addProperty(resource, RDFS.label, item.getLibraryCatalog());
            addProperty(resource, RDFS.label, item.getCallNumber());
            addProperty(resource, RDFS.label, item.getExtra());
            addProperty(resource, RDFS.label, item.getNotes());
            addProperty(resource, RDFS.label, item.getFileAttachments());
            addProperty(resource, RDFS.label, item.getLinkAttachments());
            addProperty(resource, RDFS.label, item.getManualTags());
            addProperty(resource, RDFS.label, item.getAutomaticTags());
            addProperty(resource, RDFS.label, item.getEditor());
            addProperty(resource, RDFS.label, item.getSeriesEditor());
            addProperty(resource, RDFS.label, item.getTranslator());
            addProperty(resource, RDFS.label, item.getContributor());
            addProperty(resource, RDFS.label, item.getAttorneyAgent());
            addProperty(resource, RDFS.label, item.getBookAuthor());
            addProperty(resource, RDFS.label, item.getCastMember());
            addProperty(resource, RDFS.label, item.getCommenter());
            addProperty(resource, RDFS.label, item.getComposer());
            addProperty(resource, RDFS.label, item.getCosponsor());
            addProperty(resource, RDFS.label, item.getCounsel());
            addProperty(resource, RDFS.label, item.getInterviewer());
            addProperty(resource, RDFS.label, item.getProducer());
            addProperty(resource, RDFS.label, item.getRecipient());
            addProperty(resource, RDFS.label, item.getReviewedAuthor());
            addProperty(resource, RDFS.label, item.getScriptwriter());
            addProperty(resource, RDFS.label, item.getWordsBy());
            addProperty(resource, RDFS.label, item.getGuest());
            addProperty(resource, RDFS.label, item.getNumber());
            addProperty(resource, RDFS.label, item.getEdition());
            addProperty(resource, RDFS.label, item.getRunningTime());
            addProperty(resource, RDFS.label, item.getScale());
            addProperty(resource, RDFS.label, item.getMedium());
            addProperty(resource, RDFS.label, item.getArtworkSize());
            addProperty(resource, RDFS.label, item.getFilingDate());
            addProperty(resource, RDFS.label, item.getApplicationNumber());
            addProperty(resource, RDFS.label, item.getAssignee());
            addProperty(resource, RDFS.label, item.getIssuingAuthority());
            addProperty(resource, RDFS.label, item.getCountry());
            addProperty(resource, RDFS.label, item.getMeetingName());
            addProperty(resource, RDFS.label, item.getConferenceName());
            addProperty(resource, RDFS.label, item.getCourt());
            addProperty(resource, RDFS.label, item.getReferences());
            addProperty(resource, RDFS.label, item.getReporter());
            addProperty(resource, RDFS.label, item.getLegalStatus());
            addProperty(resource, RDFS.label, item.getPriorityNumbers());
            addProperty(resource, RDFS.label, item.getProgrammingLanguage());
            addProperty(resource, RDFS.label, item.getVersion());
            addProperty(resource, RDFS.label, item.getSystem());
            addProperty(resource, RDFS.label, item.getCode());
            addProperty(resource, RDFS.label, item.getCodeNumber());
            addProperty(resource, RDFS.label, item.getSection());
            addProperty(resource, RDFS.label, item.getSession());
            addProperty(resource, RDFS.label, item.getCommittee());
            addProperty(resource, RDFS.label, item.getHistory());
            addProperty(resource, RDFS.label, item.getLegislativeBody());

        };
    }
}
