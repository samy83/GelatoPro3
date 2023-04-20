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

	public Optional<Ingredient> findByNom(String nom){
		return this.ingredientRepository.findByNom(nom);
	}

	public Iterable<Ingredient> findAll()
	{
		return this.ingredientRepository.findAll();
	}

	public Iterable<Ingredient> findAllByType(Type type)
	{
		return this.ingredientRepository.findAllByType(type);
	}

	public void createIngredient(Ingredient ingredient)
	{
		this.ingredientRepository.save(ingredient);
	}
}
