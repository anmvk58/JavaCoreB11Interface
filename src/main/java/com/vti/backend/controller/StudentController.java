package com.vti.backend.controller;

import com.vti.backend.service.IStudentService;
import com.vti.backend.service.StudentService;
import com.vti.database.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentController {
    IStudentService service;

    public StudentController() {
       service = new StudentService();
    }

    public List<Student> getListStudent() throws SQLException {
        return service.getListStudents();
    }

    public void updateInfoStudent(String name) throws SQLException {
        // gọi phương thức update thông tin học sinh mà Service cung cấp

        // validate request của người dùng
        if(service.checkStudentExistsByName(name)){
            System.out.println("Oke tôi sẽ update thông tin cho bạn");
            // handling service logic
        }
        else {
            System.out.println("Xin lỗi, không tồn tại học sinh với tên " + name +" !!!");
        }

    }
}
