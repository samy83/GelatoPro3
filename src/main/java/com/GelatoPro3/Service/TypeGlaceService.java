package com.GelatoPro3.Service;

import com.GelatoPro3.Entity.TypeArome;
import com.GelatoPro3.Entity.TypeGlace;
import com.GelatoPro3.Repository.TypeGlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeGlaceService
{
	@Autowired
	TypeGlaceRepository typeGlaceRepository;

	public Iterable<TypeGlace> findAll()
	{
		return typeGlaceRepository.findAll();
	}
}
