package com.sist;

import java.util.List;

public interface ICalAccess {
	boolean addCalendar(Cal cal);
	List<Cal> calList(String id, String yyyyMM);
	Cal getCal(String seq); 
	List<Cal> getDayList(String id, String yyyymmdd);
}
