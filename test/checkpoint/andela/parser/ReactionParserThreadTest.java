package checkpoint.andela.parser;

import checkpoint.andela.configs.Constants;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by suadahaji.
 */
public class ReactionParserThreadTest {
    String filePath;
    ReactionParserThread reactionParserThread;

    @Before
    public void setUp() throws Exception {
        filePath = Constants.FILEPATH.toString();
        reactionParserThread = new ReactionParserThread(filePath);
    }

    @Test
    public void testReactionParserThread() throws Exception{
        Thread parserThread = new Thread(reactionParserThread);
        parserThread.start();
        assertTrue(parserThread.isAlive());
    }
}