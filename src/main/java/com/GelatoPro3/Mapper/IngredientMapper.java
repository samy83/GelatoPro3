package com.GelatoPro3.Mapper;

import com.GelatoPro3.Entity.Ingredient;
import com.GelatoPro3.Form.IngredientForm;
import org.springframework.stereotype.Service;

@Service
public class IngredientMapper
{
	public Ingredient ingredientFormToIngredient(IngredientForm form, String userEmail){
		Ingredient ingredient = new Ingredient();

		int range = 10000 - 100 + 1;
		ingredient.setId((long)(Math.random() * range));

		ingredient.setNom(form.getNom());
		ingredient.setGras( Double.parseDouble(form.getTauxGras())/100);
		ingredient.setFournisseur(form.getFournisseur());
		ingredient.setType(form.getType());
		ingredient.setExtrait_sec(Double.parseDouble(form.getExtraitSec()));
		ingredient.setTaux_sucre(Double.parseDouble(form.getTauxSucre())/100);
		ingredient.setTaux_fruit(Double.parseDouble(form.getTauxFruit())/100);
		ingredient.setPrix_au_gramme(Double.parseDouble(form.getPrixKG())/1000);
		switch (form.getType()){
			case FRUIT100, FRUIT_SUCRE, FRUIT_ACIDE -> ingredient.setCoefficient_pouvoir_sucrant(1.25);
			case CHOCOLAT, AUTRE_AROME, ALCOOL, FRUIT_SEC -> ingredient.setCoefficient_pouvoir_sucrant(1);
		}
		ingredient.setUserEmail(userEmail);
		return ingredient;
	}
}
