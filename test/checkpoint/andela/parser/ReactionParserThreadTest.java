package checkpoint.andela.parser;

import checkpoint.andela.config.Constants;
import checkpoint.andela.config.SharedBuffer;
import checkpoint.andela.log.LogBuffer;
import checkpoint.andela.log.LogWriter;
import checkpoint.andela.log.LogWriterThread;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by suadahaji.
 */
public class ReactionParserThreadTest {

    ReactionParserThread reactionParserThread;
    String filePath;
    ReactionParser parser;
    File file;
    LogBuffer logBuffer;
    LogWriter logWriter;
    LogWriterThread logWriterThread;


    @Before
    public void setUp() throws Exception {
        filePath = Constants.FILEPATH.toString();
        file = new File(filePath);
        parser = new ReactionParser(filePath);
        reactionParserThread = new ReactionParserThread(filePath);
        logBuffer = SharedBuffer.logBuffer();
        logWriter = new LogWriter(Constants.LOGPATH.toString());
        logWriterThread = new LogWriterThread(Constants.LOGPATH.toString());

    }




    @Test
    public void testRun() throws Exception {
        parser.readFile(file);

        reactionParserThread.run();

       logWriterThread.run();

    }
}