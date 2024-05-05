package com.project.ecom.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductDto {
	
	private int id;
	
	private String name;
	
	private long price;

	private String description;
	
	private byte[] byteImg;
	
	private Long categoryId; //maps product with category
	
	private MultipartFile img;
}
