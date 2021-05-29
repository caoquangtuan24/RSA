/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhcnhn.rsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@Getter
@Setter
public class RandomKey {
   public static  boolean isPrimeNumber(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
   public static List<Integer> soNguyenTo(){
       int n = 100;
       int dem = 0; // dem tong so nguyen to
       int i = 2;   // tim so nguyen to bat dau tu so 2
    List<Integer> a = new ArrayList<>();
    while (dem < n) {
        if (isPrimeNumber(i)) {
            a.add(i); 
            dem++;
        }
        i++;
    }
       //System.out.println("a" + a);
    return a;
   }
   //Tim gcd
	public static int GCD(int a, int b) {
		if(a == 0) return b;
		if(b == 0) return a;
		if(a == b) return a;
		if(a > 0) {
			int temp = a%b;
			a = b;
			b = temp;
			return GCD(a,b);
		}
		int temp = b%a;
		a = b;
		b = temp;
		return GCD(a,b);
	}
        
    public static int randomPQ(){
        Random rd = new Random();
        int a = rd.nextInt(soNguyenTo().size());
        int p = soNguyenTo().get(a);
        System.out.println(" + " + p);
        return p;
    }
    public static int P ;
    public static int Q ;
    public static int phiN = (P-1)*(Q-1);

    public static int randomE(){
         phiN = (P-1)*(Q-1);
      do{
          int i = (int) ((Math.random())*((phiN - 1 + 1) + 1));
          if(GCD(i, phiN) == 1){
               System.out.println("i=" + i);
          return i;
          }
      }while(true);
    }
    
    public static int e ;
    
        public static int tinhD(){
        int[] s = new int[50];
		int[] t = new int[50];
		int[] q = new int[50];
		s[0] = 1;
		t[0] = 0;
		s[1] = 0;
		t[1] = 1;
		q[0] = 0;
		int i = 0;//buoc
                phiN = (P-1)*(Q-1);
		int r0 = phiN;
                int r1 = e;
		int r;
		System.out.println("r0 = " + r0); 
		System.out.println("r1 = " + r1);
		int Tr0 = r0;
		int Tr1 = r1;
		if(GCD(r0, r1) == 1) {
			do {
				if(i >= 2) {
					s[i] = s[i-2] - q[i-1]*s[i-1];
					t[i] = t[i-2] - q[i-1]*t[i-1];
				}
				q[i+1] = r0 / r1;
				r = r0 % r1;
				r0 = r1;
				r1 = r;
				++i;
			}while(r != 0);	
			i = 0;
			r0 = Tr0;
			r1 = Tr1;
			do {
				q[i+1] = r0 / r1;
				r = r0 % r1;
				if(i >= 2) {
					s[i] = s[i-2] - q[i-1]*s[i-1];
					t[i] = t[i-2] - q[i-1]*t[i-1];
				}
				r0 = r1;
				r1 = r;
				++i;
			}while(r != 0);
			
			s[i] = s[i-2] - q[i-1]*s[i-1];
			t[i] = t[i-2] - q[i-1]*t[i-1];
			System.out.println("t = " + t[i] );
        }
                return t[i];
        }
        
	 public static int tinhSoMuMod(int x, int k, int n) {
        String chuyenDoiNhiPhan = Integer.toBinaryString(k);
        int p = 1;
        int size = chuyenDoiNhiPhan.length();
        for (int i = 0; i < size; i++) {
            if (String.valueOf(chuyenDoiNhiPhan.charAt(i)).equals("1")) {
                p = p * p;
                p = p % n;
                p = p * x;
                p = p % n;
            } else {
                p = p * p;
                p = p % n;
            }
        }
        return p;
    }
}
