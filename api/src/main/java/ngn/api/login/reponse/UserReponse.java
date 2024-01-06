package ngn.api.login.reponse;

import lombok.Data;

@Data
public class UserReponse {
	private int status;
	private String message;
	private UserPass data;
}
