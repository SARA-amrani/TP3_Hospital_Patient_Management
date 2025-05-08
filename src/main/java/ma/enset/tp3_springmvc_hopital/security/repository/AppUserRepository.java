package ma.enset.tp3_springmvc_hopital.security.repository;

import ma.enset.tp3_springmvc_hopital.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    // Methode qui permet de chercher un utilisateur
    AppUser findByUsername(String username);
}
