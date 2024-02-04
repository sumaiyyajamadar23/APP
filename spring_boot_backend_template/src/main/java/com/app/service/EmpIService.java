package com.app.service;

import java.util.List;

import com.app.model.Emp;

public interface EmpIService
{
	public Emp newEmp(Emp emp);
	public List<Emp> getAllEmp();
	public Emp getEmpId(int id);
	public void delEmp(int id);
	public Emp updateEmp(int id,Emp emp);
}
