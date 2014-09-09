package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dataBase
{
    private Connection con = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;
    private ArrayList<Customer> customer = new ArrayList<Customer>();
    
    
    public dataBase()
    {
	
    }
    protected void addPerson(String name, String familyName, int phoneNo, String email) throws SQLException
    {
	      try
	      {
	  	con = DriverManager.getConnection("jdbc:mysql://localhost/my_first_database?user=root&password=Idontknow22");
	  	preparedStatement = con.prepareStatement("INSERT INTO customers VALUES(default, ?, ?, ?, ?)");
	  	preparedStatement.setString(1, name);
	  	preparedStatement.setString(2, familyName);
	  	preparedStatement.setInt(3, phoneNo);
	  	preparedStatement.setString(4, email);
	  	preparedStatement.executeUpdate();
	  	

	  	
	      } catch (SQLException e)
	        
	      {
	  	System.out.println(e);
	      }
    	      finally
    	      {
    	  	if(con !=null)
    	  	{
    	  	    con.close();
    	  	}
    	  	
    	  	
    	      }
	      }
    
    protected ResultSet searchPerson(String name) throws SQLException
    {
	con = DriverManager.getConnection("jdbc:mysql://localhost/my_first_database?user=root&password=Idontknow22");
	
	preparedStatement = con.prepareStatement("SELECT * FROM customers where name =\""+name+"\"");
	result = preparedStatement.executeQuery();
	
	return result;
    }
    protected ArrayList<Customer> displayEveryone() throws SQLException
    {
	     try
	     {
	 	con = DriverManager.getConnection("jdbc:mysql://localhost/my_first_database?user=root&password=Idontknow22");
	 	preparedStatement = con.prepareStatement("SELECT * FROM customers");
	 	result = preparedStatement.executeQuery();
	 		 	
	 	while(result.next())
	 	{
	 	    //int id = result.getInt("id");
	 	    String name = result.getString("name");
	 	    String lastName = result.getString("last_name");
	 	    int phone = result.getInt("phone");
	 	    String email = result.getString("email");
	 	    
	 	    
	 	    Customer newCust = new Customer(name, lastName, phone, email);
	 	    
	 	    customer.add(newCust);
	 	    
	 	   
	 	}
	 	
	 	System.out.println("Connected man, well done!");
	 	
	     } catch (SQLException e)
	     {
	 	System.out.println(e);
	     }
	     finally
	     {
	 	if(con !=null)
	 	{
	 	    con.close();
	 	}
	 	
	     }
	     return customer;
	     }
    }

