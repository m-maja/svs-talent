package com.acme.termoregulators;

public class StandardThermoregulator implements Thermoregulator{

    private final int checkTime = 3000;
    private Integer configuredTemperature;


    @Override
    public void setTemperature(Integer temperature) {
        configuredTemperature = temperature;
    }

    @Override
    public void checkTemperature(Integer newTemperature) {
        System.out.print("Current temperature = " + newTemperature + " ");
        if (newTemperature > this.configuredTemperature){
            disablePower();
        }
        if (newTemperature <= this.configuredTemperature){
            enablePower();
        }
    }


    @Override
    public int checkTime() {
        return checkTime;
    }

    @Override
    public void enablePower() {
        System.out.println("Standard thermoregulator enabled");
        System.out.flush();
    }

    @Override
    public void disablePower() {
        System.out.println("Standard thermoregulator disabled");
        System.out.flush();
    }
}
