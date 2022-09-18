package ecuex.eTicaret.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecuex.eTicaret.business.dto.SalesDto;
import ecuex.eTicaret.business.requests.sales.CreateSalesRequest;
import ecuex.eTicaret.business.requests.sales.DeleteSalesRequest;
import ecuex.eTicaret.business.requests.sales.UpdateSalesRequest;
import ecuex.eTicaret.business.service.SalesService;
import ecuex.eTicaret.core.utilities.results.DataResult;
 
@RestController
@RequestMapping

public class SalessController {
	
	private SalesService salesService;

	@Autowired
	public SalessController(SalesService salesService) {
		super();
		this.salesService = salesService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SalesDto>> getAll(){
		return this.salesService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<SalesDto> add(@RequestBody @Validated CreateSalesRequest createSalesRequest) {
		return this.salesService.add(createSalesRequest);
	}
	
	@PutMapping("/update")
	public DataResult<SalesDto> update(@RequestBody @Validated UpdateSalesRequest updateSalesRequest) {
		return this.salesService.update(updateSalesRequest);
	}
	
	@PostMapping("/getBySalesId")
	public DataResult<List<SalesDto>> getBySalesId(int userId){
		return null;
	}

	@DeleteMapping("/delete")
	public DataResult<SalesDto> delete(@RequestBody @Validated DeleteSalesRequest deleteSalesRequest) {
		return this.salesService.delete(deleteSalesRequest);
	}
	

}
