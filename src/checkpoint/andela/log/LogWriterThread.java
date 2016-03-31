package checkpoint.andela.log;

import checkpoint.andela.configs.SharedBuffer;
import checkpoint.andela.configs.Complete;

import java.io.*;

/**
 * Created by suadahaji.
 */
public class LogWriterThread implements Runnable{
    private File file;

    private LogBuffer logBuffer = SharedBuffer.logBuffer();

    public LogWriterThread(String logPath) {
        createFile(logPath);
    }


    @Override
    public void run() {
        while (!Complete.INSTANCE.isCompleted() || !logBuffer.isEmpty()) {
            writeToLog(logBuffer.retrieve());
        }
    }

    public void writeToLog(String logMessage) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println(logMessage);
            printWriter.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void createFile(String logPath) {
        file = new File(logPath);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
