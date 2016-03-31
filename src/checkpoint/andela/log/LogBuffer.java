package checkpoint.andela.log;

import checkpoint.andela.config.Buffer;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by suadahaji.
 */
public class LogBuffer extends LinkedBlockingQueue<String> implements Buffer<String> {

    public void insert(String logMessage) {
        try {
            put(logMessage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String retrieve() {
        try {
            return take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
