package net.scub.hubicc.batch.model;

import com.opencsv.bean.CsvBindByPosition;

public class BiblioCad {


    @CsvBindByPosition(position = 0)
    private String key;
    @CsvBindByPosition(position = 1)
    private String itemType;
    @CsvBindByPosition(position = 2)
    private String publicationYear;
    @CsvBindByPosition(position = 3)
    private String author;
    @CsvBindByPosition(position = 4)
    private String title;
    @CsvBindByPosition(position = 5)
    private String publicationTitle;
    @CsvBindByPosition(position = 6)
    private String ISBN;
    @CsvBindByPosition(position = 7)
    private String ISSN;
    @CsvBindByPosition(position = 8)
    private String DOI;
    @CsvBindByPosition(position = 9)
    private String url;
    @CsvBindByPosition(position = 10)
    private String abstractNote;
    @CsvBindByPosition(position = 11)
    private String date;
    @CsvBindByPosition(position = 12)
    private String dateAdded;
    @CsvBindByPosition(position = 13)
    private String dateModified;
    @CsvBindByPosition(position = 14)
    private String accessDate;
    @CsvBindByPosition(position = 15)
    private String pages;
    @CsvBindByPosition(position = 16)
    private String numPages;
    @CsvBindByPosition(position = 17)
    private String issue;
    @CsvBindByPosition(position = 18)
    private String volume;
    @CsvBindByPosition(position = 19)
    private String numberOfVolumes;
    @CsvBindByPosition(position = 20)
    private String journalAbbreviation;
    @CsvBindByPosition(position = 21)
    private String shortTitle;
    @CsvBindByPosition(position = 22)
    private String series;
    @CsvBindByPosition(position = 23)
    private String seriesNumber;
    @CsvBindByPosition(position = 24)
    private String seriesText;
    @CsvBindByPosition(position = 25)
    private String seriesTitle;
    @CsvBindByPosition(position = 26)
    private String publisher;
    @CsvBindByPosition(position = 27)
    private String place;
    @CsvBindByPosition(position = 28)
    private String language;
    @CsvBindByPosition(position = 29)
    private String rights;
    @CsvBindByPosition(position = 30)
    private String type;
    @CsvBindByPosition(position = 31)
    private String archive;
    @CsvBindByPosition(position = 32)
    private String archiveLocation;
    @CsvBindByPosition(position = 33)
    private String libraryCatalog;
    @CsvBindByPosition(position = 34)
    private String callNumber;
    @CsvBindByPosition(position = 35)
    private String extra;
    @CsvBindByPosition(position = 36)
    private String notes;
    @CsvBindByPosition(position = 37)
    private String fileAttachments;
    @CsvBindByPosition(position = 38)
    private String linkAttachments;
    @CsvBindByPosition(position = 39)
    private String manualTags;
    @CsvBindByPosition(position = 40)
    private String automaticTags;
    @CsvBindByPosition(position = 41)
    private String editor;
    @CsvBindByPosition(position = 42)
    private String seriesEditor;
    @CsvBindByPosition(position = 43)
    private String translator;
    @CsvBindByPosition(position = 44)
    private String contributor;
    @CsvBindByPosition(position = 45)
    private String attorneyAgent;
    @CsvBindByPosition(position = 46)
    private String bookAuthor;
    @CsvBindByPosition(position = 47)
    private String castMember;
    @CsvBindByPosition(position = 48)
    private String commenter;
    @CsvBindByPosition(position = 49)
    private String composer;
    @CsvBindByPosition(position = 50)
    private String cosponsor;
    @CsvBindByPosition(position = 51)
    private String counsel;
    @CsvBindByPosition(position = 52)
    private String interviewer;
    @CsvBindByPosition(position = 53)
    private String producer;
    @CsvBindByPosition(position = 54)
    private String recipient;
    @CsvBindByPosition(position = 55)
    private String reviewedAuthor;
    @CsvBindByPosition(position = 56)
    private String scriptwriter;
    @CsvBindByPosition(position = 57)
    private String wordsBy;
    @CsvBindByPosition(position = 58)
    private String guest;
    @CsvBindByPosition(position = 59)
    private String number;
    @CsvBindByPosition(position = 60)
    private String edition;
    @CsvBindByPosition(position = 61)
    private String runningTime;
    @CsvBindByPosition(position = 62)
    private String scale;
    @CsvBindByPosition(position = 63)
    private String medium;
    @CsvBindByPosition(position = 64)
    private String artworkSize;
    @CsvBindByPosition(position = 65)
    private String filingDate;
    @CsvBindByPosition(position = 66)
    private String applicationNumber;
    @CsvBindByPosition(position = 67)
    private String assignee;
    @CsvBindByPosition(position = 68)
    private String issuingAuthority;
    @CsvBindByPosition(position = 69)
    private String country;
    @CsvBindByPosition(position = 70)
    private String meetingName;
    @CsvBindByPosition(position = 71)
    private String conferenceName;
    @CsvBindByPosition(position = 72)
    private String court;
    @CsvBindByPosition(position = 73)
    private String references;
    @CsvBindByPosition(position = 74)
    private String reporter;
    @CsvBindByPosition(position = 75)
    private String legalStatus;
    @CsvBindByPosition(position = 76)
    private String priorityNumbers;
    @CsvBindByPosition(position = 77)
    private String programmingLanguage;
    @CsvBindByPosition(position = 78)
    private String version;
    @CsvBindByPosition(position = 79)
    private String system;
    @CsvBindByPosition(position = 80)
    private String code;
    @CsvBindByPosition(position = 81)
    private String codeNumber;
    @CsvBindByPosition(position = 82)
    private String section;
    @CsvBindByPosition(position = 83)
    private String session;
    @CsvBindByPosition(position = 84)
    private String committee;
    @CsvBindByPosition(position = 85)
    private String history;
    @CsvBindByPosition(position = 86)
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

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
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
