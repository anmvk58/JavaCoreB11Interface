package com.vti.backend.service;

import com.vti.database.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentService {
    // Get Danh sách student;
    //phương thức get all students:
    List<Student> getListStudents() throws SQLException;

    Boolean checkStudentExistsByName(String name) throws SQLException;
}
