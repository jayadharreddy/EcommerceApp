package com.project.ecom.services.admin.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ecom.dto.CategoryDto;
import com.project.ecom.entity.Category;
import com.project.ecom.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

	private final CategoryRepository categoryRepository;
	
	public Category createcategory(CategoryDto categorydto) {
		Category category=new Category();
		category.setName(categorydto.getName());
		category.setDescription(categorydto.getDescription());
		 
		return categoryRepository.save(category);
	}
	
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
}
