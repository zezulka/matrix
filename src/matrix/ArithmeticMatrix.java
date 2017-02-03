package matrix;

/**
 * Defines matrix which is capable of most primitive matrix operations.
 * @author Miloslav Zezulka, 2017
 * @param <T> any numeric object (therefore T instanceof Number == true)
 */
public interface ArithmeticMatrix<T extends Number> extends Matrix<T> {
    ArithmeticMatrix<T> add(ArithmeticMatrix<T> a);
    ArithmeticMatrix<T> subtract(ArithmeticMatrix<T> a);
    ArithmeticMatrix<T> multiply(ArithmeticMatrix<T> a);
    ArithmeticMatrix<T> negate();
}
