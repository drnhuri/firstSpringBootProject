package ecuex.eTicaret.business.service;

import java.util.List;


import ecuex.eTicaret.business.dto.BasketDto;
import ecuex.eTicaret.business.requests.basket.CreateBasketRequest;
import ecuex.eTicaret.business.requests.basket.DeleteBasketRequest;
import ecuex.eTicaret.business.requests.basket.UpdateBasketRequest;
import ecuex.eTicaret.core.utilities.results.DataResult;


public interface BasketService {
	DataResult<List<BasketDto>> getAll();
	
	DataResult<BasketDto> add(CreateBasketRequest createBasketRequest);
	
	DataResult<BasketDto> delete(DeleteBasketRequest deleteBasketRequest);
	
	DataResult<BasketDto> update(UpdateBasketRequest updateBasketRequest);
}
