# A Simple File to DB Parser

This is a multithreaded application, which reads in data from a text document, parses the document and saves the data into a mysql database while generating an action log at the same time.

A thread reads in the data into a buffer(temporary storage), another writes it into the database, and the third writes into a log file simultaneously. Each thread logs its action and records time it takes to complete its task.

## Classes

## checkpoint.andela.parser.ReactionParser
This class implements the Runnable class to read in and parse the attached document(reactant.dat) into a buffer.
```sh
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

    private void parseLine(String line) {
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
```

## checkpoint.andela.db.DatabaseWriterThread

This class which implements a Runnable is responsible for collecting data written to the buffer and writing them to the database. 

```sh
@Override
    public void run() {
        while (!databaseBuffer.isEmpty() || !Complete.INSTANCE.isCompleted()) {
            Reactant reactant = databaseBuffer.retrieve();
            dbManager.insertIntoTable(reactant);
            LogMessage.logMessage("DBWriter", reactant.getUniqueId());
        }
    }
```

## checkpoint.andela.log.LogWriterThread
This thread picks from the logs written on the log buffer and writes them into a single text file.
```sh
@Override
    public void run() {
        while (!Complete.INSTANCE.isCompleted() || !logBuffer.isEmpty()) {
            writeToLog(logBuffer.retrieve());
        }
    }

    public void writeToLog(String logMessage) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println(logMessage);
            printWriter.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
```

The log could look like this:
```sh
FileParser Thread (31/03/16 10:59)---- wrote UNIQUE-ID ALKAPHOSPHA-RXN to buffer.
DBWriter Thread (31/03/16 10:59) --- collected UNIQUE-ID PHENYLALANINE--TRNA-LIGASE-RXN from buffer.
```

## Test 
Test cases for the various packages have also been created.
