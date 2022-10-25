package base.algorithm;

public interface Algorithm<X, Y> {

    Y performAlgorithm(X x);

    String getVariantName();

}
