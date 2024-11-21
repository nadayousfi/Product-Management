package com.example.demo.dto;

import java.sql.Date;

import com.example.demo.modele.Categorie;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProduitDTO {
	private Long idProduit;
	private String nomProduit;
	private String numeros;

	private String unite;
	private String unitespec;
	private Boolean donation;
	private Double prixProduit;
	private Date dateCreation;
	
	private Categorie categorie;
private String nomCat;


}
