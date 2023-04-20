package com.GelatoPro3.Service;

import com.GelatoPro3.Entity.TypeGlace;
import com.GelatoPro3.Entity.TypeGras;
import com.GelatoPro3.Repository.TypeGlaceRepository;
import com.GelatoPro3.Repository.TypeGrasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeGrasService
{
	@Autowired
	TypeGrasRepository typeGrasRepository;

	public Iterable<TypeGras> findAll()
	{
		return typeGrasRepository.findAll();
	}
}