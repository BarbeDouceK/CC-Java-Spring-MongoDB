package fr.batou.rest_webservice_java_mongo.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * DTO for {@link fr.batou.rest_webservice_java_mongo.modeles.Consultation}
 */
public class ConsultationDto implements Serializable {
    private final String identifiant;
    private final String numero;
    private final LocalDateTime date;
    private final String identifiantPatient;
    private final String identifiantMedecin;

    public ConsultationDto(String identifiant, String numero, LocalDateTime date, String identifiantPatient, String identifiantMedecin) {
        this.identifiant = identifiant;
        this.numero = numero;
        this.date = date;
        this.identifiantPatient = identifiantPatient;
        this.identifiantMedecin = identifiantMedecin;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getIdentifiantPatient() {
        return identifiantPatient;
    }

    public String getIdentifiantMedecin() {
        return identifiantMedecin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultationDto entity = (ConsultationDto) o;
        return Objects.equals(this.identifiant, entity.identifiant) &&
                Objects.equals(this.numero, entity.numero) &&
                Objects.equals(this.date, entity.date) &&
                Objects.equals(this.identifiantPatient, entity.identifiantPatient) &&
                Objects.equals(this.identifiantMedecin, entity.identifiantMedecin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiant, numero, date, identifiantPatient, identifiantMedecin);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "identifiant = " + identifiant + ", " +
                "numero = " + numero + ", " +
                "date = " + date + ", " +
                "identifiantPatient = " + identifiantPatient + ", " +
                "identifiantMedecin = " + identifiantMedecin + ")";
    }
}