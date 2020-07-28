/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplevoting;

/**
 *
 * @author User
 */
// para makakonek i- import ang java.sql.*;
  import java.sql.*;


import javax.swing.JOptionPane;



// eto ang ating connection
public class VotingsystemDB {
   // yung connection nilagyan ng variable na conn
  
    Connection conn = null;
   //kokonek k sa database na nasa xampp
    public static Connection VotingsystemDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            // yun conn dyan variable lang yan ng connection
            Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost/sg_voting","root","");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Database is not connected");
            return null;
        }
    }
}
