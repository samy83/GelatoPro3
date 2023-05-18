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
	public Iterable<Ingredient> getAllAutre_arome()
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.AUTRE_AROME);
		return ingredients;
	}

	@GetMapping("/sucre/all")
	public Iterable<Ingredient> getAllSucre()
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.SUCRE);
		return ingredients;
	}

	@GetMapping("/chocolat/all")
	public Iterable<Ingredient> getAllChocolat()
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.CHOCOLAT);
		return ingredients;
	}

	@GetMapping("/fruit-sucre/all")
	public Iterable<Ingredient> getAllFruit_sucre()
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.FRUIT_SUCRE);
		return ingredients;
	}

	@GetMapping("/fruit100/all")
	public Iterable<Ingredient> getAllFruit100()
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.FRUIT100);
		return ingredients;
	}

	@GetMapping("/fruit-acide/all")
	public Iterable<Ingredient> getAllFruitAcide()
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.FRUIT_ACIDE);
		return ingredients;
	}

	@GetMapping("/fruit-sec/all")
	public Iterable<Ingredient> getAllFruitSec()
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.FRUIT_SEC);
		return ingredients;
	}

	@GetMapping("/alcool/all")
	public Iterable<Ingredient> getAllAlcool()
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.ALCOOL);
		return ingredients;
	}

	@GetMapping("/stabilisant/all")
	public Iterable<Ingredient> getAllStabilisant()
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.STABILISANT);
		return ingredients;
	}

	@GetMapping("/emulsifiant/all")
	public Iterable<Ingredient> getAllEmulsifiant()
	{
		final Iterable<Ingredient> ingredients = this.ingredientService.findAllByType(Type.EMULSIFIANT);
		return ingredients;
	}
	@GetMapping("/{nom}")
	public Optional<Ingredient> getByNom(@PathVariable String nom)
	{
		final Optional<Ingredient> ingredient = this.ingredientService.findByNom(nom);
		return ingredient;
	}

	@PostMapping(path= "/ingredient", consumes = {"multipart/form-data"})
	public void createIngredient(@ModelAttribute IngredientForm formIngredient){
		this.ingredientService.createIngredient(ingredientMapper.ingredientFormToIngredient(formIngredient));
	}

}
