import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public enum RockPaperScissorDecision {
    ROCK(1, 'A', 'X'),
    PAPER(2, 'B', 'Y'),
    SCISSOR(3, 'C', 'Z');

    public final static Map<RockPaperScissorDecision, RockPaperScissorDecision> DEFEATS_MAP = getDefeatsMap();

    public final int score;
    public final char enemyEncoding;
    public final char playerEncoding;

    private RockPaperScissorDecision(int score, char enemyEncoding, char playerEncoding) {
        this.score = score;
        this.enemyEncoding = enemyEncoding;
        this.playerEncoding = playerEncoding;
    }

    private static Map<RockPaperScissorDecision, RockPaperScissorDecision> getDefeatsMap(){
        Map<RockPaperScissorDecision, RockPaperScissorDecision> map = new HashMap<>();
        map.put(ROCK, SCISSOR);
        map.put(SCISSOR, PAPER);
        map.put(PAPER, ROCK);
        return Collections.unmodifiableMap(map);
    }

    public static RockPaperScissorDecision parseCodeOfPlayer(char code) {
        return Stream.of(values())
            .filter(decision -> decision.playerEncoding == code)
                .findAny()
                    .orElse(null);
    }

    public static RockPaperScissorDecision parseCodeOfEnemy(char code) {
        return Stream.of(values())
            .filter(decision -> decision.enemyEncoding == code)
                .findAny()
                    .orElse(null);
    }

    public RockPaperScissorOutcome playAgainst(RockPaperScissorDecision enemyDecision) {
        if(DEFEATS_MAP.get(this) == enemyDecision)
            return RockPaperScissorOutcome.WIN;
        if(DEFEATS_MAP.get(enemyDecision) == this)
            return RockPaperScissorOutcome.LOSE;   
        return RockPaperScissorOutcome.DRAW;
    }
}