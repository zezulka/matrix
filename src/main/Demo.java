/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import matrix.impl.FullArithmeticMatrix;
import matrix.Matrix;
import matrix.impl.IntegerArithmetics;
import matrix.ArithmeticMatrix;
//import matrix.impl.FullMatrix;

/**
 *
 * @author miloslav
 */
public class Demo {
    public static void main(String[] args) {
        ArithmeticMatrix<Integer> m1 = new FullArithmeticMatrix<>(2, 2, IntegerArithmetics.getInstance());
        ArithmeticMatrix<Integer> m2 = new FullArithmeticMatrix<>(2, 2, IntegerArithmetics.getInstance());
        m1.set(0, 0, 2);
        m1.set(0, 1, 10);
        m1.set(1, 0, 5);
        m1.set(1, 1, 6);
        
        m2.set(0, 0, 2);
        m2.set(0, 1, 1);
        m2.set(1, 0, 1);
        m2.set(1, 1, 3);
        
        System.out.println(m1.toString() + m2.toString()); 
        
        Matrix<Integer> m12 = m1.multiply(m2);
        
        ArithmeticMatrix<Integer> intm = new FullArithmeticMatrix<>(new Integer[][]{{5, 16},{42, 0}}, IntegerArithmetics.getInstance());
        
        System.out.println(intm);
    }
}
