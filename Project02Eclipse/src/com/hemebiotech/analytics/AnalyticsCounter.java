package com.hemebiotech.analytics;

import com.hemebiotech.analytics.symptomanalyserhandler.AbstractSymptomAnalyserHandler;
import com.hemebiotech.analytics.symptomanalyserhandler.FileTextToFileTextSymptomsAnalyser;

public class AnalyticsCounter {
	

			public static void main(String[] args)
			{
				AbstractSymptomAnalyserHandler analyserHandler;

				analyserHandler	= new FileTextToFileTextSymptomsAnalyser("symptoms.txt", "result.out");

				analyserHandler.makeAndSaveSymptomAnalyse();
			}

}