package com.playtika.java.training.challenge2.Margau.Teodora.GameSettings;

public class BingoNumber implements Printable, Cloneable {
    private String column;
    private int number;

    public BingoNumber(String column, int number) {
        if(isValidCombination(column,number)){
            this.column = column;
            this.number = number;
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        BingoNumber clone = new BingoNumber(this.column, this.number);
        return clone;
    }

    public boolean isValidCombination(String column, int number) {
        if (number >= 1 && number < 16 && column.equals("B")) {
            return true;
        }
        if (number >= 16 && number < 31 && column.equals("I")) {
            return true;
        }
        if (number >= 31 && number < 46 && column.equals("N")) {
            return true;
        }
        if (number >= 46 && number < 61 && column.equals("G")) {
            return true;
        }
        if (number >= 61 && number < 76 && column.equals("O")) {
            return true;
        }
        return false;
    }

    @Override
    public void print() {
        System.out.printf("%s-%d\n", this.column, this.number);
    }
    public String getColumn(){
        return this.column;
    }
    public int getNumber(){
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        BingoNumber clone= (BingoNumber) obj;
        if(this.getColumn()==null||clone.getColumn()==null){
            return false;
        }
        if(this.column.equals(clone.getColumn())){
            if(this.getNumber()== clone.getNumber()){
                return true;
            }
        }
        return false;
    }
}
