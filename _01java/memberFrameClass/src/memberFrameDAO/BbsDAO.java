package memberFrameDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import FileClass.FileClass;
import memberFrameClass.SingletonClass;
import memberFrameDTO.BbsDTO;


public class BbsDAO {
	
	public List<BbsDTO> list = new ArrayList<BbsDTO>();
	public List<BbsDTO> selList = new ArrayList<BbsDTO>();
	private int seq = 0;
	FileClass fc = null;
	
	public BbsDAO() {
		fc = new FileClass();
		String[] copy;
		String[] temp;
		BbsDTO dto;
		boolean b = fc.checkBeforeReadFile("bbsDB");
		if(!b) fc.fileCreate("bbsDB");
		
		copy = fc.fileRead("bbsDB");
		
		list.removeAll(list);
		for(int i=0; i<copy.length; ++i){
			System.out.println(i + "바퀴");
			if(copy[i].equals("")) break;
			temp = copy[i].split("-");
			
			
			
			
			
			//temp[3] = temp[3].replaceAll("<br>", "[\r\n]+");
			
			System.out.print("temp[" + i + "] : ");
			for(int j=0; j<temp.length; ++j){
				System.out.print(temp[j]);
			}
			System.out.println();
			
			dto = new BbsDTO(temp[1], temp[2], temp[3]);
			dto.setWdate(temp[4]);
			dto.setSeq(Integer.parseInt(temp[0]));
			dto.setReadcount(Integer.parseInt(temp[5]));
			list.add(dto);
			
			seq = Integer.parseInt(temp[0]);
			
		}
	}
	
	public boolean selBbs(String choiceTxt, String selT){
		selList.removeAll(selList);
		boolean b = false;
		
		switch(choiceTxt){
			case "전체" : {
				for(int i=0; i<list.size(); ++i){
					if(list.get(i).getId().contains(selT)){
						selList.add(list.get(i));
						b = true;
					}else if(list.get(i).getTitle().contains(selT)){
						selList.add(list.get(i));
						b = true;
					}else if(list.get(i).getContent().contains(selT)){
						selList.add(list.get(i));
						b = true;
					}
				}
				break;
			}
			case "작성자" : {
				for(int i=0; i<list.size(); ++i){
					if(list.get(i).getId().contains(selT)){
						selList.add(list.get(i));
						b = true;
					}
				}
				break;
			}
			case "제목" : {
				for(int i=0; i<list.size(); ++i){
					if(list.get(i).getTitle().contains(selT)){
						selList.add(list.get(i));
						b = true;
					}
				}
				break;
			}
			case "내용" : {
				for(int i=0; i<list.size(); ++i){
					if(list.get(i).getContent().contains(selT)){
						selList.add(list.get(i));
						b = true;
					}
				}
				break;
			}
		}
			
		return b;
	}
	
	public BbsDTO updateBbs(BbsDTO dto){
		BbsDTO result = null;
		SingletonClass sc = SingletonClass.getInstance();
		for(int i=0; i<list.size(); ++i){
			if(sc.selBbs.getId().equals(list.get(i).getId())){
				if(sc.selBbs.getTitle().equals(list.get(i).getTitle())){
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat transFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					String wdate = transFormat.format(cal.getTime());
					dto.setWdate(wdate);
					dto.setReadcount(sc.selBbs.getReadcount());
					sc.selBbs = dto;
					list.set(i, dto);
					result = dto;
				}
			}
		}
		return result;
	}
	
	public boolean deleteBbs(BbsDTO dto){
		boolean b = false;
		for(int i=0; i<list.size(); ++i){
			if(dto == list.get(i)){
				list.remove(i);
				System.out.println("삭제 완료!");
				b = true;
				break;
			}
		}
		return b;
	}
	
	
	public boolean writeBbs(BbsDTO dto) {
		seq++;
		// dto
		
		dto.setSeq(seq);
		dto.setReadcount(0);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String wdate = transFormat.format(cal.getTime());
		dto.setWdate(wdate);
		
		boolean b = list.add(dto);
		
		allPrint();
		
		// list
		
		return b;
	}
	
	public void allPrint(){
		for(int i=0; i<list.size(); ++i){
			BbsDTO d = list.get(i);
			System.out.println(d.toString());
		}
	}
	
	public void fileLoad(){
		String[] text = new String[list.size()];
		for(int i =0; i<list.size(); ++i){
			text[i] = list.get(i).toString();
		}
		fc.fileWrite("bbsDB", text);
		
	}
}
