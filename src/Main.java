import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;  

abstract class Matematika {
	abstract int luas();
}

class Segitiga extends Matematika {
	int alas;
	int tinggi;
	
	public Segitiga(int alas, int tinggi) {
		this.alas = alas;
		this.tinggi = tinggi;
	}
	
	@Override
	int luas() {
		return alas * tinggi / 2; 
	}
}

class PersegiPanjang extends Matematika {
	int panjang;
	int lebar;
	
	public PersegiPanjang(int panjang, int lebar) {
		this.panjang = panjang;
		this.lebar = lebar;
	}
	
	@Override
	int luas() {
		return panjang * lebar;
	}
}

public class Main {
	public static void main(String[] args) {
		Segitiga segitiga = new Segitiga(8, 10);
		PersegiPanjang ppanjang = new PersegiPanjang(2, 4);
		
		int alas = segitiga.alas;
		int tinggi = segitiga.tinggi;
		int luasSegitiga = segitiga.luas();
		
		int panjang = ppanjang.panjang;
		int lebar = ppanjang.lebar;
		int luasPPanjang = ppanjang.luas();
		
		System.out.println("===Segitiga===");
		System.out.println("Alas: " + alas);
		System.out.println("Tinggi: " + tinggi);
		System.out.println("Luas dari segitiga berikut adalah: " + luasSegitiga);
		System.out.println("==============");
		System.out.println("===Persegi Panjang===");
		System.out.println("Panjang: " + panjang);
		System.out.println("Lebar: " + lebar);
		System.out.println("Luas dari persegi panjang berikut adalah: " + luasPPanjang);
		System.out.println("=====================");
		
	}
}
