package day2.java;

import java.io.File;

public class Appilcation {

    private final static String STRATEGY_GUIDE_PATH = "C:/Users/Patrick.Welter/Desktop/advent_of_code_2022/day2/input.txt";
    public static void main(String[] args) throws Exception {
        printSolutionOfFirstTask();
        printSolutionOfSecondTask();
    }

    private static void printSolutionOfFirstTask() throws Exception {
        RockPaperScissorTurnament turnament = new RockPaperScissorTurnament();
        int strategyGuideScore = turnament.calculateScoreOfStrategyGuide(new File(STRATEGY_GUIDE_PATH));
        System.out.println(String.format("The given strategy guide will result in a turnament score of %s points for the player!", strategyGuideScore));
    }

    private static void printSolutionOfSecondTask() throws Exception {
        RockPaperScissorTurnament turnament = new RockPaperScissorTurnament();
        
    }
    
}
