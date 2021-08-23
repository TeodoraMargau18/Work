package com.playtika;

import java.util.Arrays;

/**
 * Am reformulat o problema gasita pe net
 * <p>
 * Se da un sir de numere. Verificati daca se afla in progresie aritmetica sau geometrica.
 * Daca se afla intr-una din cele doua situatii. Creati un nou vector cu "size" elemente care
 * sa contina acelasi sir de numere la care se adauga celelalte numere ce lipsesc pentru
 * a completa sirul pana la "size".
 **/
public class MissingNumberMain {

    public static void main(String[] args) {
        int[] numbers = {2, 6, 10, 14};
        int size = 20;
        printResult(numbers, size);
        System.out.println("------Array 2 Geometric progression ----");
        int[] numbers2 = {2, 6, 18};
        int size2 = 0;
        printResult(numbers2, size2);
        System.out.println("------Array 3 NO progression ----");
        int[] numbers3 = {2, 1, 7, 6, 18};
        int size3 = 10;
        printResult(numbers3, size3);
        System.out.println("------Array 4 NO progression ----");
        int[] numbers4 = null;
        int size4 = 10;
        printResult(numbers4, size4);
    }

    public static void printResult(int[] numbers, int size) {
        if(numbers==null||numbers.length==0){
            System.out.println("The vector is not in progression");
            return;
        }
        boolean isArithRatio;
        int ratioA = computeArithmeticRatio(numbers[1], numbers[0]);
        int ratioG = computeGeometricRatio(numbers[1], numbers[0]);
        isArithRatio = checkArithRatio(numbers, ratioA);
        if (isArithRatio) {
            printNewArithmeticArray(numbers, size, ratioA);
            return;
        }
        if (!hasProgression(numbers, ratioG)) {
            return;
        }
        printNewGeometricArray(numbers, size, ratioG);
    }

    public static boolean hasProgression(int[] numbers, int ratioG) {
        for (int i = 1; i < numbers.length; i++) {
            if (ratioG != computeGeometricRatio(numbers[i], numbers[i - 1])) {
                System.out.println("The vector is not in progression");
                return false;
            }
        }
        return true;
    }

    public static boolean checkArithRatio(int[] numbers, int ratioA) {
        for (int i = 1; i < numbers.length; i++) {
            if (ratioA != computeArithmeticRatio(numbers[i], numbers[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void printNewArithmeticArray(int[] numbers, int size, int ratio) {
        System.out.println("The ratio for the arithmetic progression is " + ratio);
        int[] newNumbers = new int[size];
        if (numbers == null || numbers.length == 0 || numbers.length == 1)
            return;
        copyArithmArray(numbers, newNumbers, ratio);
    }


    public static void printNewGeometricArray(int[] numbers, int size, int ratio) {
        System.out.println("The ratio for geometric progression is " + ratio);
        int[] newNumbers = new int[size];
        if (numbers == null || numbers.length == 0 || numbers.length == 1){
            return;
        }
        copyGeomArray(numbers, newNumbers, ratio);
    }

    public static void copyArithmArray(int[] numbers, int[] newNumbers, int ratio) { if(newNumbers.length>=numbers.length){
        System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
    }else{
        System.arraycopy(numbers, 0, newNumbers, 0, newNumbers.length);
    }
        for (int i = numbers.length; i < newNumbers.length; i++) {
            newNumbers[i] = arithmeticProgression(numbers[0], i + 1, ratio);
        }
        System.out.println(Arrays.toString(newNumbers));
    }

    public static void copyGeomArray(int[] numbers, int[] newNumbers, int ratio) {
        if(newNumbers.length>=numbers.length){
            System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
        }else{
            System.arraycopy(numbers, 0, newNumbers, 0, newNumbers.length);
        }
        for (int i = numbers.length; i < newNumbers.length; i++) {
            newNumbers[i] = geometricProgression(numbers[0], i + 1, ratio);
        }
        System.out.println(Arrays.toString(newNumbers));
    }

    public static int computeArithmeticRatio(int ak, int ak_1) {
        return ak - ak_1;
    }

    public static int computeGeometricRatio(int bk, int bk_1) {
        if (bk_1 == 0) {
            return 0;
        }
        return bk / bk_1;
    }

    public static int arithmeticProgression(int a1, int k, int ratio) {
        Progression nextArithmeticProgressionNr = (a_1, k_, ratio_) -> a_1 + (k_ - 1) * ratio_;
        return nextArithmeticProgressionNr.nextNumber(a1, k, ratio);
    }

    public static int geometricProgression(int b1, int k, int ratio) {
        Progression nextArithmeticProgressionNr = (b_1, k_, ratio_) -> (int) (b_1 * Math.pow(ratio_, k_ - 1));
        return nextArithmeticProgressionNr.nextNumber(b1, k, ratio);
    }

}
