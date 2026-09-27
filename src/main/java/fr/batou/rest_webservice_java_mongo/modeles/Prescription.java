package fr.batou.rest_webservice_java_mongo.modeles;

import jakarta.persistence.Entity;

public class Prescription {
    private String identifiantMedicament;
    private String libelleMedicament;
    private int nombrePrises;

    public Prescription(String identifiantMedicament, String libelleMedicament, int nombrePrises) {
        this.identifiantMedicament = identifiantMedicament;
        this.libelleMedicament = libelleMedicament;
        this.nombrePrises = nombrePrises;
    }

    public String getIdentifiantMedicament() {
        return identifiantMedicament;
    }

    public void setIdentifiantMedicament(String identifiantMedicament) {
        this.identifiantMedicament = identifiantMedicament;
    }

    public String getLibelleMedicament() {
        return libelleMedicament;
    }

    public void setLibelleMedicament(String libelleMedicament) {
        this.libelleMedicament = libelleMedicament;
    }

    public int getNombrePrises() {
        return nombrePrises;
    }

    public void setNombrePrises(int nombrePrises) {
        this.nombrePrises = nombrePrises;
    }
}

