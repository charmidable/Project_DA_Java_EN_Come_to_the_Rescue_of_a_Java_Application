package com.hemebiotech.analytics.symptomanalyserhandler;

import com.hemebiotech.analytics.ISymptomReader;
import com.hemebiotech.analytics.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.symptomswriter.ISymptomWriter;
import com.hemebiotech.analytics.symptomswriter.WriteSymptomDataToFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public final class FileTextToFileTextSymptomsAnalyser extends AbstractSymptomAnalyserHandler
{
    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    public FileTextToFileTextSymptomsAnalyser(String inputFile, String outputFile)
    {
        reader = new ReadSymptomDataFromFile(Path.of(inputFile) );
        writer = new WriteSymptomDataToFile(Path.of(outputFile) );
    }


    @Override
    protected final List<String> getSymptoms() throws IOException
    {
        return ((ReadSymptomDataFromFile)reader).getSymptoms();
    }

    @Override
    protected final void saveSymptoms(final Map<String, Long> map) throws IOException
    {
        ((WriteSymptomDataToFile)writer).writeSymptomAnalyse(map);
    }
}