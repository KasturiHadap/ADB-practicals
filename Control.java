import java.sql.*;  
import java.util.Scanner;
public class Control
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int ch;
		while(true)
		{
			System.out.println("\n1.Range Partition\n2.Hash Partition\n3.Exit\nEnter Choice :");
			ch=sc.nextInt();
			switch(ch)
			{
				case 2:
					try
					{  
					    Class.forName("com.mysql.jdbc.Driver");  
					    Connection con=DriverManager.getConnection(  
					    "jdbc:mysql://localhost:3306/Employee","root","@dmin");    
					    Statement stmt=con.createStatement();
					    ResultSet rs1=stmt.executeQuery("select partition_ordinal_position, Table_rows, partition_method from information_schema.partitions where table_name='employee'");
					    System.out.println("position"+"  "+"tableRows"+"  "+"Method");
					    while(rs1.next())  
						    System.out.println(rs1.getInt(1)+"  "+rs1.getString(2)+"  "+rs1.getString(3));
					    ResultSet rs=stmt.executeQuery("explain partitions select * from employee;");
					    System.out.println("executed");
					    System.out.println("ID"+"  "+"Sel_type"+"  "+"Table"+"  "+"Partitions"+"  "+"Types"+"  "+"Possible_keys"+"  "+"Key"+"  "+"Key_len"+"  "+"ref"+"  "+"rows");
					    while(rs.next())  
					    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getString(9)+"  "+rs.getInt(10));	   	
					    con.close();  
					}
		
					catch(Exception e)
					{ 
						System.out.println(e);
					}  
					break;
				case 1:
					try
		    		{  
					    Class.forName("com.mysql.jdbc.Driver");  
					    Connection con=DriverManager.getConnection(  
					    "jdbc:mysql://localhost:3306/Employee","root","@dmin");    
					    Statement stmt=con.createStatement(); 
					    ResultSet rs1=stmt.executeQuery("select partition_ordinal_position, Table_rows, partition_method from information_schema.partitions where table_name='employee'");
					    System.out.println("position"+"  "+"tableRows"+"  "+"Method");
					    while(rs1.next())  
						    System.out.println(rs1.getInt(1)+"  "+rs1.getString(2)+"  "+rs1.getString(3));
					   ResultSet rs=stmt.executeQuery("explain partitions select * from emp1;");
					    System.out.println("executed");
					    System.out.println("ID"+"  "+"Sel_type"+"  "+"Table"+"  "+"Partitions"+"  "+"Types"+"  "+"Possible_keys"+"  "+"Key"+"  "+"Key_len"+"  "+"ref"+"  "+"rows");
					    while(rs.next())  
					    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getString(9)+"  "+rs.getInt(10));
					    con.close();  
		    		}
		    
		    		catch(Exception e)
		    		{ 
		    			System.out.println(e);
		    		}  
					break;
				case 3:
					return;
			}
		}
	}

}

/* Output
 * 

1.Range Partition
2.Hash Partition
3.Exit
Enter Choice :
1
position  tableRows  Method
1  1  HASH
2  5  HASH
3  3  HASH
4  5  HASH
executed
ID  Sel_type  Table  Partitions  Types  Possible_keys  Key  Key_len  ref  rows
1  SIMPLE  emp1  p0,p1,p2,p3,p4  ALL  null  null  null  null  12

1.Range Partition
2.Hash Partition
3.Exit
Enter Choice :
2
position  tableRows  Method
1  1  HASH
2  5  HASH
3  3  HASH
4  5  HASH
executed
ID  Sel_type  Table  Partitions  Types  Possible_keys  Key  Key_len  ref  rows
1  SIMPLE  employee  p0,p1,p2,p3  ALL  null  null  null  null  14

1.Range Partition
2.Hash Partition
3.Exit
Enter Choice :
3

*/
