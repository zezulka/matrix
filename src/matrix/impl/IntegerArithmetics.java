package matrix.impl;

import matrix.NumberArithmetics;

/**
 * This implementation does not take null values into consideration, meaning that 
 * NullPointerException is thrown whenever null arguments are passed into the functions.
 * @author Miloslav Zezulka, 2017
 */
public class IntegerArithmetics implements NumberArithmetics<Integer>{

    private static final IntegerArithmetics ARIT = new IntegerArithmetics(); //singleton instance
    private static final Integer ZERO = Integer.valueOf(0);
    private static final Integer ONE = Integer.valueOf(1);
    
    private IntegerArithmetics() {}
    
    public static IntegerArithmetics getInstance() {
        return ARIT;
    }
    
    @Override
    public Integer add(Integer a, Integer b) {
        return Integer.sum(a, b);
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        return Integer.sum(a, -b);
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        return a / b;
    }

    /**
     * Negates the defined value.
     * @param a
     * @return 
     */
    @Override
    public Integer negate(Integer a) {
        return -a;
    }

    /**
     * Returns zero instance.
     * @return static reference to Integer.valueOf(0) 
     */
    @Override
    public Integer zero() {
        return ZERO;
    }
    
    /**
     * Returns Integer instance of one.
     * @return static reference to Integer.valueOf(1) 
     */
    @Override
    public Integer one() {
        return ONE;
    }
}
