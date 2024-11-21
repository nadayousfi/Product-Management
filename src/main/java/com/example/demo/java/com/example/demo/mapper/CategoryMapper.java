package com.example.demo.mapper;


import org.modelmapper.ModelMapper;

import com.example.demo.dto.CategoryDto;
import com.example.demo.modele.Categorie;

public class CategoryMapper {
private static final ModelMapper modelMapper=new ModelMapper();
public static CategoryDto convertToDto(Categorie categorie) {
	return modelMapper.map(categorie, CategoryDto.class);
}
public static Categorie convertToEntity(CategoryDto dto) {
	return modelMapper.map(dto, Categorie.class);
}
}
