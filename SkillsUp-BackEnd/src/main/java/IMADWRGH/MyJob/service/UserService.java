package IMADWRGH.MyJob.service;

import IMADWRGH.MyJob.Controller.Model.LoginBody;
import IMADWRGH.MyJob.Repository.UserRepository;
import IMADWRGH.MyJob.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    private final EncryptionService encryptionService;

    public UserService(UserRepository userRepository, JwtService jwtService, EncryptionService encryptionService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.encryptionService = encryptionService;
    }

    public String Login(LoginBody loginBody) {
        Optional<User> optionalUser = userRepository.findByUserNameIgnoreCase(loginBody.getUsername());
        if (optionalUser.isPresent()) {
            User user =optionalUser.get();
            if (encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())) {
                return jwtService.generateJwt(user);
            }
        }
        return null;
    }
}
