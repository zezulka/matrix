package matrix;

/**
 * Defines the most abstract matrix, which does not need to define arithmetic 
 * operations, e.g. Matrix<String>.
 * @author Miloslav Zezulka, 2017
 * @param <T> any object
 */
public interface Matrix<T> {
    boolean set(int j, int i, T val);
    T get(int j, int i);
    int getHeight();
    int getWidth();
}
