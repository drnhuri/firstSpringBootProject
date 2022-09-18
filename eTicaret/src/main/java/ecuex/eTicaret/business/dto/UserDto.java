package ecuex.eTicaret.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
		
	private String name;
	
	private String lastName;
	
	private String email;
	
	private String phoneNumber;
	
	private String address;

}
