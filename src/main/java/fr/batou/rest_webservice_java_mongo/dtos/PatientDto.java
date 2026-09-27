package fr.batou.rest_webservice_java_mongo.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link fr.batou.rest_webservice_java_mongo.modeles.Patient}
 */
public class PatientDto implements Serializable {
    private final String identifiant;
    private final String nom;

    public PatientDto(String identifiant, String nom) {
        this.identifiant = identifiant;
        this.nom = nom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientDto entity = (PatientDto) o;
        return Objects.equals(this.identifiant, entity.identifiant) &&
                Objects.equals(this.nom, entity.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiant, nom);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "identifiant = " + identifiant + ", " +
                "nom = " + nom + ")";
    }
}