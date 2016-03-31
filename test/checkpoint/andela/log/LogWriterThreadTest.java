package checkpoint.andela.log;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by suadahaji.
 */
public class LogWriterThreadTest {
    String logPath;
    LogWriterThread logWriterThread;
    String logMessage;

    @Before
    public void setUp() throws Exception {
        logPath = "lib/testFile.txt";
        logWriterThread = new LogWriterThread(logPath);
        logMessage = "FileParser Thread (31/03/16 09:36)---- wrote UNIQUE-ID RXN-8748 to buffer.\n";
    }

    @Test
    public void testLogWriterThread() throws Exception {
        Thread logWriter = new Thread(new LogWriterThread(logPath));
        logWriter.start();
        assertTrue(logWriter.isAlive());
    }

    @Test
    public void testWriteToLog() throws Exception {
        logWriterThread.writeToLog(logMessage);
    }
}