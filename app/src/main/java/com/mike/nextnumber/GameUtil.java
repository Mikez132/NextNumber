package com.mike.nextnumber;

/**
 * Created by Mike on 7/23/2015.
 * conatins satis methods that the main game will use
 */

import java.util.Random;
public class GameUtil {


   /*
   *generates a radnom numb up to n
   @param n - Upper Bound
   @return- Random Number
    */
    public static int genenratenewNumb(int n) {
        Random r = new Random();
        int ranNumb = r.nextInt(n);
        return ranNumb;
    }
    public static boolean isPrime(int n) {

       //placeholder
        return true;



    }






}
