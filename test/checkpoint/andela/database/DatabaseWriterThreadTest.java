package checkpoint.andela.database;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by suadahaji.
 */
public class DatabaseWriterThreadTest {
    DatabaseWriterThread dbWriter;

    @Before
    public void setUp() throws Exception {
        dbWriter = new DatabaseWriterThread();
    }

    @Test
    public void testDbWriterThread() throws Exception {
        Thread dbWriterThread = new Thread(new DatabaseWriterThread());
        dbWriterThread.start();
        assertTrue(dbWriterThread.isAlive());
    }
}