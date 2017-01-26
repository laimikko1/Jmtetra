/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laimikko
 */
public class PieceTest {
    private Piece piece;
    
    public PieceTest() {
        this.piece = new Piece(0, 0, '-');
    }
    
    
    @Test
    public void getXWorks() {
        assertEquals(this.piece.getX(), 0);
    }
    
    @Test
    public void getYWorks() {
        assertEquals(this.piece.getY(), 0);
    }
    
    @Test
    public void getMarkWorks() {
        assertEquals(this.piece.getMark(), '-');
    }
    
    @Test
    public void setXWorks() {
        this.piece.setX(1);
        assertEquals(1, this.piece.getX());
    }
    
    @Test
    public void setYWorks() {
        this.piece.setY(1);
        assertEquals(1, this.piece.getY());
    }
    
    @Test
    public void setMarkWorks() {
        this.piece.setMark('a');
        assertEquals('a', this.piece.getMark());
    }

}
