package erwin.springbootlearning.Controller;

import erwin.springbootlearning.Entity.Users;
import erwin.springbootlearning.Service.UserDetailService;
import erwin.springbootlearning.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {
    private final UserService userService;
    public UsersController(UserService userService) {
        this.userService = userService;

    }
    @GetMapping("/")
    public String index(HttpServletRequest request) {
        return "Hello World! " + request.getSession().getId();
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @GetMapping("/user")
    public String userName(){
        return "username";
    }
    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userService.getUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Users> saveUser(@RequestBody Users users){
        Users savedUser = userService.saveUser(users);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users users){
        String token = userService.verify(users);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }







}
