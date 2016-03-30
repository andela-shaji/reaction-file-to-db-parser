package checkpoint.andela.log;

import checkpoint.andela.config.SharedBuffer;

/**
 * Created by suadahaji.
 */
public class LogWriterThread implements Runnable{

    private LogWriter logWriter;

    private LogBuffer logBuffer = SharedBuffer.logBuffer();

    @Override
    public void run() {
        while (logBuffer.isEmpty()) {
            logWriter.writeToFile(logBuffer.retrieve());
        }
    }
}
