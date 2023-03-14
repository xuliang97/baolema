package com.cook.baolema.utils;

import java.util.Random;

public class RandomNumberGenerator {

    /**
     *
     * @param n 生成随机数的位数，最好是4-6位;
     * @return
     */
        public static int getRandomNumber(int n) {
            // 生成n位随机数
            Random rand = new Random();
            int randomNum = rand.nextInt((int) Math.pow(10, n)) + (int) Math.pow(10, n-1);
            return randomNum;
        }

    public static void main(String[] args) {
        System.out.println(getRandomNumber(5));
    }
}
