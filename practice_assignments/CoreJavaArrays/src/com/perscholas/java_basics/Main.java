package com.perscholas.java_basics;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        //1
        int[] numbers = {1, 2, 3};

        for (int number : numbers) {
            System.out.println(number);
        }

        //2
        int[] intArr = {13, 5, 7, 68, 2};
        int middle = intArr.length / 2;
        System.out.println(intArr[middle]);

        //3
        String[] words = {"red", "green", "blue", "yellow"};
        System.out.println(words.length);
        String[] wordsClone = words.clone();
        System.out.println(Arrays.toString(wordsClone));

        //4
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("First: " + nums[0] + ", Last: " + nums[nums.length - 1]);
        //System.out.println(nums[nums.length()]);
        //nums[5] = 7;

        //5
        int[] values = new int[5];

        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        System.out.println(Arrays.toString(values));

        //6
        int[] vals = new int[5];

        for (int i = 0; i < vals.length; i++) {
            vals[i] = i * 2;
        }
        System.out.println(Arrays.toString(vals));

        //7
        int[] numArr = new int[5];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = i;
        }
        for (int i = 0; i < numArr.length; i++) {
            if (i != (numArr.length / 2)) {
                System.out.println(numArr[i]);
            }
        }

        //8
        String[] stringArr = {"red", "green", "blue", "yellow", "purple"};
        int mid = stringArr.length / 2;
        String temp = stringArr[mid];
        stringArr[mid] = stringArr[0];
        stringArr[0] = temp;
        System.out.println(Arrays.toString(stringArr));

        //9
        int[] moreNums = {4, 2, 9, 13, 1, 0};
        Arrays.sort(moreNums);
        System.out.print("Array in ascending order: ");
        for (int i = 0; i < moreNums.length; i++) {
            if (i != (moreNums.length - 1)) {
                System.out.print(i + ", ");
            } else {
                System.out.print(i);
            }
        }
        System.out.println("\nThe smallest number is " + moreNums[0]);
        System.out.println("The biggest number is " + moreNums[moreNums.length - 1]);

        //10
        ArrayList mixedArr = new ArrayList();
        mixedArr.add(7);
        mixedArr.add("one");
        mixedArr.add("two");
        mixedArr.add("three");
        mixedArr.add(9.4);

        System.out.println(mixedArr);
    }
}
