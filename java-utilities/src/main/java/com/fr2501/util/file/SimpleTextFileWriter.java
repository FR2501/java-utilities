package com.fr2501.util.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;

/**
 * 
 * A simple implementation of a {@linkplain TextFileWriter}.
 *
 */
public class SimpleTextFileWriter implements TextFileWriter {

	@Override
	public void writeToFile(String path, String content) throws IOException {
		this.writeToFile(new File(path), content);
	}

	@Override
	public void writeToFile(URL url, String content) throws IOException {
		this.writeToFile(url.getFile(), content);
	}

	@Override
	public void writeToFile(File file, String content) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.write(content, 0, content.length());
		} catch (IOException e) {
			throw e;
		}
	}

	@Override
	public void writeCollectionToFile(String path, Collection<?> content) throws IOException {
		this.writeCollectionToFile(new File(path), content);
	}

	@Override
	public void writeCollectionToFile(URL url, Collection<?> content) throws IOException {
		this.writeCollectionToFile(url.getFile(), content);
	}

	@Override
	public void writeCollectionToFile(File file, Collection<?> content) throws IOException {
		this.writeCollectionToFile(file, content, System.lineSeparator());
	}

	@Override
	public void writeCollectionToFile(String path, Collection<?> content, String separator) throws IOException {
		this.writeCollectionToFile(new File(path), content, separator);
	}

	@Override
	public void writeCollectionToFile(URL url, Collection<?> content, String separator) throws IOException {
		this.writeCollectionToFile(url.getFile(), content, separator);
	}

	@Override
	public void writeCollectionToFile(File file, Collection<?> content, String separator) throws IOException {
		String contentString = "";
		
		if(content.size() != 0) {
			for(Object o: content) {
				contentString += o.toString() + separator;
			}
			
			contentString = contentString.substring(0, contentString.length() - separator.length());
		}
		
		this.writeToFile(file, contentString);
	}

}
