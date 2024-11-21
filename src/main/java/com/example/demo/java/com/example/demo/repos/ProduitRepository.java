package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.modele.Categorie;
import com.example.demo.modele.Produit;
@RepositoryRestResource(path = "rest")
public interface ProduitRepository extends JpaRepository<Produit, Long> {
List <Produit> findByNomProduit (String nom); 
//boolean existsBySerie(String serie);
List <Produit> findByPrixProduit (double prix); 
List <Produit> findByNomProduitContains(String nom);
List <Produit> findByUniteContains(String unite);
List <Produit> findByUnitespecContains(String unitespec);

//@Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")

//List<Produit> findByNomPrix(String nom,double prix);

@Query("select p from Produit p where  p.nomProduit like %:nom AND p.prixProduit > :prix")
List<Produit> findByNomPrix(@Param("nom")String nom,@Param("prix") Double prix);

@Query("select p from Produit p where p.categorie = ?1") 
List<Produit> findByCategorie (Categorie categorie); 
List<Produit> findByCategorieIdCat(Long id);
List<Produit> findByCategorieNomCat(String nomCat);
List<Produit> findByOrderByNomProduitAsc();
@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
List<Produit> trierProduitsNomPrix();
 
}
