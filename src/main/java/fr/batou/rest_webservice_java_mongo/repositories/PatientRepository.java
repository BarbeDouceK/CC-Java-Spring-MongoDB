package fr.batou.rest_webservice_java_mongo.repositories;

import fr.batou.rest_webservice_java_mongo.modeles.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {

    Page<Patient> rechercherParNomOuNumero(String motCle, Pageable pagination);
}