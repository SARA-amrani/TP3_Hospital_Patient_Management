package ma.enset.tp3_springmvc_hopital.security.repository;

import ma.enset.tp3_springmvc_hopital.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository <AppRole, String> {
}
