package com.acme.termoregulators;

import com.ventoelectrics.components.PoweredDevice;

public interface Thermoregulator extends PoweredDevice {

    void setTemperature(Integer temperature);

    void checkTemperature(Integer newTemperature);

    int checkTime();
}
