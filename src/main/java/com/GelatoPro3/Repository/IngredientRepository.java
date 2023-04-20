package com.GelatoPro3.Repository;

import com.GelatoPro3.Entity.Ingredient;
import com.GelatoPro3.Enum.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long>
{
	Optional<Ingredient> findByNom(String name);

	Iterable<Ingredient> findAllByType(Type type);

}
