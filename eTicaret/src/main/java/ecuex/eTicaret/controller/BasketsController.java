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
import ecuex.eTicaret.business.dto.BasketDto;
import ecuex.eTicaret.business.requests.basket.CreateBasketRequest;
import ecuex.eTicaret.business.requests.basket.DeleteBasketRequest;
import ecuex.eTicaret.business.requests.basket.UpdateBasketRequest;
import ecuex.eTicaret.business.service.BasketService;
import ecuex.eTicaret.core.utilities.results.DataResult;


@RestController
@RequestMapping("/api/baskets")
public class BasketsController {
	
	private BasketService basketService;

	@Autowired
	public BasketsController(BasketService basketService) {
		super();
		this.basketService = basketService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<BasketDto>> getAll(){
		return this.basketService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<BasketDto> add(@RequestBody @Validated CreateBasketRequest createBasketRequest) {
		return this.basketService.add(createBasketRequest);
	}
	
	@PutMapping("/update")
	public DataResult<BasketDto> update(@RequestBody @Validated UpdateBasketRequest updateBasketRequest) {
		return this.basketService.update(updateBasketRequest);
	}

	@DeleteMapping("/delete")
	public DataResult<BasketDto> delete(@RequestBody @Validated DeleteBasketRequest deleteBasketRequest) {
		return this.basketService.delete(deleteBasketRequest);
	}
}
