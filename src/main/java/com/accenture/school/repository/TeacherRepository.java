package com.accenture.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.school.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>  {

}
