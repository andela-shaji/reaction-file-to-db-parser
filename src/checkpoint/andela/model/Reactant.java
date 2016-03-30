package checkpoint.andela.model;

/**
 * Created by suadahaji.
 */
public class Reactant {
    private String uniqueId;

    private String types;

    private String atomMappings;

    private String credits;

    private String ecNumber;

    private String enzymaticReaction;

    private String left;

    private String right;

    public Reactant(String uniqueId, String types, String atomMappings, String credits) {
        setUniqueId(uniqueId);
        setTypes(types);
        setAtomMappings(atomMappings);
        setCredits(credits);
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getAtomMappings() {
        return atomMappings;
    }

    public void setAtomMappings(String atomMappings) {
        this.atomMappings = atomMappings;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getEcNumber() {
        return ecNumber;
    }

    public void setEcNumber(String ecNumber) {
        this.ecNumber = ecNumber;
    }

    public String getEnzymaticReaction() {
        return enzymaticReaction;
    }

    public void setEnzymaticReaction(String enzymaticReaction) {
        this.enzymaticReaction = enzymaticReaction;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }


}
