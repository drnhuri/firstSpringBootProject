package ecuex.eTicaret.business.requests.product;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeleteProductRequest {
	
	@NotNull
	private int id;

}
