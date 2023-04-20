package com.GelatoPro3.Form;

import com.GelatoPro3.Enum.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientForm
{
	private String nom;
	private Type type;
	private String tauxSucre;
	private String extraitSec;
	private String prixKG;
	private String fournisseur;
	private String tauxGras;
	private String tauxFruit;

}
