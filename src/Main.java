import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;  

public class Main {

	public static void main(String[] args) {
		int nilai1 = 3;
		int nilai2 = 5;
		int nilai3 = 2;
		
		int tambah = nilai1 + nilai2 + nilai3;
		int result = tambah / 3;
		
		System.out.println("Hasil rata-rata adalah: " + result);
		
	}

}
