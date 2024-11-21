package com.example.demo.modele;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Identifiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
	@Column(updatable = false)
	private LocalDateTime createdAt;
	@PrePersist
	public void preCreate() {
		createdAt=LocalDateTime.now();
	}
	}
