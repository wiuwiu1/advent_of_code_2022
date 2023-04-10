import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StrategyGuideReader extends BufferedReader{

    private final int guideVersion;

    public StrategyGuideReader(File file, int guideVersion) throws IOException{
        super(new FileReader(file));
        if(guideVersion != 1 || guideVersion != 2) {
            close();
            throw new InvalidParameterException();
        }
        this.guideVersion = guideVersion;
    }

    public Stream<RockPaperScissorGame> getRockPaperScissorGameStream(){
        if(guideVersion == 1)
            Function parseFunction = this::parseCharsToGameVersionOne;
        return this.lines().map(this::parseLineToGame);
    }

    private RockPaperScissorGame parseLineToGame(String line, Function<List<Character>, RockPaperScissorGame> parseFunction) {
        List<Character> gameDecisionChars = splitLineIntoChars(line);

        if(gameDecisionChars.size() != 2){
            System.out.println("One line of the strategy guide has " + gameDecisionChars.size() + " decisions. It should be exactly 2.");
        }

        return parseFunction.apply(gameDecisionChars);
    }

    private List<Character> splitLineIntoChars(String line) {
        return  Stream.of(line.split(" "))
                    .map(decisionString -> decisionString.charAt(0)).
                        toList();
    }

    private RockPaperScissorGame parseCharsToGameVersionOne(List<Character> gameDecisionChars){
        RockPaperScissorDecision enemyDecision = RockPaperScissorDecision.parseCodeOfEnemy(gameDecisionChars.get(0));
        RockPaperScissorDecision playerDecision = RockPaperScissorDecision.parseCodeOfPlayer(gameDecisionChars.get(1));

        return new RockPaperScissorGame(enemyDecision, playerDecision);   
    }
    
    
}
