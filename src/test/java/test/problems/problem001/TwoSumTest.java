package test.problems.problem001;

import base.types.IntegerArrayType;
import base.types.TwoSumType;
import problems.problem001.TwoSumProblem;
import test.base.BootstrapBaseTest;

public class TwoSumTest extends BootstrapBaseTest<TwoSumType, IntegerArrayType> {
    @Override
    public void setTemplate() {
        this.problemComponents = new TwoSumProblem();
    }
}
