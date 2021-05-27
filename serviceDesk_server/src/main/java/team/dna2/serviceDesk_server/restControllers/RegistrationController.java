//
//package team.dna2.serviceDesk_server.restControllers;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import team.dna2.serviceDesk_server.databaseService.entities.Developer;
//import team.dna2.serviceDesk_server.databaseService.entities.Member;
//import team.dna2.serviceDesk_server.databaseService.entities.User;
//import team.dna2.serviceDesk_server.databaseService.services.UserService;
//
//import javax.annotation.Resource;
//
//@Deprecated
//@RestController
//@RequestMapping("/admin")
//@Validated
//@Slf4j
//public class RegistrationController {
//
//    @Resource
//    private UserService userService;
//
//
//    @PostMapping("/registration")
//    public String addUser(@ModelAttribute("userForm") @Validated User userForm, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            //errors
//            return "registration";
//        }
//        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
//            //passwordError", "Пароли не совпадают"
//            return "registration";
//        }
//        if (!userService.saveUser(userForm)){
//            //"usernameError", "Пользователь с таким именем уже существует"
//            return "registration";
//        }
//
//        return "redirect:/";
//    }
//
//    @PostMapping("/registration/member")
//    public String registration(@RequestParam Member newMember) {
//
//        return "redirect:/";
//    }
//
//    @PostMapping("/registration/developer")
//    public String registration(@RequestParam Developer newDeveloper) {
//
//        return "redirect:/";
//    }
//}
