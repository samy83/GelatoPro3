package com.GelatoPro3.Service;

import com.GelatoPro3.Entity.TypeArome;
import com.GelatoPro3.Repository.TypeAromeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeAromeService
{
	@Autowired
	TypeAromeRepository typeAromeRepository;

	public Iterable<TypeArome> findAll()
	{
		return typeAromeRepository.findAll();
	}
}