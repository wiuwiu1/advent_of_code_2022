import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

public class RockPaperScissorTurnament {

    public int calculateScoreOfStrategyGuide(File strategyGuide) throws IOException{
        StrategyGuideReader reader = new StrategyGuideReader(strategyGuide);
        int score = reader.getRockPaperScissorGameStream()
            .collect(Collectors.summingInt(RockPaperScissorGame::getPlayerScore));
        reader.close();
        return score;
    }
}        
