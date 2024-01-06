package ngn.api.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ngn.api.login.models.ChangePasswordModel;
import ngn.api.login.models.SignUpRequest;
import ngn.api.login.models.SigninRequest;
import ngn.api.login.reponse.UserPass;
import ngn.api.login.reponse.UserReponse;
import ngn.api.login.repository.JwtAuthenticationResponse;
import ngn.api.login.service.AuthenticationService;
import ngn.api.login.service.UserService;
import ngn.api.login.service.impl.EditUserService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    
    @Autowired
    private EditUserService editUserService;
    
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
    
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/login")
    public UserReponse sigin(@RequestBody SigninRequest request) {
    	UserReponse userReponse = new UserReponse();
    	System.out.println("email: "+request.getEmail()+" Pass: "+request.getPassword());
    	try {
    		userReponse.setStatus(200);
        	userReponse.setMessage("Authentication successful");
        	
        	UserPass userPass = new UserPass();
        	userPass.setEmail(request.getEmail());
        	userPass.setToken(authenticationService.signin(request).getToken().toString());
        	userReponse.setData(userPass);
		} catch (Exception e) {
			e.printStackTrace();
			userReponse.setStatus(500);
        	userReponse.setMessage("KO OK");
        	userReponse.setData(new UserPass());
		}
    	
    	return userReponse;
    }
    
    @PutMapping("/changepassword")
    public UserReponse changePassword(@RequestBody ChangePasswordModel changePasswordModel) {
    	UserReponse userReponse = new UserReponse();
    	try {
    		if(editUserService.checkPassword(changePasswordModel.getEmail(), changePasswordModel.getOldpass())) {
    			editUserService.changePassword(changePasswordModel.getEmail(), changePasswordModel.getConfirmpass());
        		userReponse.setStatus(200);
            	userReponse.setMessage("Success");
            	userReponse.setData(new UserPass());
    		}else {
    			userReponse.setStatus(300);
            	userReponse.setMessage("Pass cu ko dung");
            	userReponse.setData(new UserPass());
    		}
		} catch (Exception e) {
			e.printStackTrace();
			userReponse.setStatus(500);
        	userReponse.setMessage("Fake");
        	userReponse.setData(new UserPass());
		}
    	
    	return userReponse;
    }
}