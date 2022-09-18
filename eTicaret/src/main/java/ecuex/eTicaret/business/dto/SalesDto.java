package ecuex.eTicaret.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SalesDto {

	
	private int userId;
	
	private int productId;
	
	private double unitPrice;
	
	private int quantity;

}
