package com.fr2501.util.file;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * 
 * An interface to provide simple interaction with the file system.
 * For writing instead of reading files, see {@link TextFileWriter}.
 *
 */
public interface TextFileReader {
	
	/**
	 * @see #readFile(File)
	 */
	public String readFile(String path) throws IOException;
	
	/**
	 * @see #readFile(File)
	 */
	public String readFile(URL url) throws IOException;
	
	/**
	 * Returns the contents of a file, ends of lines in the file are set to {@link System#lineSeparator()}.
	 * @param file  the file to be read
	 * @return the contents of that file
	 * @throws IOException  if file system interaction fails
	 */
	public String readFile(File file) throws IOException;
	
	/**
	 * @see #readFileLineByLine(File)
	 */
	public List<String> readFileLineByLine(String path) throws IOException;
	
	/**
	 * @see #readFileLineByLine(File)
	 */
	public List<String> readFileLineByLine(URL url) throws IOException;
	
	/**
	 * Returns the contents of a file, line by line.
	 * @param file  the file to be read
	 * @return the contents of that file, with every line being one item of the list
	 * @throws IOException  if file system interaction fails
	 */
	public List<String> readFileLineByLine(File file) throws IOException;
}
