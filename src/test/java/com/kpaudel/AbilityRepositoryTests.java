package com.kpaudel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kpaudel.modal.Ability;
import com.kpaudel.repository.AbilityRepository;

/**
 * Test for ability respository
 * 
 * @author krishna
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AbilityRepositoryTests {
	@Autowired
	private AbilityRepository abilityRepository;

	@Before
	public void init() {
		//
	}

	@Test
	public void testCreation() {
		assertNotNull("Ability repository object is null", this.abilityRepository);
	}

	@Test
	public void testInsertion() {
		Ability ability = new Ability(123, 1, "Test", "descrt", true);
		this.abilityRepository.save(ability);

		Ability fetchedAbility = this.abilityRepository.findById(123).get();
		assertNotNull("Fetched Value is null", fetchedAbility);
		assertEquals(fetchedAbility.getId(), ability.getId());
	}

	@Test
	public void testFilterAbilitiesByHeroId() {
		this.abilityRepository.deleteAll();
		Ability ability1 = new Ability(123, 1, "Test1", "descrt1", true);
		Ability ability2 = new Ability(124, 2, "Test2", "descrt2", true);
		Ability ability3 = new Ability(127, 1, "Test3", "descrt3", false);
		this.abilityRepository.save(ability1);
		this.abilityRepository.save(ability2);
		this.abilityRepository.save(ability3);
		
		List<Ability> filteredAbility=new ArrayList<>();
		this.abilityRepository.findAbilitiesByHeroId(1).forEach(e->filteredAbility.add(e));
		assertEquals(2, filteredAbility.size());
		
	}

}
