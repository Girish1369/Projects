package com.gbk.service;

import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.gbk.entity.CourseDetails;
import com.gbk.model.SearchInputs;
import com.gbk.model.SearchResults;
import com.gbk.repository.ICourseDatailsRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CourseManagmentServiceImplementation implements ICourseManagmentService {
	@Autowired
	private ICourseDatailsRepository repo;

	@Override
	public Set<String> showAllCourseCategories() {
		return repo.getuniqueCourseCategory();
	}

	

	@Override
	public Set<String> showAllTrainingModes() {
		
		return repo.getuniquetraininMode();
	}

	@Override
	public Set<String> showAllFaculties() {
		return repo.getuniquefacultyName();
	}

//	@Override
//	public List<SearchResults> showCourseByFilters(SearchInputs inputs) {
//		
//		CourseDetails entity =new CourseDetails();
//		
//		String category = inputs.getCourseCategory();
//		if((category!=null)&&!category.equals("")&&category.length()!=0) {
//			entity.setCourseCategory(category);
//		}
//		
//		String faculty = inputs.getFaculityName();
//		if((faculty!=null)&&!faculty.equals("")&&faculty.length()!=0) {
//			entity.setFacultyName(faculty);
//		}
//		
//		String trainigmode = inputs.getTraininMode();
//		if((trainigmode!=null)&&!trainigmode.equals("")&&trainigmode.length()!=0) {
//			entity.setTraininMode(trainigmode);;
//		}
//		
//		LocalDateTime startDate=inputs.getStartOn();
//		if(startDate!=null) {
//			entity.setStartDate(startDate);
//		}
//		
//		Example<CourseDetails> example = Example.of(entity);
//		
//		//peform the search operation with filter data of the Example Entity obj
//		List<CourseDetails> listEntities = repo.findAll(example);
//		//convert List<Entity Obj> to List<SearchResult obj>
//		List<SearchResults> listResults=new ArrayList<>();
//		//copying the object from course details entity class(as input) and paste in the 
//				// search result object
//		listEntities.forEach(course->{
//		SearchResults result=new SearchResults();
//		BeanUtils.copyProperties(course, result);
//		listResults.add(result);
//		}
//				);
//		return listResults;
//	}

	@Override
	public List<SearchResults> showCourseByFilters(SearchInputs inputs) {
		
		CourseDetails entity =new CourseDetails();
		
		String category = inputs.getCourseCategory();
		if(StringUtils.hasLength(category)) {
			entity.setCourseCategory(category);
		}
		
		String faculty = inputs.getfacultyName();
		if(StringUtils.hasLength(faculty)) {
			entity.setFacultyName(faculty);
		}
		
		String trainigmode = inputs.getTraininMode();
		if(StringUtils.hasLength(trainigmode)) {
			entity.setTrainingMode(trainigmode);;
		}
		
		LocalDateTime startDate=inputs.getStartDate();
		if(!ObjectUtils.isEmpty(startDate)) {
			entity.setStartDate(startDate);
		}
		
		Example<CourseDetails> example = Example.of(entity);
		
		//peform the search operation with filter data of the Example Entity obj
		List<CourseDetails> listEntities = repo.findAll(example);
		//convert List<Entity Obj> to List<SearchResult obj>
		List<SearchResults> listResults=new ArrayList<>();
		//copying the object from course details entity class(as input) and paste in the 
				// search result object
		listEntities.forEach(course->{
		SearchResults result=new SearchResults();
		BeanUtils.copyProperties(course, result);
		listResults.add(result);
		}
				);
		return listResults;
	}
	@Override
	public void generatePdfReport(SearchInputs inputs, HttpServletResponse res) throws Exception {
		//get search results 
		List<SearchResults> listResults=showCourseByFilters(inputs);
		//create Document obj(openPdf)
		Document document=new Document(PageSize.A4); 
		//get PdfWriter to write to the document and response obj
		PdfWriter.getInstance(document, res.getOutputStream());
		//open document to write
		document.open();
		//define font for paragraph
		Font font=FontFactory.getFont(FontFactory.TIMES_BOLD);
		font.setSize(30);
		font.setColor(Color.CYAN);
		
		//create paragraph having content for above font style
		Paragraph para=new Paragraph("Search report of paragraph",font);
		para.setAlignment(Paragraph.ALIGN_CENTER);
		//add paragraph to document
		document.add(para);
		// Display search results as the pdf table
		PdfPTable table=new PdfPTable(10);
		table.setWidthPercentage(70);
		table.setWidths(new float[] {3.0f,3.0f,3.0f,3.0f,3.0f,3.0f,3.0f,3.0f,3.0f,3.0f});
		table.setSpacingBefore(2.0f);
		
		//prepare heading row cells in the pdf table
		PdfPCell cell=new PdfPCell();
		cell.setBackgroundColor(Color.GRAY);
		cell.setPadding(5.0f);
		Font cellFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		cellFont.setColor(Color.BLACK);
		cell.setPhrase(new Phrase("courseId",cellFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("courseName",cellFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("courseCategory",cellFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("facultyName",cellFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("startDate",cellFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("location",cellFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("fee",cellFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("adminContact",cellFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("traininMode",cellFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("courseStatus",cellFont));
		table.addCell(cell);
		
		//add cells to pdf table
		listResults.forEach(result->{
			table.addCell(String.valueOf(result.getCourseId()));
			table.addCell(result.getCourseName());
			table.addCell(result.getCourseCategory());
			table.addCell(result.getFacultyName());
			table.addCell(String.valueOf(result.getStartDate()));
			table.addCell(result.getLocation());
			table.addCell(String.valueOf(result.getFee()));
			table.addCell(String.valueOf(result.getAdminContact()));
			table.addCell(result.getTrainingMode());
			table.addCell(result.getCourseStatus());
			
		});
		//add table to document
		document.add(table);
		//close the document
		document.close();
		
	}

	@Override
	public void generateExcelReport(SearchInputs inputs, HttpServletResponse res) throws Exception{
		//get all the records from database
		List<CourseDetails> list = repo.findAll();
		//copy List<CourseDetails> to List <SearchResults>
		List<SearchResults> listResults=new ArrayList();
		list.forEach(course->{
			SearchResults result=new SearchResults();
			BeanUtils.copyProperties(course, result);
			listResults.add(result);
			
			
		});
		
		
		//create the ExcellWorkBook
		HSSFWorkbook workbook=new HSSFWorkbook();
		//create sheet in the workbook
		HSSFSheet sheet1=workbook.createSheet("CourseDetails");
		HSSFRow headerRow=sheet1.createRow(0);
		headerRow.createCell(0).setCellValue("courseId");
		headerRow.createCell(1).setCellValue("courseName");
		headerRow.createCell(2).setCellValue("courseCategory");
		headerRow.createCell(3).setCellValue("facultyName");
		headerRow.createCell(4).setCellValue("startDate");
		headerRow.createCell(5).setCellValue("location");
		headerRow.createCell(6).setCellValue("fee");
		headerRow.createCell(7).setCellValue("adminContact");
		headerRow.createCell(8).setCellValue("trainingMode");
		headerRow.createCell(9).setCellValue("courseStatus");
		
		int i=1;
		for(SearchResults result:listResults) {
			
			HSSFRow dataRow =sheet1.createRow(i);
			dataRow.createCell(0).setCellValue(result.getCourseId());
			dataRow.createCell(1).setCellValue(result.getCourseName());
			dataRow.createCell(2).setCellValue(result.getCourseCategory());
			dataRow.createCell(3).setCellValue(result.getFacultyName());
			dataRow.createCell(4).setCellValue(result.getStartDate());
			dataRow.createCell(5).setCellValue(result.getLocation());
			dataRow.createCell(6).setCellValue(result.getFee());
			dataRow.createCell(7).setCellValue(result.getAdminContact());
			dataRow.createCell(8).setCellValue(result.getTrainingMode());
			dataRow.createCell(9).setCellValue(result.getCourseStatus());
			i++;
			
		}
		//get output stream pointing to response obj
		ServletOutputStream outputStream = res.getOutputStream();
		//write the excell file with outputstream
		workbook.write(outputStream);
		outputStream.close();
		workbook.close();
		
		
	}



	@Override
	public void generatePdfReportAll(HttpServletResponse res) throws Exception {
		//get search results 
				List<CourseDetails> list=repo.findAll();
				List<SearchResults> listResult=new ArrayList();
				list.forEach(course->{
					SearchResults result=new SearchResults();
					BeanUtils.copyProperties(course, result);
					listResult.add(result);
				}
						);
				
				
				
				//create Document obj(openPdf)
				Document document=new Document(PageSize.A4); 
				//get PdfWriter to write to the document and response obj
				PdfWriter.getInstance(document, res.getOutputStream());
				//open document to write
				document.open();
				//define font for paragraph
				Font font=FontFactory.getFont(FontFactory.TIMES_BOLD);
				font.setSize(30);
				font.setColor(Color.CYAN);
				
				//create paragraph having content for above font style
				Paragraph para=new Paragraph("Search report of paragraph",font);
				para.setAlignment(Paragraph.ALIGN_CENTER);
				//add paragraph to document
				document.add(para);
				// Display search results as the pdf table
				PdfPTable table=new PdfPTable(10);
				table.setWidthPercentage(70);
				table.setWidths(new float[] {3.0f,3.0f,3.0f,3.0f,3.0f,3.0f,3.0f,3.0f,3.0f,3.0f});
				table.setSpacingBefore(2.0f);
				
				//prepare heading row cells in the pdf table
				PdfPCell cell=new PdfPCell();
				cell.setBackgroundColor(Color.GRAY);
				cell.setPadding(5.0f);
				Font cellFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
				cellFont.setColor(Color.BLACK);
				cell.setPhrase(new Phrase("courseId",cellFont));
				table.addCell(cell);
				cell.setPhrase(new Phrase("courseName",cellFont));
				table.addCell(cell);
				cell.setPhrase(new Phrase("courseCategory",cellFont));
				table.addCell(cell);
				cell.setPhrase(new Phrase("facultyName",cellFont));
				table.addCell(cell);
				cell.setPhrase(new Phrase("startDate",cellFont));
				table.addCell(cell);
				cell.setPhrase(new Phrase("location",cellFont));
				table.addCell(cell);
				cell.setPhrase(new Phrase("fee",cellFont));
				table.addCell(cell);
				cell.setPhrase(new Phrase("adminContact",cellFont));
				table.addCell(cell);
				cell.setPhrase(new Phrase("traininMode",cellFont));
				table.addCell(cell);
				cell.setPhrase(new Phrase("courseStatus",cellFont));
				table.addCell(cell);
				
				//add cells to pdf table
				listResult.forEach(result->{
					table.addCell(String.valueOf(result.getCourseId()));
					table.addCell(result.getCourseName());
					table.addCell(result.getCourseCategory());
					table.addCell(result.getFacultyName());
					table.addCell(String.valueOf(result.getStartDate()));
					table.addCell(result.getLocation());
					table.addCell(String.valueOf(result.getFee()));
					table.addCell(String.valueOf(result.getAdminContact()));
					table.addCell(result.getTrainingMode());
					table.addCell(result.getCourseStatus());
					
				});
				//add table to document
				document.add(table);
				//close the document
				document.close();

	}



	@Override
	public void generateExcelReportAll(HttpServletResponse res) throws Exception {
		//get all the records from database
		List<CourseDetails> list = repo.findAll();
		//copy List<CourseDetails> to List <SearchResults>
		List<SearchResults> listResults=new ArrayList();
		list.forEach(course->{
			SearchResults result=new SearchResults();
			BeanUtils.copyProperties(course, result);
			listResults.add(result);
			
			
		});
		
		
		//create the ExcellWorkBook
		HSSFWorkbook workbook=new HSSFWorkbook();
		//create sheet in the workbook
		HSSFSheet sheet1=workbook.createSheet("CourseDetails");
		HSSFRow headerRow=sheet1.createRow(0);
		headerRow.createCell(0).setCellValue("courseId");
		headerRow.createCell(1).setCellValue("courseName");
		headerRow.createCell(2).setCellValue("courseCategory");
		headerRow.createCell(3).setCellValue("facultyName");
		headerRow.createCell(4).setCellValue("startDate");
		headerRow.createCell(5).setCellValue("location");
		headerRow.createCell(6).setCellValue("fee");
		headerRow.createCell(7).setCellValue("adminContact");
		headerRow.createCell(8).setCellValue("trainingMode");
		headerRow.createCell(9).setCellValue("courseStatus");
		
		int i=1;
		for(SearchResults result:listResults) {
			
			HSSFRow dataRow =sheet1.createRow(i);
			dataRow.createCell(0).setCellValue(result.getCourseId());
			dataRow.createCell(1).setCellValue(result.getCourseName());
			dataRow.createCell(2).setCellValue(result.getCourseCategory());
			dataRow.createCell(3).setCellValue(result.getFacultyName());
			dataRow.createCell(4).setCellValue(result.getStartDate());
			dataRow.createCell(5).setCellValue(result.getLocation());
			dataRow.createCell(6).setCellValue(result.getFee());
			dataRow.createCell(7).setCellValue(result.getAdminContact());
			dataRow.createCell(8).setCellValue(result.getTrainingMode());
			dataRow.createCell(9).setCellValue(result.getCourseStatus());
			i++;
			
		}
		//get output stream pointing to response obj
		ServletOutputStream outputStream = res.getOutputStream();
		//write the excell file with outputstream
		workbook.write(outputStream);
		outputStream.close();
		workbook.close();
		
	}

}
