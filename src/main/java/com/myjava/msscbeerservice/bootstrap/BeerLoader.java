package com.myjava.msscbeerservice.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.myjava.msscbeerservice.domain.Beer;
import com.myjava.msscbeerservice.repositories.BeerRepository;

@Component
public class BeerLoader implements CommandLineRunner{

	private final BeerRepository beerReposotory;

	public BeerLoader(BeerRepository beerReposotory) {
		this.beerReposotory = beerReposotory;
	}

	@Override
	public void run(String... args) throws Exception {
		loadBeerObjects();
		
	}

	private void loadBeerObjects() {
		if(beerReposotory.count() == 0){
			beerReposotory.save(Beer.builder()
					.beerName("Lapinkulta")
					.beerStyle("Lager")
					.quantityToBrew(200)
					.minOnHand(12)
					.upc(3370100001L)
					.price(new BigDecimal("12.95"))
					.build());
			
			beerReposotory.save(Beer.builder()
					.beerName("Laitilan IPA")
					.beerStyle("IPA")
					.quantityToBrew(300)
					.minOnHand(13)
					.upc(3370100003L)
					.price(new BigDecimal("11.95"))
					.build());
		}
			
		System.out.println("Louded Beers: " + beerReposotory.count());
	}
	
	
	
}
