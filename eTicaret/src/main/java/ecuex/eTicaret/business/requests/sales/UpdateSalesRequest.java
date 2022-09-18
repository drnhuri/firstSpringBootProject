package ecuex.eTicaret.business.requests.sales;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateSalesRequest {
	
	@NotNull
	private int id;
	
	@NotNull
	private int userId;
	
	@NotNull
	private int productId;
	
	private double unitPrice;
	
	private int quantity;

}
