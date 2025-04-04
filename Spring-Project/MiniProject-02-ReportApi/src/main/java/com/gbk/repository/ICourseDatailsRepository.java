package com.gbk.repository;



import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gbk.entity.CourseDetails;

public interface ICourseDatailsRepository extends JpaRepository<CourseDetails, Integer> {
	
	@Query("select distinct (courseCategory) from CourseDetails")
	public Set<String> getuniqueCourseCategory();
	
	@Query("select distinct (facultyName) from CourseDetails")
	public Set<String> getuniquefacultyName();
	
	@Query("select distinct (trainingMode) from CourseDetails")
	public Set<String> getuniquetraininMode();

}
