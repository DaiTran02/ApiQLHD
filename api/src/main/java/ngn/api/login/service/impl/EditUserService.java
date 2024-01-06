package ngn.api.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ngn.api.login.models.User;
import ngn.api.login.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class EditUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public boolean checkPassword(String email,String oldPassword) {
		User user = userRepository.findByEmail(email).get();
		if(passwordEncoder.matches(oldPassword, user.getPassword())==true) {
			return true;
		}
		return false;
	}
	
	public void changePassword(String email,String passWord) {
		User user = userRepository.findByEmail(email).get();
		System.out.println("Data: "+user);
		
		user.setPassword(passwordEncoder.encode(passWord));
		userRepository.save(user);
	}

}
