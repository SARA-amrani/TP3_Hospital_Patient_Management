package ma.enset.tp3_springmvc_hopital;

import ma.enset.tp3_springmvc_hopital.entities.Patient;
import ma.enset.tp3_springmvc_hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HopitalApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HopitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       // patientRepository.save(new Patient(null, "SARA","EL AMRANI", new Date(), false,34));
        //patientRepository.save(new Patient(null, "AYA","EL AMRANI", new Date(), true,55));
        //patientRepository.save(new Patient(null, "HOUDA","EL AMRANI", new Date(), false,70));
        //patientRepository.save(new Patient(null, "MUSTAPHA","EL AMRANI", new Date(), true,60));

        // en utilisant Builder
        Patient patient=Patient.builder()
                .nom("Imane")
                .prenom("Alami")
                .dateNaissance(new Date())
                .score(56)
                .malade(true)
                .build();
    }

    //CommandLineRunner commandLineRunner()
}
