package fr.batou.rest_webservice_java_mongo.services;


import fr.batou.rest_webservice_java_mongo.repositories.ConsultationRepository;
import fr.batou.rest_webservice_java_mongo.repositories.MedecinRepository;
import fr.batou.rest_webservice_java_mongo.repositories.PatientRepository;
import fr.batou.rest_webservice_java_mongo.modeles.Consultation;
import fr.batou.rest_webservice_java_mongo.modeles.Medecin;
import fr.batou.rest_webservice_java_mongo.modeles.Patient;
import fr.batou.rest_webservice_java_mongo.modeles.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceClinique {

    private final PatientRepository repoPAT;
    private final MedecinRepository repoMED;
    private final ConsultationRepository repoConsultation;

    // Injection de dépendances
    public ServiceClinique(PatientRepository repoPAT, MedecinRepository repoMED, ConsultationRepository repoConsultation) {
        this.repoPAT = repoPAT;
        this.repoMED = repoMED;
        this.repoConsultation = repoConsultation;
    }

    // Lister les patients (avec pagination et recherche)
    public Page<Patient> listerPatients(String recherche, Pageable pagination) {
        if (recherche != null && !recherche.isBlank()) {
            return repoPAT.rechercherParNomOuNumero(recherche, pagination);
        }
        return repoPAT.findAll(pagination);
    }

    // Lister les médecins (avec pagination et recherche)
    public Page<Medecin> listerMedecins(String recherche, Pageable pagination) {
        if (recherche != null && !recherche.isBlank()) {
            return repoMED.rechercherParNomOuMatricule(recherche, pagination);
        }
        return repoMED.findAll(pagination);
    }

    // Lister les consultations d'un patient donné
    public Page<Consultation> listerConsultationsPatient(String identifiantPatient, Pageable pagination) {
        return repoConsultation.findByIdentifiantPatient(identifiantPatient, pagination);
    }

    // Ajouter, modifier ou supprimer une consultation
    public Consultation ajouterConsultation(Consultation consultation) {
        if (consultation.getDate().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La consultation doit être programmée dans le futur.");
        }
        return repoConsultation.save(consultation);
    }

    /**
     * Modifier une consultation, renvoi une Erreur si pas trouvée
     *
     * @param id
     * @param donneesAjour
     * @return
     */
    public Consultation modifierConsultation(String id, Consultation donneesAjour) {
        Consultation existante = repoConsultation.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Consultation introuvable"));
        existante.setDate(donneesAjour.getDate());
        existante.setMedecin(donneesAjour.getMedecin());
        // Mise à jour des autres champs...
        return repoConsultation.save(existante);
    }

    /**
     * Delete
     *
     * @param id
     */
    public void supprimerConsultation(String id) {
        repoConsultation.deleteById(id);
    }

    /**
     *
     * @param identifiantConsultation
     * @return List<Prescription>
     */
    // Détailler les médicaments prescrits
    public List<Prescription> detaillerPrescriptions(String identifiantConsultation) {
        Consultation consultation = repoConsultation.findById(identifiantConsultation)
                .orElseThrow(() -> new IllegalArgumentException("Consultation introuvable"));
        return consultation.getPrescriptions();
    }

    /**
     *
     * @param identifiantConsultation
     * @param nouvellesPrescriptions
     * @return bool : sauvegardé ou non 1 ou 0
     */
    // Modifier la prescription
    public Consultation modifierPrescriptions(String identifiantConsultation, List<Prescription> nouvellesPrescriptions) {
        Consultation consultation = repoConsultation.findById(identifiantConsultation)
                .orElseThrow(() -> new IllegalArgumentException("Consultation introuvable"));
        consultation.setPrescriptions(nouvellesPrescriptions);
        return repoConsultation.save(consultation);
    }

    // Joindre un document
    public Consultation joindreDocument(String identifiantConsultation, MultipartFile fichier) {
        Consultation consultation = repoConsultation.findById(identifiantConsultation)
                .orElseThrow(() -> new IllegalArgumentException("Consultation introuvable"));

        String identifiantFichier = "DOC_" + fichier.getOriginalFilename();
        consultation.setIdentifiantDocumentAttache(identifiantFichier);

        return repoConsultation.save(consultation);
    }
}