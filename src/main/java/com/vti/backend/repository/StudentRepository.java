package com.vti.backend.repository;

import com.vti.database.Student;
import com.vti.utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private ConnectionUtils connectionUtils;

    public StudentRepository() {
        connectionUtils = new ConnectionUtils();
    }

    @Override
    public List<Student> getListStudents() throws SQLException {
        Connection connection = connectionUtils.getConnection();

        // Tạo đối tượng statement để thực hiện querry
        Statement myStatement = connection.createStatement();

        // Querry và hứng kết quả vào ResultSet
        ResultSet resultSet = myStatement.executeQuery("SELECT  * FROM student");

        List<Student> list = new ArrayList<>();

        // Gán các data từ DB vào trong arrayList:
        while (resultSet.next()){
            int tempId = resultSet.getInt("id");
            String tempName = resultSet.getString("name");
            int tempAge = resultSet.getInt("age");
            String tempHometown = resultSet.getString("hometown");

            Student student = new Student(tempId, tempName, tempAge, tempHometown);
            list.add(student);
        }

        connectionUtils.dropConnection();
        return list;
    }

    @Override
    public Boolean checkStudentExistsByName(String name) throws SQLException {
        Connection connection = connectionUtils.getConnection();

        // Tạo đối tượng statement để thực hiện querry
        PreparedStatement myStatement = connection.prepareStatement("SELECT  * FROM student WHERE name = ?");

        myStatement.setString(1, name);

        ResultSet resultSet = myStatement.executeQuery();

        if(resultSet.next()){
            return true;
        } else {
            return false;
        }
    }
}
