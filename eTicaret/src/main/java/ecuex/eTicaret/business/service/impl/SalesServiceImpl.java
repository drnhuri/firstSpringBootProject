package ecuex.eTicaret.business.service.impl;

import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecuex.eTicaret.business.dto.SalesDto;
import ecuex.eTicaret.business.requests.sales.CreateSalesRequest;
import ecuex.eTicaret.business.requests.sales.DeleteSalesRequest;
import ecuex.eTicaret.business.requests.sales.UpdateSalesRequest;
import ecuex.eTicaret.business.service.SalesService;
import ecuex.eTicaret.core.utilities.results.DataResult;
import ecuex.eTicaret.core.utilities.results.ErrorDataResult;
import ecuex.eTicaret.core.utilities.results.SuccessDataResult;
import ecuex.eTicaret.dataAccess.SalesDao;
import ecuex.eTicaret.entities.Sales;

@Service

public class SalesServiceImpl implements SalesService{

	ModelMapper modelMapper;
	SalesDao salesDao;
	
	@Autowired
	public SalesServiceImpl(SalesDao salesDao,ModelMapper modelMapper) {
		super();
		this.salesDao = salesDao;
		this.modelMapper = modelMapper;
	}

	
	@Override
	public DataResult<List<SalesDto>> getAll() {
		
		List<Sales> saless = this.salesDao.findAll();
		List<SalesDto> salessDto = saless.stream().map(sales -> modelMapper.map(sales, SalesDto.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<SalesDto>>(salessDto, "Listelendi");
	}

	
	@Override
	public DataResult<SalesDto> add(CreateSalesRequest createSalesRequest) {
		
		Sales sales = this.modelMapper.map(createSalesRequest, Sales.class);
		sales = salesDao.save(sales);
		SalesDto salesDto = this.modelMapper.map(sales, SalesDto.class);
		
		return new SuccessDataResult<SalesDto>(salesDto);
	}

	
	@Override
	public DataResult<SalesDto> delete(DeleteSalesRequest deleteSalesRequest) {
		
		if(!this.salesDao.existsById(deleteSalesRequest.getId())){
			return new ErrorDataResult<SalesDto>("id bulunmamaktadır");
		}
		
		this.salesDao.deleteById(deleteSalesRequest.getId());
		
		return new SuccessDataResult<SalesDto>("Kayıt silindi");
	}

	
	@Override
	public DataResult<SalesDto> update(UpdateSalesRequest updateSalesRequest) {
		
		if(!this.salesDao.existsById(updateSalesRequest.getId())) {
			return new ErrorDataResult<SalesDto>("id bulunmamaktadır");
		}
		
		Sales sales = this.modelMapper.map(updateSalesRequest, Sales.class);
		sales = this.salesDao.save(sales);
		SalesDto salesDto = this.modelMapper.map(sales, SalesDto.class);
		
		return new SuccessDataResult<SalesDto>(salesDto,"Güncellendi");
	}


	@Override
	public DataResult<SalesDto> getBySalesId(int id) {
		
		if(!this.salesDao.existsById(id)) {
			return new ErrorDataResult<SalesDto>("id bulunmamaktadır");
		}
		
		Sales sales = this.salesDao.getById(id);
		SalesDto salesDto = this.modelMapper.map(sales, SalesDto.class);
		
		return new SuccessDataResult<SalesDto>(salesDto);
	}

	
}
