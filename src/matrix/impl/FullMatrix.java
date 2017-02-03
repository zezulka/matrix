/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix.impl;

import java.util.Arrays;
import matrix.Matrix;
import misc.Errors;

/**
 * This is an implementation of the Matrix interface. Therefore, such matrix is not
 * capable of arithmetic operations (see Matrix interface in 'matrix' package).
 * @author Miloslav Zezulka, 2017
 * @param <T> any object
 */
public class FullMatrix<T> implements Matrix<T> {

    private final T[][] vals;
    
    public FullMatrix(int width, int height) {
        this.vals = (T[][]) (new Number[width][height]);
    }
    
    public FullMatrix(T[][] vals) {
        if(vals == null) {
            throw new IllegalArgumentException("vals" + Errors.NULL_PTR);
        }
        int width = vals[0].length;
        this.vals = (T[][]) (new Object[vals.length][]);
        for(int row = 0; row < vals.length; row++) {
            if(vals[row].length != width) {
                throw new IllegalArgumentException(Errors.MATRIX_ERR.toString());
            }
            this.vals[row] = Arrays.copyOf(vals[row], width);
        }
    }
   
    @Override
    public boolean set(int j, int i, T val) {
        if(this.getHeight() <= j || j < 0 || this.getWidth() <= i || i < 0) {
            return false;
        } 
        this.vals[j][i] = val;
        return true;
    }

    /**
     * Returns object at the coordinates [j, i].
     * @param j row specification
     * @param i column specification
     * @return If indices are out of bounds, null is returned. IMMUTABLE (TO DO) Object on the specified coordinates if successful.
     */
    @Override
    public T get(int j, int i) {
        if(this.getHeight() <= j || j < 0 || this.getWidth() <= i || i < 0) {
            return null;
        }
        return this.vals[j][i];
    }

    @Override
    public int getHeight() {
        if(vals == null) {
            return 0;
        }
        return this.vals.length;
    }

    @Override
    public int getWidth() {
        if(vals == null) {
            return 0;
        }
        return this.vals[0].length;
    }
    
    @Override 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb = sb.append("Matrice with ").append(getHeight()).append(" rows and ").append(getWidth()).append(" columns.\n");
        if(vals == null) {
            return "";
        }
        for(T[] row : vals) {
            sb.append(' ');
            for(T val : row) {
                sb = sb.append(val).append(' ');
            }
            sb = sb.append('\n');
        }
        return sb.toString();
    }
}
