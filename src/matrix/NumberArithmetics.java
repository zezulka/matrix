package matrix;

/**
 * When possible, it is recommended to delegate arithmetic operations to the defined types.
 * Most of the classes in java.lang which extend Number have static <ClassName>.add(a, b) method in them.
 * @author Miloslav Zezulka, 2017
 */
public interface NumberArithmetics<T extends Number> {
    T add(T a, T b);
    T subtract(T a, T b);
    T multiply(T a, T b);
    T divide(T a, T b);
    
    T negate(T a);
    T zero();
    T one();
}
