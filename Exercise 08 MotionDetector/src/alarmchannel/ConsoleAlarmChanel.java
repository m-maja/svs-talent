package alarmchannel;

public class ConsoleAlarmChanel implements AlarmChanel {

    private int id;

    public ConsoleAlarmChanel(int id) {
        this.id = id;
    }

    @Override
    public void alarm() {
        System.out.println("Motion detected! ConsoleAlarmChannel id[" + id + "]");
    }
}
