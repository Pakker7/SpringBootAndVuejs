package com.test.psk.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.psk.board.board.BoardDAO;
import com.test.psk.board.board.BoardVO;
import com.test.psk.board.board.ParamBoardVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    private static final String URL = "jdbc:mariadb://192.168.195.128:3306/board";
    private static final String USER ="test";
    private static final String PW = "test";

    @Test
    public void testConnection() throws Exception{
        Class.forName(DRIVER);
        try (Connection con = DriverManager.getConnection(URL, USER, PW))	{
            System.out.println(con);
        }catch(Exception e){
            System.err.println(e);

        }
    }

    @Test
    public  void dkdk(){
        System.out.println("dkdkdkdkd");
    }


}
