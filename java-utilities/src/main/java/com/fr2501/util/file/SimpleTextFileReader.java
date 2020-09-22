package com.fr2501.util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * A simple implementation of a {@linkplain TextFileReader}.
 *
 */
public class SimpleTextFileReader implements TextFileReader {

	@Override
	public String readFile(String path) throws IOException {
		return this.readFile(new File(path));
	}

	@Override
	public String readFile(URL url) throws IOException {
		return this.readFile(url.getFile());
	}

	@Override
	public String readFile(File file) throws IOException {
		String result = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			int characterNum = br.read();
			while(characterNum != -1) {
				result += (char) characterNum;
				
				characterNum = br.read();
			} 
			
			return result;
		} catch (IOException e) {
			throw e;
		}
	}

	@Override
	public List<String> readFileLineByLine(String path) throws IOException {
		return this.readFileLineByLine(new File(path));
	}

	@Override
	public List<String> readFileLineByLine(URL url) throws IOException {
		return this.readFileLineByLine(url.getFile());
	}

	@Override
	public List<String> readFileLineByLine(File file) throws IOException {
		List<String> result = new LinkedList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			while(line != null) {
				result.add(line);
				line = br.readLine();
			}
			
			return result;
		} catch (IOException e) {
			throw e;
		}
	}
}
