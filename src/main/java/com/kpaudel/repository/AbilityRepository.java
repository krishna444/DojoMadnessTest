package com.kpaudel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kpaudel.modal.Ability;

/**
 * Ability repository
 * 
 * @author krishna
 *
 */
@Repository
public interface AbilityRepository extends CrudRepository<Ability, Integer> {
	public Iterable<Ability> findAbilitiesByHeroId(Integer heroId);
}
