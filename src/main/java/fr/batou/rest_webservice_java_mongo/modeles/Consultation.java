package fr.batou.rest_webservice_java_mongo.modeles;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
}