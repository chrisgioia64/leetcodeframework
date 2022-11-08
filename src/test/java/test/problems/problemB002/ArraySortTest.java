package test.problems.problemB002;

import base.types.IntegerArrayType;
import problems.problemB002.ArraySortProblem;
import test.base.BootstrapBaseTest;

public class ArraySortTest extends BootstrapBaseTest<IntegerArrayType, IntegerArrayType> {
    @Override
    public void setTemplate() {
        this.problemComponents = new ArraySortProblem();
    }
}
