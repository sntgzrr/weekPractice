package com.sntzrr;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    /*------------------------------- DAY 1 -------------------------------*/
    //Plus-Minus.
    private void ratios(List<Integer> list){
        list = new ArrayList<>(list);
        int positive = 0, zero = 0, negative = 0;
        int div = list.size();

        for (Integer element : list){
            if(element > 0){
                positive++;
            } else if (element < 0) {
                negative++;
            } else {
                zero++;
            }
        }
        double positiveRatio = (double) positive / div;
        double negativeRatio = (double) negative / div;
        double zeroRatio = (double) zero / div;
        System.out.println(positiveRatio);
        System.out.println(negativeRatio);
        System.out.println(zeroRatio);
    }

    //Min-Max Sum.
    private void sums(List<Integer> list){
        Collections.sort(list);
        long maxSum = 0, minSum = 0;
        for (int i = 1; i < list.size(); i++){
            maxSum = maxSum + list.get(i);
            minSum = minSum + list.get(list.size() - i - 1);
        }
        System.out.println(minSum +" "+maxSum);
    }

    //Time Conversion.
    private String reformDate(String s){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ssa", Locale.ENGLISH);
        LocalTime time = LocalTime.parse(s, dtf);
        return time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    //Optional test.
    private void fizzBuzz (Integer n){
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            list.add(i);
        }

        for (Integer element : list){
            if(element % 5 == 0 && element % 3 == 0){
                System.out.println("FizzBuzz");
            } else if (element % 3 == 0) {
                System.out.println("Fizz");
            } else if (element % 5 == 0) {
                System.out.println("Buzz");
            }else {
                System.out.println(element);
            }
        }
    }

    //Mock Test.
    private void median(List<Integer> arr){
        Collections.sort(arr);
        int median = 0;
        for (int i = 0; i < arr.size()/2+1; i++){
            median = arr.get(i);
        }
        System.out.println(median);
    }

    /*------------------------------- DAY 2 -------------------------------*/

    //Lonely Integer.
    private int uniqueElement (List<Integer> a){
        int unique = 0;
        for (Integer element : a){
            unique ^= element;
        }
        return unique;
    }

    //Diagonal Difference.
    private static int diagonalDifference (List<List<Integer>> arr){
        int n = arr.size();
        int d1 = 0, d2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    d1 += arr.get(i).get(j);
                if (i == n - j - 1)
                    d2 += arr.get(i).get(j);
            }
        }
        return Math.abs(d1 - d2);
    }

    //Counting Sort 1 (List already sorted).
    public static List<Integer> countingSort(List<Integer> arr) {
        int max = Collections.max(arr) + 1;
        int[] array = new int[max];
        for (Integer element : arr) {
            array[element]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            while (array[i] > 0) {
                list.add(i);
                array[i]--;
            }
        }
        return list;
    }

    //Counting sort 1.
    public static List<Integer> countingSort2(List<Integer> arr) {
        int[] array = new int[100];
        for (Integer element : arr) {
            array[element]++;
        }
        return Arrays.asList(Arrays.stream(array).boxed().toArray(Integer[]::new));
    }

    //Mock Test.
    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.max(matrix.get(i).get(j),
                        Math.max(matrix.get(2 * n - 1 - i).get(j),
                                Math.max(matrix.get(i).get(2 * n - 1 - j),
                                        matrix.get(2 * n - 1 - i).get(2 * n - 1 - j))));
            }
        }
        return sum;
    }

    /*------------------------------- DAY 3 -------------------------------*/


    /*------------------------------- Basics certification -------------------------------*/
    public static boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else if ((stack.isEmpty())) {
                return false;
            }else{
                char top = stack.pop();
                if ((bracket == ')' && top != '(') || (bracket == ']' && top != '[') || (bracket == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    abstract class Shape {
        int length;
        int breadth;
        abstract void area();
    }

    class Shapes extends Shape{
        Shapes(int length, int breadth){
            this.length = length;
            this.breadth = breadth;
        }
        public void area(){
            System.out.println(this.length+" "+this.breadth);
        }
    }

    class Rectangule extends Shape{
        Rectangule(int length, int breadth){
            this.length = length;
            this.breadth = breadth;
        }
        public void area(){
            System.out.println(this.length*this.breadth);
        }

    }


    public static String decryptMessage(String encryptedMessage) {
        String[] array = encryptedMessage.split(" ");
        StringBuilder reverse = new StringBuilder();

        for (int i = 0; i < array.length; i++){
            reverse.append(array[array.length -i -1]);
            if (i != array.length - 1) {
                reverse.append(" ");
            }
        }

        return reverse.toString();
    }

    public static void main(String[] args) {

    }
}