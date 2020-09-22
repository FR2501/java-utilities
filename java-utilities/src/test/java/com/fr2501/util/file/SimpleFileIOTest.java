package com.fr2501.util.file;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * Unit tests for both {@link SimpleTextFileReader} and {@link SimpleTextFileWriter}.
 *
 */
public class SimpleFileIOTest {
	private static final String SIMPLE_TEST_STRING = "The quick brown fox jumped over the lazy dog.";
	
    @Test
    /**
     * Writes a short String to a temporary file and reads it again.
     * The String should not have changed.
     */
    public void simpleWriteAndRead() throws IOException {
        File tmpFile = File.createTempFile("test", ".txt");
        tmpFile.deleteOnExit();
        
        TextFileWriter writer = new SimpleTextFileWriter();
        TextFileReader reader = new SimpleTextFileReader();
        
        writer.writeToFile(tmpFile, SIMPLE_TEST_STRING);
        String result = reader.readFile(tmpFile);
        
        assert(result.equals(SIMPLE_TEST_STRING));
    }
    
    @Test
    /**
     * Writes a short String to a temporary file and reads it again.
     * The String ends on a line separator that should be preserved.
     * The String should not have changed.
     */
    public void simpleWriteAndReadWithLineBreak() throws IOException {
        File tmpFile = File.createTempFile("test", ".txt");
        tmpFile.deleteOnExit();
        
        TextFileWriter writer = new SimpleTextFileWriter();
        TextFileReader reader = new SimpleTextFileReader();
        
        writer.writeToFile(tmpFile, SIMPLE_TEST_STRING + System.lineSeparator());
        String result = reader.readFile(tmpFile);
        
        assert(result.equals(SIMPLE_TEST_STRING + System.lineSeparator()));
    }
    
    @Test
    /**
     * Writes a List containing one String to a file and reads it again.
     */
    public void writeAndReadUnitaryCollection() throws IOException {
        File tmpFile = File.createTempFile("test", ".txt");
        tmpFile.deleteOnExit();
    	
    	List<String> string = new LinkedList<String>();
    	string.add(SIMPLE_TEST_STRING);
    	
        TextFileWriter writer = new SimpleTextFileWriter();
        TextFileReader reader = new SimpleTextFileReader();
        
        writer.writeCollectionToFile(tmpFile, string);
        List<String> result = reader.readFileLineByLine(tmpFile);
        
        assert(result.equals(string));
    }
    
    @Test
    /**
     * Writes a List containing several Strings to a file and reads it again.
     */
    public void writeAndReadCollection() throws IOException {
        File tmpFile = File.createTempFile("test", ".txt");
        tmpFile.deleteOnExit();
    	
    	List<String> stringList = new LinkedList<String>();
    	String[] splits = SIMPLE_TEST_STRING.split(" ");
    	for(String split: splits) {
    		stringList.add(split);
    	}
    	
        TextFileWriter writer = new SimpleTextFileWriter();
        TextFileReader reader = new SimpleTextFileReader();
        
        writer.writeCollectionToFile(tmpFile, stringList);
        List<String> result = reader.readFileLineByLine(tmpFile);
        
        assert(result.equals(stringList));
    }
}
