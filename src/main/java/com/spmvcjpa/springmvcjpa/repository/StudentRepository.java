package com.spmvcjpa.springmvcjpa.repository;

import com.spmvcjpa.springmvcjpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
