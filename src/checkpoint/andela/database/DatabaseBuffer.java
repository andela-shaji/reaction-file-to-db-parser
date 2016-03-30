package checkpoint.andela.database;

import checkpoint.andela.config.Buffer;
import checkpoint.andela.model.Reactant;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by suadahaji.
 */
public class DatabaseBuffer extends LinkedBlockingQueue<Reactant> implements Buffer<Reactant> {

    public DatabaseBuffer(){
        super();
    }
    public void insert(Reactant reactant) {
        try {
            put(reactant);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Reactant retrieve() {
        try {
            return take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
