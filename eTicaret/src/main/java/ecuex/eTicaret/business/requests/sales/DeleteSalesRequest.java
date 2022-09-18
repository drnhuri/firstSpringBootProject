package ecuex.eTicaret.business.requests.sales;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeleteSalesRequest {
	
	@NotNull
	private int id;

}
