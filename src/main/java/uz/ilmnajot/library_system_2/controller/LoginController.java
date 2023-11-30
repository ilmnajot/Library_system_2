package uz.ilmnajot.library_system_2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("/login")
    public String myLoginPage() {
        return "login";
    }

    @RequestMapping("/index")
    public String showMustGoOn() {
        return "index";
    }
    @RequestMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }
}
