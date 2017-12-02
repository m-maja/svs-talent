package capturingdevice;

import image.Image;

import java.util.Scanner;

public class ConsoleImageCapturingDevice implements ImageCapturingDevice {

    private Image image;

    public ConsoleImageCapturingDevice() {
        image = new Image();
    }

    @Override
    public void captureImage() {
        Scanner scanner = new Scanner(System.in);
        image = new Image();
        image.addBytes(scanner.nextLine().getBytes());
    }

    @Override
    public Image getImage() {
        return image;
    }
}
