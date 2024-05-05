package com.project.ecom.services.admin.adminproduct;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.ecom.dto.ProductDto;
import com.project.ecom.entity.Category;
import com.project.ecom.entity.Product;
import com.project.ecom.repository.CategoryRepository;
import com.project.ecom.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminProductServiceImpl implements AdminProductService{

	private final ProductRepository productRepository;
	
	private final CategoryRepository categoryRepository;
	
	public ProductDto addProduct(ProductDto productDto) throws IOException {
		Product product = new Product();
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setImg(productDto.getImg().getBytes());
		System.out.println("name: "+productDto.getName());
		System.out.println("id: "+ productDto.getId());
		Category category= categoryRepository.findById(productDto.getCategoryId()).orElseThrow();
		
		product.setCategory(category);
		
		return productRepository.save(product).getDto();
	}
	
	public List<ProductDto> getAllproducts(){
		List<Product> products= productRepository.findAll();
		return products.stream().map(Product::getDto).collect(Collectors.toList());
	}
}
