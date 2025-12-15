package eee.com.sevenfit.LoginandRegister;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public String register(User user) {

        if (repo.existsByEmail(user.getEmail())) {
            return "Email already exists";
        }

        repo.save(user);
        return "success";
    }
    
    public String login(String email, String password) {
    	
    	 User user = repo.findByEmail(email);

         if (user == null) {
             throw new RuntimeException("User not found");
         }

         if (!user.getPassword().equals(password)) {
             throw new RuntimeException("Invalid password");
         }

         // ✅ Generate JWT token
         return JwtUtil.generateToken(user.getEmail());
    }
}

