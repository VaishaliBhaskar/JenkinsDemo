package com.practiceapp.project.Service;

import java.util.List;

import com.practiceapp.project.Dao.ProfessorRepository;
import com.practiceapp.project.Entity.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ProfessorService {

	@Autowired
	private ProfessorRepository repo;
	
	//create a professor
	public Professor saveProfessorById(Professor P) {
		
		repo.save(P);
		return P;
	}
	//create multiple professor
	public List<Professor> saveAllProfessor(List<Professor> P){
		
		repo.saveAll(P);
		return P;
		
	}
	//get Professor by id
	public Professor findProfessorById(int id) {
		return repo.findById(id).orElseThrow(null);
	}
	//get professor by id
	public List<Professor> findAllProfessor(){
		return repo.findAll();
		
	}
	//delete a professor
	public String deleteProfessorById(int id) {
		repo.deleteById(id);
		
		return " Professor deleted by id";
		
	}
	//delete all professor
	public String deleteAllProfessor() {
		repo.deleteAll();
		
		return "All Professor deleted";
		
	}
	//update a professor
	public Professor updateProfessor(Professor P) {
		Professor exist=repo.findById(P.getId()).orElseThrow();
		exist.setName(P.getName());
		exist.setDepartment(P.getDepartment());
		return repo.save(exist);
		
	}
	
	
	
	
	
}
