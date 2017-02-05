/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;
import matrix.impl.FullArithmeticMatrix;
import matrix.Matrix;
import matrix.impl.IntegerArithmetics;
import matrix.ArithmeticMatrix;
import matrix.impl.FloatArithmetics;
import matrix.impl.FullMatrix;

/**
 *
 * @author miloslav
 */
public class Demo {
    public static void main(String[] args) {
        
        ArithmeticMatrix<Integer> m1 = new FullArithmeticMatrix<>(2, 2, IntegerArithmetics.getInstance());
        ArithmeticMatrix<Integer> m2 = new FullArithmeticMatrix<>(2, 2, IntegerArithmetics.getInstance());
        ArithmeticMatrix<Integer> m3 = new FullArithmeticMatrix<>(new Integer[][]{{1,2,3}, {4,5,6}, {7,8,9}}, IntegerArithmetics.getInstance());

        m1.set(0, 0, 1);
        m1.set(0, 1, 1);
        m1.set(1, 0, 1);
        m1.set(1, 1, 1);
        
        m2.set(0, 0, 1);
        m2.set(0, 1, 1);
        m2.set(1, 0, 1);
        m2.set(1, 1, 1);
        
        System.out.println(m3);
        //m2.set(0, 0, -5);
        
        //System.out.println(m1.toString() + m2.toString()); 
        
        //Matrix<Integer> m12 = m1.multiply(m2);

        System.out.println(m1 + "\n" + m2);
        
        System.out.println(m1.equals(m2) +", " + m1.hashCode() +", " + m2.hashCode());
    }
}
