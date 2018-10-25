/**
  c = DriverManager
            .getConnection("jdbc:postgresql://ec2-54-246-86-167.eu-west-1.compute.amazonaws.com:5432/ddp80vm6d0pkmq",
            "lrjiawzjtegxpj", "e2cd7dacea8d0072cc85aaf9c47d17f80542544df0b780b8e9a06d9ac9170c86");
 *  */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class PostgreSQLJDBC {
   public PostgreSQLJDBC() {
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
         .getConnection("jdbc:postgresql://ec2-54-246-86-167.eu-west-1.compute.amazonaws.com:5432/ddp80vm6d0pkmq?ssl=true&sslmode=require",
         "lrjiawzjtegxpj", "e2cd7dacea8d0072cc85aaf9c47d17f80542544df0b780b8e9a06d9ac9170c86");

         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery( "SELECT Company_Name FROM origins.Analytics WHERE pk=1;" );
         while ( rs.next() ) {
            //int id = rs.getInt("id");
            String  name = rs.getString("Company_Name");
            //int age  = rs.getInt("age");
            //String  address = rs.getString("address");
            //float salary = rs.getFloat("salary");
            
            System.out.println( "NAME = " + name );
            
            /*
            System.out.println( "ID = " + id );
            System.out.println( "NAME = " + name );
            System.out.println( "AGE = " + age );
            System.out.println( "ADDRESS = " + address );
            System.out.println( "SALARY = " + salary );*/
            System.out.println();
         }
         rs.close();
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Operation done successfully");
   }
}