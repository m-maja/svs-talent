package com.acme.termoregulators;

import com.ventoelectrics.components.WaterHeater;

public class ThermoregulatorAdapter extends Thread {
    private WaterHeater waterHeater;

    public ThermoregulatorAdapter(WaterHeater waterHeater) {
        super();
        this.waterHeater = waterHeater;
    }

    @Override
    public void run() {
        while (true) {
            try{
                waterHeater.getThermoregulator().checkTemperature(
                        waterHeater.getThermometer().getTemperature()
                );
            } catch (Exception ex){
                break;
            }

            try {
                sleep(waterHeater.getThermoregulator().checkTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
