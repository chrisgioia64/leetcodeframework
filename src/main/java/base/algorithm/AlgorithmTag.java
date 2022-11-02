package base.algorithm;

public enum AlgorithmTag {

    DYNAMIC_PROGRAMMING("Dynamic Programming"),
    ARRAYS("Arrays");

    private AlgorithmTag(String name) {
        this.name = name;
    }

    private String name;
}
