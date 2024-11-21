package com.example.demo.RESTController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProduitDTO;
import com.example.demo.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CategoryRestController {
private  final CategoryService service;
@GetMapping
public List<CategoryDto> getAll(){
	return service.getAllCategory();
}
@PostMapping
public CategoryDto createCategory (@RequestBody CategoryDto categpryDto) {
	return service.saveCategory(categpryDto);
}
@GetMapping("/{id}")
public CategoryDto findById(@PathVariable long id){
	return service.getCategoryById(id);
}
@GetMapping("/nomProduit/{nom}")
public ResponseEntity<List<CategoryDto>> getAllCategory(@PathVariable String nom){
	return ResponseEntity.ok(service.getByNomProduit(nom));
}
@PutMapping
public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto) {
	return service.updateCategory(categoryDto);
}
}
