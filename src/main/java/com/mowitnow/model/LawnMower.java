package com.mowitnow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * author : Wassim MNASSER
 */

@Entity
public class LawnMower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int initialX;
	private int initialY;
	private char initialDirection;
	private String instructions;

	public LawnMower(Long id, int initialX, int initialY, char initialDirection, String instructions) {
		
		this.id = id;
		this.initialX = initialX;
		this.initialY = initialY;
		this.initialDirection = initialDirection;
		this.instructions = instructions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getInitialX() {
		return initialX;
	}

	public void setInitialX(int initialX) {
		this.initialX = initialX;
	}

	public int getInitialY() {
		return initialY;
	}

	public void setInitialY(int initialY) {
		this.initialY = initialY;
	}

	public char getInitialDirection() {
		return initialDirection;
	}

	public void setInitialDirection(char initialDirection) {
		this.initialDirection = initialDirection;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

}
