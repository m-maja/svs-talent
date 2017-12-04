package com.ventoelectrics.components;

import java.util.Random;

public class Thermometer implements PoweredDevice {
	
	private boolean powerEnabled = false;

	private Random random = new Random(System.currentTimeMillis());

	public Integer getTemperature() {
		if (!powerEnabled) {
			throw new NoPowerException();
		}
		return random.nextInt(60);
	}

	@Override
	public void enablePower() {
		System.out.println("Thermometer enabled");
		powerEnabled = true;
	}

	@Override
	public void disablePower() {
		System.out.println("Thermometer disabled");
		powerEnabled = false;
	}

}
