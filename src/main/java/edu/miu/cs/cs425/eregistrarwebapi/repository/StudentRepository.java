package edu.miu.cs.cs425.eregistrarwebapi.repository;

import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM  Students_db  WHERE  first_Name like %:value% " +
            "or   middle_Name like %:value%  or  last_Name like %:value% " +
            "or   student_Number like %:value%  or  cgpa like %:value% "
            , nativeQuery = true)
    List<Student> searchByFirstName(String value);
}