package checkpoint.andela.log;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by suadahaji.
 */
public class LogBufferTest {
    LogBuffer logBuffer;
    String logMessage;

    @Before
    public void setUp() throws Exception {
        logBuffer = new LogBuffer();
        logMessage = "FileParser Thread (31/03/16 09:36) --- wrote UNIQUE-ID RXN-8748 to buffer.\n";
    }

    @Test
    public void testInsert() throws Exception {
        logBuffer.insert(logMessage);
        assertNotNull(logBuffer);
    }

    @Test
    public void testRetrieve() throws Exception {
        logBuffer.insert(logMessage);
        assertNotNull(logBuffer);

        logBuffer.retrieve();
        assertFalse(logBuffer.contains(logMessage));

    }
}