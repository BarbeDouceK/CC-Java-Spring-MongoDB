package fr.batou.rest_webservice_java_mongo.repositories;

import fr.batou.rest_webservice_java_mongo.modeles.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    // Recherche optionnelle par nom ou numéro de sécu (en ignorant la casse)
    @Query("{ '$or': [ { 'nom': { '$regex': ?0, '$options': 'i' } }, { 'numeroSecuriteSociale': { '$regex': ?0, '$options': 'i' } } ] }")
    Page<Patient> rechercherParNomOuNumero(String motCle, Pageable pagination);
}