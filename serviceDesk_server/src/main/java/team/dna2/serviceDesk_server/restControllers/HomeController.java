package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String getHome() {
        return "HELLO WORLD! THIS IS SERVICE DESK! DO YOU SEE?";
    }

//    @PostMapping("/logout")
//    public String logOut(){
//        return "logout";
//    }
//
//    @PostMapping("/login")
//    public String logIn(){
//        return "login";
//    }

}
