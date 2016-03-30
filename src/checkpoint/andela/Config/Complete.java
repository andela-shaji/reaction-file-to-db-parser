package checkpoint.andela.config;

/**
 * Created by suadahaji.
 */
public enum Complete {
    INSTANCE;

    private boolean completed = false;

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
