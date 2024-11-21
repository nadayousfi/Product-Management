package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProduitDTO;

public interface CategoryService {
List<CategoryDto> getAllCategory();
List<CategoryDto> getByNomProduit(String nom);
CategoryDto getCategoryById(Long id);
CategoryDto saveCategory(CategoryDto c);
CategoryDto updateCategory(CategoryDto c);


}
