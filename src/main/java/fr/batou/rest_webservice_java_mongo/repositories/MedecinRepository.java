package fr.batou.rest_webservice_java_mongo.repositories;

import fr.batou.rest_webservice_java_mongo.modeles.Medecin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MedecinRepository extends MongoRepository<Medecin, String> {
    @Query("{ '$or': [ { 'nom': { '$regex': ?0, '$options': 'i' } }, { 'matricule': { '$regex': ?0, '$options': 'i' } } ] }")
    Page<Medecin> rechercherParNomOuMatricule(String recherche, Pageable pagination);
}