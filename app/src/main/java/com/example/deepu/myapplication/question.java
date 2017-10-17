package com.example.deepu.myapplication;

import java.util.Random;

/**
 * Created by deepu on 09-10-2017.
 */

public class question {


    Random rand = new Random();
    int sum=0;
    public int[] getQuestion(int n) {
        int[] a = new int[n];
        sum=0;
        for (int i = 0; i < n; i++) {

            if (i == n - 1) {
                if (sum < 0) {
                    a[i] = (sum - rand.nextInt(2)) > -9 ? -(sum - rand.nextInt(3)) : -sum;

                } else if (sum > 2) {
                    a[i] = -(sum - rand.nextInt(2));
                } else {
                    a[i] = 0;
                }

            } else if (i == n - 2) {
                a[i] = rand.nextInt(19) + (-9);
                while (((sum + a[i]) < -9) || ((sum + a[i]) > 9)) {

                    a[i] = rand.nextInt(19) + (-9);
                }
            } else {

                if (sum < -9) {
                    a[i] = 9;

                } else if (sum > 9) {

                    a[i] = -9;

                } else {

                    a[i] = rand.nextInt(19) + (-9);


                }
            }
            sum += a[i];
        }
        return a;
    }
    public int correctAnswer()
    {
        return sum;
    }
}
