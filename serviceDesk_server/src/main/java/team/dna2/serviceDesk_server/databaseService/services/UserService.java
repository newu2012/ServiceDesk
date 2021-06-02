package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.dna2.serviceDesk_server.databaseService.entities.Role;
import team.dna2.serviceDesk_server.databaseService.entities.User;
import team.dna2.serviceDesk_server.databaseService.repositories.RoleRepository;
import team.dna2.serviceDesk_server.databaseService.repositories.UsersRepository;
import team.dna2.serviceDesk_server.restControllers.requestModels.DeveloperRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UsersRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @PersistenceContext
    private EntityManager em;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

//    @Transactional
//    public boolean saveUser(User user) {
//        User userFromDB = userRepository.findByEmail(user.getUsername());
//
//        if (userFromDB != null) {
//            return false;
//        }
//
//        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
//        user.setPasswordHash(bCryptPasswordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//        return true;
//    }

    @Transactional
    public void createUserDeveloperFromRequest(DeveloperRequest developerRequest) throws Exception{
        User userFromDB = userRepository.findByEmail(developerRequest.getEmail());
        if (userFromDB != null) {
            throw new Exception("User with this email already exists");
        }

        var user = new User();
        user.setEmail(developerRequest.getEmail());
        user.setPasswordHash(bCryptPasswordEncoder.encode(developerRequest.getPassword()));
        user.setFirstName(developerRequest.getFirstName());
        user.setLastName(developerRequest.getLastName());
        user.setPatronymicName(developerRequest.getPatronymicName());
        var roles = new HashSet<Role>();
        roles.add(roleRepository.getOne(1L));
        roles.add(roleRepository.getOne(3L));
        user.setRoles(roles);
        user.setIsActive(true);
        userRepository.save(user);
    }

    @Deprecated
    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Transactional
    public void blockUser(Long id){
        userRepository.blockUserById(id);
    }

    @Transactional
    public void unblockUser(Long id){
        userRepository.unblockUserById(id);
    }
}
