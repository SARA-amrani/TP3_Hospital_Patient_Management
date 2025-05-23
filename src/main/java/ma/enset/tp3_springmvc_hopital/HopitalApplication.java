package ma.enset.tp3_springmvc_hopital;

import ma.enset.tp3_springmvc_hopital.entities.Patient;
import ma.enset.tp3_springmvc_hopital.repository.PatientRepository;
import ma.enset.tp3_springmvc_hopital.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

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
       // patientRepository.save(new Patient(null, "Imane","Alami", new Date(), false,57));
        //patientRepository.save(new Patient(null, "Rim","Toto", new Date(), true,55));
        //patientRepository.save(new Patient(null, "Nezha","Didi", new Date(), false,70));
        //patientRepository.save(new Patient(null, "Bilal","EL AMRANI", new Date(), true,60));

        // en utilisant Builder
        Patient patient=Patient.builder()
                .nom("Imane")
                .prenom("Alami")
                .dateNaissance(new Date())
                .score(56)
                .malade(true)
                .build();
    }

   // @Bean
    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager) {
        PasswordEncoder passwordEncoder = passwordEncoder();
        return args -> {
            UserDetails u11 = jdbcUserDetailsManager.loadUserByUsername("user11");
            if(u11==null)
                jdbcUserDetailsManager.createUser(
                    User.withUsername("user11").password(passwordEncoder.encode("1234")).roles("USER").build()
            );
            UserDetails u22 = jdbcUserDetailsManager.loadUserByUsername("user22");
            if(u22==null)
                jdbcUserDetailsManager.createUser(
                    User.withUsername("user22").password(passwordEncoder.encode("1234")).roles("USER").build()
            );
            UserDetails u33 = jdbcUserDetailsManager.loadUserByUsername("admin11");
            if(u33==null)
                jdbcUserDetailsManager.createUser(
                    User.withUsername("admin11").password(passwordEncoder.encode("1234")).roles("USER","ADMIN").build()
            );
        };
    }
    @Bean
    CommandLineRunner commandLineRunnerUserDetails(AccountService accountService) {
        return args -> {
            try {
                accountService.addNewRole("USER");
            } catch (RuntimeException e) {
                System.out.println("Role USER already exists.");
            }

            try {
                accountService.addNewRole("ADMIN");
            } catch (RuntimeException e) {
                System.out.println("Role ADMIN already exists.");
            }

            if (accountService.loadUserByUsername("user1") == null)
                accountService.addNewUser("user1", "1234", "1234", "user1@gmail.com");

            if (accountService.loadUserByUsername("user2") == null)
                accountService.addNewUser("user2", "1234", "1234", "user2@gmail.com");

            if (accountService.loadUserByUsername("admin") == null)
                accountService.addNewUser("admin", "1234", "1234", "admin@gmail.com");

            accountService.addRoleToUser("user1", "USER");
            accountService.addRoleToUser("user2", "USER");
            accountService.addRoleToUser("admin", "USER");
            accountService.addRoleToUser("admin", "ADMIN");
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
