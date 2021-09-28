package cd.home.redditbackend.Controller;

import cd.home.redditbackend.data.LoginRequest;
import cd.home.redditbackend.data.RegisterRequest;
import cd.home.redditbackend.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
        this.authService.signup(registerRequest);
        return new ResponseEntity<>("User registration successful", OK);
    }

    @PostMapping("/logiin")
    public ResponseEntity<String> signup(@RequestBody LoginRequest loginRequest) {
        this.authService.login(loginRequest);
        return new ResponseEntity<>("User registration successful", OK);
    }

    @GetMapping("/accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        this.authService.verifyAccount(token);
        return new ResponseEntity<>("Account activated successfuly", OK);
    }


}
