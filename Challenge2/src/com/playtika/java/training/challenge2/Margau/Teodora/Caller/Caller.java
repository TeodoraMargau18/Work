package com.playtika.java.training.challenge2.Margau.Teodora.Caller;

import com.playtika.java.training.challenge2.Margau.Teodora.GameSettings.BingoNumber;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Caller {
    private char lastNumberColumn;
    private int lastNumberNumber;
    private AtomicInteger noRounds;
    private ArrayList<BingoNumber> previousCombination;

    public Caller(){
        this.lastNumberColumn=' ';
        this.lastNumberNumber=0;
        this.noRounds.set(0);
        this.previousCombination=new ArrayList<>();
    }

    public boolean wasPicked(BingoNumber bingoNumber){
        return false;
    }
    public char getLastColumn(){
        return lastNumberColumn;
    }
    public int getLastNumber(){
        return lastNumberNumber;
    }
    public int getNoOfPlayedNumber(){
        return 0;
    }
    public ArrayList<BingoNumber> getPreviousCombination() throws CloneNotSupportedException {
        ArrayList<BingoNumber> copie=new ArrayList();
        for(int i=0;i<this.previousCombination.size();i++){
            copie.add((BingoNumber) previousCombination.get(i).clone());
        }
        return copie;
    }
    public boolean checkGameStatus(){
        int i=noRounds.get();
        if(previousCombination.size()<i){
            return false;
        }
        return true;
    }
}
