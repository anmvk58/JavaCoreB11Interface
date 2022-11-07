package com.vti.backend.service;

import com.vti.backend.repository.IStudentRepository;
import com.vti.backend.repository.StudentRepository;
import com.vti.database.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService implements IStudentService{
    IStudentRepository repository;

    public StudentService() {
        repository = new StudentRepository();
    }

    @Override
    public List<Student> getListStudents() throws SQLException {
        return repository.getListStudents();
    }

    @Override
    public Boolean checkStudentExistsByName(String name) throws SQLException {
        return repository.checkStudentExistsByName(name);
    }
}
