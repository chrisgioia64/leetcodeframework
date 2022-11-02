package test.problems.problemB001;

import base.types.IntegerArrayType;
import problems.problemB001.NextArrayProblem;
import test.base.BootstrapBaseTest;

public class NextArrayTest extends BootstrapBaseTest<IntegerArrayType, IntegerArrayType> {

    @Override
    public void setTemplate() {
        this.problemComponents = new NextArrayProblem();
    }
}
