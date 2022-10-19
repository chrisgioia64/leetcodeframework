package base;

import java.util.Iterator;

public interface InputGenerator<T> {

    Iterator<T> generateInput();

}
