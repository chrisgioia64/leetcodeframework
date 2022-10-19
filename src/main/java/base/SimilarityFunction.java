package base;

public interface SimilarityFunction<X, Y> {

    boolean isSimilar(X input, Y actualOutput, Y expectedOutput);

}
