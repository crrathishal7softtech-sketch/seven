package eee.com.sevenfit.LoginandRegister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return service.register(user);
    }
    
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
      return service.login(request.getEmail(), request.getPassword());
    }
    
    @GetMapping("/UserFetch")
    public UserDetails user(Authentication authentication) {
        return (UserDetails) authentication.getPrincipal();
    }


    

}

