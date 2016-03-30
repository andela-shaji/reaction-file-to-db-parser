package checkpoint.andela.parser;

import checkpoint.andela.config.Constants;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by suadahaji.
 */
public class ReactionParserTest {

    ReactionParser reactionParser;
    String filePath;
    File file;

    @Before
    public void setUp() throws Exception {
        filePath = Constants.FILEPATH.toString();

        reactionParser = new ReactionParser(filePath);
    }

    @Test
    public void testReadFile() throws Exception {

        reactionParser.readFile(file);


    }

    @Test
    public void testParseLine() throws Exception {

    }

    @Test
    public void testGetReactants() throws Exception {

    }
}