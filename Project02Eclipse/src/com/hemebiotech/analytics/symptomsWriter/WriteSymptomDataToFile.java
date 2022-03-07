package com.hemebiotech.analytics.symptomsWriter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;


/**
 *  write symptom data to a file
 */
public class WriteSymptomDataToFile implements ISymptomWriter
{
    private final Path path;

    public WriteSymptomDataToFile(Path path)
    {
        this.path = path;
    }

    /**
     * write symptomes'name and occurences from a Map to a file text
     * @param symptomMap symptomes'name and occurences
     * @throws IOException output file cannot be created or writed
     */
    @Override
    public void writeSymptomAnalyse(final Map<String, Long> symptomMap) throws IOException
    {
        StringBuilder buffer = new StringBuilder();

        symptomMap.forEach
                (
                        (symptom, occurences) -> buffer .append(symptom)
                                .append(", ")
                                .append(occurences)
                                .append("\n")
                );

        try(BufferedWriter writer = Files.newBufferedWriter(path))
        {
            writer.write(buffer.toString());
        }
        catch(IOException ioe)
        {
            if(!Files.exists(path))
            {
                throw new IOException("The output " + path + " cannot be created.");
            }
            else
            {
                throw new IOException("The output " + path + " file is not writtable.");
            }
        }
    }
}
