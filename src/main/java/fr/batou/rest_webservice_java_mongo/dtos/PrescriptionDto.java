package fr.batou.rest_webservice_java_mongo.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link fr.batou.rest_webservice_java_mongo.modeles.Prescription}
 */
public class PrescriptionDto implements Serializable {
    private final String identifiantMedicament;
    private final String libelleMedicament;
    private final int nombrePrises;

    public PrescriptionDto(String identifiantMedicament, String libelleMedicament, int nombrePrises) {
        this.identifiantMedicament = identifiantMedicament;
        this.libelleMedicament = libelleMedicament;
        this.nombrePrises = nombrePrises;
    }

    public String getIdentifiantMedicament() {
        return identifiantMedicament;
    }

    public String getLibelleMedicament() {
        return libelleMedicament;
    }

    public int getNombrePrises() {
        return nombrePrises;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionDto entity = (PrescriptionDto) o;
        return Objects.equals(this.identifiantMedicament, entity.identifiantMedicament) &&
                Objects.equals(this.libelleMedicament, entity.libelleMedicament) &&
                Objects.equals(this.nombrePrises, entity.nombrePrises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiantMedicament, libelleMedicament, nombrePrises);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "identifiantMedicament = " + identifiantMedicament + ", " +
                "libelleMedicament = " + libelleMedicament + ", " +
                "nombrePrises = " + nombrePrises + ")";
    }
}