package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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
    public User getUser(@PathVariable Long userId){
        return userService.findUserById(userId);
    }

    @PatchMapping("/{userId}/block")
    @PreAuthorize("hasRole('DEVELOPER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void blockUser(@PathVariable Long userId){
        userService.blockUser(userId);
    }

    @PatchMapping("/{userId}/unblock")
    @PreAuthorize("hasRole('DEVELOPER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void unblockUser(@PathVariable Long userId){
        userService.unblockUser(userId);
    }
}
