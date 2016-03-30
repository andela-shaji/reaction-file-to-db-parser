package checkpoint.andela.log;


import java.io.*;

/**
 * Created by suadahaji.
 */
public class LogWriter {
    private File file;

    public LogWriter(){}

    public LogWriter (String filePath) {
        file = new File(filePath);

        try {
            if(!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String log) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println(log);
            printWriter.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
