package cd.home.redditbackend.Controller;

import cd.home.redditbackend.data.RegisterRequest;
import cd.home.redditbackend.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    public void signup(@RequestBody RegisterRequest registerRequest) {
        this.authService.signup(registerRequest);
    }


}
