package checkpoint.andela.log;

import checkpoint.andela.config.SharedBuffer;

/**
 * Created by suadahaji.
 */
public class LogWriterThread extends LogWriter implements Runnable{

    private LogBuffer logBuffer = SharedBuffer.logBuffer();

    private String log;



    @Override
    public void run() {
        while (logBuffer.isEmpty()) {
            writeToFile(logBuffer.retrieve());
        }
    }
}
