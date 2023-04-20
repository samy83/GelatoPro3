package com.GelatoPro3.Repository;

import com.GelatoPro3.Entity.TypeArome;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeAromeRepository extends CrudRepository<TypeArome, Long>
{
}
