package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final Path path;


	
	/**
	 * 
	 * @param path  path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile(final Path path)
	{
		this.path = path;
	}
	
	@Override
	public final List<String> getSymptoms() throws IOException
	{
		List<String> symptomList = new ArrayList<>();

		try(Stream<String> lines = Files.lines(path))
		{
			lines.forEach(symptomList::add);
		}
		catch (IOException ioException)
		{
			if (!Files.exists(path))
			{
				throw new IOException("The '" + path + "' symptom input text file does not exist.");
			}
			else if (!Files.isReadable(path))
			{
				throw new IOException("The '" + path + "' symptom input text file does exist, but cannot be read.");
			}
		}

		return symptomList;
	}

}
