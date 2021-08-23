package com.playtika.java.training.challenge2.Margau.Teodora.GameSettings;

import com.playtika.java.training.challenge2.Margau.Teodora.GameSettings.Exception.NoAvailablePlayersException;
import com.playtika.java.training.challenge2.Margau.Teodora.GameSettings.Exception.NoGameSettingsException;

import java.io.*;
import java.util.ArrayList;

public class GameSettings implements Cloneable {
    public static int NO_CARDS;
    private int noPlayers;
    private ArrayList<String> names;
    private ArrayList<BingoNumber> forbiddenCombinations = new ArrayList<>();

    public GameSettings(String settingsFileName) throws IOException {
//        Citire din fisier
        File file = new File(settingsFileName);
        if (settingsFileName == null || settingsFileName.isEmpty() || !file.exists()) {
            throw new NoGameSettingsException("I can't find the settingFile!");
        }

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try (bufferedReader) {
            NO_CARDS = Integer.parseInt(bufferedReader.readLine());
            System.out.println(NO_CARDS);
            this.noPlayers = Integer.parseInt(bufferedReader.readLine());
            if (this.noPlayers > 10 || this.noPlayers < 1) {
                throw new NoAvailablePlayersException("There is No Available Players");
            }
            this.names = new ArrayList<>();
            for (int i = 0; i < this.noPlayers; i++) {
                this.names.add(bufferedReader.readLine());
            }
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String column=line.split(",")[0];
                for(int i=1;i<6;i++){
                    int number=Integer.parseInt(line.split(",")[i].trim());
                    BingoNumber forbiddenNumber=new BingoNumber(column,number);
                    forbiddenCombinations.add(forbiddenNumber);
                }
            }

        }
    }
    private GameSettings(){
        this.noPlayers=0;
        this.names=null;
        this.forbiddenCombinations = null;
    }

    public int getNoPlayers() {
        return noPlayers;
    }
    private void setNames(ArrayList<String> names){
        if(names==null){
            this.names=null;
            return;
        }
        this.names=new ArrayList<>();
        for(int i=0;i<names.size();i++){
            this.names.add(names.get(i));
        }
    }
    private void setForbiddenCombinations(ArrayList<BingoNumber> forbiddenCombinations) throws CloneNotSupportedException {
        if(forbiddenCombinations==null){
            this.forbiddenCombinations=null;
            return;
        }
        this.forbiddenCombinations=new ArrayList<>();
        for(int i=0;i<forbiddenCombinations.size();i++){
            this.forbiddenCombinations.add((BingoNumber) forbiddenCombinations.get(i).clone());
        }
    }

    public String getPlayerName(int index) {
        if (names == null && names.size() == 0 && names.size() <= index && index < 0) {
            return null;
        }
        return names.get(index);
    }

    public int getNoForbiddenCombinations() {
        if (forbiddenCombinations == null && forbiddenCombinations.size() == 0) {
            return 0;
        }
        return forbiddenCombinations.size();
    }

    public ArrayList<BingoNumber> getForbiddenCombination(int index) {
        if (forbiddenCombinations == null && forbiddenCombinations.size() == 0
                && forbiddenCombinations.size() <= (5*index+5) && index < 0) {
            return null;
        }
        ArrayList<BingoNumber> forbiddenCombination=new ArrayList<>();
        for(int i=0;i<5;i++){
            forbiddenCombination.add(forbiddenCombinations.get((index*5)+i));
        }
        return forbiddenCombination;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        GameSettings clone=new GameSettings();
        clone.noPlayers=this.noPlayers;
        clone.setNames(this.names);
        clone.setForbiddenCombinations(this.forbiddenCombinations);
        return clone;
    }
}
