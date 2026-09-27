package fr.batou.rest_webservice_java_mongo.services;

import fr.batou.rest_webservice_java_mongo.repositories.ConsultationRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultationService {
    private final ConsultationRepository consultationRepository;


    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }
}
