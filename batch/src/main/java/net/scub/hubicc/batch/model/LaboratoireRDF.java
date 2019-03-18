package net.scub.hubicc.batch.model;

public class LaboratoireRDF {

    public static String[] FIELDS = {
            "idRef",
            "rnsr",
            "structureSuperieur",
            "pays",
            "webSite",
            "typeDeStructure",
            "statut",
            "nom",
            "acronyme",
            "adresse",
            "codeStructure",
            "identifiantExterne",
    };

    // TODO début URI
    /**
     * owl:sameAs
     */
    private String idRef;
    /**
     * owl:sameAs
     */
    private String rnsr;
    /**
     * org:unitOf
     */
    private String structureSuperieur;
    /**
     * vcard:country-name
     */
    private String pays;
    /**
     * vcard:url
     */
    private String webSite;
    /**
     * org:classification
     */
    private String typeDeStructure;
    /**
     * hal:status
     */
    private String statut;
    // TODO fin URI
    /**
     * skos:prefLabel
     */
    private String nom;
    /**
     * skos:altLabel
     */
    private String acronyme;
    /**
     * org:siteAddress
     */
    private String adresse;
    /**
     * dc:identifier
     */
    private String codeStructure;
    /**
     * hal:msr hal:idref hal:isni
     */
    private String identifiantExterne;

    ///////////////////////////////////////////////////////////////////////
    // Getters and Setters

    public String getIdRef() {
        return idRef;
    }

    public void setIdRef(String idRef) {
        this.idRef = idRef;
    }

    public String getRnsr() {
        return rnsr;
    }

    public void setRnsr(String rnsr) {
        this.rnsr = rnsr;
    }

    public String getStructureSuperieur() {
        return structureSuperieur;
    }

    public void setStructureSuperieur(String structureSuperieur) {
        this.structureSuperieur = structureSuperieur;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getTypeDeStructure() {
        return typeDeStructure;
    }

    public void setTypeDeStructure(String typeDeStructure) {
        this.typeDeStructure = typeDeStructure;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAcronyme() {
        return acronyme;
    }

    public void setAcronyme(String acronyme) {
        this.acronyme = acronyme;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodeStructure() {
        return codeStructure;
    }

    public void setCodeStructure(String codeStructure) {
        this.codeStructure = codeStructure;
    }

    public String getIdentifiantExterne() {
        return identifiantExterne;
    }

    public void setIdentifiantExterne(String identifiantExterne) {
        this.identifiantExterne = identifiantExterne;
    }
}
