package runner;

import problems.PalindromicSubstringProblem;
import base.strategy.ApplicationEvaluationStrategy;

public class TestRunner {

    public static void main(String[] args) {
        PalindromicSubstringProblem problem = new PalindromicSubstringProblem();
        ApplicationEvaluationStrategy<String, String> strategy = new ApplicationEvaluationStrategy<>();
        strategy.setProblem(problem);
        strategy.standardBootstrap();
    }

}
