package ngn.api.login.service;

import ngn.api.login.models.SignUpRequest;
import ngn.api.login.models.SigninRequest;
import ngn.api.login.repository.JwtAuthenticationResponse;

public interface AuthenticationService {
	JwtAuthenticationResponse signup(SignUpRequest request);

	JwtAuthenticationResponse signin(SigninRequest request);

}
