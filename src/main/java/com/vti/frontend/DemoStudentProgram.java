package com.vti.frontend;

import com.vti.backend.controller.StudentController;
import com.vti.database.Student;

import java.sql.SQLException;
import java.util.Scanner;

public class DemoStudentProgram {
    public static void main(String[] args) throws SQLException {
        StudentController controller = new StudentController();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Mời nhập lựa chọn: ");
        System.out.println("1 - view list students");
        System.out.println("2 - update a student");
        int x = scanner.nextInt();

        if(x == 1){
            for(Student s : controller.getListStudent()){
                System.out.println(s);
            }
        } else if( x == 2){
            System.out.println("Mời nhập tên học sinh cần update thông tin: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            controller.updateInfoStudent(name);
        } else {
            System.out.println("Wrong choose !!!");
        }
    }
}
