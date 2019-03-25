package net.scub.hubicc.batch.model;

import com.opencsv.bean.CsvCustomBindByPosition;
import net.scub.hubicc.batch.tools.csv.converter.BooleanConverter;
import net.scub.hubicc.batch.tools.csv.converter.DateConverter;
import net.scub.hubicc.batch.tools.csv.converter.StringConverter;

import java.util.Date;

public class Formation {

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 0)
    private String id;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 1)
    private String university;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 2)
    private String intitule;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 3)
    private String niveau;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 4)
    private String domaineDiplome;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 5)
    private String mentionDiplome;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 6)
    private String specialiteDiplome;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 7)
    private String parcoursDiplome;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 8)
    private String lieuFormation;

    @CsvCustomBindByPosition(position = 9, converter = BooleanConverter.class)
    private Boolean formationInitiale;

    @CsvCustomBindByPosition(position = 10, converter = BooleanConverter.class)
    private Boolean formationContinue;

    @CsvCustomBindByPosition(position = 11, converter = BooleanConverter.class)
    private Boolean contratApprentissage;

    @CsvCustomBindByPosition(position = 12, converter = BooleanConverter.class)
    private Boolean contratProfessionnalisation;

    @CsvCustomBindByPosition(position = 13, converter = BooleanConverter.class)
    private Boolean voieRecherche;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 14)
    private String typeDeStage;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 15)
    private String dureeStage;

    @CsvCustomBindByPosition(converter = DateConverter.class, position = 16)
    private Date dateDebut;

    @CsvCustomBindByPosition(converter = DateConverter.class, position = 17)
    private Date dateFinObligatoire;

    @CsvCustomBindByPosition(position = 18, converter = BooleanConverter.class)
    private Boolean serviceStageEmploi;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 19)
    private String siteInternetStageEmploi;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 20)
    private String exempleSujetMemoire1;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 21)
    private String exempleSujetMemoire2;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 22)
    private String exempleSujetMemoire3;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 23)
    private String responsablePedagogique;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 24)
    private String courrielSecretariatFormation;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 25)
    private String telephone;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 26)
    private String adresse;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 27)
    private String codePostal;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 28)
    private String commune;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 29)
    private String siteInternet;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 30)
    private String rattachementLaboratoire1;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 31)
    private String rattachementLaboratoire2;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 32)
    private String rattachementLaboratoire3;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 33)
    private String informationsComplementaires;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getDomaineDiplome() {
        return domaineDiplome;
    }

    public void setDomaineDiplome(String domaineDiplome) {
        this.domaineDiplome = domaineDiplome;
    }

    public String getMentionDiplome() {
        return mentionDiplome;
    }

    public void setMentionDiplome(String mentionDiplome) {
        this.mentionDiplome = mentionDiplome;
    }

    public String getSpecialiteDiplome() {
        return specialiteDiplome;
    }

    public void setSpecialiteDiplome(String specialiteDiplome) {
        this.specialiteDiplome = specialiteDiplome;
    }

    public String getParcoursDiplome() {
        return parcoursDiplome;
    }

    public void setParcoursDiplome(String parcoursDiplome) {
        this.parcoursDiplome = parcoursDiplome;
    }

    public String getLieuFormation() {
        return lieuFormation;
    }

    public void setLieuFormation(String lieuFormation) {
        this.lieuFormation = lieuFormation;
    }

    public Boolean getFormationInitiale() {
        return formationInitiale;
    }

    public void setFormationInitiale(Boolean formationInitiale) {
        this.formationInitiale = formationInitiale;
    }

    public Boolean getFormationContinue() {
        return formationContinue;
    }

    public void setFormationContinue(Boolean formationContinue) {
        this.formationContinue = formationContinue;
    }

    public Boolean getContratApprentissage() {
        return contratApprentissage;
    }

    public void setContratApprentissage(Boolean contratApprentissage) {
        this.contratApprentissage = contratApprentissage;
    }

    public Boolean getContratProfessionnalisation() {
        return contratProfessionnalisation;
    }

    public void setContratProfessionnalisation(Boolean contratProfessionnalisation) {
        this.contratProfessionnalisation = contratProfessionnalisation;
    }

    public Boolean getVoieRecherche() {
        return voieRecherche;
    }

    public void setVoieRecherche(Boolean voieRecherche) {
        this.voieRecherche = voieRecherche;
    }

    public String getTypeDeStage() {
        return typeDeStage;
    }

    public void setTypeDeStage(String typeDeStage) {
        this.typeDeStage = typeDeStage;
    }

    public String getDureeStage() {
        return dureeStage;
    }

    public void setDureeStage(String dureeStage) {
        this.dureeStage = dureeStage;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFinObligatoire() {
        return dateFinObligatoire;
    }

    public void setDateFinObligatoire(Date dateFinObligatoire) {
        this.dateFinObligatoire = dateFinObligatoire;
    }

    public Boolean getServiceStageEmploi() {
        return serviceStageEmploi;
    }

    public void setServiceStageEmploi(Boolean serviceStageEmploi) {
        this.serviceStageEmploi = serviceStageEmploi;
    }

    public String getSiteInternetStageEmploi() {
        return siteInternetStageEmploi;
    }

    public void setSiteInternetStageEmploi(String siteInternetStageEmploi) {
        this.siteInternetStageEmploi = siteInternetStageEmploi;
    }

    public String getExempleSujetMemoire1() {
        return exempleSujetMemoire1;
    }

    public void setExempleSujetMemoire1(String exempleSujetMemoire1) {
        this.exempleSujetMemoire1 = exempleSujetMemoire1;
    }

    public String getExempleSujetMemoire2() {
        return exempleSujetMemoire2;
    }

    public void setExempleSujetMemoire2(String exempleSujetMemoire2) {
        this.exempleSujetMemoire2 = exempleSujetMemoire2;
    }

    public String getExempleSujetMemoire3() {
        return exempleSujetMemoire3;
    }

    public void setExempleSujetMemoire3(String exempleSujetMemoire3) {
        this.exempleSujetMemoire3 = exempleSujetMemoire3;
    }

    public String getResponsablePedagogique() {
        return responsablePedagogique;
    }

    public void setResponsablePedagogique(String responsablePedagogique) {
        this.responsablePedagogique = responsablePedagogique;
    }

    public String getCourrielSecretariatFormation() {
        return courrielSecretariatFormation;
    }

    public void setCourrielSecretariatFormation(String courrielSecretariatFormation) {
        this.courrielSecretariatFormation = courrielSecretariatFormation;
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

    public String getSiteInternet() {
        return siteInternet;
    }

    public void setSiteInternet(String siteInternet) {
        this.siteInternet = siteInternet;
    }

    public String getRattachementLaboratoire1() {
        return rattachementLaboratoire1;
    }

    public void setRattachementLaboratoire1(String rattachementLaboratoire1) {
        this.rattachementLaboratoire1 = rattachementLaboratoire1;
    }

    public String getRattachementLaboratoire2() {
        return rattachementLaboratoire2;
    }

    public void setRattachementLaboratoire2(String rattachementLaboratoire2) {
        this.rattachementLaboratoire2 = rattachementLaboratoire2;
    }

    public String getRattachementLaboratoire3() {
        return rattachementLaboratoire3;
    }

    public void setRattachementLaboratoire3(String rattachementLaboratoire3) {
        this.rattachementLaboratoire3 = rattachementLaboratoire3;
    }

    public String getInformationsComplementaires() {
        return informationsComplementaires;
    }

    public void setInformationsComplementaires(String informationsComplementaires) {
        this.informationsComplementaires = informationsComplementaires;
    }
}
