/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edpracdomino;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mulas
 */
public class Player {
    
    //DATA
    private List <DominoToken> hand;
    
    //CONSTRUCTOR
    public Player(){
        hand = new ArrayList<>();        
    }
    
    //METHODS
    public String showHand(){
        return hand.toString();
    }
    
    public String showSize(){
        String ab="        ";
        for (int i = 0; i < sizeHand(); i++) {
            ab+=""+i+"     ";
        }
        return ab;
    }
    
    public void stealToken(TokenPack elem){
        if (elem.size()!=0) {
             hand.add(elem.choose());
        } else {
            System.out.println("No quedan fichas para robar.");
        }
       
        
    }
    
    public DominoToken putToken(int index){
        return hand.get(index);
    }
    
    public void removeToken(int index){
        hand.remove(index);
    }
    
    public int sizeHand(){
        return hand.size();
    }
    
    public int score(){
        int score=0;
        for (int i = 0; i < hand.size(); i++) {
            score+=hand.get(i).show1()+hand.get(i).show2();
        }
        return score;        
    }
}
