package checkpoint.andela.database;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by suadahaji.
 */
public class DatabaseManagerTest {

    DatabaseManager databaseManager = new DatabaseManager();

    @Test
    public void testDeleteDatabaseTable() throws Exception {
       databaseManager.deleteTableRecords();
    }

    @Test
    public void testCreateDatabaseTable() throws Exception {
        databaseManager.createDbTable();
    }




}