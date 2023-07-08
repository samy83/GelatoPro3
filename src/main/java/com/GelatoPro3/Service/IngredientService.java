package com.GelatoPro3.Service;

import com.GelatoPro3.Entity.Ingredient;
import com.GelatoPro3.Enum.Type;
import com.GelatoPro3.Repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService
{
	@Autowired
	IngredientRepository ingredientRepository;

	public Optional<Ingredient> findByNom(String nom, String userEmail){
		return this.ingredientRepository.findByNomAndUserEmail(nom, userEmail);
	}

	public Iterable<Ingredient> findAll()
	{
		return this.ingredientRepository.findAll();
	}

	public Iterable<Ingredient> findAllByType(Type type, String userEmail)
	{
		return this.ingredientRepository.findAllByTypeAndUserEmail(type.toString(), userEmail);
	}

	public Ingredient createIngredient(Ingredient ingredient)
	{
		return this.ingredientRepository.save(ingredient);
	}
}
