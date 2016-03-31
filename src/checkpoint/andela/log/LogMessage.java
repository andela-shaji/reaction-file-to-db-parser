package checkpoint.andela.log;

import checkpoint.andela.configs.SharedBuffer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by suadahaji.
 */
public class LogMessage {

    public LogMessage(){}

    private static LogBuffer logBuffer = SharedBuffer.logBuffer();

    public static void logMessage(String currentLog, String columnValue) {

        Date date = new Date();

        String logTime = new SimpleDateFormat("dd/MM/yy HH:mm").format(date);

            logBuffer.insert(currentLog + " Thread (" + logTime  +  getActivity(currentLog) + "UNIQUE-ID " + columnValue + getTarget(currentLog));
    }

    private static String getTarget(String currentLog) {
        if (currentLog.equals("FileParser")) {
            return " to buffer.";
        }
        return " from buffer.";
    }

    private static String getActivity(String activity) {
        if (activity.equals("FileParser")) {
            return ")---- wrote ";
        }
        return ") --- collected ";
    }

}
