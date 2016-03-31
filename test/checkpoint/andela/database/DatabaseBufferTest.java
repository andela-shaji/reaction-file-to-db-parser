package checkpoint.andela.database;

import checkpoint.andela.model.Reactant;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by suadahaji.
 */
public class DatabaseBufferTest {
    Reactant reactant;
    DatabaseBuffer databaseBuffer;

    @Before
    public void setUp() throws Exception {
        databaseBuffer = new DatabaseBuffer();
        reactant = new Reactant("P-PANTOCYSLIG-RXN", "Small-Molecule-Reactions", "(:NO-HYDROGEN-ENCODING", "SRI");

    }

    @Test
    public void testInsert() throws Exception {
        databaseBuffer.insert(reactant);
        assertNotNull(databaseBuffer);
    }

    @Test
    public void testRetrieve() throws Exception {
        databaseBuffer.insert(reactant);
        assertNotNull(databaseBuffer);

        databaseBuffer.retrieve();
        assertFalse(databaseBuffer.contains(reactant));

    }
}