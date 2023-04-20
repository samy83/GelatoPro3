package com.GelatoPro3.Repository;

import com.GelatoPro3.Entity.TypeGras;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeGrasRepository extends CrudRepository<TypeGras, Long>
{

}