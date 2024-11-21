package com.example.demo.service.Impl;




import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProduitDTO;
import com.example.demo.mapper.Produitmapper;
import com.example.demo.modele.Categorie;
import com.example.demo.modele.Produit;
import com.example.demo.repos.ProduitRepository;
import com.example.demo.service.ProduitService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService{
	
	

private  final	ProduitRepository produitRepository;
	
	@Override
	public ProduitDTO saveProduit(ProduitDTO p) {
		return Produitmapper.convertToDto(produitRepository.save(Produitmapper.convertToEntity(p) ));
	}

	@Override
	public ProduitDTO updateProduit(ProduitDTO p) {
		
		return Produitmapper.convertToDto(produitRepository.save(Produitmapper.convertToEntity(p)));
		}

	@Override
	public void deleteProduit(Produit p) {

		produitRepository.delete(p);
			
	}

	@Override
	public void deleteProduitById(Long id) {
produitRepository.deleteById(id);		
	}

	@Override
	public Produit getProduit(Long id) {
		return (produitRepository.findById(id).get() );
	}

	@Override
	public List<ProduitDTO> getAllProduits() {
		return (produitRepository.findAll().stream())
				.map(Produitmapper::convertToDto)
				.collect(Collectors.toList());
	}


@Override 
public List<Produit> findByNomProduit(String nom) { 
 return produitRepository.findByNomProduit(nom); 
} 

@Override 
public List<Produit> findByNomProduitContains(String nom) { 
 return produitRepository.findByNomProduitContains(nom); 
} 
@Override
public List<Produit> findByUnite(String unite) {
	return produitRepository.findByUniteContains(unite);
}
@Override
public List<Produit> findByUnitespectContains(String unitespec) {
	// TODO Auto-generated method stub
	return produitRepository.findByUnitespecContains(unitespec);
			}
@Override
public List<Produit> findByUnitetContains(String unite) {
	return produitRepository.findByUniteContains(unite);
}

@Override 
public List<Produit> findByNomPrix(String nom, Double prix) { 
 return produitRepository.findByNomPrix(nom, prix); 
} 
 
@Override 
public List<Produit> findByCategorie(Categorie categorie) { 
 return produitRepository.findByCategorie(categorie); 
} 

@Override 
public List<Produit> findByCategorieIdCat(Long id) { 
 return produitRepository.findByCategorieIdCat(id); 
} 

@Override 
public List<Produit> findByOrderByNomProduitAsc() { 
 return produitRepository.findByOrderByNomProduitAsc(); }


@Override 
public List<Produit> trierProduitsNomsPrix() { 
	return produitRepository.trierProduitsNomPrix(); 
}

@Override
public List<Produit> findByNomCat(String nomCat) {
	return produitRepository.findByCategorieNomCat(nomCat);
}





/*@Override
public boolean findBySerie(String serie) {
	
	return produitRepository.existsBySerie(serie);
}*/




}

