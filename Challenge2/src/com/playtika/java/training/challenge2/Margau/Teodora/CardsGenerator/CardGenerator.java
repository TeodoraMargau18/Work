package com.playtika.java.training.challenge2.Margau.Teodora.CardsGenerator;

import com.playtika.java.training.challenge2.Margau.Teodora.GameSettings.BingoNumber;
import com.playtika.java.training.challenge2.Margau.Teodora.Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

//El va fi cel carer da drumul la noTh pentru generarea cardurilor!!!
public class CardGenerator {
    private int noThreads;
    private int noCards;
    private boolean hasFinishedGeneratingData = false;

    public CardGenerator(int noThreads, int noCards) {
        this.noThreads = noThreads;
        this.noCards = noCards;
    }

    public ArrayList<PlayerCard> getInitialCards() throws ExecutionException, InterruptedException {

        ArrayList<Callable> threads = new ArrayList<>();
        for (int i = 0; i < noThreads; i++) {
            Callable<ArrayList<PlayerCard>> newThread = () -> {
                ArrayList<PlayerCard> oneThreadAllPlayerCards = new ArrayList<>();
                for (int j = 0; j < this.noCards / this.noThreads; j++) {
                    PlayerCard playerCard = generateOnePlayerCard();
                    oneThreadAllPlayerCards.add(playerCard);
                }
                return oneThreadAllPlayerCards;
            };
            threads.add(newThread);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(noThreads);
        mergeThreadsResult(executorService, threads);
        executorService.shutdown();
        this.hasFinishedGeneratingData = true;
        return Main.playerCardsOfTheGame;
    }

    private PlayerCard generateOnePlayerCard() throws CloneNotSupportedException {
        ArrayList<BingoNumber> bingoNumbers = createListOfBingoNumbres();
        PlayerCard playerCard = new PlayerCard(bingoNumbers);
        return playerCard;
    }

    private ArrayList<BingoNumber> createListOfBingoNumbres() {
        ArrayList<BingoNumber> bingoNumberPerPlayerCard = generateBingoNumber();
        return bingoNumberPerPlayerCard;
    }

    private ArrayList<BingoNumber> generateBingoNumber() {
        ArrayList<BingoNumber> columns = new ArrayList<>();
        int i = 0;
        Random random = new Random();
        while (i < 5) {

            int number = random.nextInt(16);
            BingoNumber bingoNumberB = new BingoNumber("B", number);
            if (bingoNumberB.getColumn() != null) {
                BingoNumber bingoNumberI = new BingoNumber("I", number + 15);
                BingoNumber bingoNumberN = new BingoNumber("N", number + 30);
                BingoNumber bingoNumberG = new BingoNumber("G", number + 45);
                BingoNumber bingoNumberO = new BingoNumber("O", number + 60);
                if (!columns.contains(bingoNumberB)) {
                    columns.add(bingoNumberB);
                    columns.add(bingoNumberI);
                    columns.add(bingoNumberN);
                    columns.add(bingoNumberG);
                    columns.add(bingoNumberO);
                    i++;
                }

            }
        }
        checkForbiddenCombination(columns);
        return columns;
    }

    public void checkForbiddenCombination(ArrayList<BingoNumber> columns) {
        for (int j = 0; j < (Main.g.getNoForbiddenCombinations() / 5); j++) {
            if (columns.contains(Main.g.getForbiddenCombination(j))) {
                columns = generateBingoNumber();
            }
        }
    }


    private void mergeThreadsResult(ExecutorService executorService,
                                    ArrayList<Callable> threads) throws ExecutionException, InterruptedException {
        for (int i = 0; i < noThreads; i++) {
            Future<ArrayList<PlayerCard>> listFromOneThread
                    = executorService.submit(threads.get(i));
            Main.playerCardsOfTheGame.addAll(listFromOneThread.get());
        }
    }

    public boolean hasFinished() {
        return hasFinishedGeneratingData;
    }


}
