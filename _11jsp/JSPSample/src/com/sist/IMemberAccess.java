package com.sist;

public interface IMemberAccess {
	public boolean addMember(Member member);
	public Member login(Member member);
	boolean selectId(String id);
}
