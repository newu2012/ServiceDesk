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

    @GetMapping("/developer")
    public String getDev() {
        return "HELLO DEVELOPER! THIS IS SERVICE DESK! DO YOU SEE ME?";
    }

    @GetMapping("/member")
    public String getMember() {
        return "HELLO MEMBER! THIS IS SERVICE DESK! DO YOU SEE ME?";
    }

    @GetMapping("/owner")
    public String getOwner() {
        return "HELLO OWNER! THIS IS SERVICE DESK! DO YOU SEE ME?";
    }

    @GetMapping("/member/tickets")
    public String getTickets() {
        return "HELLO OWNER! THIS IS TICKETS! DO YOU SEE ME?";
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
