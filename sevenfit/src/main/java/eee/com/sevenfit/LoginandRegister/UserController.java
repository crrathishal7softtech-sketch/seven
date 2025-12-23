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
   
    public UserResponse user(Authentication authentication) {

        String email = authentication.getName(); 
        User user = service.getCurrentUser(email);

        return new UserResponse(
            user.getId(),
            user.getEmail()
        );
    }


    

}

