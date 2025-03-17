package ma.enset.tp3_springmvc_hopital.repository;

import ma.enset.tp3_springmvc_hopital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long>  {
}
