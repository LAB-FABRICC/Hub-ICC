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
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 12)
//    private String dateAdded;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 13)
//    private String dateModified;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 14)
//    private String accessDate;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 15)
//    private String pages;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 16)
//    private String numPages;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 17)
//    private String issue;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 18)
//    private String volume;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 19)
//    private String numberOfVolumes;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 20)
//    private String journalAbbreviation;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 21)
    private String shortTitle;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 22)
//    private String series;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 23)
//    private String seriesNumber;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 24)
//    private String seriesText;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 25)
//    private String seriesTitle;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 26)
//    private String publisher;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 27)
//    private String place;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 28)
    private String language;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 29)
//    private String rights;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 30)
//    private String type;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 31)
//    private String archive;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 32)
//    private String archiveLocation;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 33)
//    private String libraryCatalog;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 34)
//    private String callNumber;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 35)
//    private String extra;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 36)
//    private String notes;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 37)
//    private String fileAttachments;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 38)
//    private String linkAttachments;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 39)
//    private String manualTags;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 40)
//    private String automaticTags;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 41)
//    private String editor;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 42)
//    private String seriesEditor;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 43)
//    private String translator;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 44)
    private String contributor;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 45)
//    private String attorneyAgent;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 46)
    private String bookAuthor;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 47)
//    private String castMember;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 48)
//    private String commenter;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 49)
//    private String composer;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 50)
//    private String cosponsor;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 51)
//    private String counsel;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 52)
//    private String interviewer;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 53)
//    private String producer;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 54)
//    private String recipient;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 55)
//    private String reviewedAuthor;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 56)
//    private String scriptwriter;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 57)
//    private String wordsBy;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 58)
//    private String guest;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 59)
//    private String number;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 60)
//    private String edition;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 61)
//    private String runningTime;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 62)
//    private String scale;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 63)
//    private String medium;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 64)
//    private String artworkSize;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 65)
//    private String filingDate;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 66)
//    private String applicationNumber;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 67)
//    private String assignee;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 68)
//    private String issuingAuthority;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 69)
//    private String country;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 70)
//    private String meetingName;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 71)
//    private String conferenceName;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 72)
//    private String court;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 73)
//    private String references;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 74)
//    private String reporter;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 75)
//    private String legalStatus;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 76)
//    private String priorityNumbers;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 77)
//    private String programmingLanguage;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 78)
//    private String version;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 79)
//    private String system;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 80)
//    private String code;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 81)
//    private String codeNumber;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 82)
//    private String section;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 83)
//    private String session;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 84)
//    private String committee;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 85)
//    private String history;
//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 86)
//    private String legislativeBody;


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

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
