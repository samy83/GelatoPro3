package com.GelatoPro3.Repository;

import com.GelatoPro3.Entity.TypeGlace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeGlaceRepository extends CrudRepository<TypeGlace, Long>
{

}
