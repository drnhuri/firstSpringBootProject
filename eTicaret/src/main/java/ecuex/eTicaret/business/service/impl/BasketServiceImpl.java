package ecuex.eTicaret.business.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecuex.eTicaret.business.dto.BasketDto;
import ecuex.eTicaret.business.requests.basket.CreateBasketRequest;
import ecuex.eTicaret.business.requests.basket.DeleteBasketRequest;
import ecuex.eTicaret.business.requests.basket.UpdateBasketRequest;
import ecuex.eTicaret.business.service.BasketService;
import ecuex.eTicaret.core.utilities.results.DataResult;
import ecuex.eTicaret.core.utilities.results.ErrorDataResult;
import ecuex.eTicaret.core.utilities.results.SuccessDataResult;
import ecuex.eTicaret.dataAccess.BasketDao;
import ecuex.eTicaret.entities.Basket;

@Service

public class BasketServiceImpl implements BasketService{

	BasketDao basketDao;
	ModelMapper modelMapper;
	
	@Autowired
	public BasketServiceImpl(BasketDao basketDao, ModelMapper modelMapper) {
		super();
		this.basketDao = basketDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<BasketDto>> getAll() {
		
		List<Basket> baskets = this.basketDao.findAll();
		List<BasketDto> basketsDto = baskets.stream().map(basket -> modelMapper.map(basket, BasketDto.class)).collect(Collectors.toList());
				
		return new SuccessDataResult<List<BasketDto>>(basketsDto,"Listelendi");
	}

	@Override
	public DataResult<BasketDto> add(CreateBasketRequest createBasketRequest) {
		
		Basket basket = this.modelMapper.map(createBasketRequest, Basket.class);
		basket = basketDao.save(basket);
		BasketDto basketDto = this.modelMapper.map(basket, BasketDto.class);
		
		return new SuccessDataResult<BasketDto>(basketDto, "Eklendi");
	}

	@Override
	public DataResult<BasketDto> delete(DeleteBasketRequest deleteBasketRequest) {
		
		if(!this.basketDao.existsById(deleteBasketRequest.getId())) {
			return new ErrorDataResult<BasketDto>("id bulunmamaktadır");
		}
		
		return new SuccessDataResult<BasketDto>("silindi");
	}

	@Override
	public DataResult<BasketDto> update(UpdateBasketRequest updateBasketRequest) {
		
		if(!this.basketDao.existsById(updateBasketRequest.getId())) {
			return new ErrorDataResult<>("id bulunmamaktadır");
		}
		
		Basket basket = this.modelMapper.map(updateBasketRequest, Basket.class);
		basket = this.basketDao.save(basket);
		BasketDto basketDto = this.modelMapper.map(basket, BasketDto.class);
		
		return new SuccessDataResult<BasketDto>(basketDto, "Güncellendi");
	}

	



}
