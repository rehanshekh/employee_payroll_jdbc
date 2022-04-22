package com.blz;

import java.sql.*;

public class SampleClass {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "root";
        String password = "virgin@44";
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Connecting to Database:" + jdbcUrl);
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            System.out.println("Connection is Successful!! " + connection);
        }catch (Exception e) {
            e.printStackTrace();
        }
            //       Statement statement =con.createStatement();
            //       ResultSet resultSet =statement.executeQuery("select * from employee");
//         n    while (resultSet.next()){
//                 System.out.println(resultSet.getInt("id"));
//                System.out.println(resultSet.getString("name"));
//                System.out.println(resultSet.getString(("department")));
//            }
//            int updateCount=statement.executeUpdate("insert into employee(name,department) values('Krunali','Operations'),('Amol','PowerBI'),('Rehan','PLSQL')");
//            System.out.println(updateCount);
//
//            String query = "update employee set salary=? where id=?";
//            PreparedStatement prepareStatement = con.prepareStatement(query);
//            prepareStatement.setInt(1, 563000);
//            prepareStatement.setInt(2, 3);
//            int result = prepareStatement.executeUpdate();
//            System.out.println(result+" First");
//            PreparedStatement prepareStatement1 = con.prepareStatement(query);
//            prepareStatement1.setInt(1, 412000);
//            prepareStatement1.setInt(2, 4);
////            prepareStatement1.setInt(1, 3);
////            prepareStatement1.setString(2, "Amol");
//            boolean var = prepareStatement1.execute();
//            if (var) {
//                ResultSet resultSet1 = prepareStatement1.getResultSet();
//                while (resultSet1.next()) {
//                    System.out.println(resultSet1.getInt("id"));
//                    System.out.println(resultSet1.getString("name"));
//                    System.out.println(resultSet1.getString(("department")));
//                }
//            }else{
//                System.out.println(prepareStatement1.getUpdateCount());
//            }
//            System.out.println("****///////");
////            while (resultSet.next()) {
////                System.out.println(resultSet.getInt("id"));
////                System.out.println(resultSet.getString("name"));
////                System.out.println(resultSet.getString(("department")));
////            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
    }
}
