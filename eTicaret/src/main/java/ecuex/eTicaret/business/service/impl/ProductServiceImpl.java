package ecuex.eTicaret.business.service.impl;

import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecuex.eTicaret.business.dto.ProductDto;
import ecuex.eTicaret.business.requests.product.CreateProductRequest;
import ecuex.eTicaret.business.requests.product.DeleteProductRequest;
import ecuex.eTicaret.business.requests.product.UpdateProductRequest;
import ecuex.eTicaret.business.service.ProductService;
import ecuex.eTicaret.core.utilities.results.DataResult;
import ecuex.eTicaret.core.utilities.results.ErrorDataResult;
import ecuex.eTicaret.core.utilities.results.SuccessDataResult;
import ecuex.eTicaret.dataAccess.ProductDao;
import ecuex.eTicaret.entities.Product;

@Service

public class ProductServiceImpl implements ProductService{

	ModelMapper modelMapper;
	ProductDao productDao;
	
	@Autowired
	public ProductServiceImpl(ProductDao productDao,ModelMapper modelMapper) {
		super();
		this.productDao = productDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<ProductDto>> getAll() {
		
		List<Product> products = this.productDao.findAll();
		List<ProductDto> productsDto = products.stream().map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<ProductDto>>(productsDto, "Ürünler listelendi");
	}

	@Override
	public DataResult<ProductDto> getByProductId(int id) {
		
		if(!this.productDao.existsById(id)) {
			return new ErrorDataResult<ProductDto>("id yoktur");
		}
		
		Product product = this.productDao.getById(id);
		ProductDto productDto = this.modelMapper.map(product, ProductDto.class);
		
		return new SuccessDataResult<ProductDto>(productDto);
	}

	@Override
	public DataResult<ProductDto> add(CreateProductRequest createProductRequest) {
		
		Product product = this.modelMapper.map(createProductRequest, Product.class);
		product = productDao.save(product);
		ProductDto productDto = this.modelMapper.map(product, ProductDto.class);
		
		return new SuccessDataResult<ProductDto>(productDto,"Ürün eklendi");
	}

	@Override
	public DataResult<ProductDto> delete(DeleteProductRequest deleteProductRequest) {
		
		if(!this.productDao.existsById(deleteProductRequest.getId())) {
			return new ErrorDataResult<>("id ye sahip ürün bulunmamaktadır");
		}

		this.productDao.deleteById(deleteProductRequest.getId());
		
		return new SuccessDataResult<ProductDto>("Ürün silindi");
	}

	@Override
	public DataResult<ProductDto> update(UpdateProductRequest updateProductRequest) {
		
		if(!this.productDao.existsById(updateProductRequest.getId())){
			return new ErrorDataResult<ProductDto>("İd yoktur");
		}
		
		Product product = this.modelMapper.map(updateProductRequest, Product.class);
		product = this.productDao.save(product);
		ProductDto productDto = this.modelMapper.map(product, ProductDto.class);
		
		return new SuccessDataResult<ProductDto>(productDto, "Güncellendi");
	}

	



	


	

}
