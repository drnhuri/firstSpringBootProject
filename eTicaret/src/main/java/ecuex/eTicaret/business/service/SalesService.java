package ecuex.eTicaret.business.service;

import java.util.List;


import ecuex.eTicaret.business.dto.SalesDto;
import ecuex.eTicaret.business.requests.sales.CreateSalesRequest;
import ecuex.eTicaret.business.requests.sales.DeleteSalesRequest;
import ecuex.eTicaret.business.requests.sales.UpdateSalesRequest;
import ecuex.eTicaret.core.utilities.results.DataResult;


public interface SalesService {
	DataResult<List<SalesDto>> getAll();
	
	DataResult<SalesDto> getBySalesId(int id);
	
	DataResult<SalesDto> add(CreateSalesRequest createSalesRequest);
	
	DataResult<SalesDto> delete(DeleteSalesRequest deleteSalesRequest);
	
	DataResult<SalesDto> update(UpdateSalesRequest updateSalesRequest);
	
	

}
