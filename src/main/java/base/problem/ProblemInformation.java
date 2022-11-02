package base.problem;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Builder
@Getter
public class ProblemInformation {

    @NonNull
    private final String name;
    @NonNull
    private final int number;
    @NonNull
    private final ProblemDifficulty difficulty;

}
