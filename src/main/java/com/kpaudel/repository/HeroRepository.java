package com.kpaudel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kpaudel.modal.Hero;

/**
 * Hero repository
 * 
 * @author krishna
 *
 */
@Repository
public interface HeroRepository extends CrudRepository<Hero, Integer> {
}
