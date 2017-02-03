/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

/**
 *
 * @author Miloslav Zezulka, 2017
 */
public enum Errors {
    NULL_PTR ("must not be null"),
    NOT_COMPATIBLE_ERR ("matrices are not compatible for this operation"),
    MATRIX_ERR("this is not a matrix");
    
    private final String msg;
    
    Errors(String msg) {
        this.msg = msg;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    @Override
    public String toString() {
        return this.getMsg();
    }
}
