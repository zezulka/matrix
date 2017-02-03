package matrix.impl;

import matrix.ArithmeticMatrix;
import matrix.NumberArithmetics;
import misc.Errors;

/**
 * Implementation of a numeric matrice.
 * highest order indices represent ROWS in a matrice, second indices are the columns in the matrice
 * @author Miloslav Zezulka, 2017
 * @param <T> any boxed numeric type (e.g. Integer, Float, ...) from Java core API
 */
public final class FullArithmeticMatrix<T extends Number> extends FullMatrix<T> implements ArithmeticMatrix<T> {
    private final NumberArithmetics<T> arithmetics; 
    
    public FullArithmeticMatrix(int width, int height, NumberArithmetics<T> arithmetics) {
        super(width, height);
        
        this.arithmetics = arithmetics;
    }
    
    public FullArithmeticMatrix(T[][] vals, NumberArithmetics<T> arithmetics) {
        super(vals);
        this.arithmetics = arithmetics;
    }
    
    public static <T extends Number> ArithmeticMatrix<T> getIdentityMatrix(int size, NumberArithmetics<T> arit) {
        ArithmeticMatrix<T> ret = new FullArithmeticMatrix<>(size, size, arit);
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                ret.set(row, col, row == col ? arit.one() : arit.zero());
            }
        }
        return ret;
    }
    
    public static <T extends Number> ArithmeticMatrix<T> getMatrixOfNs(int size, NumberArithmetics<T> arit, T n) {
        ArithmeticMatrix<T> ret = new FullArithmeticMatrix<>(size, size, arit);
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                ret.set(row, col, n);
            }
        }
        return ret;
    }
    
    public static <T extends Number> ArithmeticMatrix<T> getMatrixOfOnes(int size, NumberArithmetics<T> arit) {
        return getMatrixOfNs(size, arit, arit.one());
    }
    
    public static <T extends Number> ArithmeticMatrix<T> getZeroMatrix(int size, NumberArithmetics<T> arit) {
        return getMatrixOfNs(size, arit, arit.zero());
    }
    
    /**
     * Compares another full matrice with this one with their height and width parameters.
     * This method does not allow to compare two null objects and does not check whether matrices have 
     * same value in them
     * @param another
     * @return type equality 
     */
    public boolean areOfSameType(ArithmeticMatrix<T> another) {
        return (another != null) && (this.getHeight() == another.getHeight() && 
                                     this.getWidth() == another.getWidth());
    }
    
    @Override
    public ArithmeticMatrix<T> add(ArithmeticMatrix<T> a) {
        if(a == null) {
            throw new IllegalArgumentException("a" + Errors.NULL_PTR);
        }
        if(!this.areOfSameType(a)) {
            throw new IllegalArgumentException(Errors.NOT_COMPATIBLE_ERR + "(not the same type)");
        }
        ArithmeticMatrix<T> ret = new FullArithmeticMatrix<>(this.getHeight(), this.getWidth(), this.arithmetics);
        for(int row = 0; row < this.getHeight(); row++) {
            for(int col = 0; col < this.getWidth(); col++) {
                ret.set(row, col, this.arithmetics.add(this.get(row, col), a.get(row, col)));
            }
        }
        return ret;
    }

    @Override
    public ArithmeticMatrix<T> subtract(ArithmeticMatrix<T> a) {
        return this.add(a.negate());
    }

    @Override
    public ArithmeticMatrix<T> multiply(ArithmeticMatrix<T> a) {
        if(a == null) {
            throw new IllegalArgumentException("a" + Errors.NULL_PTR);
        }
        if(this.getWidth() != a.getHeight()) {
            throw new IllegalArgumentException(Errors.NOT_COMPATIBLE_ERR + "(not the same type)");
        }
        ArithmeticMatrix<T> ret = new FullArithmeticMatrix<>(this.getHeight(), this.getWidth(), this.arithmetics); 
        for(int row = 0; row < this.getHeight(); row++) {
            for(int col = 0; col < this.getWidth(); col++) {
                ret.set(row, col, arithmetics.zero());
                for (int sum = 0; sum < this.getWidth(); sum++)
		    ret.set(row, col, arithmetics
		       .add(ret.get(row, col), arithmetics.multiply(get(row, sum), a.get(sum, col))));
            }
        }
        return ret;
    }

    @Override
    public ArithmeticMatrix<T> negate() {
        ArithmeticMatrix<T> ret = new FullArithmeticMatrix<>(this.getHeight(), this.getWidth(), this.arithmetics);
        for(int row = 0; row < this.getHeight(); row++) {
            for(int col = 0; col < this.getWidth(); col++) {
                ret.set(row, col, this.arithmetics.negate(this.get(row, col)));
            }
        }
        return ret;
    }
    
}
