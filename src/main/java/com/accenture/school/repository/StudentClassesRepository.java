package com.accenture.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.school.model.StudentClasses;

@Repository
public interface StudentClassesRepository extends JpaRepository<StudentClasses, Long> {

}
