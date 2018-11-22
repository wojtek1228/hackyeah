package com.hackyeah.mainapp.dao;


import com.hackyeah.mainapp.entities.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface EntityService extends CrudRepository<Entity,String> {

}
