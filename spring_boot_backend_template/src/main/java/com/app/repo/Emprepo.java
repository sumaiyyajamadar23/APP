package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Emp;

public interface Emprepo extends JpaRepository<Emp, Integer>
{

}
