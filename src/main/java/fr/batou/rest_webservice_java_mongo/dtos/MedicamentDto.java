package fr.batou.rest_webservice_java_mongo.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link fr.batou.rest_webservice_java_mongo.modeles.Medicament}
 */
public class MedicamentDto implements Serializable {
    private final String identifiant;
    private final String code;
    private final String libelle;

    public MedicamentDto(String identifiant, String code, String libelle) {
        this.identifiant = identifiant;
        this.code = code;
        this.libelle = libelle;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicamentDto entity = (MedicamentDto) o;
        return Objects.equals(this.identifiant, entity.identifiant) &&
                Objects.equals(this.code, entity.code) &&
                Objects.equals(this.libelle, entity.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiant, code, libelle);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "identifiant = " + identifiant + ", " +
                "code = " + code + ", " +
                "libelle = " + libelle + ")";
    }
}