package checkpoint.andela.configs;

import checkpoint.andela.database.DatabaseBuffer;
import checkpoint.andela.log.LogBuffer;

/**
 * Created by suadahaji.
 */
public class SharedBuffer {
    private static DatabaseBuffer databaseBuffer = new DatabaseBuffer();

    private static LogBuffer logBuffer = new LogBuffer();

    public static DatabaseBuffer databaseBuffer() {
        return databaseBuffer;
    }

    public static LogBuffer logBuffer() {
        return logBuffer;
    }
}
