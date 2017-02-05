/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import matrix.Matrix;
import misc.Errors;

/**
 * This is an implementation of the Matrix interface. Therefore, such matrix is not
 * capable of arithmetic operations (see Matrix interface in 'matrix' package).
 * @author Miloslav Zezulka, 2017
 * @param <T> any object
 */
public class FullMatrix<T> implements Matrix<T> {

    private final List<List<T>> vals;
    private final int height;
    private final int width;
    private volatile int hashCode; //hashcode optimisation, cache usage
    
    public FullMatrix(int height, int width) { 
        this.vals = new ArrayList<>(height);
        this.height = height;
        this.width = width;
        do {
            List<T> row = new ArrayList<>(width);
            for(int i = 0; i < width; i++) {
                row.add(null);
            }
            this.vals.add(row);
        } while(--height > 0);
    }
    
    public FullMatrix(T[][] vals) {
        if(vals == null) {
            throw new IllegalArgumentException("vals" + Errors.NULL_PTR);
        }
        this.width = vals[0].length;
        this.height = vals.length;
        this.vals = new ArrayList<>(vals.length);
        for(T[] row : vals) {
            if(row.length != this.width) {
                throw new IllegalArgumentException(Errors.MATRIX_ERR.toString());
            }
            this.vals.add(Arrays.asList(row));
        }
    }
   
    @Override
    public boolean set(int j, int i, T val) {
        if(this.getHeight() <= j || j < 0 || this.getWidth() <= i || i < 0) {
            return false;
        } 
        this.vals.get(j).set(i, val);
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
        return this.vals.get(j).get(i);
    }

    @Override
    public int getHeight() {
        if(vals == null) {
            return 0;
        }
        return this.height;
    }

    @Override
    public int getWidth() {
        if(vals == null) {
            return 0;
        }
        return this.width;
    }
    
    @Override 
    public String toString() {
        if(vals == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb = sb.append("Matrice with ").append(getHeight()).append(" rows and ").append(getWidth()).append(" columns.\n");
        for(List<T> list : vals) {
            sb = sb.append(' ');
            for(T item : list) {
                sb = sb.append(item).append(' ');
            }
            sb = sb.append(" \n");
        }
        return sb.toString();
    }
    
    /**
     * Values taken into consideration: matrix width, height, value types and values themselves.
     * Please note that the same implementation is inherited by FullArithmeticMatrix, as 
     * FullArithmeticMatrix does not have additional DISTINGUISHABLE attributes.
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof FullMatrix)) {
            return false;
        }
        if (obj==this) {
            return true;
        } 
        if (obj.getClass().equals(this.getClass()))
        {
            //OK, because obj must be instance of FullMatrix
            @SuppressWarnings("unchecked")
            FullMatrix<T> o = (FullMatrix<T>)obj;
            if (this.getHeight() != o.getHeight() || this.getWidth() != o.getWidth()) {
                return false;
            }         
            for (int row = 0; row < this.getHeight(); row++)
                    for (int col = 0; col < this.getWidth(); col++)
                        if (!get(row,col).equals(o.get(row, col)))
                            return false;
            return true;
        }
	return false;
    }
    
    /**
     * Values taken into consideration: matrix width, height, value types and values themselves.
     * Please note that the same implementation is inherited by FullArithmeticMatrix, as 
     * FullArithmeticMatrix does not have additional DISTINGUISHABLE attributes.
     * @return 
     */
    @Override
    public int hashCode() {
        int result = hashCode;
        if(result == 0) {
            result = 17; //init val
            result += 31 * (this.getHeight() + this.getWidth() + this.getClass().hashCode()); 
            for(List<T> row: this.vals) {
                for (T item : row) {
                    result = 31 * result + item.hashCode();
                }
            }
            hashCode = result;
        }
        return result;
    }
}
