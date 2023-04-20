package com.GelatoPro3.Entity;

import com.GelatoPro3.Enum.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;


@Entity
@Table(name = "ingredient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient
{
	@Id
	@Column(name = "id", unique = true , nullable = false)
	private Long id;

	@Column(name = "nom", unique = true, nullable = false)
	private String nom;

	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private Type type;

	@Column(name = "taux_sucre", nullable = false)
	private double taux_sucre;

	@Column(name = "extrait_sec", nullable = false)
	private double extrait_sec;

	@Column(name = "prix_au_gramme", nullable = false)
	private double prix_au_gramme;

	@Column(name = "fournisseur", nullable = true)
	private String fournisseur;

	@Column(name = "gras", nullable = false)
	private double gras;

	@Column(name = "coefficient_pouvoir_sucrant", nullable = false)
	private double coefficient_pouvoir_sucrant;

	@Column(name = "taux_fruit", nullable = true)
	private double taux_fruit;



}