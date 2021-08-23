package com.playtika;


public class Main {

    public static void main(String[] args) {
        String[] givenStrings = {"ana are mere", "acum", "bc"};
        String[] stringsForSearch = {"acum", "ana are mere", "acum"};
        int[] noAppearances = countAppearances(givenStrings, stringsForSearch);
        for (int i = 0; i < noAppearances.length; i++) {
            System.out.println(noAppearances[i]);
        }

    }

    public static int[] countAppearances(String[] givenStrings, String[] stringsForSearch) {
        if (givenStrings == null || givenStrings.length == 0) {
            return null;
        }
        int[] noAppearances = new int[givenStrings.length];
        if (stringsForSearch == null || stringsForSearch.length == 0) {
            return noAppearances;
        }
        countMatchingStrings(noAppearances,givenStrings,stringsForSearch);
        return noAppearances;
    }
    public static void countMatchingStrings(int[] noAppearances, String[] givenStrings, String[] stringsForSearch){
        for (int i = 0; i < givenStrings.length; i++) {
            if (givenStrings[i] == null) {
                continue;
            }
            for (int j = 0; j < stringsForSearch.length; j++) {
                if (givenStrings[i].equals(stringsForSearch[j])) {
                    noAppearances[i]++;
                }
            }
        }
    }
}
