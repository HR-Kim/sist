package springbook.code.dao;

import java.util.List;

import springbook.code.doamin.CodeM;

public interface Code {
	public int selectAll();
	public void deleteAll();
	public int add(CodeM code);
	CodeM get(String code_id);
	List<CodeM> getAll();
}
