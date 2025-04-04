package com.gbk.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbk.model.SearchInputs;
import com.gbk.model.SearchResults;
import com.gbk.service.ICourseManagmentService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/reporting/api")
public class CourseReportOperationController {
	@Autowired
	private ICourseManagmentService courseService;

	@GetMapping("/courses")
	public ResponseEntity<?> fetchAllCourseCategories() {
		try {
			Set<String> allCouseCategories = courseService.showAllCourseCategories();
			return new ResponseEntity<Set<String>>(allCouseCategories, HttpStatus.OK);
		} catch (Exception e) {
			e.getStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/training-mode")
	public ResponseEntity<?> fetchAllTrainingMode() {
		try {
			Set<String> FacultiesInfo = courseService.showAllFaculties();
			return new ResponseEntity<Set<String>>(FacultiesInfo, HttpStatus.OK);
		} catch (Exception e) {
			e.getStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/faculties")
	public ResponseEntity<?> fetchAllFaculties() {
		try {
			Set<String> TrainingModesInfo = courseService.showAllTrainingModes();
			return new ResponseEntity<Set<String>>(TrainingModesInfo, HttpStatus.OK);

		} catch (Exception e) {
			e.getStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/search")
	public ResponseEntity<?> fetchCoursesByFilters(@RequestBody SearchInputs input){
		try {
			List<SearchResults> list = courseService.showCourseByFilters(input);
			return new ResponseEntity<List<SearchResults>>(list,HttpStatus.OK);
		}catch(Exception e) {
			e.getStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PostMapping("/pdf-report")
	public void showPdReport(@RequestBody SearchInputs inputs,HttpServletResponse res) {
		try {
			//set response content type
			res.setContentType("application/pdf");
			//set the content dispotion header to response contenet going to browser as downloadable file
			res.setHeader("Content-Disposition", "attachment;fileName=course.pdf");
			//use service
			courseService.generatePdfReport(inputs, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping("/excel-report")
	public void showExcelReport(@RequestBody SearchInputs inputs,HttpServletResponse res) {
		try {
			//set response content type
			res.setContentType("application/vnd.ms-excel");
			//set the content dispotion header to response contenet going to browser as downloadable file
			res.setHeader("Content-Disposition", "attachment; filename=courseDetails.xls");

			//use service
			courseService.generateExcelReport(inputs, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/all-pdf-report")
	public void showPdfRepotAllData(HttpServletResponse res) {
		try {
			//set response content type
			res.setContentType("application/pdf");
			//set the content dispotion header to response contenet going to browser as downloadable file
			res.setHeader("Content-Disposition", "attachment;fileName=course.pdf");
			//use service
			courseService.generatePdfReportAll(res);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@GetMapping("/all-excel-report")
	public void showExcelReportAllData(HttpServletResponse res) {
		try {
			//set response content type
			res.setContentType("application/vnd.ms-excel");
			//set the content dispotion header to response contenet going to browser as downloadable file
			res.setHeader("Content-Disposition", "attachment; filename=courseDetails.xls");

			//use service
			courseService.generateExcelReportAll(res);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
