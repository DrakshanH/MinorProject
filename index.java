//# MinorProject JAVA CODE
//Employee databases input and printing the details based on different order

import java.util.*;

class Date
{
	String date,month,year;
	
	Date (String y, String m, String d)
	{
		date = d; month = m; year = y;
	}
	
	String getDate()
	{
		return(year +"-" + month + "-" + date);
				
	}	
}

class Address
{
	String street, city, state, country, zipcode;
	
	Address (String street, String city, String state, String country, String zipcode)
	{
		this.street = street; this.city = city;
		this.state = state; 
		this.country = country; this.zipcode = zipcode;
	}
	
	String getAddress()
	{
		return (street + " , " + city + " , " + state + " , " + zipcode);
				
	}
}

class Employee
{
	String name, jobPosition, contactNumber; 
  int empID; 
  double salary; 
  Date hireDate; 
  Address address;
	
	Employee(String name, String jobPosition, String contactNumber, int empID, double salary, Date hireDate, Address address)
	{
		this.name = name;
		this.jobPosition = jobPosition;
		this.contactNumber = contactNumber;
		this.empID = empID;
		this.salary = salary;
		this.hireDate = hireDate;
		this.address = address;
	}
	
	public String getHireDate() 
	{
        return hireDate.getDate();
    }
	
	public String getEmployee() {
        return (
            "Name : " + name + 
            "\nEmployee Id : " + empID + 
            "\nSalary : " + salary + 
            "\nHire Date : " + hireDate.getDate() + 
            "\nJob Position : " + jobPosition + 
            "\nContact Number : " + contactNumber +
            "\nAddress : " + address.getAddress()
        );
	}
	
}
public class Test 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("enter number of employees");
		int x = in.nextInt();
		Employee e[] = new Employee[x];
		for(int i = 0; i < x; i ++)
		{
			System.out.println("enter employee details:");
			System.out.print("name:");
			String n = in.next();
			
			System.out.print("job position: ");
			String pos = in.next();
			
			System.out.print("contact number: ");
			String no = in.next();
			
			System.out.print("employee id: ");
			int eid = in.nextInt();
			
			System.out.print("salary: ");
			double sal = in.nextDouble();
			
			System.out.print("enter hire date in form dd-mm-yyy: ");
			String d = in.next(); 
			String m = in.next(); 
			String y = in.next();
			Date date = new Date(y,m,d);
			
			System.out.println("enter the address:");
						
			System.out.print("enter street: ");
			String street = in.next();
			
			System.out.print("enter city: ");
			String city = in.next(); 
			
			System.out.print("enter state: ");
			String state = in.next();
			
			System.out.print("enter country: ");
			String country = in.next();
			
			System.out.print("enter zipcode: ");
			String zipcode = in.next();
			
			Address add = new Address(street,city,state,country,zipcode);
			
			e[i] = new Employee(n, pos, no, eid, sal, date, add);
			
		}
		
		System.out.println();
        System.out.println("Sorting the Employee Database According to Salary in Decresing Order : ");
		arrangeEmployeeBySalary(e);
		System.out.println("Sorting is done");
		
		System.out.println();
        System.out.println("For Displaying the Detail of Employee (of the Entered Job Position ) : ");
        System.out.print("Enter Job Position : ");
        String jp = in.next();
        getEmployeesByJobPosition(e, jp);
        
        
        System.out.println();
        System.out.println("For Displaying the Detail of the Employee Between the Following Dates : ");
        System.out.print("Enter starting Hire Date : ");
        String d1 = in.next();
        String m1 = in.next();
        String y1 = in.next();
        Date date1 = new Date(y1, m1, d1);
        System.out.print("Enter Ending Hire Date : ");
        String d2 = in.next();
        String m2 = in.next();
        String y2 = in.next();
        Date date2 = new Date(y2, m2, d2);
        getEmployeesByHireDate(e, date1, date2);
        
        
        System.out.println();
        System.out.println("Displaying the Employee Detail between the range of the following Salary : ");
        System.out.print("Enter the salary value of S1 : ");
        double s1 = in.nextDouble();
        System.out.print("Enter the salary value of s2 : ");
        double s2 = in.nextDouble();
        getEmployeesBySalary(e, s1, s2);
        
        System.out.println();
        System.out.println("Displaying the number of foreign employees " + foreignEmployeeCount(e));
        
		
	}
	
	public static void arrangeEmployeeBySalary(Employee e[])
	{
		for (int i=0 ; i<e.length ; i++) 
		{
            for (int j=0 ; j<e.length ; j++) 
            {
                if (e[j].salary < e[i].salary) 
                {
                    Employee temp = e[i];
                    e[i] = e[j];
                    e[j] = temp;
                }
            }
        }
	}
	
    public static void getEmployeesByJobPosition(Employee e[], String jp)
    {
    	for (int i=0 ; i<e.length ; i++) 
    	{
            if (e[i].jobPosition.equals(jp)) 
            {
                System.out.println("Employee Detail: ");
                System.out.println(e[i].getEmployee());
            }
        }
    }
    
    public static void getEmployeesByHireDate(Employee e[], Date d1, Date d2) 
    {
        for (int i=0 ; i<e.length ; i++) 
        {
        	if( e[i].getHireDate().compareTo(d1.getDate()) >=0 & e[i].getHireDate().compareTo(d2.getDate()) <= 0)
            {
                System.out.println("Employee Detail: ");
                System.out.println(e[i].getEmployee());
            }
        }
    }

    public static int foreignEmployeeCount(Employee e[]) 
    {
        int c = 0;
        for (int i=0 ; i<e.length ; i++) 
        {
            if(!(e[i].contactNumber.startsWith("+91"))) 
                c++;
        }
        return c;
    }
    
    public static void getEmployeesBySalary(Employee e[],double s1,double s2)
    {
    	 for (int i=0 ; i<e.length ; i++) 
    	 {
             if (e[i].salary >= s1 && e[i].salary <= s2) 
             {
                 System.out.println("Employee Detail: ");
                 System.out.println(e[i].getEmployee());
             }
         }
     
    }
    
    
}
