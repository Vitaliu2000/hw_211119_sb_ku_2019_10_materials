package ru.itvitality.sbrf.cu.library.dao.utils;

import ru.itvitality.sbrf.cu.library.entities.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EntityConnectionDbH2 {

    public static String pathByDB = "jdbc:h2:~/IdeaProjects/sbercurs/hw_211119_sb_ku_2019_10_materials/library/src/main/resources/testDB";

    public static Connection conn;
    static {
        try {
            conn = DriverManager.getConnection(pathByDB, "userName", "Passw0rd");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String createTableBook = "create table book (id bigint not null, author varchar(255), deleted integer, isbn varchar(255) not null, name varchar(255), primary key (id))";
    private static String updateTableBook = "" +
            "INSERT INTO BOOK (id,author,deleted,isbn,name)\n" +
            "VALUES (1, 'Автор книги', '0', 'isbn_rq_123', 'читатель');";

    public static String selectAll = "select * from book";

    /**
     * Создание всегда файла БД.
     */
    public static void connectionDbH2(){
        try {
            Class.forName("org.h2.Driver");
            Statement st = conn.createStatement();
            st.execute(createTableBook);//todo --> Создается всегда. Не стал много времени тратить на написание условий создания базы даных, так как Spring все разруливает сам.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void sqlUpdater(String script_update){
        try {
            Class.forName("org.h2.Driver");
            Statement st = conn.createStatement();

            st.executeUpdate(script_update);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void sqlRemove(String script_update){
        try {
            Class.forName("org.h2.Driver");
            Statement st = conn.createStatement();
            st.executeUpdate(script_update);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> sqlGetList(String script){
        List<Book> list = new ArrayList<>();
        try {
            Class.forName("org.h2.Driver");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(script);
            while(rs.next()) {
                list.add(new Book(rs.getLong("id"), rs.getString("isbn"),
                        rs.getString("name"), rs.getString("author"), rs.getInt("deleted")));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}