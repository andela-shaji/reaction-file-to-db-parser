package checkpoint.andela.parser;

import checkpoint.andela.config.Columns;
import checkpoint.andela.model.Reactant;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by suadahaji.
 */
public class ReactionParser {
    private HashMap<String, String > attributeValuePair = new HashMap<>();

    private List<Reactant> reactants = new ArrayList<>();

    public ReactionParser() {}

    public ReactionParser(String filePath) {
        File file = new File(filePath);
        readFile(file);

    }
    public void readFile(File file) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String contentLine ;
            while (bufferedReader.ready()) {
                contentLine = bufferedReader.readLine();
                parseLine(contentLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void parseLine(String line) {
        if (!hasComment(line)){
            if (!hasDelimiter(line)){
                String[] data = line.split(" - ");
                attributeValuePair.putIfAbsent(data[0], data[1]);
            } else {
                reactants.add(createRow(attributeValuePair));
                attributeValuePair = new HashMap<>();
            }
        }
    }

    private Reactant createRow(HashMap attributeValuePair) {
        String uniqueId = (String) attributeValuePair.get(Columns.UNIQUEID);
        String types = (String) attributeValuePair.get(Columns.TYPES);
        String atomMappings = (String) attributeValuePair.get(Columns.ATOMMAPPINGS);
        String credits = (String) attributeValuePair.get(Columns.CREDITS);
        String ecNumber = (String) attributeValuePair.get(Columns.ECNUMBER);
        String enzymaticReaction = (String) attributeValuePair.get(Columns.ENZYMATICREACTION);
        String left = (String) attributeValuePair.get(Columns.LEFT);
        String right = (String) attributeValuePair.get(Columns.RIGHT);

        Reactant reactant = new Reactant(uniqueId, types, atomMappings, credits);
        reactant.setEcNumber(ecNumber);
        reactant.setEnzymaticReaction(enzymaticReaction);
        reactant.setLeft(left);
        reactant.setRight(right);

        return reactant;
    }

    public List<Reactant> getReactants() {
        return reactants;
    }

    private boolean hasComment(String currentLine) {
        if (currentLine.startsWith("#")) {
            return true;
        }
        return false;
    }

    private boolean hasDelimiter(String currentLine) {
        if (currentLine.startsWith("//")) {
            return true;
        }
        return false;
    }

}
