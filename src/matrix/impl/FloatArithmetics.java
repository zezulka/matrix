
package matrix.impl;

import matrix.NumberArithmetics;

/**
 *
 * @author Miloslav Zezulka, 2017
 */
public class FloatArithmetics implements NumberArithmetics<Float>{

    private static final Float ZERO = Float.valueOf(0);
    private static final Float ONE = Float.valueOf(1);
    private static final FloatArithmetics ARIT = new FloatArithmetics();
    
    private FloatArithmetics() {}
    
    public static FloatArithmetics getInstance() {
        return ARIT;
    }
    
    @Override
    public Float add(Float a, Float b) {
        return Float.sum(a, b);
    }

    @Override
    public Float subtract(Float a, Float b) {
        return this.add(a, -b);
    }

    @Override
    public Float multiply(Float a, Float b) {
        return a * b;
    }

    @Override
    public Float divide(Float a, Float b) {
        return a / b;
    }

    @Override
    public Float negate(Float a) {
        return -a;
    }

    @Override
    public Float zero() {
        return ZERO;
    }

    @Override
    public Float one() {
        return ONE;
    }
    
}
