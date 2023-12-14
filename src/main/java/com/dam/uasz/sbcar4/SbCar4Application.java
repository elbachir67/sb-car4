package com.dam.uasz.sbcar4;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dam.uasz.sbcar4.domain.*;
import com.dam.uasz.sbcar4.domain.CarOwner.CarOwnerId;

@SpringBootApplication
public class SbCar4Application implements CommandLineRunner {

	private static final Logger logger = 
			LoggerFactory.getLogger(SbCar4Application.class);
	
			@Autowired
			private CarRepository repository;
			
		
			@Autowired
			private OwnerRepository orepository;
			
			@Autowired
			private CarOwnerRepository corepository;
		
			
			public static void main(String[] args) {
				SpringApplication.run(SbCar4Application.class, args);
			}
		
			@Override
			public void run(String... args) throws Exception {
				// Add owner objects and save these to db 
				Owner owner1 = new Owner("John" , "Johnson");
				Owner owner2 = new  Owner("Mary" , "Robinson");
				orepository.saveAll(Arrays.asList(owner1, owner2));
		
				// Add car object and link to owners and save these to db
				Car car1 = new Car("Ford", "Mustang", "Red", 
						"ADF-1121", 2021, 59000);
				Car car2 = new Car("Nissan", "Leaf", "White", 
						"SSJ-3002", 2019, 29000);
				Car car3 = new Car("Toyota", "Prius", "Silver", 
						"KKO-0212", 2020, 39000);
				repository.saveAll(Arrays.asList(car1, car2, car3));
				
				
				CarOwner.CarOwnerId carOwnerId1 = new CarOwnerId(car1.getId(), owner1.getOwnerid());
				CarOwner.CarOwnerId carOwnerId2 = new CarOwnerId(car1.getId(), owner2.getOwnerid());
				CarOwner.CarOwnerId carOwnerId3 = new CarOwnerId(car2.getId(), owner2.getOwnerid());
				CarOwner.CarOwnerId carOwnerId4 = new CarOwnerId(car3.getId(), owner2.getOwnerid());
				CarOwner carOwner1 = new CarOwner(carOwnerId1);
				carOwner1.setCar(car1);
				carOwner1.setOwner(owner1);
				
				CarOwner carOwner2 = new CarOwner(carOwnerId2);
				carOwner2.setCar(car1);
				carOwner2.setOwner(owner2);
				
				CarOwner carOwner3 = new CarOwner(carOwnerId3);
				carOwner3.setCar(car2);
				carOwner3.setOwner(owner2);
				
				CarOwner carOwner4 = new CarOwner(carOwnerId4);
				carOwner4.setCar(car3);
				carOwner4.setOwner(owner2);
				
				corepository.saveAll(Arrays.asList(carOwner1, carOwner2, carOwner3, carOwner4));
						  
				for (Car car : repository.findAll()) {
					logger.info(car.getBrand() + " " + car.getModel());
				}
			}
}


