package net.scub.hubicc.batch.model;

public class Laboratoire {

    public static String[] FIELDS = {
            "id",
            "champDeRecherche",
            "university",
            "intitule",
            "intituleAbrege",
            "referenceLaboratoire",
            "structureRattachement",
            "rattachementExterne",
            "nombreChercheurs",
            "associationCnrs",
            "axeRecherche1",
            "axeRecherche1",
            "axeRecherche1",
            "axeRecherche1",
            "axeRecherche1",
            "axeRecherche1",
            "axeRecherche1",
            "axeRecherche1",
            "direction",
            "siteInternet",
            "courrielSecretariat",
            "telephone",
            "adresse",
            "codePostal",
            "commune",
            "informationsComplementaires"
    };

    private String id;

    // Identité
    private String champDeRecherche;
    private String university;
    private String intitule;
    private String intituleAbrege;
    private String referenceLaboratoire;
    private String structureRattachement;
    private String rattachementExterne;

    //Recherche
    private String nombreChercheurs;
    private String associationCnrs;
    private String axeRecherche1;
    private String axeRecherche2;
    private String axeRecherche3;
    private String axeRecherche4;
    private String axeRecherche5;
    private String axeRecherche6;
    private String axeRecherche7;
    private String axeRecherche8;

    // Coordonnées
    private String direction;
    private String siteInternet;
    private String courrielSecretariat;
    private String telephone;
    private String adresse;
    private String codePostal;
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

    public String getNombreChercheurs() {
        return nombreChercheurs;
    }

    public void setNombreChercheurs(String nombreChercheurs) {
        this.nombreChercheurs = nombreChercheurs;
    }

    public String getAssociationCnrs() {
        return associationCnrs;
    }

    public void setAssociationCnrs(String associationCnrs) {
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
}
