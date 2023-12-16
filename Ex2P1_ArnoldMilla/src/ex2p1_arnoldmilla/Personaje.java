package ex2p1_arnoldmilla;
import java.util.*;

public class Personaje {
    String Nombre = "";
    int HP, MP, AttackPoints; 
    double DefensePoints;

    public Personaje() {
    }
    
    public Personaje(String nombre, int hp, int mp, int atkp, double defp) {
        this.Nombre = nombre;
        this.HP = hp;
        this.MP = mp;
        this.AttackPoints = atkp;
        this.DefensePoints = defp;
    }
    
    @Override
    public String toString(){
        return Nombre + " = " + HP + " HP, \n" + MP + " MP, \n" + AttackPoints + " Attack, \n" + DefensePoints + " Defense\n";
    }
    public String getNombre(String character) {
        return Nombre;
    }

    public void setNombre(String character) {
        this.Nombre = character;
    }
    
    public ArrayList<Integer> Stats (String name){
        int hp = 0;
        int mp = 0;
        int atk = 0;
        int def = 0;
        
        ArrayList<Integer> stats = new ArrayList<Integer>();
        switch(name){
            case "Sora":{
                hp = 300;
                mp = 300;
                atk = 75;
                def = 15;                            
            }break;
            
            case "Donald":{
                hp = 150;
                mp = 450;
                atk = 45;
                def = 10;
            }break;
            
            case "Goofy":{
                hp = 450;
                mp = 100;
                atk = 150;
                def = 50;
            }break;
            
            case "Mickey":{
                hp = 100;
                mp = 500;
                atk = 150;
                def = 35;
            }break;
            
            case "Roxas":{
                hp = 300;
                mp = 300;
                atk = 15;
                def = 75;
            }break;
            
            case "Kairi":{
                hp = 200;
                mp = 200;
                atk = 50;
                def = 15;
            }break;
        }
        return stats;
    }
    
}
