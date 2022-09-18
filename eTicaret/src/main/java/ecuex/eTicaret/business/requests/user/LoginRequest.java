package ecuex.eTicaret.business.requests.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginRequest {

	@NotNull
	@Email
	String email;
	
	@NotNull
	String password;
	
}
