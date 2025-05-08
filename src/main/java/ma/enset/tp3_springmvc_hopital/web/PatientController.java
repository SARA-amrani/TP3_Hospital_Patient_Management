package ma.enset.tp3_springmvc_hopital.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.tp3_springmvc_hopital.entities.Patient;
import ma.enset.tp3_springmvc_hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    // chercher les patients
    @GetMapping("/user/index")
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

    // delete Patient
    @GetMapping("/admin/delete")
    @PreAuthorize("hasRole('ROLE ADMIN')")
    public String delete(Long id, String keyword, int page) {
        patientRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/")
    public String home() {
        return "redirect:/user/index";
    }

    @GetMapping("/patients")
    @ResponseBody
    public List<Patient> listPatients() {
        return patientRepository.findAll();
    }

    // methode qui permet de retourner une vue : formulaire de saisie
    @GetMapping("/formPatient")
    @PreAuthorize("hasRole('ROLE ADMIN')")
    public String formPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "formPatient";
    }

    // save Patient
    @PostMapping("/admin/save")
    @PreAuthorize("hasRole('ROLE ADMIN')")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue ="") String keyword) {
        if (bindingResult.hasErrors()) return "formPatient";
        patientRepository.save(patient);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    // editPatient

    @GetMapping("/admin/editPatient")
    @PreAuthorize("hasRole('ROLE ADMIN')")
    public String editPatient(Model model, Long id, String keyword, int page) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient == null) throw new RuntimeException("Patient introuvable");
        model.addAttribute("patient",patient);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "editPatient";
    }

}
