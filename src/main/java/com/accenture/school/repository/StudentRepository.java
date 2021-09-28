package com.accenture.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accenture.school.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>  {

	@Query("SELECT s FROM Student s "
			+ " LEFT JOIN s.studentClasses sc "
			+ " INNER JOIN sc.classes c  "
			+ "WHERE s.id = ?1 ")
	Student getByIdWithClasses(Long id);
}
