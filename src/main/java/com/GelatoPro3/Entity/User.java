package com.GelatoPro3.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "user", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User
{
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", unique = true , nullable = false)
	private UUID id;
	@Column(name = "prenom", nullable = false)
	private String prenom;
	@Column(name = "nom", nullable = false)
	private String nom;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "pwd", nullable = false)
	private String pwd;
	@Column(name = "pays", nullable = false)
	private String pays;

}
