package fr.batou.rest_webservice_java_mongo.repositories;

import fr.batou.rest_webservice_java_mongo.modeles.Consultation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsultationRepository extends MongoRepository<Consultation, String> {
    Page<Consultation> findByIdentifiantPatient(String identifiantPatient, Pageable pagination);

    // On imaginera un CRUD des consultations...
}