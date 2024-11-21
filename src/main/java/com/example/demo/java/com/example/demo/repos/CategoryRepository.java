package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.modele.Categorie;
import com.example.demo.modele.Produit;

@RepositoryRestResource(path = "cat")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular http://localhost:4200/
public interface CategoryRepository extends JpaRepository<Categorie, Long> {
List<Categorie> findByProduitsPrixProduit(double prix);
List<Categorie> findByProduitsNomProduit(String nom);
}
