package com.sist;

import java.io.Serializable;

/*create table bbs(
		seq number(8) primary key,
		id varchar2(50) not null,
		ref number(8) not null,
		step number(8) not null,
		depth number(8) not null,
		title varchar2(200) not null,
		content varchar2(4000) not null,
		wdate date not null,
		parent number(8) not null,
		del number(1) not null,
		readcount number(8) not null
	);

	create sequence seq_bbs
	start with 1 increment by 1;

	alter table bbs
	      add constraint fk_bbs_id foreign key(id)
	      references member(id);*/
	
public class Bbs implements Serializable {

	private static final long serialVersionUID = 3687924113099733910L;
	
	private int seq;	//검색을 빨리하고 중복을 막기위해 사용
	private String id;
	
	private int ref; //reference 그룹번호  댓글달거나 할때 용이
	private int step; // 밑으로 
	private int depth;	// 옆으로
	
	private String title;
	private String content;
	private String wdate;
	private int parent;	//부모글
	
	private int del;	//삭제된 글이냐 아니냐 확인 데이터베이스의 무결성이 꺠지지 않도록 삭제할때 실제로 데이터에 지우지 않고 이 변수로 제어한다.
	private int readcount;
	
	public Bbs() {}
	
	public Bbs(String id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	

	public Bbs(int seq, String id, int ref, int step, int depth, String title, String content, String wdate, int parent,
			int del, int readcount) {
		super();
		this.seq = seq;
		this.id = id;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.parent = parent;
		this.del = del;
		this.readcount = readcount;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	@Override
	public String toString() {
		return "Bbs [seq=" + seq + ", id=" + id + ", ref=" + ref + ", step=" + step + ", depth=" + depth + ", title="
				+ title + ", content=" + content + ", wdate=" + wdate + ", parent=" + parent + ", del=" + del
				+ ", readcount=" + readcount + "]";
	}

}
