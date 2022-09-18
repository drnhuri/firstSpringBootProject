package ecuex.eTicaret.business.requests.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateUserRequest {
	
	@NotNull
	private int id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String lastName;
	
	@NotNull
	@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Email formatında hata var")
	private String email;
	
	@NotNull
	@Size(min = 5 , max = 20, message = "Şifre boyutu 5-20 karakter arasında olmalıdır ")
	private String password;
	
	@Pattern(regexp = "5[0-9]{9}",message = "Telefon numarası 5 ile başlamalı ve 10 basamaklı olmalıdır ")
	private String phoneNumber;
	
	@NotNull
	private String address;

}
