package com.playtika.java.training.challenge2.Margau.Teodora.CardsGenerator;

import com.playtika.java.training.challenge2.Margau.Teodora.GameSettings.BingoNumber;

import java.util.*;

public class PlayerCard implements Printable{
    public final int UID;
    private List<BingoNumber> numbers;
    private HashMap<String,ArrayList<Integer>> numbersPerColumns
            =new HashMap<>();
    private static int idUnic=0;

    public PlayerCard(List<BingoNumber> numbers) throws CloneNotSupportedException {
        this.UID=++idUnic;
        this.numbers=new ArrayList<>();
        for(BingoNumber b:numbers){
            this.numbers.add((BingoNumber) b.clone());
            if(!numbersPerColumns.containsKey(b.getColumn())){
                ArrayList<Integer> columnList=new ArrayList<>();
                columnList.add(b.getNumber());
                numbersPerColumns.put(b.getColumn(),columnList);
            }else{
                numbersPerColumns.get(b.getColumn()).add(b.getNumber());
            }
        }

    }
    @Override
    public void print() {
        System.out.printf(" \nCard UID : <%d>\n",this.UID);
        String[] bingo={"B","I","N","G","O"};

        for( int i=0;i<5;i++){
            System.out.printf(" %s: ",bingo[i]);
            for(int j=0;j<5;j++){
                System.out.printf("<%d>|", numbersPerColumns.get(bingo[i]).get(j));
            }
            System.out.printf("\n");
        }
    }
}
