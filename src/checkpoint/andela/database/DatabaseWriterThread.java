package checkpoint.andela.database;

import checkpoint.andela.config.SharedBuffer;
import checkpoint.andela.log.LogMessage;
import checkpoint.andela.model.Reactant;

/**
 * Created by suadahaji.
 */
public class DatabaseWriterThread  implements Runnable {
    private DatabaseManager dbManager;

    private DatabaseBuffer databaseBuffer = SharedBuffer.databaseBuffer();

    public DatabaseWriterThread() {
        dbManager = new DatabaseManager();
    }

    @Override
    public void run() {
        while (!databaseBuffer.isEmpty()) {
            Reactant reactant = databaseBuffer.retrieve();
            dbManager.insertIntoTable(reactant);
            LogMessage.logMessage("DBWriter", reactant.getUniqueId());
        }
    }
}
