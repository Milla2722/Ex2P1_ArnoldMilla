package ex2p1_arnoldmilla;
import java.util.*;


public class Items {
    String Nombre;
    int HPpoints, MPpoints;
    
    public Items(){
    }
    
    public Items(String nombre, int HP, int MP){
        this.Nombre = nombre;
        this.HPpoints = HP;
        this.MPpoints = MP;
    }
    
    @Override
    public String toString(){
        return Nombre + " = " + HPpoints + " HP, " + MPpoints + " MP \n";
    }
}
