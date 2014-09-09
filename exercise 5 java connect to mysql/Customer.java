package test;

public class Customer
{
     protected String fname;
    protected String lname;
    protected int phoneNo;
    protected String email;
    
    public Customer(String fname, String lname, int phoneNo, String email)
    {
	this.fname = fname;
	this.lname = lname;
	this.phoneNo = phoneNo;
	this.email = email;
    }
    protected String getFname()
    {
        return fname;
    }

    protected void setFname(String fname)
    {
        this.fname = fname;
    }

    protected String getLname()
    {
        return lname;
    }

    protected void setLname(String lname)
    {
        this.lname = lname;
    }

    protected int getPhoneNo()
    {
        return phoneNo;
    }

    protected void setPhoneNo(int phoneNo)
    {
        this.phoneNo = phoneNo;
    }

    protected String getEmail()
    {
        return email;
    }

    protected void setEmail(String email)
    {
        this.email = email;
    }
}
