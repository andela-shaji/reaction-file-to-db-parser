package checkpoint.andela.parser;

import checkpoint.andela.config.SharedBuffer;
import checkpoint.andela.config.Complete;
import checkpoint.andela.database.DatabaseBuffer;
import checkpoint.andela.log.LogMessage;
import checkpoint.andela.model.Reactant;

import java.util.List;

/**
 * Created by suadahaji.
 */
public class ReactionParserThread implements Runnable {
    private ReactionParser parser;

    private DatabaseBuffer databaseBuffer = SharedBuffer.databaseBuffer();

    public ReactionParserThread(String filePath) {
        this.parser = new ReactionParser(filePath);
    }

    @Override
    public void run() {
        List<Reactant> reactants = parser.getReactants();

        for (Reactant reactant: reactants) {
            writeToBuffer(reactant);
            LogMessage.logMessage("FileParser", reactant.getUniqueId());
        }
        Complete.INSTANCE.setCompleted(true);
    }

    private void writeToBuffer(Reactant reactant) {
        databaseBuffer.insert(reactant);
    }
}
