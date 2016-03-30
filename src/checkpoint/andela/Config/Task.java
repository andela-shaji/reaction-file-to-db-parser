package checkpoint.andela.config;

/**
 * Created by suadahaji.
 */
public class Task {
    private static boolean isWriting = true;

    public static boolean isWriting() {
        return isWriting;
    }

    public static void setWriting(boolean isWriting) {
        Task.isWriting = isWriting;
    }
}
