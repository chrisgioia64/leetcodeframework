package base.problem;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProblemInformation {

    private final String name;
    private final int number;
    private final ProblemDifficulty difficulty;

}
