package ma.enset.tp3_springmvc_hopital.web;

import lombok.AllArgsConstructor;
import ma.enset.tp3_springmvc_hopital.entities.Patient;
import ma.enset.tp3_springmvc_hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page" ,defaultValue = "0") int page,
                        @RequestParam(name = "size" ,defaultValue = "4") int size,
                        @RequestParam(name = "keyword" ,defaultValue = "") String keyword) {
        Page<Patient> pagePatient = patientRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("listPatients",pagePatient.getContent());
        model.addAttribute("pages",new int[pagePatient.getTotalPages()] ); //Pagination
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "patients";
    }
}
