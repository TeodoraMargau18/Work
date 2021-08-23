package com.playtika.java.training.challenge2.Margau.Teodora;

import com.playtika.java.training.challenge2.Margau.Teodora.CardsGenerator.CardGenerator;
import com.playtika.java.training.challenge2.Margau.Teodora.CardsGenerator.PlayerCard;
import com.playtika.java.training.challenge2.Margau.Teodora.GameSettings.GameSettings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Main {

    public static ArrayList<PlayerCard> playerCardsOfTheGame = new ArrayList<>();
    public static GameSettings g;

    static {
        try {
            g = new GameSettings("settings.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, CloneNotSupportedException, ExecutionException, InterruptedException {

        CardGenerator cardGenerator = new CardGenerator(4, GameSettings.NO_CARDS);
        cardGenerator.getInitialCards();
        if(cardGenerator.hasFinished()){
            System.out.printf("Avem %d carduri!",playerCardsOfTheGame.size());
            for(int i=0;i<10;i++){
                playerCardsOfTheGame.get(i).print();
            }
        }
    }
}
