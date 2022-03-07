package com.hemebiotech.analytics.symptomanalyserhandler;

import com.hemebiotech.analytics.analyser.ISymptomAnalyser;
import com.hemebiotech.analytics.analyser.SymptomAnalyser;

import java.util.Map;
import java.util.List;



public abstract class AbstractSymptomAnalyserHandler
{
    ISymptomAnalyser analyser = new SymptomAnalyser();


    abstract protected List<String> getSymptoms() throws Exception;

    abstract protected void saveSymptoms(final Map<String, Long> map) throws Exception;


    public final void makeAndSaveSymptomAnalyse()
    {
        try
        {
            saveSymptoms(analyser.sortAndCount(getSymptoms()));
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}