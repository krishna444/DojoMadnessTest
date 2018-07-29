package com.kpaudel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kpaudel.modal.Hero;
import com.kpaudel.repository.HeroRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeroRepositoryTests {
	@Autowired
	private HeroRepository heroRepository;

	@Test
	public void testCreation() {
		assertNotNull("Hero repository Object is null", this.heroRepository);
	}

	@Test
	public void testInsertion() {
		this.heroRepository.deleteAll();
		assertEquals(0, this.heroRepository.count());
		Hero hero = new Hero(12, "testHero", "Krishna", 12, 13, 45);
		this.heroRepository.save(hero);

		assertNotNull(this.heroRepository.findById(12).get());
		

	}
}
