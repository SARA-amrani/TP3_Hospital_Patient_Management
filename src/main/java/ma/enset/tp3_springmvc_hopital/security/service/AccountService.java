package ma.enset.tp3_springmvc_hopital.security.service;

import ma.enset.tp3_springmvc_hopital.security.entities.AppRole;
import ma.enset.tp3_springmvc_hopital.security.entities.AppUser;

public interface AccountService {
    AppUser addNewUser(String username, String password ,String confirmPassword, String email);
    AppRole addNewRole(String role);
    void addRoleToUser(String username, String role);
    void removeRoleFromUser(String username, String role);
    AppUser loadUserByUsername(String username); // methode qui permet de retourner un user par son nom
}
