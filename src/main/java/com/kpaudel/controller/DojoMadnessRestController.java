package com.kpaudel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kpaudel.modal.Ability;
import com.kpaudel.modal.Hero;
import com.kpaudel.repository.AbilityRepository;
import com.kpaudel.repository.HeroRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DojoMadnessRestController {
	@Autowired
	private AbilityRepository abilityRepository;
	@Autowired
	private HeroRepository heroRepository;

	@ResponseBody
	@RequestMapping(value = "/heros")
	public List<Hero> getHeros() {
		List<Hero> heroList = new ArrayList<>();
		this.heroRepository.findAll().forEach(e -> heroList.add(e));
		return heroList;
	}

	@ResponseBody
	@RequestMapping(value = "/heros/{heroId}")
	public Hero getHero(@PathVariable Integer heroId) {
		if (!this.heroRepository.existsById(heroId))
			return null;
		return this.heroRepository.findById(heroId).get();
	}

	@ResponseBody
	@RequestMapping(value = "/abilities")
	public List<Ability> getAbilities() {
		List<Ability> abilityList = new ArrayList<>();
		this.abilityRepository.findAll().forEach(e -> abilityList.add(e));
		return abilityList;
	}

	@ResponseBody
	@RequestMapping(value = "/abilities/{abilityId}")
	public Ability getAbility(@PathVariable Integer abilityId) {
		if (!this.abilityRepository.existsById(abilityId))
			return null;
		return this.abilityRepository.findById(abilityId).get();
	}

	@ResponseBody
	@RequestMapping(value = "/heros/{heroId}/abilities")
	public List<Ability> getHeroAbilities(@PathVariable Integer heroId) {
		List<Ability> abilityList = new ArrayList<>();
		this.abilityRepository.findAbilitiesByHeroId(heroId).forEach(e -> abilityList.add(e));
		return abilityList;
	}

}
