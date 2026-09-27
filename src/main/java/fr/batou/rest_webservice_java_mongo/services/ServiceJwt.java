package fr.batou.rest_webservice_java_mongo.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Key;
import java.util.Date;

@Service
public class ServiceJwt {

    private static final Logger log = LoggerFactory.getLogger(ServiceJwt.class);
    // Durée de validité du jeton (ici : 24 heures en millisecondes)
    private final long DUREE_VALIDITE = 86400000L;

    private final Key cleSecrete = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * Génère un jeton JWT après une authentification réussie.
     */
    public String genererJeton(Authentication authentification) {
        // Récupération de l'utilisateur authentifié
        UserDetails utilisateurPrincipal = (UserDetails) authentification.getPrincipal();

        Date now = new Date();
        Date dateExpiration = new Date(now.getTime() + DUREE_VALIDITE);

        // Construction du jeton avec la charge utile (Payload) et la signature
        return Jwts.builder()
                .setSubject(utilisateurPrincipal.getUsername()) // "sub" (sujet du jeton)
                .setIssuedAt(now) // "iat" (date de création)
                .setExpiration(dateExpiration) // "exp" (date d'expiration)
                .signWith(cleSecrete)
                .compact();
    }

    /**
     * Extrait le nom d'utilisateur (le sujet) contenu dans la charge utile du jeton.
     */
    public String extraireNomUtilisateur(String jeton) {
        Claims revendications = Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) cleSecrete)
                .build()
                .parseSignedClaims(jeton)
                .getPayload();

        return revendications.getSubject();
    }

    /**
     * Valide l'intégrité de la signature et vérifie que le jeton n'est pas expiré.
     */
    public boolean validerJeton(String jeton) {
        try {
            Jwts.parser()
                    .verifyWith((javax.crypto.SecretKey) cleSecrete)
                    .build()
                    .parseSignedClaims(jeton);
            return true;
        } catch (Exception e) {
            // Le jeton est invalide (expiré, malformé, signature incorrecte, etc.)
            log.error("Jeton invalide : {}", e.getMessage());
            return false;
        }
    }
}