package net.scub.hubicc.batch.model;

import com.opencsv.bean.CsvCustomBindByPosition;
import net.scub.hubicc.batch.tools.csv.converter.BooleanConverter;
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

//    @CsvCustomBindByPosition(position = 13, converter = BooleanConverter.class)
//    private Boolean voieRecherche;

//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 14)
//    private String typeDeStage;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 15)
    private String dureeMinStage;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 16)
    private String dureeMaxStage;

//    @CsvCustomBindByPosition(converter = DateDayMonthConverter.class, position = 17)
//    private Date dateDebut;

//    @CsvCustomBindByPosition(converter = DateDayMonthConverter.class, position = 18)
//    private Date dateFinObligatoire;

//    @CsvCustomBindByPosition(position = 19, converter = BooleanConverter.class)
//    private Boolean serviceStageEmploi;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 20)
    private String coordonneesServiceStage;

//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 21)
//    private String exempleSujetMemoire1;

//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 22)
//    private String exempleSujetMemoire2;

//    @CsvCustomBindByPosition(converter = StringConverter.class, position = 23)
//    private String exempleSujetMemoire3;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 24)
    private String responsablePedagogique;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 25)
    private String courrielSecretariatFormation;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 26)
    private String telephone;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 27)
    private String adresse;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 28)
    private String codePostal;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 29)
    private String commune;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 30)
    private String siteInternet;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 31)
    private String rattachementLaboratoire1;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 32)
    private String rattachementLaboratoire2;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 33)
    private String rattachementLaboratoire3;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 34)
    private String informationsComplementaires;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 35)
    private String objectifFormation;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 36)
    private String ects;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 37)
    private String competenceUniversitaire1;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 38)
    private String competenceUniversitaire2;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 39)
    private String competenceUniversitaire3;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 40)
    private String competenceUniversitaire4;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 41)
    private String competenceUniversitaire5;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 42)
    private String competenceUniversitaire6;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 43)
    private String competenceUniversitaire7;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 44)
    private String competenceUniversitaire8;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 45)
    private String competenceUniversitaire9;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 46)
    private String competenceUniversitaire10;
    
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 47)
    private String competencePro1;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 48)
    private String competencePro2;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 49)
    private String competencePro3;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 50)
    private String competencePro4;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 51)
    private String competencePro5;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 52)
    private String competencePro6;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 53)
    private String competencePro7;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 54)
    private String competencePro8;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 55)
    private String competencePro9;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 56)
    private String competencePro10;

    @CsvCustomBindByPosition(converter = StringConverter.class, position = 57)
    private String metierVise1;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 58)
    private String metierVise2;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 59)
    private String metierVise3;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 60)
    private String metierVise4;
    @CsvCustomBindByPosition(converter = StringConverter.class, position = 61)
    private String metierVise5;

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

    public String getDureeMinStage() {
        return dureeMinStage;
    }

    public void setDureeMinStage(String dureeMinStage) {
        this.dureeMinStage = dureeMinStage;
    }

    public String getDureeMaxStage() {
        return dureeMaxStage;
    }

    public void setDureeMaxStage(String dureeMaxStage) {
        this.dureeMaxStage = dureeMaxStage;
    }

    public String getCoordonneesServiceStage() {
        return coordonneesServiceStage;
    }

    public void setCoordonneesServiceStage(String coordonneesServiceStage) {
        this.coordonneesServiceStage = coordonneesServiceStage;
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

    public String getObjectifFormation() {
        return objectifFormation;
    }

    public void setObjectifFormation(String objectifFormation) {
        this.objectifFormation = objectifFormation;
    }

    public String getEcts() {
        return ects;
    }

    public void setEcts(String ects) {
        this.ects = ects;
    }

    public String getCompetenceUniversitaire1() {
        return competenceUniversitaire1;
    }

    public void setCompetenceUniversitaire1(String competenceUniversitaire1) {
        this.competenceUniversitaire1 = competenceUniversitaire1;
    }

    public String getCompetenceUniversitaire2() {
        return competenceUniversitaire2;
    }

    public void setCompetenceUniversitaire2(String competenceUniversitaire2) {
        this.competenceUniversitaire2 = competenceUniversitaire2;
    }

    public String getCompetenceUniversitaire3() {
        return competenceUniversitaire3;
    }

    public void setCompetenceUniversitaire3(String competenceUniversitaire3) {
        this.competenceUniversitaire3 = competenceUniversitaire3;
    }

    public String getCompetenceUniversitaire4() {
        return competenceUniversitaire4;
    }

    public void setCompetenceUniversitaire4(String competenceUniversitaire4) {
        this.competenceUniversitaire4 = competenceUniversitaire4;
    }

    public String getCompetenceUniversitaire5() {
        return competenceUniversitaire5;
    }

    public void setCompetenceUniversitaire5(String competenceUniversitaire5) {
        this.competenceUniversitaire5 = competenceUniversitaire5;
    }

    public String getCompetenceUniversitaire6() {
        return competenceUniversitaire6;
    }

    public void setCompetenceUniversitaire6(String competenceUniversitaire6) {
        this.competenceUniversitaire6 = competenceUniversitaire6;
    }

    public String getCompetenceUniversitaire7() {
        return competenceUniversitaire7;
    }

    public void setCompetenceUniversitaire7(String competenceUniversitaire7) {
        this.competenceUniversitaire7 = competenceUniversitaire7;
    }

    public String getCompetenceUniversitaire8() {
        return competenceUniversitaire8;
    }

    public void setCompetenceUniversitaire8(String competenceUniversitaire8) {
        this.competenceUniversitaire8 = competenceUniversitaire8;
    }

    public String getCompetenceUniversitaire9() {
        return competenceUniversitaire9;
    }

    public void setCompetenceUniversitaire9(String competenceUniversitaire9) {
        this.competenceUniversitaire9 = competenceUniversitaire9;
    }

    public String getCompetenceUniversitaire10() {
        return competenceUniversitaire10;
    }

    public void setCompetenceUniversitaire10(String competenceUniversitaire10) {
        this.competenceUniversitaire10 = competenceUniversitaire10;
    }

    public String getCompetencePro1() {
        return competencePro1;
    }

    public void setCompetencePro1(String competencePro1) {
        this.competencePro1 = competencePro1;
    }

    public String getCompetencePro2() {
        return competencePro2;
    }

    public void setCompetencePro2(String competencePro2) {
        this.competencePro2 = competencePro2;
    }

    public String getCompetencePro3() {
        return competencePro3;
    }

    public void setCompetencePro3(String competencePro3) {
        this.competencePro3 = competencePro3;
    }

    public String getCompetencePro4() {
        return competencePro4;
    }

    public void setCompetencePro4(String competencePro4) {
        this.competencePro4 = competencePro4;
    }

    public String getCompetencePro5() {
        return competencePro5;
    }

    public void setCompetencePro5(String competencePro5) {
        this.competencePro5 = competencePro5;
    }

    public String getCompetencePro6() {
        return competencePro6;
    }

    public void setCompetencePro6(String competencePro6) {
        this.competencePro6 = competencePro6;
    }

    public String getCompetencePro7() {
        return competencePro7;
    }

    public void setCompetencePro7(String competencePro7) {
        this.competencePro7 = competencePro7;
    }

    public String getCompetencePro8() {
        return competencePro8;
    }

    public void setCompetencePro8(String competencePro8) {
        this.competencePro8 = competencePro8;
    }

    public String getCompetencePro9() {
        return competencePro9;
    }

    public void setCompetencePro9(String competencePro9) {
        this.competencePro9 = competencePro9;
    }

    public String getCompetencePro10() {
        return competencePro10;
    }

    public void setCompetencePro10(String competencePro10) {
        this.competencePro10 = competencePro10;
    }

    public String getMetierVise1() {
        return metierVise1;
    }

    public void setMetierVise1(String metierVise1) {
        this.metierVise1 = metierVise1;
    }

    public String getMetierVise2() {
        return metierVise2;
    }

    public void setMetierVise2(String metierVise2) {
        this.metierVise2 = metierVise2;
    }

    public String getMetierVise3() {
        return metierVise3;
    }

    public void setMetierVise3(String metierVise3) {
        this.metierVise3 = metierVise3;
    }

    public String getMetierVise4() {
        return metierVise4;
    }

    public void setMetierVise4(String metierVise4) {
        this.metierVise4 = metierVise4;
    }

    public String getMetierVise5() {
        return metierVise5;
    }

    public void setMetierVise5(String metierVise5) {
        this.metierVise5 = metierVise5;
    }
}
