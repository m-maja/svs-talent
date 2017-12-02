package motiondetector;

import alarmchannel.AlarmChanel;
import capturingdevice.ImageCapturingDevice;
import image.Image;

import java.util.List;

public class MotionDetector extends Thread {

    private List<AlarmChanel> alarmChannels;
    private ImageCapturingDevice capturingDevice;


    public MotionDetector(ImageCapturingDevice imageCapturingDevice, List<AlarmChanel> alarmChannels) {
        this.capturingDevice = imageCapturingDevice;
        this.alarmChannels = alarmChannels;
    }

    @Override
    public void run() {
        Image lastImage = new Image();
        boolean isFirstImage = true;


        while(true){
            capturingDevice.captureImage();
            if(isFirstImage){
                isFirstImage = false;
                lastImage = capturingDevice.getImage();
                continue;
            }
            if (!capturingDevice.getImage().equals(lastImage)){
                notifyAlarms();
            }
            lastImage = capturingDevice.getImage();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void notifyAlarms() {
        for (AlarmChanel alarmChanel: alarmChannels) {
            alarmChanel.alarm();
        }
    }


}
