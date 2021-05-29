/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhcnhn.rsa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.crypto.Cipher;

/**
 *
 * @author Admin
 */
public class MD5 {
     public static void main(String args[]) 
    {
       String resultKy =  "456-789-123456-987465";
        String output[] = resultKy.split("-");
        List<Integer> outputInt = new ArrayList<Integer>();
        for(int i = 0; i < output.length ; i++){
            int a = Integer.valueOf(output[i]);
            outputInt.add(a);
        }
          String kqq = "";
        for(int i = 0 ; i < outputInt.size();i++){
            int kq = RandomKey.tinhSoMuMod(outputInt.get(i), 1000, 15769);
             kqq += String.valueOf(kq);
             
        }
        System.out.println("kqq" + kqq);
        System.out.println("out + " + outputInt);
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
