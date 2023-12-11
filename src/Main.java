import java.sql.*;
import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;  

public class Main {
	//Connect to Database
	static final String DB_URL = "jdbc:mysql://localhost:3306/mahasiswa";
	static final String USER = "root";
	static final String PASS = "";
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	static BufferedReader input = new BufferedReader(inputStreamReader);
	
	public static void main(String[] args) {
		try {
			//Create a connection to database
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//Create a statement object
			stmt = conn.createStatement();
			
			while (!conn.isClosed()) {
				showMenu();
			}
			stmt.close();
			stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void showMenu() {
		System.out.println("=========== MENU UTAMA ===========");
		System.out.println("==================================");
		System.out.println("1. Input Data");
		System.out.println("2. Tampil Data");
		System.out.println("3. Update Data");
		System.out.println("0. Keluar");
		System.out.print("PILIHAN > ");
		
		try {
			Scanner sc = new Scanner(System.in);
			int pilihan = sc.nextInt();
			switch(pilihan) {
			case 0:
				System.exit(0);
				break;
			case 1:
				insertMahasiswa();
				break;
			case 2:
				showMahasiswa();
				break;
			case 3:
				updateMahasiswa();
				break;
				default:
					System.out.println("Pilihan salah.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void insertMahasiswa() {
		try {
			System.out.print("Nama: ");
			String nama = input.readLine().trim();
			System.out.print("Alamat: ");
			String alamat = input.readLine().trim();
			
			//Save query
			String sql = "INSERT INTO mahasiswa (nama, alamat) VALUE ('%s','%s')";
			sql = String.format(sql, nama, alamat);
			
			//Save mahasiswa
			stmt.execute(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void showMahasiswa() {
		//Create a query to database
		String sql = "SELECT * FROM mahasiswa";
		
		try {
			//Execute the query and save the result on object ResultSet
			rs = stmt.executeQuery(sql);
			
			//Show the result
			System.out.println("=================================");
			System.out.println("=======Daftar Nama Mahasiswa=====");
			System.out.println("=================================");
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("Nama: " + rs.getString("nama"));
				System.out.println("Alamat: " + rs.getString("alamat"));
				System.out.println("=================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void updateMahasiswa() {
		try {
			System.out.print("ID yang akan diedit: ");
			int id = Integer.parseInt(input.readLine());
			System.out.print("Nama: ");
			String nama = input.readLine().trim();
			System.out.print("Alamat: ");
			String alamat = input.readLine().trim();
			
			//Query update
			String sql = "UPDATE mahasiswa SET nama='%s', alamat='%s' WHERE id=%d";
			sql = String.format(sql, nama, alamat, id);
			
			//Update mahasiswa
			stmt.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
