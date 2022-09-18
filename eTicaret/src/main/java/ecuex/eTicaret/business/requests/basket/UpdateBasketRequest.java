package ecuex.eTicaret.business.requests.basket;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateBasketRequest {

	@NotNull
	private int id;
	
	@NotNull
	private int userId;
	
	@NotNull
	private int productId;
	
	@NotNull
	private int status;
}
