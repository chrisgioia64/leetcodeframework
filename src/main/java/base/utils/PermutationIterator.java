package base.utils;

import java.util.Iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class PermutationIterator implements Iterator<int[]> {

    private int[] indices;
    private boolean[] taken;
    private Stack<FunctionCall> stack;
    private int n;
    private int[] last;

    public static class FunctionCall {
        private int index;
        private int permutationNumber;
        private FunctionCall back;

        public FunctionCall(int index, int permutationNumber) {
            this.index = index;
            this.permutationNumber = permutationNumber;
        }

        @Override
        public String toString() {
            return "(" + index + ", " + permutationNumber + ")";
        }
    }

    public PermutationIterator(int n) {
        this.indices = new int[n];
        this.taken = new boolean[n];
        this.n = n;
        this.stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            FunctionCall fnCall = new FunctionCall(0, i);
            stack.push(fnCall);
        }
        this.last = evaluate();
    }

    private int[] evaluate() {
        while (!stack.isEmpty()) {
            FunctionCall fnCall = stack.pop();
            if (!taken[fnCall.permutationNumber]) {
                if (fnCall.index == taken.length - 1) {
                    indices[fnCall.index] = fnCall.permutationNumber;
                    int[] returnedValue = new int[indices.length];
                    System.arraycopy(indices, 0, returnedValue, 0, indices.length);
                    updateTaken(fnCall);
                    return returnedValue;
                } else {
                    taken[fnCall.permutationNumber] = true;
                    indices[fnCall.index] = fnCall.permutationNumber;

                    FunctionCall newFnCall = new FunctionCall(fnCall.index + 1, n-1);
                    newFnCall.back = fnCall;
                    stack.push(newFnCall);
                    for (int i = n-2; i >= 0; i--) {
                        newFnCall = new FunctionCall(fnCall.index + 1, i);
                        stack.push(newFnCall);
                    }
                }
            } else {
                updateTaken(fnCall);
            }
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public int[] next() {
        int[] returnedValue = this.last;
        this.last = evaluate();
        return returnedValue;
    }

    private void updateTaken(FunctionCall fnCall) {
        if (fnCall.back != null) {
            FunctionCall backCall = fnCall.back;
            taken[backCall.permutationNumber] = false;
            while (backCall.back != null) {
                backCall = backCall.back;
                taken[backCall.permutationNumber] = false;
            }
        }
    }
}
