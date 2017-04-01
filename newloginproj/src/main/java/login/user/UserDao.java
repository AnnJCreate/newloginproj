package login.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import login.user.User;

@Repository
public class UserDao {
	
 @SuppressWarnings("finally")
 public Boolean findUserByUserBean(User userbean) 
	{
	 Connection conn = null;
	 PreparedStatement ps = null;
	 ResultSet rs = null;

//	 System.out.println("findUserByUserBean");
	 
		String driver ="com.mysql.jdbc.Driver";
		String url= "jdbc:mysql://localhost:3306/git";
        String user = "root"; 
        String pasw = "root";
        boolean b = true;
        
        try{
      
		Class.forName(driver);
		 
        conn = DriverManager.getConnection(url, user, pasw);
        String sql = "";
        if(userbean.getPassword().equals("") || userbean.getPassword() == null){
        	sql="select username,password from usertable where username = ? and password is null ;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userbean.getUserName());

        }
        else{
        	
        	sql="select username,password from usertable where username = ? and password = ? ;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userbean.getUserName());
            ps.setString(2, userbean.getPassword());

        }
 //        System.out.println("ps"+ps);
        rs = ps.executeQuery();
        if(rs.next()){
//        	System.out.println("1");
//        	System.out.println("rs.getString(1)="+rs.getString(1));
        	
        	b = true;
			return true;
		}
		else{
//			System.out.println("2");
			b = false;
			return false;
		}
        }
        catch (ClassNotFoundException e) {
        	b = false;
//        	System.out.println("3");
			e.printStackTrace();
		}catch(SQLException e){
			b = false;
//			System.out.println("4");
        	e.printStackTrace();
        }finally{
//        	System.out.println("b end is ="+b);
			try {
				rs.close();
				ps.close();
				conn.close();
//				System.out.println("5");
				return b;
			} catch (SQLException e) {
				e.printStackTrace();
//				System.out.println("6");
				b = false;
				return false;
			}
			
		}

	}

}