package com.deo.app.rakuten;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <code> FileOpration </code> is a class. Which is used to read user file and
 * count the number of words in it.
 *
 * @author Manish Deo
 * @since May 19, 2018
 */
public class FileOperation {

    private File file;
    private static String EMPTY = "";
    private static String LINE_SPLIT_REGEX = "\\s+";

    public FileOperation() {
    }

    /**
     * Constructor with input filepPath
     *
     * @param filePath : as user file
     */
    public FileOperation(String filePath) {
        this.file = new File(filePath);
    }

    /**
     * Method to return true if it is valid file.
     *
     * @return
     */
    boolean isFile() {
        return this.file.isFile();
    }

    /**
     * Method to read file and count the number of words in the file. 
     * 
     * @return  
     **/
    boolean readFile() {
        try {

            if (isFile()) {
                FileInputStream fileStream = new FileInputStream(file);
                InputStreamReader input = new InputStreamReader(fileStream);
                BufferedReader reader = new BufferedReader(input);

                String line;

                int countWord = 0;

                while ((line = reader.readLine()) != null) {
                    if (!(line.equals(EMPTY))) {

                        String[] wordList = line.split(LINE_SPLIT_REGEX);
                        countWord += wordList.length;
                    }
                }

                Logger.getLogger(WordCount.class.getName()).log(Level.INFO, "Total Number of words: {0}", countWord);
            } else {
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;

    }

}
