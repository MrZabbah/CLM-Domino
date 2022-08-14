/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edpracdomino;

/**
 * SE CORRESPONDE CON LA CLASE MONTON PEDIDA EN LA PRACTICA
 * @author mulas
 */
public class TokenPack {

    //DATA
    private Set pack = new DoubleLinkedSet();
            
    //CONSTRUCTOR
    public TokenPack() {
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 6; j++) {
                DominoToken token = new DominoToken(i, j);
                pack.add(token);
                if (pack.contains(token.swap()) && !token.same()) {
                    
                    pack.remove(token);
                }

            }
        }
        //System.out.println(pack.toString());
        //System.out.println(pack.size());
    }
    
    //METHODS
    public DominoToken choose(){
        return (DominoToken)pack.choose();
    }
    @Override
    public String toString(){
        return pack.toString();
    }
    public int size(){
        return pack.size();
    }
    
    public boolean notContainsNum(int elem){
        boolean contained=false;
        Iterator it = pack.iterator();
        while (it.hasNext() && contained==false) {
            DominoToken aux = (DominoToken)it.next();
            if (aux.show1()==elem || aux.show2()==elem) {
                contained=true;
            }
        }
        return !contained;
    }
}
