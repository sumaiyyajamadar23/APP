package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Emp;
import com.app.repo.Emprepo;
@Service
public class EmpService implements EmpIService
{

	@Autowired
	public Emprepo emprepo;
	@Override
	public Emp newEmp(Emp emp) {
		// TODO Auto-generated method stub
		return emprepo.save(emp);
	}

	@Override
	public List<Emp> getAllEmp() {
		// TODO Auto-generated method stub
		return emprepo.findAll();
	}

	@Override
	public Emp getEmpId(int id) {
		// TODO Auto-generated method stub
		return emprepo.findById(id).get();
	}

	@Override
	public void delEmp(int id) {
		// TODO Auto-generated method stub
		//boolean a=true;
		//emprepo.deleteById(id);
		Emp e=emprepo.findById(id).get();
		if(e!=null)
		{
			emprepo.delete(e);
		}
		
	}

	@Override
	public Emp updateEmp(int id, Emp newe) {
		// TODO Auto-generated method stub
		Emp old=emprepo.findById(id).get();
		if(old!=null)
		{
			newe.setId(id);
			return emprepo.save(newe);
		}
		return null;
	}

}
