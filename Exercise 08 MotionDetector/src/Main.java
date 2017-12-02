import alarmchannel.AlarmChanel;
import alarmchannel.ConsoleAlarmChanel;
import capturingdevice.ConsoleImageCapturingDevice;
import motiondetector.MotionDetector;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String [] args){
        List<AlarmChanel> alarmChannels = new ArrayList<>();
        alarmChannels.add(new ConsoleAlarmChanel(1));
        alarmChannels.add(new ConsoleAlarmChanel(2));

        new MotionDetector(
                new ConsoleImageCapturingDevice(),
                alarmChannels
        ).start();
    }
}
