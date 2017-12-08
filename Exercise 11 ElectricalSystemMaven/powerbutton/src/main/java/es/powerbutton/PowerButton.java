package es.powerbutton;

public class PowerButton {

	private boolean enabled = false;

    private PoweredDevice device;

    public PowerButton(PoweredDevice device) {
        this.device = device;
    }

    public void click() {

        enabled = !enabled;

        if (enabled) {
            device.enable();
        } else {
            device.disable();
        }
    }
}
