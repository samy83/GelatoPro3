package com.GelatoPro3.Controller;

import com.GelatoPro3.Entity.Ingredient;
import com.GelatoPro3.Entity.TypeArome;
import com.GelatoPro3.Entity.TypeGlace;
import com.GelatoPro3.Entity.TypeGras;
import com.GelatoPro3.Enum.Type;
import com.GelatoPro3.Form.IngredientForm;
import com.GelatoPro3.Mapper.IngredientMapper;
import com.GelatoPro3.Service.IngredientService;
import com.GelatoPro3.Service.TypeAromeService;
import com.GelatoPro3.Service.TypeGlaceService;
import com.GelatoPro3.Service.TypeGrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RequestMapping("/api/ingredient")
@RestController
public class IngredientController
{
	@Autowired
	private IngredientService ingredientService;
	@Autowired
	private TypeGlaceService typeGlaceService;
	@Autowired
	private TypeGrasService typeGrasService;
	@Autowired
	private TypeAromeService typeAromeService;
	@Autowired
	private IngredientMapper ingredientMapper;

	@GetMapping("/all")
	public Iterable<Ingredient> getAllIngredients()
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAll();
		return ingredients;
	}

	@GetMapping("/type-arome/all")
	public Iterable<TypeArome> getAllTypeArome()
	{
 		final Iterable<TypeArome> typeAromes = this.typeAromeService.findAll();
		return typeAromes;
	}

	@GetMapping("/type-glace/all")
	public Iterable<TypeGlace> getAllTypeGlace()
	{
		final Iterable<TypeGlace> typeGlaces = this.typeGlaceService.findAll();
		return typeGlaces;
	}
	@GetMapping("/type-gras/all")
	public Iterable<TypeGras> getAllTypeGras()
	{
		final Iterable<TypeGras> typeGras = this.typeGrasService.findAll();
		return typeGras;
	}


	@GetMapping("/autre-arome/all")
	public Iterable<Ingredient> getAllAutre_arome(@PathVariable String userEmail)
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.AUTRE_AROME, userEmail);
		return ingredients;
	}

	@GetMapping("/sucre/all/{userEmail}")
	public Iterable<Ingredient> getAllSucre(@PathVariable String userEmail)
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.SUCRE, userEmail);
		return ingredients;
	}

	@GetMapping("/chocolat/all/{userEmail}")
	public Iterable<Ingredient> getAllChocolat(@PathVariable String userEmail)
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.CHOCOLAT, userEmail);
		return ingredients;
	}

	@GetMapping("/fruit-sucre/all/{userEmail}")
	public Iterable<Ingredient> getAllFruit_sucre(@PathVariable String userEmail)
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.FRUIT_SUCRE, userEmail);
		return ingredients;
	}

	@GetMapping("/fruit100/all/{userEmail}")
	public Iterable<Ingredient> getAllFruit100(@PathVariable String userEmail)
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.FRUIT100, userEmail);
		return ingredients;
	}

	@GetMapping("/fruit-acide/all/{userEmail}")
	public Iterable<Ingredient> getAllFruitAcide(@PathVariable String userEmail)
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.FRUIT_ACIDE, userEmail);
		return ingredients;
	}

	@GetMapping("/fruit-sec/all/{userEmail}")
	public Iterable<Ingredient> getAllFruitSec(@PathVariable String userEmail)
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.FRUIT_SEC, userEmail);
		return ingredients;
	}

	@GetMapping("/alcool/all/{userEmail}")
	public Iterable<Ingredient> getAllAlcool(@PathVariable String userEmail)
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.ALCOOL, userEmail);
		return ingredients;
	}

	@GetMapping("/stabilisant/all/{userEmail}")
	public Iterable<Ingredient> getAllStabilisant(@PathVariable String userEmail)
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.STABILISANT, userEmail);
		return ingredients;
	}

	@GetMapping("/emulsifiant/all/{userEmail}")
	public Iterable<Ingredient> getAllEmulsifiant(@PathVariable String userEmail)
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.EMULSIFIANT, userEmail);
		return ingredients;
	}
	@GetMapping("/{nom}/{userEmail}")
	public Optional<Ingredient> getByNom(@PathVariable String nom, @PathVariable String userEmail)
	{
		final Optional<Ingredient> ingredient = this.ingredientService.findByNom(nom, userEmail);
		return ingredient;
	}

	@PostMapping(path= "/ingredient/{userEmail}", consumes = {"multipart/form-data"})
	public Ingredient createIngredient(@ModelAttribute IngredientForm formIngredient, @PathVariable String userEmail){
		return this.ingredientService.createIngredient(ingredientMapper.ingredientFormToIngredient(formIngredient, userEmail));
	}

}
