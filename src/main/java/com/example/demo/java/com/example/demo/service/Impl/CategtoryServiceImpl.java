package com.example.demo.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProduitDTO;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.Produitmapper;
import com.example.demo.repos.CategoryRepository;
import com.example.demo.service.CategoryService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategtoryServiceImpl implements CategoryService {
private final CategoryRepository repository;

@Override
public List<CategoryDto> getAllCategory() {
	return repository.findAll().stream()
			.map(CategoryMapper::convertToDto)
			.collect(Collectors.toList());
}

@Override
public List<CategoryDto> getByNomProduit(String nom) {
	return repository.findByProduitsNomProduit(nom)
			.stream()
			.map(CategoryMapper::convertToDto)
			.collect(Collectors.toList());
}

@Override
public CategoryDto getCategoryById(Long id) {
	return repository.findById(id)
			
			.map(CategoryMapper::convertToDto)
			.orElseThrow(()-> new EntityNotFoundException("pas de command client avec ce id"));

}

@Override
public CategoryDto saveCategory(CategoryDto c) {
 return CategoryMapper.convertToDto(repository.save(CategoryMapper.convertToEntity(c)));
	
}

@Override
public CategoryDto updateCategory(CategoryDto c) {
	// TODO Auto-generated method stub
	return CategoryMapper.convertToDto(repository.save(CategoryMapper.convertToEntity(c)));
		}

}



