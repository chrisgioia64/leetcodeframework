package test.base;

import base.problem.ProblemComponents;
import test.base.strategy.TestEvaluationStrategy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public abstract class BootstrapBaseTest<X, Y> {

    protected ProblemComponents<X, Y> problemComponents;
    protected TestEvaluationStrategy<X, Y> strategy;

    @BeforeClass
    public void setup() {
        this.strategy = new TestEvaluationStrategy<>();
        setTemplate();
        strategy.setProblem(problemComponents);
    }

    public abstract void setTemplate();

    @Test
    public void testSimpleAlgorithm() {
        strategy.testSimpleAlgorithm();
    }

    @Test
    public void testAdvanceAlgorithm() {
        strategy.testAllAdvancedAlgorithms();
    }

}
