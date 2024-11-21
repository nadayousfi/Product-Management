package com.example.demo.mapper;

import org.modelmapper.ModelMapper;

import com.example.demo.dto.ProduitDTO;
import com.example.demo.modele.Produit;

public class Produitmapper {
private static final ModelMapper modelMapper=new ModelMapper();
public static ProduitDTO convertToDto(Produit produit) {
	return modelMapper.map(produit, ProduitDTO.class);
}
public static Produit convertToEntity(ProduitDTO dto) {
	return modelMapper.map(dto, Produit.class);
}
}
