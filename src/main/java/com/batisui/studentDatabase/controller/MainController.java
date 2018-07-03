package com.batisui.studentDatabase.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.batisui.studentDatabase.mapper.studentTwoMapper;
import com.batisui.studentDatabase.model.StudentTwo;

@Controller
public class MainController {

	@Autowired
	studentTwoMapper studenttwomapper;
	
	@GetMapping(value="/insert")
	public String showInsertPage(Model model) {
		model.addAttribute("student",new StudentTwo());
		return "insertPage";
	}
	@PostMapping(value="/insert")
	public String showMessege(@ModelAttribute StudentTwo student,
			@RequestParam String action,Map<String, Object> map,Model model) {
		studenttwomapper.insert(student);//using field in html to catch the data
		map.put("student", student);
		//adding view
		//adding show all
				List<StudentTwo> studentlist= studenttwomapper.selectAll();
				model.addAttribute("studentList", studentlist);
		return "insertPage";
	}
	//select all
	@GetMapping(value="/all")
	public String showingAll(Model model) {
		List<StudentTwo> student= studenttwomapper.selectAll();
		model.addAttribute("studentList", student);
		return "showAll";
	}
	//update
	@GetMapping(value="/update")
	public String showUpdatePage(Model model) {
		model.addAttribute("student",new StudentTwo());
		return "updatePage";
	}
	@PostMapping(value="/update")
	public String showUpdateMessege(@ModelAttribute StudentTwo student,
			@RequestParam String action,Map<String, Object> map,Model model) {
		studenttwomapper.update(student);//using field in html to catch the data
		map.put("student", student);
		//adding view
				//adding show all
						List<StudentTwo> studentlist= studenttwomapper.selectAll();
						model.addAttribute("studentList", studentlist);
		return "updatePage";
	}
	//delete
	@GetMapping(value="/delete")
	public String showDeletePage(Model model) {
		model.addAttribute("student",new StudentTwo());
		return "deletePage";
	}
	@PostMapping(value="/delete")
	public String showDeleteMessege(@ModelAttribute StudentTwo student,
			@RequestParam String action,Map<String, Object> map,Model model) {
		int id=student.getId();
		studenttwomapper.delete(id);//using field in html to catch the data
		//adding view
				//adding show all
						List<StudentTwo> studentlist= studenttwomapper.selectAll();
						model.addAttribute("studentList", studentlist);
		return "deletePage2";
	}
}
