package ecuex.eTicaret.business.requests.product;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateProductRequest {
	
	@NotNull
	private int id;
	
	@NotNull
	private String productName;
	
	@NotNull
	private double unitPrice;
	
	@NotNull
	private short unitsInStock;

}
