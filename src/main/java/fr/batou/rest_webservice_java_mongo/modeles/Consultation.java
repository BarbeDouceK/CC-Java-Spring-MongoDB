package fr.batou.rest_webservice_java_mongo.modeles;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "consultations")
public class Consultation {
    @Id
    private String identifiant;
    private String numero;
    private LocalDateTime date;

    // Relation : Assiste (1,1) -> Référence vers le Patient
    @DocumentReference(lazy = true)
    private Patient patient;

    // Relation : Donne (1,1) -> Référence vers le Médecin
    @DocumentReference(lazy = true)
    private Medecin medecin;

    // Relation : Prescrit (0,n) -> Liste embarquée
    private List<Prescription> prescriptions = new ArrayList<>();

    // Identifiant du fichier joint
    private String identifiantDocumentAttache;

    //Constructeur complet
    public Consultation(String identifiant, String numero, LocalDateTime date, Patient patient, List<Prescription> prescriptions, Medecin medecin, String identifiantDocumentAttache) {
        this.identifiant = identifiant;
        this.numero = numero;
        this.date = date;
        this.patient = patient;
        this.prescriptions = prescriptions;
        this.medecin = medecin;
        this.identifiantDocumentAttache = identifiantDocumentAttache;
    }

    // COnstructeur Vide
    public Consultation() {
    }

    // Sans pièce jointe
    public Consultation(String identifiant, String numero, LocalDateTime date, Patient patient, Medecin medecin, List<Prescription> prescriptions) {
        this.identifiant = identifiant;
        this.numero = numero;
        this.date = date;
        this.patient = patient;
        this.medecin = medecin;
        this.prescriptions = prescriptions;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
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