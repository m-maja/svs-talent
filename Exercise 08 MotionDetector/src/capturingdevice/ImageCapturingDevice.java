package capturingdevice;

import image.Image;

public interface ImageCapturingDevice {

    void captureImage();

    Image getImage ();
}
