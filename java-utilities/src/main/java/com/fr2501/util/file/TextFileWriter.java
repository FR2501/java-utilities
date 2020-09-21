package com.fr2501.util.file;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;

/**
 * 
 * An interface to provide simple interaction with the file system.
 * For reading instead of writing files, see {@link TextFileReader}.
 *
 */
public interface TextFileWriter {

	/**
	 * @see #writeToFile(File, String)
	 */
	public void writeToFile(String path, String content) throws IOException;
	
	/**
	 * @see #writeToFile(File, String)
	 */
	public void writeToFile(URL url, String content) throws IOException;
	
	/**
	 * Writes the given contents to a file, possibly creating or overwriting it.
	 * @param file  the file to be written to
	 * @param content  the content
	 * @throws IOException  if file system interaction fails.
	 */
	public void writeToFile(File file, String content) throws IOException;
	
	/**
 	 * @see #writeCollectionToFile(File, Collection)
	 */
	public void writeCollectionToFile(String path, Collection<?> content) throws IOException;
	
	/**
 	 * @see #writeCollectionToFile(File, Collection)
	 */
	public void writeCollectionToFile(URL url, Collection<?> content) throws IOException;
	
	/**
	 * Writes the given contents to a file, possibly creating or overwriting it.
	 * Every item of the collection appears on a new line.
	 * The collection's iterator is used, thus its behavior will be mirrored.
	 * @param file  the file to be written to
	 * @param content  the content
	 * @throws IOException  if file system interaction fails.
	 */
	public void writeCollectionToFile(File file, Collection<?> content) throws IOException;
	
	/**
	 * @see #writeCollectionToFile(File, Collection, String)
	 */
	public void writeCollectionToFile(String path, Collection<?> content, String separator) throws IOException;
	
	/**
	 * @see #writeCollectionToFile(File, Collection, String)
	 */
	public void writeCollectionToFile(URL url, Collection<?> content, String separator) throws IOException;
	
	/**
	 * Writes the given contents to a file, possibly creating or overwriting it.
	 * Items will be separated by the given separator String.
	 * The collection's iterator is used, thus its behavior will be mirrored.
	 * @param file  the file to be written to
	 * @param content  the content
	 * @param separator  the separator
	 * @throws IOException  if file system interaction fails.
	 */
	public void writeCollectionToFile(File file, Collection<?> content, String separator) throws IOException;
}
