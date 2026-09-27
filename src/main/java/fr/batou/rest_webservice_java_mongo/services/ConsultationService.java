package fr.batou.rest_webservice_java_mongo.services;

import fr.batou.rest_webservice_java_mongo.modeles.Consultation;
import fr.batou.rest_webservice_java_mongo.repositories.ConsultationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConsultationService {
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
}
