package net.scub.hubicc.batch.model;

import com.opencsv.bean.CsvCustomBindByPosition;
import net.scub.hubicc.batch.tools.csv.converter.BooleanConverter;
import net.scub.hubicc.batch.tools.csv.converter.IntegerConverter;
import net.scub.hubicc.batch.tools.csv.converter.StringConverter;

public class Laboratoire {

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 0)
    private String id;

    // Identité
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 1)
    private String champDeRecherche;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 2)
    private String university;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 3)
    private String intitule;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 4)
    private String intituleAbrege;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 5)
    private String referenceLaboratoire;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 6)
    private String structureRattachement;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 7)
    private String rattachementExterne;

    //Recherche
    @CsvCustomBindByPosition(position = 8, converter = IntegerConverter.class)
    private Integer nombreChercheurs;
    @CsvCustomBindByPosition(position = 9, converter = BooleanConverter.class)
    private Boolean associationCnrs;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 10)
    private String axeRecherche1;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 11)
    private String axeRecherche2;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 12)
    private String axeRecherche3;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 13)
    private String axeRecherche4;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 14)
    private String axeRecherche5;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 15)
    private String axeRecherche6;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 16)
    private String axeRecherche7;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 17)
    private String axeRecherche8;

    // Coordonnées
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 18)
    private String direction;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 19)
    private String siteInternet;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 20)
    private String courrielSecretariat;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 21)
    private String telephone;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 22)
    private String adresse;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 23)
    private String codePostal;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 24)
    private String commune;

    // Divers
    private String informationsComplementaires;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChampDeRecherche() {
        return champDeRecherche;
    }

    public void setChampDeRecherche(String champDeRecherche) {
        this.champDeRecherche = champDeRecherche;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getIntituleAbrege() {
        return intituleAbrege;
    }

    public void setIntituleAbrege(String intituleAbrege) {
        this.intituleAbrege = intituleAbrege;
    }

    public String getReferenceLaboratoire() {
        return referenceLaboratoire;
    }

    public void setReferenceLaboratoire(String referenceLaboratoire) {
        this.referenceLaboratoire = referenceLaboratoire;
    }

    public String getStructureRattachement() {
        return structureRattachement;
    }

    public void setStructureRattachement(String structureRattachement) {
        this.structureRattachement = structureRattachement;
    }

    public String getRattachementExterne() {
        return rattachementExterne;
    }

    public void setRattachementExterne(String rattachementExterne) {
        this.rattachementExterne = rattachementExterne;
    }

    public Integer getNombreChercheurs() {
        return nombreChercheurs;
    }

    public void setNombreChercheurs(Integer nombreChercheurs) {
        this.nombreChercheurs = nombreChercheurs;
    }

    public Boolean getAssociationCnrs() {
        return associationCnrs;
    }

    public void setAssociationCnrs(Boolean associationCnrs) {
        this.associationCnrs = associationCnrs;
    }

    public String getAxeRecherche1() {
        return axeRecherche1;
    }

    public void setAxeRecherche1(String axeRecherche1) {
        this.axeRecherche1 = axeRecherche1;
    }

    public String getAxeRecherche2() {
        return axeRecherche2;
    }

    public void setAxeRecherche2(String axeRecherche2) {
        this.axeRecherche2 = axeRecherche2;
    }

    public String getAxeRecherche3() {
        return axeRecherche3;
    }

    public void setAxeRecherche3(String axeRecherche3) {
        this.axeRecherche3 = axeRecherche3;
    }

    public String getAxeRecherche4() {
        return axeRecherche4;
    }

    public void setAxeRecherche4(String axeRecherche4) {
        this.axeRecherche4 = axeRecherche4;
    }

    public String getAxeRecherche5() {
        return axeRecherche5;
    }

    public void setAxeRecherche5(String axeRecherche5) {
        this.axeRecherche5 = axeRecherche5;
    }

    public String getAxeRecherche6() {
        return axeRecherche6;
    }

    public void setAxeRecherche6(String axeRecherche6) {
        this.axeRecherche6 = axeRecherche6;
    }

    public String getAxeRecherche7() {
        return axeRecherche7;
    }

    public void setAxeRecherche7(String axeRecherche7) {
        this.axeRecherche7 = axeRecherche7;
    }

    public String getAxeRecherche8() {
        return axeRecherche8;
    }

    public void setAxeRecherche8(String axeRecherche8) {
        this.axeRecherche8 = axeRecherche8;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSiteInternet() {
        return siteInternet;
    }

    public void setSiteInternet(String siteInternet) {
        this.siteInternet = siteInternet;
    }

    public String getCourrielSecretariat() {
        return courrielSecretariat;
    }

    public void setCourrielSecretariat(String courrielSecretariat) {
        this.courrielSecretariat = courrielSecretariat;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getInformationsComplementaires() {
        return informationsComplementaires;
    }

    public void setInformationsComplementaires(String informationsComplementaires) {
        this.informationsComplementaires = informationsComplementaires;
    }

    @Override
    public String toString() {
        return "{" +
                "id:'" + id + '\'' +
                ", champDeRecherche:'" + champDeRecherche + '\'' +
                ", university:'" + university + '\'' +
                ", intitule:'" + intitule + '\'' +
                ", intituleAbrege:'" + intituleAbrege + '\'' +
                ", referenceLaboratoire:'" + referenceLaboratoire + '\'' +
                ", structureRattachement:'" + structureRattachement + '\'' +
                ", rattachementExterne:'" + rattachementExterne + '\'' +
                ", nombreChercheurs:'" + nombreChercheurs + '\'' +
                ", associationCnrs:'" + associationCnrs + '\'' +
                ", axeRecherche1:'" + axeRecherche1 + '\'' +
                ", axeRecherche2:'" + axeRecherche2 + '\'' +
                ", axeRecherche3:'" + axeRecherche3 + '\'' +
                ", axeRecherche4:'" + axeRecherche4 + '\'' +
                ", axeRecherche5:'" + axeRecherche5 + '\'' +
                ", axeRecherche6:'" + axeRecherche6 + '\'' +
                ", axeRecherche7:'" + axeRecherche7 + '\'' +
                ", axeRecherche8:'" + axeRecherche8 + '\'' +
                ", direction:'" + direction + '\'' +
                ", siteInternet:'" + siteInternet + '\'' +
                ", courrielSecretariat:'" + courrielSecretariat + '\'' +
                ", telephone:'" + telephone + '\'' +
                ", adresse:'" + adresse + '\'' +
                ", codePostal:'" + codePostal + '\'' +
                ", commune:'" + commune + '\'' +
                ", informationsComplementaires:'" + informationsComplementaires + '\'' +
                '}';
    }
}
