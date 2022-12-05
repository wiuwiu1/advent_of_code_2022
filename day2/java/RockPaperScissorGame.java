package day2.java;

public record RockPaperScissorGame(RockPaperScissorDecision enemyDecision, RockPaperScissorDecision playerDecision) {

    public int getPlayerScore() {
        return playerDecision.score + calculateGameOutcomeScore();
    }

    private int calculateGameOutcomeScore() {
        return playerDecision.playAgainst(enemyDecision).score;
    }
    
}
