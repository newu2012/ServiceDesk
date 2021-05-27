package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.dna2.serviceDesk_server.databaseService.entities.User;
import team.dna2.serviceDesk_server.databaseService.services.UserService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/{userId}")
    public User getTicketCategory(@PathVariable Long userId){
        return userService.findUserById(userId);
    }
}
