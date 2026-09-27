package fr.batou.rest_webservice_java_mongo.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link fr.batou.rest_webservice_java_mongo.modeles.Medecin}
 */
public class MedecinDto implements Serializable {
    private final String identifiant;
    private final String matricule;
    private final String nom;

    public MedecinDto(String identifiant, String matricule, String nom) {
        this.identifiant = identifiant;
        this.matricule = matricule;
        this.nom = nom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedecinDto entity = (MedecinDto) o;
        return Objects.equals(this.identifiant, entity.identifiant) &&
                Objects.equals(this.matricule, entity.matricule) &&
                Objects.equals(this.nom, entity.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiant, matricule, nom);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "identifiant = " + identifiant + ", " +
                "matricule = " + matricule + ", " +
                "nom = " + nom + ")";
    }
}