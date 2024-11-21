package com.example.demo.RESTController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProduitDTO;
import com.example.demo.modele.Produit;
import com.example.demo.service.ProduitService;

import jakarta.persistence.Id;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController {
@Autowired
ProduitService produitService;
@RequestMapping(path="all",method=RequestMethod.GET)
public List<Produit> getAllProduit(){
	return produitService.findByOrderByNomProduitAsc();
	}

@PostMapping("/addprod")
@PreAuthorize("hasAuthority('ADMIN')")
public ProduitDTO createProduit (@RequestBody ProduitDTO produitDTO) {
	return produitService.saveProduit(produitDTO);
}
@GetMapping("/getbyid/{id}")

public Produit getProduitById(@PathVariable("id") Long id) {	
	return produitService.getProduit(id);
}
@PutMapping("/updateprod")
public ProduitDTO updateProduit(@RequestBody ProduitDTO produitDTO) {
	return produitService.updateProduit(produitDTO);
}
@DeleteMapping("/delprod/{id}")
public void deleteProduit(@PathVariable long id)
{
	produitService.deleteProduitById(id);

}

@GetMapping("/prodscat/{idCat}")
public List<Produit> getProduitByCatId(@PathVariable long idCat){
	return produitService.findByCategorieIdCat(idCat);
}
@GetMapping("/prodsBy/{nom}")
public List<Produit> getNomCat(@PathVariable String nom){
	return produitService.findByNomCat(nom);
}
@RequestMapping(value="/prodsByName/{nom}",method = RequestMethod.GET)
public List<Produit> findByNomProduitContains(@PathVariable("nom") String nom) {
return produitService.findByNomProduitContains(nom);
}
@RequestMapping(value="/prodsByUnite/{unite}",method = RequestMethod.GET)
public List<Produit> findByUniteContains(@PathVariable("unite") String unite) {
return produitService.findByUnitetContains(unite);
}
@RequestMapping(value="/prodsByUnitespec/{unitespec}",method = RequestMethod.GET)
public List<Produit> findByUnitespecContains(@PathVariable("unitespec") String unitespec) {
return produitService.findByUnitespectContains(unitespec);}
}
/*
@GetMapping("/existe/{serie}")
public ResponseEntity<Boolean> getProduitBySerie(@PathVariable String serie){
	return new ResponseEntity<>(produitService.findBySerie(serie), HttpStatus.OK);}
}*/