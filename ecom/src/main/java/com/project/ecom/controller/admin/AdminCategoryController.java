package com.project.ecom.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecom.dto.CategoryDto;
import com.project.ecom.entity.Category;
import com.project.ecom.services.admin.category.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminCategoryController {

	private final CategoryService categoryService;
	
	@PostMapping("category")
	public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categorydto){
		System.out.println("Category: "+categorydto.getName()+ categorydto.getDescription());
		Category category= categoryService.createcategory(categorydto);
		return ResponseEntity.status(HttpStatus.CREATED).body(category);
	}
}
