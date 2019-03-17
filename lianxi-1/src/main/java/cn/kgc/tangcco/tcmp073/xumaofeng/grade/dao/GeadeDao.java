package cn.kgc.tangcco.tcmp073.xumaofeng.grade.dao;

import java.util.List;

import cn.kgc.tangcco.tcmp073.xumaofeng.grade.entity.Grade;

public interface GeadeDao {

	List<Grade> queryAllGrade();
	
	List<Grade> queryAllToStudent();
	
	Grade detailGrade(String gradename);
	
	int addGrade(Grade grade);
	
	int updateGrade(Grade grade);
	
	int deleteGrade(int gradeid);
	
	int queryGradeCount();
	
	
	
}
