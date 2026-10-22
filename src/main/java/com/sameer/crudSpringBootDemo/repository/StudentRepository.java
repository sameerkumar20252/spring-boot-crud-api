package com.sameer.crudSpringBootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.sameer.crudSpringBootDemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository //tells it is a repositry
public interface StudentRepository extends JpaRepository<Student, Long> {

//    public Student saveStudent(Student studentReq) {
//        //Save to database
//        return null;
//    }
    Optional<Student> findByIdAndDeletedIsFalse(Long id);
    List<Student> findByDeletedIsFalse();
}
