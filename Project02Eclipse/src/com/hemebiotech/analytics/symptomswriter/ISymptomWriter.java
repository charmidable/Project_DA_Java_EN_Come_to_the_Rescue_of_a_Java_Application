package com.hemebiotech.analytics.symptomswriter;

import java.util.Map;


/**
 * Anything that will write symptom data to a destination.
 */
public interface ISymptomWriter
{
    /**
     * @param symptomsMap symptomes'name and occurences
     * @throws Exception destination accessibility
     */
    void writeSymptomAnalyse(final Map<String, Long> symptomsMap) throws Exception;
}