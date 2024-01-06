package ngn.api.login.reponse;

import org.springframework.http.ResponseEntity;

import lombok.Data;
import ngn.api.login.repository.JwtAuthenticationResponse;

@Data
public class UserPass {
	private String email;
	private String token;

}
