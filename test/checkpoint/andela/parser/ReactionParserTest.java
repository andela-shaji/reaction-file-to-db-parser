package checkpoint.andela.parser;

import checkpoint.andela.configs.Constants;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Created by suadahaji.
 */
public class ReactionParserTest {
    String filePath;
    ReactionParser reactionParser;
    File file;

    @Before
    public void setUp() throws Exception {
        filePath = Constants.FILEPATH.toString();
        reactionParser = new ReactionParser(filePath);
        file = new File(filePath);

    }

    @Test
    public void testReadFile() throws Exception {
        reactionParser.readFile(file);
    }
}