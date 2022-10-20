package base.utils;


import java.util.Iterator;
import java.util.Stack;

/**
 * Iterator for generating all combinations of string comprising the characters CHARS
 * of size SIZE
 * e.g. if CHARS = "AB" and SIZE = 3, then we would generate the strings:
 * "AAA", "AAB", "ABA", "ABB", "BAA", "BAB", "BBA", "BBB"
 */
public class StringPermutationIterator implements Iterator<String> {

    private int size;
    private char[] chars;
    private Stack<FunctionCall> stack;
    private char[] ary;

    public static class FunctionCall {
        private int index;
        private char c;

        public FunctionCall(int index, char c) {
            this.index = index;
            this.c = c;
        }
    }

    public StringPermutationIterator(int size, String chars) {
        this.size = size;
        this.chars = chars.toCharArray();
        this.ary = new char[size];
        this.stack = new Stack<>();
        for (int i = chars.length() - 1; i >= 0; i--) {
            stack.add(new FunctionCall(0, this.chars[i]));
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public String next() {
        while (!stack.isEmpty()) {
            FunctionCall functionCall = stack.pop();
            this.ary[functionCall.index] = functionCall.c;
            if (functionCall.index == ary.length - 1) {
                String newString = new String(this.ary);
                return newString;
            } else {
                for (int i = chars.length - 1; i >= 0; i--) {
                    FunctionCall fnCall = new FunctionCall(functionCall.index + 1, this.chars[i]);
                    stack.push(fnCall);
                }
            }
        }
        return null;
    }
}
