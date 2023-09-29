//opg. 7
import java.io.FileNotFoundException;
import java.io.File;

public class LeseTrad implements Runnable {

    String filnavn;
    Monitor2 monitor;

    public LeseTrad(Monitor2 monitor, String filnavn) {
        this.filnavn = filnavn;
        this.monitor = monitor;
    }

    //Nå leser vi filer
    public void run() {
        try {
            monitor.settInn(monitor.lesFil(filnavn));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
