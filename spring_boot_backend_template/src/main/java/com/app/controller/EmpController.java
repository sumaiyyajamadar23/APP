package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Emp;
import com.app.repo.Emprepo;
import com.app.service.EmpService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/emp/sp")
public class EmpController
{
	@Autowired
	private EmpService service;
	@PostMapping("/save")
	public ResponseEntity<Emp> createEmp(@RequestBody Emp emp)
	{
		return new ResponseEntity<Emp>(service.newEmp(emp),HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<List<Emp>> getAllEmployee()
	{
		return new ResponseEntity<List<Emp>>(service.getAllEmp(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Emp> getEmpById(@PathVariable int id)
	{
		return new ResponseEntity<Emp>(service.getEmpId(id),HttpStatus.OK);
	}
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id)
	{
		service.delEmp(id);
		return new ResponseEntity<String>("Deleted Sucessfully....",HttpStatus.OK);
	}
	@PostMapping("/update/{id}")
	public ResponseEntity<Emp> updateEmp(@PathVariable int id,@RequestBody Emp emp)
	{
		return new ResponseEntity<Emp>(service.updateEmp(id, emp),HttpStatus.OK);
	}
}
