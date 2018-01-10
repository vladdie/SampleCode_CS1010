package sampleQuestions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Reader {
	
	public ArrayList<String> CSVReader(String path){
		ArrayList<String> contents = new ArrayList<String>();
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine())!=null){
				//String[] items = line.split(",");
				contents.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contents;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(System.getProperty("user.dir"));
		String path = System.getProperty("user.dir")+"\\movie.csv";
		
		Reader r = new Reader();
		
		for(String iterator: r.CSVReader(path)){
			String[] items = iterator.split(",");
			for(int i = 0; i < items.length; i++){
			System.out.print(items[i]+ " , ");
			}
			System.out.println();
		}
		
		
	}

}
