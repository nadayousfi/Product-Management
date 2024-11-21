package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProduitDTO;
import com.example.demo.modele.Categorie;
import com.example.demo.modele.Produit;

public interface ProduitService {
ProduitDTO saveProduit(ProduitDTO p);
Produit getProduit(Long id);
List<ProduitDTO> getAllProduits();
ProduitDTO updateProduit(ProduitDTO p);
void deleteProduit(Produit p);
void deleteProduitById(Long id);
List<Produit> findByNomProduit(String nom); 
List<Produit> findByUnite(String unite); 
List<Produit> findByUnitetContains(String unite); 
List<Produit> findByUnitespectContains(String unitespec); 
List<Produit> findByNomProduitContains(String nom); 
List<Produit> findByNomPrix (String nom, Double prix); 
List<Produit> findByCategorie (Categorie categorie); 
List<Produit> findByCategorieIdCat(Long id); 
List<Produit> findByOrderByNomProduitAsc(); 
List<Produit> trierProduitsNomsPrix(); 
List<Produit> findByNomCat(String nomCat);
//boolean findBySerie(String serie);

}
