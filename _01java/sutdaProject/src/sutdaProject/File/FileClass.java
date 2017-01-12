package sutdaProject.File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileClass {
public FileClass() {
		
	}
	
	public void fileWrite(String filename, String str[]){
		
		File writeFile = new File("c:\\sutdaDB\\"+ filename + ".txt");
		
		boolean b = checkBeforeWriteFile(writeFile);
		if(!b){
			System.out.println("--파일이 없거나 파일이 아니므로 쓰기를 할 수 없습니다--");
			return;
		}
				
		try{
			PrintWriter pw 
				= new PrintWriter(new BufferedWriter(
								new FileWriter(writeFile)));
			
			for (int i = 0; i < str.length; i++) {
				pw.println(str[i]);
			}						
			
			System.out.println("기입되었습니다!");
			
			pw.close();
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void fileAppend(String fileName, String content){
		String dirStr = "c:\\sutdaDB";
		fileName = "\\" + fileName + ".txt";
		File f = new File(dirStr+fileName);
		content = content + "\r\n";
		try {
			FileWriter fileAppend = new FileWriter(f, true);
			
			fileAppend.write(content);
			
			fileAppend.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void fileCreate(String fileName){
		String dirStr = "c:\\sutdaDB";
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
		String dirStr = "c:\\sutdaDB";
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
		String dirStr = "c:\\sutdaDB";
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
	
	public static void filePrint(){
		File tmpdir = new File("c:\\sutdaDB");
		File filelist[] = tmpdir.listFiles();
		
		for(int i=0; i<filelist.length; i++){
			// System.out.println(filelist[i]);
			if(filelist[i].isFile()){
				System.out.println("[파일명]" + filelist[i].getName());
			}
			else if(filelist[i].isDirectory()){
				System.out.println("[directory]" + filelist[i].getName());
			}
			else{
				System.out.println("[?]" + filelist[i].getName());
			}
		}
	}
	
	public  static boolean checkBeforeReadFile(String fileName){
		String dirStr = "c:\\sutdaDB";
		fileName = "\\" + fileName + ".txt";
		File f = new File(dirStr+fileName);
		
		if(f.exists()){
			if(f.isFile() && f.canRead()){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean checkBeforeWriteFile(File f){		
		if(f.exists()){
			if(f.isFile() && f.canWrite()){
				return true;
			}
		}		
		return false;
	}
}
