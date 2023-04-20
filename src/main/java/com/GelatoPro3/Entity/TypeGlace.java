package com.GelatoPro3.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "type_glace")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeGlace
{
	@Id
	@Column(name = "valeur_enum", unique = true , nullable = false)
	private String valeurEnum;

	@Column(name = "libelle", unique = true, nullable = false)
	private String libelle;
}
