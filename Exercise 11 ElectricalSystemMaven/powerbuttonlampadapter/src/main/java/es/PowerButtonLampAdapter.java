package es;

import es.powerbutton.PoweredDevice;
import es.lamp.Lamp;

public class PowerButtonLampAdapter implements PoweredDevice {

    private Lamp lamp;

    public PowerButtonLampAdapter(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void enable() {
        lamp.turnOn();
    }

    @Override
    public void disable() {
        lamp.turnOff();
    }
}
