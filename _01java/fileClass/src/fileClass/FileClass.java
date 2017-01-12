package fileClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileClass {
	
	public FileClass() {
		
	}
	
	public static void fileCreate(String fileName){
		String dirStr = "c:\\tmp";
		fileName = "\\" + fileName + ".txt";
		File file = new File(dirStr+fileName);
		
		try {
			if(file.createNewFile()){
				System.out.println("create success");
			}else{
				System.out.println("create fail");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void fileDelete(String fileName){
		String dirStr = "c:\\tmp";
		fileName = "\\" + fileName + ".txt";
		File file = new File(dirStr+fileName);
		
		if(file.delete()){
			System.out.println("delete success");
		}else{
			System.out.println("delete fail");
		}
	}
	
	public static String[] fileRead(String fileName){
		String str;
		String personInfo[] = null;
		int count;
		String dirStr = "c:\\tmp";
		fileName = "\\" + fileName + ".txt";
		File file = new File(dirStr+fileName);
		
		count=0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			while((str = br.readLine()) != null){
				count++;
			}
			br.close();
			
			br = new BufferedReader(new FileReader(file));
			personInfo = new String[count];
						
			int j=0;
			while((str = br.readLine()) != null){
				personInfo[j] = new String();
				personInfo[j] = str;
				j++;
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personInfo;
	}
	
	public  static boolean checkBeforeReadFile(String fileName){
		String dirStr = "c:\\tmp";
		fileName = "\\" + fileName + ".txt";
		File f = new File(dirStr+fileName);
		
		if(f.exists()){
			if(f.isFile() && f.canRead()){
				return true;
			}
		}
		
		return false;
	}
	
	
}





















