package com.kpaudel.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kpaudel.modal.Ability;
import com.kpaudel.modal.Hero;
import com.kpaudel.repository.AbilityRepository;
import com.kpaudel.repository.HeroRepository;

/**
 * This processes rest api objects with database
 * 
 * @author Krishna Paudel
 *
 */
@Service
public class RESTConsumerService {
	private static final String HERO_URL = "https://overwatch-api.net/api/v1/hero/";
	private static final String ABILITY_URL = "https://overwatch-api.net/api/v1/ability/";
	private HeroRepository heroRepository;
	private AbilityRepository abilityRepository;
	private RestTemplate restTemplate;
	private HttpEntity<String> httpEntity;

	@Autowired
	public RESTConsumerService(HeroRepository heroRepository, AbilityRepository abilityRepository) {
		this.heroRepository = heroRepository;
		this.abilityRepository = abilityRepository;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		this.httpEntity = new HttpEntity<String>("parameters", headers);
		this.restTemplate = new RestTemplate();
		this.heroRepository.deleteAll();
		this.abilityRepository.deleteAll();
		this.fetchHeros();
		this.fetchAbilities();
	}

	/**
	 * Fetches heros from the rest and stores in the database
	 * 
	 * @throws JSONException
	 */
	public void fetchHeros() {
		List<Hero> heroList = new ArrayList<>();
		ResponseEntity<String> response = this.restTemplate.exchange(HERO_URL, HttpMethod.GET, this.httpEntity,
				String.class);
		if (response.getStatusCode() != HttpStatus.OK)
			return;
		try {
			JSONObject responseObject = new JSONObject(response.getBody().toString());
			JSONArray jsonArray = responseObject.getJSONArray("data");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject heroJSON = jsonArray.getJSONObject(i);
				Hero hero = new Hero();
				hero.setId(heroJSON.getInt("id"));
				hero.setName(heroJSON.getString("name"));
				hero.setRealName(heroJSON.getString("real_name"));
				hero.setHealth(heroJSON.getInt("health"));
				hero.setArmour(heroJSON.getInt("armour"));
				hero.setShield(heroJSON.getInt("shield"));
				heroList.add(hero);
			}
			this.heroRepository.saveAll(heroList);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Fetches abilities from the rest and stores in the database
	 */
	public void fetchAbilities() {
		List<Ability> abilityList = new ArrayList<>();
		ResponseEntity<String> response = this.restTemplate.exchange(ABILITY_URL, HttpMethod.GET, this.httpEntity,
				String.class);
		if (response.getStatusCode() != HttpStatus.OK)
			return;
		try {
			JSONObject responseObject = new JSONObject(response.getBody().toString());
			JSONArray jsonArray = responseObject.getJSONArray("data");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject abilityJSON = jsonArray.getJSONObject(i);
				Ability ability = new Ability();
				ability.setId(abilityJSON.getInt("id"));
				ability.setName(abilityJSON.getString("name"));
				ability.setDescription(abilityJSON.getString("description"));
				ability.setUltimate(abilityJSON.getBoolean("is_ultimate"));
				JSONObject hero = abilityJSON.getJSONObject("hero");
				ability.setHeroId(hero.getInt("id"));
				abilityList.add(ability);
			}
			this.abilityRepository.saveAll(abilityList);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
