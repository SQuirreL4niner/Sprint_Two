package JDBC_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {





			
			
			private Connection con;
			private Statement stmt;
			private ResultSet rs;
			
			
			public void insertRecords() throws SQLException{
				
				try {
					
					
					//////////////////////  JDBC CONNECTION with ORACLE						///////////////////////////////////////////////
				
					//load and register JDBC Driver for Oracle DBMS
					Class.forName("oracle.jdbc.OracleDriver");
					
					//Create connection object
					con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Admin","none");
					
					//Create Statement object
					stmt= con.createStatement();

					//enable transcation by setting auto-commit to false
					
					con.setAutoCommit(false);
					

					
				
					
//##########################################################################################################################################################################			
					
					
					
					
					
					////////////////////////  create a simple table with a primary key		//////////////////////////////////////////////////
					
					
				    /*String sql = "CREATE TABLE USERS (id INTEGER not NULL, uname VARCHAR2(4000), " +
				    		  	 "pword VARCHAR2(4000), PRIMARY KEY (id))";
				    stmt.executeUpdate(sql);
				    System.out.println("Created table in given database...");*/
					
					
//##########################################################################################################################################################################						
					
					
					
					///////////////////////    select data from result set	and print				///////////////////////////////////////////////////
					
					
				     /* String sql = "SELECT UNAME, PWORD FROM Users";
				      ResultSet rs = stmt.executeQuery(sql);
				      
				      while(rs.next()){
				         //  Retrieve by column name

				         String uname = rs.getString("UNAME");
				         String pword = rs.getString("PWORD");

				         //  Display values

				         System.out.print(", Username: " + uname);
				         System.out.println("\t Password: " + pword);
				      }
				      rs.close();*/
			
					
					
					
//##########################################################################################################################################################################						
					
				      String sql = "SELECT UNAME, PWORD FROM Users WHERE ID=201";
				      ResultSet rs = stmt.executeQuery(sql);
				      
				      while(rs.next()){
					         //  Retrieve by column name

					         String uname = rs.getString("UNAME");
					         String pword = rs.getString("PWORD");

					         //  Display values

					         System.out.print(", Username: " + uname);
					         System.out.println("\t Password: " + pword);
					      }
					      rs.close();
					
					
					
					con.commit();
					
				} catch (ClassNotFoundException e) {
					con.rollback();
					e.printStackTrace();
					
				} catch (SQLException e) {
					con.rollback();
					e.printStackTrace();
					
				}
				
				finally{
					
					con.close();
				}
				
				
			}
			

			
		public static void main(String[] args) throws SQLException {
			
			Test trans= new Test();
			
			trans.insertRecords();
		}	
			
			
			
			
			
			
		}


