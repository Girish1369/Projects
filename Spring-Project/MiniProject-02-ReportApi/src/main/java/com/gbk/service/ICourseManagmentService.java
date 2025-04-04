package com.gbk.service;

import java.util.List;
import java.util.Set;

import com.gbk.model.SearchInputs;
import com.gbk.model.SearchResults;

import jakarta.servlet.http.HttpServletResponse;

public interface ICourseManagmentService {
	public Set<String> showAllCourseCategories();
	public Set<String> showAllTrainingModes();
	public Set<String> showAllFaculties();
	
	public List<SearchResults> showCourseByFilters(SearchInputs inputs);
	
	public void generatePdfReport(SearchInputs inputs,HttpServletResponse res) throws Exception;
	public void generateExcelReport(SearchInputs inputs,HttpServletResponse res) throws Exception;
	
	public void generatePdfReportAll(HttpServletResponse res) throws Exception;
	public void generateExcelReportAll(HttpServletResponse res) throws Exception;
}
