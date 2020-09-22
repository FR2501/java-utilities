package com.fr2501.util.file;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 
 * Unit tests for both {@link SimpleTextFileReader} and {@link SimpleTextFileWriter}.
 *
 */
public class SimpleFileIOTest {
	private static final String SIMPLE_TEST_STRING = "The quick brown fox jumped over the lazy dog.\n";
	
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
}
