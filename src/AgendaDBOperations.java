import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by condor on 26/02/15.
 * FastTrackIT, 2015
 * <p/>
 * DEMO ONLY PURPOSES, IT MIGHT CONTAINS INTENTIONALLY ERRORS OR ESPECIALLY BAD PRACTICES
 *
 * make sure you refactor it and remove lots of bad practices like loading the driver multiple times or
 * repeating the same common code multiple times
 *
 * BTW, exercise 1: how we reorg this/refactor in small pieces
 */
public class AgendaDBOperations {


    public static void demoCreate(AgendaItem ai) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/6Ionel";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO agenda (name, phone) VALUES (?,?)");
        pSt.setString(1, ai.getName());
        pSt.setString(2,ai.getPhone());

        // 5. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    public static List<AgendaItem> demoRead() throws ClassNotFoundException, SQLException {
               // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/6Ionel";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        // 5. execute a query



      //  List<User> lista = new ArrayList();

        String query="select id,name,phone from agenda";
        ResultSet rs = st.executeQuery(query);

        // 6. iterate the result set and print the values
        List<AgendaItem> rowsFromDB = new ArrayList();
        while (rs.next()) {
            System.out.println("intra");
           AgendaItem ai = new AgendaItem();
           ai.setPk(rs.getLong("id"));
           ai.setName(rs.getString("name"));
           ai.setPhone(rs.getString("phone"));
           rowsFromDB.add(ai);
        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();

        return rowsFromDB;
    }

    public static void demoUpdateChangeName(String currentName, String newName) throws ClassNotFoundException, SQLException {

                // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/6Ionel";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("update agenda set name=? where name=?"); //so we have 3 params
        pSt.setString(1, newName);
        pSt.setString(2, currentName);


        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    public static void demoUpdateChangePhone(String name, String newphpone) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/6Ionel";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("update agenda set phone=? where name=?"); //so we have 3 params
        pSt.setString(1, newphpone);
        pSt.setString(2, name);


        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }


    public static void demoUpdateChangePhoneByID(Long id , String newphpone) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/6Ionel";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("update agenda set phone=? where id=?"); //so we have 3 params
        pSt.setString(1, newphpone);
        pSt.setLong(2, id);


        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    public static void demoUpdateChangePhoneById(Long id, String newphpone) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/6Ionel";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("update agenda set phone=? where id=?"); //so we have 3 params
        pSt.setString(1, newphpone);
        pSt.setLong(2, id);


        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    public static void demoDeleteById(Long pk) throws ClassNotFoundException, SQLException {

               // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/6Ionel";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("DELETE FROM agenda WHERE id=?");
        pSt.setLong(1,pk);

        // 5. execute a prepared statement
        int rowsDeleted = pSt.executeUpdate();
        System.out.println(rowsDeleted + " rows were deleted.");
        // 6. close the objects
        pSt.close();
        conn.close();
    }

    public static void demoDeleteByName(String name) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/6Ionel";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("DELETE FROM agenda WHERE name=?");
        pSt.setString(1, name);

        // 5. execute a prepared statement
        int rowsDeleted = pSt.executeUpdate();
        System.out.println(rowsDeleted + " rows were deleted.");
        // 6. close the objects
        pSt.close();
        conn.close();
    }
}

