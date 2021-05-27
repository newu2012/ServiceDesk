//package team.dna2.serviceDesk_server.restControllers;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import team.dna2.serviceDesk_server.databaseService.entities.User;
//import team.dna2.serviceDesk_server.databaseService.services.UserService;
//
//import javax.annotation.Resource;
//
//@Deprecated
//@RestController
//@RequestMapping("/login")
//@Slf4j
//public class LoginController {
//
//    @Resource
//    private UserService userService;
//
//    @PostMapping
//    public String logIn(@Validated String email, @Validated String passwd, BindingResult bindingResult){
//        if (!bindingResult.hasErrors()) {
//            UserDetails user = userService.loadUserByUsername(email);
//            if(user != null){
//                if(user.getPassword() == passwd){
//
//                }
//            }
//        }
//        return "login";
//    }
//
//}
