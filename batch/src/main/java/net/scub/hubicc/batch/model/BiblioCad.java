package net.scub.hubicc.batch.model;

import com.opencsv.bean.CsvCustomBindByPosition;
import net.scub.hubicc.batch.tools.csv.converter.DateYearConverter;
import net.scub.hubicc.batch.tools.csv.converter.StringConverter;

import java.util.Date;

public class BiblioCad {


    @CsvCustomBindByPosition(converter = StringConverter.class, position = 0)
    private String key;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 1)
    private String itemType;
    @CsvCustomBindByPosition(converter = DateYearConverter.class, position = 2)
    private Date publicationYear;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 3)
    private String author;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 4)
    private String title;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 5)
    private String publicationTitle;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 6)
    private String ISBN;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 7)
    private String ISSN;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 8)
    private String DOI;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 9)
    private String url;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 10)
    private String abstractNote;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 11)
    private String date;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 12)
    private String dateAdded;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 13)
    private String dateModified;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 14)
    private String accessDate;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 15)
    private String pages;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 16)
    private String numPages;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 17)
    private String issue;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 18)
    private String volume;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 19)
    private String numberOfVolumes;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 20)
    private String journalAbbreviation;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 21)
    private String shortTitle;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 22)
    private String series;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 23)
    private String seriesNumber;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 24)
    private String seriesText;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 25)
    private String seriesTitle;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 26)
    private String publisher;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 27)
    private String place;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 28)
    private String language;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 29)
    private String rights;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 30)
    private String type;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 31)
    private String archive;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 32)
    private String archiveLocation;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 33)
    private String libraryCatalog;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 34)
    private String callNumber;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 35)
    private String extra;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 36)
    private String notes;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 37)
    private String fileAttachments;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 38)
    private String linkAttachments;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 39)
    private String manualTags;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 40)
    private String automaticTags;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 41)
    private String editor;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 42)
    private String seriesEditor;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 43)
    private String translator;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 44)
    private String contributor;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 45)
    private String attorneyAgent;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 46)
    private String bookAuthor;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 47)
    private String castMember;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 48)
    private String commenter;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 49)
    private String composer;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 50)
    private String cosponsor;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 51)
    private String counsel;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 52)
    private String interviewer;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 53)
    private String producer;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 54)
    private String recipient;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 55)
    private String reviewedAuthor;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 56)
    private String scriptwriter;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 57)
    private String wordsBy;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 58)
    private String guest;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 59)
    private String number;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 60)
    private String edition;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 61)
    private String runningTime;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 62)
    private String scale;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 63)
    private String medium;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 64)
    private String artworkSize;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 65)
    private String filingDate;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 66)
    private String applicationNumber;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 67)
    private String assignee;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 68)
    private String issuingAuthority;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 69)
    private String country;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 70)
    private String meetingName;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 71)
    private String conferenceName;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 72)
    private String court;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 73)
    private String references;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 74)
    private String reporter;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 75)
    private String legalStatus;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 76)
    private String priorityNumbers;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 77)
    private String programmingLanguage;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 78)
    private String version;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 79)
    private String system;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 80)
    private String code;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 81)
    private String codeNumber;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 82)
    private String section;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 83)
    private String session;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 84)
    private String committee;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 85)
    private String history;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 86)
    private String legislativeBody;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Date getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Date publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationTitle() {
        return publicationTitle;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getDOI() {
        return DOI;
    }

    public void setDOI(String DOI) {
        this.DOI = DOI;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAbstractNote() {
        return abstractNote;
    }

    public void setAbstractNote(String abstractNote) {
        this.abstractNote = abstractNote;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(String accessDate) {
        this.accessDate = accessDate;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getNumPages() {
        return numPages;
    }

    public void setNumPages(String numPages) {
        this.numPages = numPages;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumberOfVolumes() {
        return numberOfVolumes;
    }

    public void setNumberOfVolumes(String numberOfVolumes) {
        this.numberOfVolumes = numberOfVolumes;
    }

    public String getJournalAbbreviation() {
        return journalAbbreviation;
    }

    public void setJournalAbbreviation(String journalAbbreviation) {
        this.journalAbbreviation = journalAbbreviation;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(String seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public String getSeriesText() {
        return seriesText;
    }

    public void setSeriesText(String seriesText) {
        this.seriesText = seriesText;
    }

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
    }

    public String getArchiveLocation() {
        return archiveLocation;
    }

    public void setArchiveLocation(String archiveLocation) {
        this.archiveLocation = archiveLocation;
    }

    public String getLibraryCatalog() {
        return libraryCatalog;
    }

    public void setLibraryCatalog(String libraryCatalog) {
        this.libraryCatalog = libraryCatalog;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFileAttachments() {
        return fileAttachments;
    }

    public void setFileAttachments(String fileAttachments) {
        this.fileAttachments = fileAttachments;
    }

    public String getLinkAttachments() {
        return linkAttachments;
    }

    public void setLinkAttachments(String linkAttachments) {
        this.linkAttachments = linkAttachments;
    }

    public String getManualTags() {
        return manualTags;
    }

    public void setManualTags(String manualTags) {
        this.manualTags = manualTags;
    }

    public String getAutomaticTags() {
        return automaticTags;
    }

    public void setAutomaticTags(String automaticTags) {
        this.automaticTags = automaticTags;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getSeriesEditor() {
        return seriesEditor;
    }

    public void setSeriesEditor(String seriesEditor) {
        this.seriesEditor = seriesEditor;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getAttorneyAgent() {
        return attorneyAgent;
    }

    public void setAttorneyAgent(String attorneyAgent) {
        this.attorneyAgent = attorneyAgent;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getCastMember() {
        return castMember;
    }

    public void setCastMember(String castMember) {
        this.castMember = castMember;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getCosponsor() {
        return cosponsor;
    }

    public void setCosponsor(String cosponsor) {
        this.cosponsor = cosponsor;
    }

    public String getCounsel() {
        return counsel;
    }

    public void setCounsel(String counsel) {
        this.counsel = counsel;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getReviewedAuthor() {
        return reviewedAuthor;
    }

    public void setReviewedAuthor(String reviewedAuthor) {
        this.reviewedAuthor = reviewedAuthor;
    }

    public String getScriptwriter() {
        return scriptwriter;
    }

    public void setScriptwriter(String scriptwriter) {
        this.scriptwriter = scriptwriter;
    }

    public String getWordsBy() {
        return wordsBy;
    }

    public void setWordsBy(String wordsBy) {
        this.wordsBy = wordsBy;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getArtworkSize() {
        return artworkSize;
    }

    public void setArtworkSize(String artworkSize) {
        this.artworkSize = artworkSize;
    }

    public String getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(String filingDate) {
        this.filingDate = filingDate;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getLegalStatus() {
        return legalStatus;
    }

    public void setLegalStatus(String legalStatus) {
        this.legalStatus = legalStatus;
    }

    public String getPriorityNumbers() {
        return priorityNumbers;
    }

    public void setPriorityNumbers(String priorityNumbers) {
        this.priorityNumbers = priorityNumbers;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getCommittee() {
        return committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getLegislativeBody() {
        return legislativeBody;
    }

    public void setLegislativeBody(String legislativeBody) {
        this.legislativeBody = legislativeBody;
    }
}
