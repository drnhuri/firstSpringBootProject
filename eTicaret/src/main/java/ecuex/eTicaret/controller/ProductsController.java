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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecuex.eTicaret.business.dto.ProductDto;
import ecuex.eTicaret.business.requests.product.CreateProductRequest;
import ecuex.eTicaret.business.requests.product.DeleteProductRequest;
import ecuex.eTicaret.business.requests.product.UpdateProductRequest;
import ecuex.eTicaret.business.service.ProductService;
import ecuex.eTicaret.core.utilities.results.DataResult;


@RestController
@RequestMapping("/api/products")

public class ProductsController {
	
	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<ProductDto>> getAll(){
		return this.productService.getAll();
	}
	
	@GetMapping("/getByUserId")
	public DataResult<ProductDto> getByUserId(@RequestParam int id){
		return this.productService.getByProductId(id);
	}
	@PostMapping("/add")
	public DataResult<ProductDto> add(@RequestBody @Validated CreateProductRequest createProductRequest) {
		return this.productService.add(createProductRequest);
	}
	
	@PutMapping("/update")
	public DataResult<ProductDto> update(@RequestBody @Validated UpdateProductRequest updateProductRequest) {
		return this.productService.update(updateProductRequest);
	}

	@DeleteMapping("/delete")
	public DataResult<ProductDto> delete(@RequestBody @Validated DeleteProductRequest deleteProductRequest) {
		return this.productService.delete(deleteProductRequest);
	}
}
