package swp391.fptqna.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public static String convertFromDateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
        String strDate = formatter.format(date);
        return strDate;
    }
}