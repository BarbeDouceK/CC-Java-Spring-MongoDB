package fr.batou.rest_webservice_java_mongo.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class ServiceAuthentification {

    private final AuthenticationManager gestionnaireAuthentification;
    private final ServiceJwt serviceJwt; // Service utilitaire pour générer le Token (ex: librairie jjwt)

    public ServiceAuthentification(AuthenticationManager gestionnaireAuthentification, ServiceJwt serviceJwt) {
        this.gestionnaireAuthentification = gestionnaireAuthentification;
        this.serviceJwt = serviceJwt;
    }

    public String authentifierEtGenererJeton(String nomUtilisateur, String motDePasse) {
        // 1. Vérification des identifiants
        Authentication authentification = gestionnaireAuthentification.authenticate(
                new UsernamePasswordAuthenticationToken(nomUtilisateur, motDePasse)
        );

        // 2. Génération du jeton JWT si succès
        return serviceJwt.genererJeton(authentification);
    }
}