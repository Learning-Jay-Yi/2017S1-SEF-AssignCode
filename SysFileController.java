// package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;

public class SysFileController implements Serializable {

	//private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String COMMA_DELIMITER = ",";


    //CSV file header
	//private static final String FILE_HEADER = "id,firstName,lastName,gender,age";
	// CSV File Writer
	public static void dataLog(String fileName, String input,Boolean a) {

	    FileWriter fileWriter = null;
	    try{
	    	fileWriter = new FileWriter(fileName,a);
	    	fileWriter.append(input.toString());
	    	fileWriter.append(NEW_LINE_SEPARATOR);
	    	System.out.println("New data has been added");
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Error In CSV FIle opening");
	    	e.printStackTrace();
	    }
	    finally
	    {
	    	try{
	    		fileWriter.flush();
	    		fileWriter.close();
	    	}
	    	catch(IOException e){
	    		System.out.println("Error while flushing/closing !");
	    		e.printStackTrace();
	    	}
	    }
	}
	
	public static void dataRead(String fileName) {

		BufferedReader fileReader = null;
	    try{
	    	String line = "";
	    	fileReader = new BufferedReader(new FileReader(fileName));
	    	//fileReader.readLine();
	    	while ((line = fileReader.readLine()) != null)
	    	{
	    		System.out.println(line.toString());
	    		//String[] tokens = line.split(COMMA_DELIMITER);
	    	}

	    }
	    catch(Exception e)
	    {
	    	System.out.println("Error In CSV FIle opening");
	    	e.printStackTrace();
	    }
	    finally
	    {
	    	try{
	    		fileReader.close();
	    	}
	    	catch(IOException e){
	    		System.out.println("Error while closing !");
	    		e.printStackTrace();
	    	}
	    }
	}
	/*
	public static void dataDelect(String fileName, String Indicater) {
		BufferedReader fileReader = null;
		FileWriter fileWriter = null;
		ArrayList<String> strList;
	    try{
	    	String line = "";
	    	strList = new ArrayList();
	    	int size = 0;
	    	fileReader = new BufferedReader(new FileReader(fileName));
	    	//fileReader.readLine();
	    	while ((line = fileReader.readLine()) != null)
	    	{
	    		System.out.println(line.toString());
	    		String[] tokens = {" "," "};//line.split(COMMA_DELIMITER);
		    	String newline = "";
	    		size = tokens.length;
	    		if(size>0)
	    		{
	    			for(int i = 0;i<size;i++)
	    			{
	    				if(tokens[i].equals(Indicater))
	    				{
	    					break;	
	    				}
	    				newline =newline + tokens[i]+",";
	    			}
	    			strList.add(newline);
	    		}
	    		
	    	}
	    	try{
	    		
	    		
	    	}
	    	
	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Error In CSV FIle opening");
	    	e.printStackTrace();
	    }
	    finally
	    {
	    	try{
	    		fileReader.close();
	    	}
	    	catch(IOException e){
	    		System.out.println("Error while closing !");
	    		e.printStackTrace();
	    	}
	    }
	}
	*/
	
}