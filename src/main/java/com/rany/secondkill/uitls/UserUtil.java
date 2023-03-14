package com.rany.secondkill.uitls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rany.secondkill.pojo.User;
import com.rany.secondkill.vo.RespBean;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserUtil {

    public static void createUser(int count) throws Exception {
        List<User> users = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setId(13000000000L + i);
            user.setLoginCount(1);
            user.setNickname("user" + i);
            user.setRegisterDate(new Date());
            user.setSalt("1a2b3c4d");
            user.setPassword(MD5Util.inputPassToDBPass("123456", "1a2b3c4d"));
            users.add(user);
        }
        System.out.println("user 创建成功");

        String username = "root";
        String password = "123456";
        String driver = "com.mysql.cj.jdbc.Driver";
        String DBurl = "jdbc:mysql://localhost:3306/goodskill?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(DBurl, username, password);
        System.out.println("db 连接成功");

        String sql = "insert into t_user(login_count, nickname, register_date, salt, password, id) values(?,?,?,?,?,?) ";
        PreparedStatement prepareStatement = conn.prepareStatement(sql);
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            prepareStatement.setInt(1, user.getLoginCount());
            prepareStatement.setString(2, user.getNickname());
            prepareStatement.setTimestamp(3, new Timestamp(user.getRegisterDate().getTime()));
            prepareStatement.setString(4, user.getSalt());
            prepareStatement.setString(5, user.getPassword());
            prepareStatement.setLong(6, user.getId());
            prepareStatement.addBatch();
        }
        prepareStatement.executeBatch();
        prepareStatement.clearParameters();
        conn.close();
        System.out.println("db 插入成功");

        String urlString = "http://localhost:8080/login/doLogin";
        File file = new File("C:\\Users\\a3781\\Desktop\\userTicketWindows.txt");
        if (file.exists()) {
            file.delete();
        }
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        file.createNewFile();
        raf.seek(0);
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            URL url = new URL(urlString);
            HttpURLConnection co = (HttpURLConnection) url.openConnection();
            co.setRequestMethod(("POST"));
            co.setDoOutput(true);
            OutputStream out = co.getOutputStream();
            String params = "mobile=" + user.getId() + "&password=" + MD5Util.inputPassToFromPass("123456");
            out.write(params.getBytes());
            out.flush();
            InputStream inputStream = co.getInputStream();
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buff)) >= 0) {
                bout.write(buff, 0, len);
            }
            inputStream.close();
            ;
            bout.close();
            String response = new String(bout.toByteArray());
            ObjectMapper mapper = new ObjectMapper();
            RespBean respBean = mapper.readValue(response, RespBean.class);
            String userTicket = (String) respBean.getObj();
            System.out.println("create userTicket : " + userTicket);
            ;
            String row = user.getId() + "," + userTicket;
            raf.seek(raf.length());
            raf.write(row.getBytes());
            raf.write("\r\n".getBytes());
            System.out.println("write to file" + user.getId());
        }
        raf.close();
    }

    public static void main(String[] args) throws Exception {
        createUser(5000);
    }

}