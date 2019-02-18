package AntonioAguirre;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HoraActual {
        static Date date = new Date();
        static DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

    public static String hora(){
        return hourFormat.format(date);
    }
}
