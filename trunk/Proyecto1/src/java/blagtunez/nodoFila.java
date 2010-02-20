/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package blagtunez;

/**
 *
 * @author tian
 */
public class nodoFila extends nodoHead{
    char letra;

    nodoFila(){
        
    }

    nodoFila(char c){
        setLetra(c);
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }
    

}
