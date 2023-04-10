public enum RockPaperScissorOutcome {
    WIN(6),
    DRAW(3),
    LOSE(0);

    public final int score;

    private RockPaperScissorOutcome(int score) {
        this.score = score;
    }
}
