package com.vti.backend.repository;

import com.vti.database.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentRepository {
    //phương thức get all students:
    List<Student> getListStudents() throws SQLException;

    //phương thức kiểm tra 1 học sinh đã tồn tại hay chưa (truyền tên học sinh)
    Boolean checkStudentExistsByName(String name) throws SQLException;
}
