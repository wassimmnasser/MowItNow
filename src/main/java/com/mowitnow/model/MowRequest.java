package com.mowitnow.model;

import java.util.List;

/**
 * author : Wassim MNASSER
 */

public class MowRequest {
	private int upperRightX;
	private int upperRightY;
	private List<LawnMower> mowers;

	public MowRequest() {
	}

	public MowRequest(int upperRightX, int upperRightY, List<LawnMower> mowers) {
		this.upperRightX = upperRightX;
		this.upperRightY = upperRightY;
		this.mowers = mowers;
	}

	public int getUpperRightX() {
		return upperRightX;
	}

	public void setUpperRightX(int upperRightX) {
		this.upperRightX = upperRightX;
	}

	public int getUpperRightY() {
		return upperRightY;
	}

	public void setUpperRightY(int upperRightY) {
		this.upperRightY = upperRightY;
	}

	public List<LawnMower> getMowers() {
		return mowers;
	}

	public void setMowers(List<LawnMower> mowers) {
		this.mowers = mowers;
	}

}
