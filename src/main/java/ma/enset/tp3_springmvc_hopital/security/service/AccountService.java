package ma.enset.tp3_springmvc_hopital.security.service;

import ma.enset.tp3_springmvc_hopital.security.entities.AppRole;
import ma.enset.tp3_springmvc_hopital.security.entities.AppUser;

public interface AccountService {
    AppUser addNewUser(String userName, String password ,String confirmPassword, String email);
    AppRole addNewRole(String role);
    void addRoleToUser(String userName, String role);
    void removeRoleFromUser(String userName, String role);
    AppUser loadUserByUsername(String userName); // methode qui permet de retourner un user par son nom
}
