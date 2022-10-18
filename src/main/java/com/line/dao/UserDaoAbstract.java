package com.line.dao;

import com.line.domain.User;

import java.sql.*;
import java.util.Map;

public abstract class UserDaoAbstract {

    public abstract Connection makeConnection() throws SQLException;

    public void add() {
        Map<String, String> env = System.getenv();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //

            //DB 접속
            Connection c = makeConnection();
//            Connection conn = DriverManager.getConnection(
//                    "jdbc:mysql://ec2-13-125-203-31.ap-northeast-2.compute.amazonaws.com:3306/likelion_db",
//                    env.get("DB_USER"), env.get("DB_PASSWORD")
//            );

            //쿼리문 작성
            PreparedStatement pstmt = c.prepareStatement(
                    "INSERT INTO users(id, name, password) VALUES (?, ?, ?);"
            );
            pstmt.setString(1, "1");
            pstmt.setString(2, "Hyeonju");
            pstmt.setString(3, "1123");

            //쿼리문 실행
            pstmt.executeUpdate();

            pstmt.close();
            c.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // SELECT 구현
    public User findById(String id) {
        Map<String, String> env = System.getenv();
        Connection conn;

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            conn = makeConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT id, name, password FROM users WHERE id = ?"
            );
            ps.setString(1, id); //인자로 받은 id

            ResultSet rs = ps.executeQuery();
            rs.next();

            User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));

            rs.close();
            ps.close();
            conn.close();

            return user;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        UserDaoAbstract userDao = new UserDaoAbstract();
//        User user = userDao.findById("1");
//        System.out.println(user.getName());
    }
}