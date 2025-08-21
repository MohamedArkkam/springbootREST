package com.basic.springmvcboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.basic.springmvcboot.model.Alien;

public interface AlienRepository extends JpaRepository<Alien, Integer> {

    // List<Alien> findByAname(String aname);

    @Query("from Alien where aname=:aname")
    List<Alien> find(@Param("aname") String aname);

}
