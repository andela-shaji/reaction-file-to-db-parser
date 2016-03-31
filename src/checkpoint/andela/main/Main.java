package checkpoint.andela.main;

import checkpoint.andela.configs.Constants;
import checkpoint.andela.database.DatabaseWriterThread;
import checkpoint.andela.log.LogWriterThread;
import checkpoint.andela.parser.ReactionParserThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by suadahaji.
 */
public class Main {
    public static void main(String[] args) {


        Thread fileParser = new Thread(new ReactionParserThread(Constants.FILEPATH.toString()));
        Thread databaseWriter = new Thread(new DatabaseWriterThread());
        Thread logWriter = new Thread(new LogWriterThread(Constants.LOGPATH.toString()));

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(fileParser);
        executor.execute(databaseWriter);
        executor.execute(logWriter);

        executor.shutdown();
    }

}
