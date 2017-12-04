package com;

import com.acme.termoregulators.EfficientThermoregulator;
import com.acme.termoregulators.StandardThermoregulator;
import com.acme.termoregulators.Thermoregulator;
import com.acme.termoregulators.ThermoregulatorAdapter;
import com.ventoelectrics.components.WaterHeater;
import com.ventoelectrics.components.Heater;
import com.ventoelectrics.components.PowerSwitch;
import com.ventoelectrics.components.Thermometer;

import java.util.concurrent.TimeUnit;

public class WaterHeaterApplication {

    public static void main(String[] args) throws Exception {
        PowerSwitch powerSwitch = new PowerSwitch();
        Heater heater = new Heater();
        Thermometer thermometer = new Thermometer();
        Thermoregulator thermoregulator = new StandardThermoregulator(); // Standard or efficient thermoregulator.

        WaterHeater waterHeater = new WaterHeater(powerSwitch, heater, thermometer, thermoregulator);
        ThermoregulatorAdapter thermoregulatorAdapter = new ThermoregulatorAdapter(waterHeater);

        simulateRun(thermoregulatorAdapter, waterHeater);

    }

    private static void simulateRun(ThermoregulatorAdapter thermoregulatorAdapter, WaterHeater waterHeater) {
        waterHeater.getThermoregulator().setTemperature(20);
        System.out.println("---START HEATING---");
        waterHeater.getPowerSwitch().turnOn();
        thermoregulatorAdapter.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
        }

        waterHeater.getThermoregulator().setTemperature(40);

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
        }

        waterHeater.getPowerSwitch().turnOff();
        System.out.println("---STOP HEATING---");
    }
}
