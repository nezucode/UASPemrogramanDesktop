import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;  

public class Main {

	public static void main(String[] args) {
		int nilai = 80;
		
		if (nilai > 81) {
			System.out.println("Tono diterima di Perguruan Tinggi A");
		} else if (nilai >= 71 && nilai   <= 80) {
			System.out.println("Tono diterima di Perguruan Tinggi B");
		} else if (nilai >= 61 && nilai  <= 70) {
			System.out.println("Tono diterima di Perguruan Tinggi C");
		} else {
			System.out.println("Tono diterima di Perguruan Tinggi D");
		}
	}

}
