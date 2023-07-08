package com.GelatoPro3.Repository;

import com.GelatoPro3.Entity.Ingredient;
import com.GelatoPro3.Enum.Type;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long>
{
	@Query(value = "SELECT * FROM ingredient WHERE nom = ?1 AND (user_email= ?2 OR user_email is null)", nativeQuery = true)
	Optional<Ingredient> findByNomAndUserEmail(String name, String userEmail);

	@Query(value = "SELECT * FROM ingredient WHERE type = ?1  AND (user_email= ?2 OR user_email is null)", nativeQuery = true)
	Iterable<Ingredient> findAllByTypeAndUserEmail(String type, String userEmail);

	Iterable<Ingredient> findAllByUserEmail(String userEmail);

	Iterable<Ingredient> findAllByType(Type type);

	Optional<Ingredient> findByNom(String name);
}
