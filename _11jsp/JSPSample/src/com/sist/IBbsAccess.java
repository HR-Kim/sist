package com.sist;

import java.util.List;

public interface IBbsAccess {
	List<Bbs> getBbsList();
	boolean writeBbs(Bbs bbs);
	Bbs getBbs(int seq);
	boolean addReadCount(int seq, int readcount);
	boolean answer(int seq, Bbs bbs);
}
