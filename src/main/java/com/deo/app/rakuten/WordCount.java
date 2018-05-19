package com.deo.app.rakuten;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <code> WordCount </code> is a class. This class is used to validate user
 * input and process the file operation.
 *
 * @author Manish Deo
 * @since May 19, 2018
 */
public class WordCount {

    public WordCount() {
    }

    /**
     * <code> validate</code> method to accept user file and call the
     * <code>FileOperation</code> class to process with file operation.
     *
     * @param filePath
     * @return
     */
    private boolean validate(String filePath) {

        boolean isFile;
        FileOperation operation = new FileOperation(filePath);
        isFile = operation.isFile();

        if (isFile) {
            operation.readFile();
        }

        return isFile;
    }

    /**
     * <code>main</code> method to confirm user input. If user input has single
     * parameter then it will processed for file operation.
     *
     * @param args : as file pull path
     */
    public static void main(String... args) {
        boolean isValid = false;
        Logger.getLogger(WordCount.class.getName()).log(Level.INFO, "Input : {0}", args[0]);

        if (args.length == 1) {
            WordCount count = new WordCount();
            isValid = count.validate(args[0]);
        }

        if (!isValid) {
            Logger.getLogger(WordCount.class
                    .getName()).log(Level.INFO, "You must enter valid file to proceed!");
        }
    }
}
