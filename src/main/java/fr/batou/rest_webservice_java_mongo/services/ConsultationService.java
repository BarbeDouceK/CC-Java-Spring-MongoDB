package fr.batou.rest_webservice_java_mongo.services;

import fr.batou.rest_webservice_java_mongo.modeles.Consultation;
import fr.batou.rest_webservice_java_mongo.repositories.ConsultationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Service
public class ConsultationService {

    // Mon service doit plutôt prendre les DTOs et non les objets
    // TODO : Faire les DTOs
    private final ConsultationRepository consultationRepository;


    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public Consultation programmerConsultation(Consultation consultation) {
        if (consultation.getDate().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La date de consultation programmée doit être dans le futur.");
        }
        return consultationRepository.save(consultation);
    }
    public Consultation attacherDocument(String identifiantConsultation, MultipartFile fichier) {
        Consultation consultation = consultationRepository.findById(identifiantConsultation)
                .orElseThrow(() -> new IllegalArgumentException("Consultation introuvable"));

        String identifiantFichier = "DOC_" + fichier.getOriginalFilename();
        consultation.setIdentifiantDocumentAttache(identifiantFichier);

        return consultationRepository.save(consultation);
    }
}
