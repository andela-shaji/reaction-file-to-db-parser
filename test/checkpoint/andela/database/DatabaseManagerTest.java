package checkpoint.andela.database;

import checkpoint.andela.model.Reactant;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by suadahaji.
 */
public class DatabaseManagerTest {
    DatabaseManager databaseManager;
    Reactant reactant;


    @Before
    public void setUp() throws Exception {
        databaseManager = new DatabaseManager();
        reactant = new Reactant("P-PANTOCYSLIG-RXN", "Small-Molecule-Reactions", "(:NO-HYDROGEN-ENCODING", "SRI");
    }

    @Test
    public void testInsertIntoTable() throws Exception {
        boolean insert = databaseManager.insertIntoTable(reactant);
        assertTrue(insert);

    }
}