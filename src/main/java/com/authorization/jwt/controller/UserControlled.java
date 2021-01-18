package com.authorization.jwt.controller;

import com.authorization.jwt.entity.ApplicationUser;
import com.authorization.jwt.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserControlled {

//    @Autowired
//    private UserService userService;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserControlled(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/signup")
    public ApplicationUser saveUser(@RequestBody ApplicationUser user){
        System.out.println("user"+user.toString());
        ApplicationUser applicationUser = new ApplicationUser(user);
        applicationUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        ApplicationUser save = applicationUserRepository.save(applicationUser);
        return save;
    }
}
