package ecuex.eTicaret.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {

	private String productName;
	
	private double unitPrice;
	
	private short unitsInStock;
}
