package com.cap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeCRUD {
	private static String url = "jdbc:postgresql://localhost:5432/lpu";
	private static String user = "postgres";
	private static String pass = "root";
	private static Scanner sc = new Scanner(System.in);
	private static Connection con;
	static {
		try {
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, user, pass);
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static void saveEmployee() throws SQLException {
		Statement stm = con.createStatement();
		stm.execute("INSERT INTO employee VALUES "+"(101, 'Pranav',550000.00,'pranav@gmail.com',7986943321)");
		stm.execute("INSERT INTO employee VALUES "+"(102, 'Pranav',550000.00,'pranav@gmail.com',7986943321)");
		System.out.println("Record added successfully");
		
	}
	public static void saveEmployee(int id, String name, double sal, String email, long phone) throws SQLException {
		PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?,?)");
		ps.setInt(1,id);
		ps.setString(2, name);
		ps.setDouble(3, sal);
		ps.setString(4, email);
		ps.setLong(5, phone);
		ps.execute();
		System.out.println("Record added successfully");
		
	}
	public static void updateEmployee() throws SQLException {
		Statement stm = con.createStatement();
		stm.execute("UPDATE employee SET sal = 60000 WHERE id = 101");
		System.out.println("record is updated");
	}
	public static void updateEmployeeCustom() throws SQLException {
		PreparedStatement ps = con.prepareStatement("UPDATE employee SET sal = ? WHERE id = ?");
		System.out.println("Enter New Salary to change: -");
		double sal = sc.nextDouble();
		ps.setDouble(1,sal);
		System.out.println("Enter id where to Update: -");
		int id = sc.nextInt();
		ps.setInt(2, id);
		ps.execute();
		System.out.println("record is updated");
	}
	public static void deleteEmployee() throws SQLException {
		Statement stm = con.createStatement();
		stm.execute("DELETE FROM employee WHERE id IN (102,101)");
		System.out.println("record is deleted");
	}
	public static void deleteEmployeeCustom() throws SQLException {
		PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE id = ?");
		System.out.println("Enter id where to delete: -");
		int id = sc.nextInt();
		ps.setInt(1, id);
		ps.execute();
		System.out.println("record is deleted");
	}
	public static void FetchEmployee() throws SQLException {
		Statement stm = con.createStatement();
		stm.execute("SELECT * FROM employee");
		ResultSet rs = stm.getResultSet();
		while(rs.next()) {
			System.out.print("Id = "+rs.getInt("id")+" ");
			System.out.print("Name = "+rs.getString("name")+" ");
			System.out.print("Salary = "+rs.getString("sal")+" ");
			System.out.print("Email = "+rs.getString("email")+" ");
			System.out.println("Phone = "+rs.getString("phone"));
		}
	}
	public static void FindByID() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE id = ?");
		System.out.println("Enter id to Find: -");
		int id = sc.nextInt();
		ps.setInt(1, id);
		ps.execute();
		ResultSet rs = ps.getResultSet();
		while(rs.next()) {
			System.out.print("Id = "+rs.getInt("id")+" ");
			System.out.print("Name = "+rs.getString("name")+" ");
			System.out.print("Salary = "+rs.getString("sal")+" ");
			System.out.print("Email = "+rs.getString("email")+" ");
			System.out.println("Phone = "+rs.getString("phone"));
		}
	}
	public static void main(String[]args){
		try {
			//saveEmployee();
			//updateEmployee();
			//FetchEmployee();
			//deleteEmployee();
			inputTableValues();
			FetchEmployee();
			//updateEmployeeCustom();
			//FetchEmployee();
			//deleteEmployeeCustom();
			//FetchEmployee();
			//FindByID();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	private static void inputTableValues() throws SQLException {
		System.out.println("Enter the Values to Enter into table : - ");
		System.out.println("Enter id - ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name - ");
		String name = sc.nextLine();
		System.out.println("Enter salary - ");
		double sal = sc.nextDouble();
		System.out.println("Enter email - ");
		String email = sc.next();
		System.out.println("Enter phone - ");
		long phone = sc.nextLong();
		saveEmployee(id,name,sal,email,phone);
	}
}
