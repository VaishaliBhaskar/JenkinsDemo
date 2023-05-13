package com.practiceapp.project.Controller;

import java.util.List;

import com.practiceapp.project.Entity.Professor;
import com.practiceapp.project.Service.ProfessorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfessorController {
	
	@Autowired
	private ProfessorService service;
	
	//create a new resource
	@PostMapping("/professor/create")
	public void createProfessor(@RequestBody Professor professor) {
		
		service.saveProfessorById(professor);
	}
	//create multiple new resources
	@PostMapping("/professor/createall")
	public void createMultipleProfessor(@RequestBody List<Professor> professor) {
		
		service.saveAllProfessor(professor);
	}
	
	
	@GetMapping("/professor/getallprofessor")
	public List<Professor> getAllProfessor() {
		return service.findAllProfessor();
	}
	
	@DeleteMapping("/professor/deletebyid/{id}")
	public String deleteProfessorById(@PathVariable int id) {
		
		service.deleteProfessorById(id);
		return "deletedbyid";
	}
	
	@DeleteMapping("/professor/deleteall")
	public String deleteAllProfessor() {
		service.deleteAllProfessor();
		return "deletedAll";
	}
	
	@PutMapping("/professor/update")
	public void updateProfessor(@RequestBody Professor P) {
		
		service.updateProfessor(P);
	}
	
}
