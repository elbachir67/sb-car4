package com.dam.uasz.sbcar4.domain;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "car_owner")
public class CarOwner {
	
	@EmbeddedId
	private CarOwnerId id = new CarOwnerId();

	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	public Owner getOwner() {
		return owner;
	}


	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@ManyToOne
	@MapsId("carId")
	private Car car;

	@ManyToOne
	@MapsId("ownerId")
	private Owner owner;
	
	public CarOwner() {}
	
	
	public CarOwner(CarOwnerId id) {
		super();
		this.id = id;
	}
	
	


	public CarOwnerId getId() {
		return id;
	}


	public void setId(CarOwnerId id) {
		this.id = id;
	}




	@Embeddable
	public static class CarOwnerId implements Serializable {

	  private static final long serialVersionUID = 1L;

	  private Long carId;
	  private Long ownerId;

	  public CarOwnerId() {}

	  public CarOwnerId(Long carId, Long ownerId) {
	    super();
	    this.carId = carId;
	    this.ownerId = ownerId;
	  }

	  public Long getCarId() {
	    return carId;
	  }

	  public Long getOwnerId() {
	    return ownerId;
	  }

	  public void setCarId(Long carId) {
	    this.carId = carId;
	  }

	  public void setOwnerId(Long ownerId) {
	    this.ownerId = ownerId;
	  }
	}

}
