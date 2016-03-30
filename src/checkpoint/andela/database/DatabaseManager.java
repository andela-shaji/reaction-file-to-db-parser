package checkpoint.andela.database;

import checkpoint.andela.config.Columns;
import checkpoint.andela.config.Constants;
import checkpoint.andela.model.Reactant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by suadahaji.
 */
public class DatabaseManager {
    private String db_Url = Constants.DBURL.toString();
    private String db_Name = Constants.DBNAME.toString();
    private String db_Table = Constants.DBTABLE.toString();
    private String db_Password = Constants.PASS.toString();
    private String db_User = Constants.USER.toString();
    private String db_driver = Constants.DRIVER.toString();
    private Connection connection;
    private PreparedStatement statement = null;

    public DatabaseManager() {
        try {
            createDbTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection createDatabaseConnection(String driver) {
        try {
            registerDriver(driver);
            connection = DriverManager.getConnection(db_Url, db_User, db_Password);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void registerDriver(String driver) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException cnfe) {
            cnfe.getMessage();
        }
    }

    public void createDbTable() throws Exception {
        createDatabaseConnection(db_driver);
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + db_Name + "." + db_Table + " (`" + Columns.UNIQUEID + "` text, `" + Columns.TYPES
                + "` text, `" + Columns.ATOMMAPPINGS + "` text, `" + Columns.CREDITS + "` text, `" + Columns.ECNUMBER
                + "` text, `" + Columns.ENZYMATICREACTION + "` text, `" + Columns.LEFT + "` text, `" + Columns.RIGHT
                + "` text )";
        try {
            statement = connection.prepareStatement(createTableQuery);
            statement.execute(createTableQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
    }

    private void deleteTableRecords() throws Exception {
        createDatabaseConnection(db_driver);
       String deleteRecordsQuery = "DROP TABLE " + db_Name +"." + db_Table ;

        try {
            statement = connection.prepareStatement(deleteRecordsQuery);
            statement.executeUpdate(deleteRecordsQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeStatement(statement);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean insertIntoTable(Reactant reactant) {
        String insertRecordQuery = " INSERT INTO " + db_Name + "." + db_Table + " (`"
                + Columns.UNIQUEID + "`, `" + Columns.TYPES + "`, `" + Columns.ATOMMAPPINGS + "`, `" + Columns.CREDITS + "`, `"
                + Columns.ECNUMBER + "`, `" + Columns.ENZYMATICREACTION + "`, `" + Columns.LEFT + "`, `" + Columns.RIGHT + "`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            statement = connection.prepareStatement(insertRecordQuery);

            statement.setString(1, reactant.getUniqueId());
            statement.setString(2, reactant.getTypes());
            statement.setString(3, reactant.getAtomMappings());
            statement.setString(4, reactant.getCredits());
            statement.setString(5, reactant.getEcNumber());
            statement.setString(6, reactant.getEnzymaticReaction());
            statement.setString(7, reactant.getLeft());
            statement.setString(8, reactant.getRight());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                closeStatement(statement);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public void closeStatement(PreparedStatement statement) throws Exception {
        if (statement != null) {
            statement.close();
        }
    }


}
