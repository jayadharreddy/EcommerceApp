package com.project.ecom.services.admin.adminproduct;

import java.io.IOException;
import java.util.List;

import com.project.ecom.dto.ProductDto;

public interface AdminProductService {
 
	ProductDto addProduct(ProductDto productDto) throws IOException;
	
	List<ProductDto> getAllproducts();
}
