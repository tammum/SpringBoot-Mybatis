package com.batisui.studentDatabase.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.batisui.studentDatabase.model.StudentTwo;


@Mapper
public interface studentTwoMapper {
	@Insert("insert into studentTwo(id,name) values(#{id},#{name})")
	public void insert(StudentTwo student);
	
	@Select("select * from studentTwo")
	public List<StudentTwo> selectAll();
	
	@Update("update studenttwo set id=#{id},name=#{name} where id=#{id}")
	public void update(StudentTwo student);
	
	@Delete("delete from studenttwo where id=#{id}")
	public void delete(int id);
}