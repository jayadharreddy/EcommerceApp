package com.project.ecom.controller.admin;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecom.dto.ProductDto;
import com.project.ecom.services.admin.adminproduct.AdminProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminProductController {

	private final AdminProductService adminProductService;
	
	@PostMapping("/product")
	public ResponseEntity<ProductDto> addProduct(@ModelAttribute ProductDto productDto) throws IOException{
		ProductDto productDto1= adminProductService.addProduct(productDto);
		
		return ResponseEntity.status(HttpStatus.OK).body(productDto1);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> productDtos= adminProductService.getAllproducts();
		
		return ResponseEntity.ok(productDtos);
	} 
	
}
