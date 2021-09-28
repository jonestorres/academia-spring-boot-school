package com.accenture.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.school.model.Classes;

@Repository
public interface ClassesRepostitory extends JpaRepository<Classes, Long>  {

}
