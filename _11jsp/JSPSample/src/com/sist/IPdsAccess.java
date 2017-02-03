package com.sist;

import java.util.List;

public interface IPdsAccess {
	boolean writePds(Pds pds);
	
	List<Pds> getPdss();
}
