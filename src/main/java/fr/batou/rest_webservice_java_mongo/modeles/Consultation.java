package fr.batou.rest_webservice_java_mongo.modeles;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "consultations")
public class Consultation {
    @Id
    private String identifiant;
    private String numero;
    private LocalDateTime date;

    private String identifiantPatient;
    private String identifiantMedecin;

    // Liste des médicaments prescrits
    private List<Prescription> prescriptions = new ArrayList<>();

    // Identifiant du fichier joint
    private String identifiantDocumentAttache;

    // Consultation complète constructeur tous les params
    public Consultation(String identifiant, String numero, LocalDateTime date, String identifiantPatient, String identifiantMedecin, List<Prescription> prescriptions, String identifiantDocumentAttache) {
        this.identifiant = identifiant;
        this.numero = numero;
        this.date = date;
        this.identifiantPatient = identifiantPatient;
        this.identifiantMedecin = identifiantMedecin;
        this.prescriptions = prescriptions;
        this.identifiantDocumentAttache = identifiantDocumentAttache;
    }
    // Consultation sans fichier Joint
    public Consultation(String identifiant, String numero, LocalDateTime date, String identifiantPatient, String identifiantMedecin, List<Prescription> prescriptions) {
        this.identifiant = identifiant;
        this.numero = numero;
        this.date = date;
        this.identifiantPatient = identifiantPatient;
        this.identifiantMedecin = identifiantMedecin;
        this.prescriptions = prescriptions;
    }

    // COnsultation sans Prescription ?? maybe no need
    public Consultation(String identifiant, String numero, LocalDateTime date, String identifiantPatient, String identifiantMedecin) {
        this.identifiant = identifiant;
        this.numero = numero;
        this.date = date;
        this.identifiantPatient = identifiantPatient;
        this.identifiantMedecin = identifiantMedecin;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getIdentifiantPatient() {
        return identifiantPatient;
    }

    public void setIdentifiantPatient(String identifiantPatient) {
        this.identifiantPatient = identifiantPatient;
    }

    public String getIdentifiantMedecin() {
        return identifiantMedecin;
    }

    public void setIdentifiantMedecin(String identifiantMedecin) {
        this.identifiantMedecin = identifiantMedecin;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public String getIdentifiantDocumentAttache() {
        return identifiantDocumentAttache;
    }

    public void setIdentifiantDocumentAttache(String identifiantDocumentAttache) {
        this.identifiantDocumentAttache = identifiantDocumentAttache;
    }
}