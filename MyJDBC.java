import java.sql.*;
public class MyJDBC {
    public static void main(String[] args){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "2234");
            Statement statement = connection.createStatement();

            String sql = "CREATE DATABASE MOVIEDB";
            statement.executeUpdate(sql);
            System.out.println("Database created successfully...");
        }catch(Exception e){
            e.printStackTrace();
        }


        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root", "2234");

        Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE TABLE MOVIE" +
                    " (movie_name VARCHAR(255), " +
                    " lead_ACTOR VARCHAR(255), " +
                    " lead_ACTRESS VARCHAR(255), " +
                    "year_of_release year,"+
                    "director_name VARCHAR(255),"+
                    " PRIMARY KEY ( movie_name))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given movie database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root", "2234");
            Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO MOVIE VALUES('Spider Man','Tom Holland','Zendaya','2021','Jon Watta')";
            //stmt.executeUpdate(sql);
            sql = "INSERT INTO MOVIE VALUES('Piku','Amitab Bacchan','Deepika','2017','KPR')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO MOVIE VALUES('RRR','NTR','Alia','2022','Rajamouli')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO MOVIE VALUES('KGF','Yash','Palak','2022','Prashant')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root", "2234");
            Statement stmt = conn.createStatement();

        ) {
            String QUERY = "SELECT movie_name,lead_ACTOR,lead_ACTRESS,year_of_release,director_name from movie";
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next()){
                //Display values
                System.out.print("MOVIE_NAME: " + rs.getString("movie_name"));
                System.out.print(",  lead_ACTOR " + rs.getString("lead_ACTOR"));
                System.out.print(", lead_ACTRESS " + rs.getString("lead_ACTRESS"));
                System.out.println(", year_of_release " + rs.getInt("year_of_release"));
                System.out.println(", DIRECTOR_NAME " + rs.getString("director_name"));

            }
            String QUERY2 = "SELECT movie_name,year_of_release from movie where year_of_release=2022";
            ResultSet rs2 = stmt.executeQuery(QUERY2);
            while(rs2.next()){
                //Display values
                System.out.print("MOVIE_NAME: " + rs2.getString("movie_name"));
                System.out.println(", year_of_release " + rs2.getInt("year_of_release"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }

