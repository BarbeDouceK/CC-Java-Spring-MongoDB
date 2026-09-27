package fr.batou.rest_webservice_java_mongo.modeles;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medecins")
public class Medecin {
    @Id
    private String identifiant;
    private String matricule;
    private String nomMED;

    public String getNom() {
        return nomMED;
    }

    public void setNom(String nom) {
        this.nomMED = nom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}
