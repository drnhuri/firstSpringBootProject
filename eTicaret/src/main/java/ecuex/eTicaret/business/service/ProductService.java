package ecuex.eTicaret.business.service;

import java.util.List;


import ecuex.eTicaret.business.dto.ProductDto;
import ecuex.eTicaret.business.requests.product.CreateProductRequest;
import ecuex.eTicaret.business.requests.product.DeleteProductRequest;
import ecuex.eTicaret.business.requests.product.UpdateProductRequest;
import ecuex.eTicaret.core.utilities.results.DataResult;



public interface ProductService {
	DataResult<List<ProductDto>> getAll();
	
	DataResult<ProductDto> getByProductId(int id);
	
	DataResult<ProductDto> add(CreateProductRequest createProductRequest);
	
	DataResult<ProductDto> delete(DeleteProductRequest deleteProductRequest);
	
	DataResult<ProductDto> update(UpdateProductRequest updateProductRequest);
	
	
 
}
