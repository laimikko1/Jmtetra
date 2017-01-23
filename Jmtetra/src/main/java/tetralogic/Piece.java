/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetralogic;


public class Piece {
    private int y;
    private int x;
    private char mark;

    public Piece(int y, int x, char mark) {
        this.y = y;
        this.x = x;
        this.mark = mark;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }
    
    
    
    
    
    
}
