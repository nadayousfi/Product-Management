package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor


public class CategoryDto {
	private Long idCat;
	private String nomCat;
	private String descriptionCat;
	private List<ProduitDTO> produits;
}
