package by.chertko.delivery.Rest;

import by.chertko.delivery.Dto.AuthUserDto;
import by.chertko.delivery.Dto.RegisterUserDto;
import by.chertko.delivery.Entity.User;
import by.chertko.delivery.Logging.Loggable;
import by.chertko.delivery.Security.jwt.JwtTokenProvider;
import by.chertko.delivery.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.net.BindException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/")
public class AuthAndRegisterRestController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    public AuthAndRegisterRestController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("login")
    @Loggable
    public ResponseEntity<Map<Object, Object>> login(@Valid @RequestBody AuthUserDto authUserDto) {
        try {
            String username = authUserDto.getName();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, authUserDto.getPassword()));
            User user = userService.findByName(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping("/register")
    @Loggable
    public ResponseEntity<User> register(@Valid @RequestBody RegisterUserDto registerUserDto) {
        try {
            userService.register(registerUserDto);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> handleBindException (BindException ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
