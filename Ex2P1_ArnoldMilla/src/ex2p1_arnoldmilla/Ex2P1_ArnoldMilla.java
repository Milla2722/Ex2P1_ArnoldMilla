package ex2p1_arnoldmilla;
import java.util.*;


public class Ex2P1_ArnoldMilla {
static Scanner sc = new Scanner(System.in);
static Random rand = new Random();
static Personaje CHAR = new Personaje();
static Items OBJ = new Items();
    ////////////////////fila 2 silla 10

    //////////////////sout  todo esta bien menos los calculos de defensa, que en teoría deberían de estar bien pero noh
    ////////////////// por esta razon, goofy es inmortal!!!
    
    public static void main(String[] args) {
        char continuar = 's';
        int cuartos = 4;
        int contador = 0;
        int Hpeartles = 75;
        int Ateartles = 25;
        String nombre;
        int hp, mp, atkp, defp;
        ArrayList<Integer> stats = new ArrayList<Integer>();
        
        ArrayList<Personaje> Party = new ArrayList<Personaje>();
        Personaje p1 = new Personaje("Sora", 300, 300, 75, 15);
        Party.add(p1);
        p1 = new Personaje("Donald", 150, 450, 45, 10);
        Party.add(p1);
        p1 = new Personaje("Goofy", 450, 100, 150, 50);
        Party.add(p1); 
        
        ArrayList<Personaje> Reserve = new ArrayList<Personaje>();
        p1 = new Personaje("Mickey", 100, 500, 150, 35);
        Reserve.add(p1);
        p1 = new Personaje("Roxas", 300, 300, 15, 75);
        Reserve.add(p1);
        p1 = new Personaje("Kairi", 200, 200, 50, 15);
        Reserve.add(p1);
            
        ArrayList<Items> Items = new ArrayList<Items>();
        Items I1 = new Items("Pocion", 50, 0);
        Items.add(I1);
        Items I2 = new Items("Ether", 0, 50);
        Items.add(I2);
        Items I3 = new Items("Elixir", 100, 100);
        Items.add(I3);
        
        int Cpersonajes = 3;
        while (contador < cuartos ){       
            
            while (continuar == 's' || continuar == 'S'){
                System.out.println("Ha entrado al cuarto " + (contador+1));
                int event = rand.nextInt(1,6);            
                System.out.println("");
                
                
                switch(event){
                    case 1:{
                        //encuentro con los heartless
                        int cantH = rand.nextInt(1,4); 
                        System.out.println("Te has encontrado " + cantH + " Heartless!");
                        int Heartlesses = cantH * Hpeartles; ////////hp de los heartless en total
                        int AHeartlesses = cantH * Ateartles; /////// atk de los heartless sumados
                        
                        while (Heartlesses > 0 && Cpersonajes > 0){                                                      
                            System.out.println("0.- " + Party.get(0).toString());
                            //imprimiendo estadisticas del personaje
                            stats = CHAR.Stats(Party.get(0).toString());
                            
                            System.out.println("1.- " + Party.get(1).toString());
                            //imprimiendo estadisticas del personaje
                            stats = CHAR.Stats(Party.get(0).toString());
                            
                            System.out.println("2.- " + Party.get(2).toString());
                            //imprimiendo estadisticas del personaje
                            stats = CHAR.Stats(Party.get(0).toString());
                            System.out.println("");                           
                            
                            System.out.println("Elije un personaje ");
                            int personaje = sc.nextInt();
                            
                            String character = Party.get(personaje).Nombre;
                            System.out.println(character);
                            
                            System.out.println("-----Menu----");
                            System.out.println("1. - Attack");
                            System.out.println("2. - Magic");
                            System.out.println("3. - Items");
                            System.out.println("4. - Party");
                            int accion = sc.nextInt();
                        
                            switch(accion){
                                case 1:{
                                    ///atks fisicos
                                    for (int cont = 0; cont < Party.size(); cont++){
                                        if (character.equals(Party.get(cont).Nombre)){
                                            int dmg = Party.get(cont).AttackPoints;
                                            Heartlesses = Heartlesses - dmg;
                                            int mana = Party.get(cont).MP;
                                            double df2 = Party.get(cont).DefensePoints;
                                            double df = (Party.get(cont).DefensePoints) / 100;
                                            int vida = (int) Math.round((Party.get(cont).HP) - (AHeartlesses * df));                                            
                                            Personaje p2 = new Personaje(character, vida, mana, dmg, df2);
                                            Party.set(cont, p2);
                                            System.out.println(character + " ha Atacado!");
                                            if (Heartlesses < 0){
                                                Heartlesses = 0;
                                            }
                                            if(cantH > 1){
                                                System.out.println("Los Heartless han atacado!");
                                                System.out.println("Los Heartles les queda: " + Heartlesses);
                                            }
                                            else{
                                                System.out.println("El Heartles ha atacado!");
                                                System.out.println("Al Heartless le queda " + Heartlesses);
                                            }
                                            System.out.println("");
                                            break;
                                        }
                                    }
                                }break;
                            
                                case 2:{
                                    /////atks magicos
                                    int daño = 0;
                                    for (int cont = 0; cont < Party.size(); cont++) {
                                       if (character.equals(Party.get(cont).Nombre)){
                                       int mana = Party.get(cont).MP; 
                                            if (mana > 0){
                                                int dmg = Party.get(cont).AttackPoints;
                                                double df2 = Party.get(cont).DefensePoints;
                                                double df = (Party.get(cont).DefensePoints) / 100;
                                                System.out.println("1. Blizzard 50MP - 50DMG");
                                                System.out.println("2. Firaga   25MP - 25DMG");
                                                System.out.println("3. Gravity  75MP - 100DMG");
                                                int magia = sc.nextInt();
                                                if (magia == 1){
                                                    System.out.println(character + " uso Blizzard");
                                                    mana = mana - 50;
                                                    daño = 50;
                                                }
                                                else if (magia == 2){
                                                    System.out.println(character + " uso Firaga");
                                                    mana = mana - 25;
                                                    daño = 25;
                                                }
                                                else if (magia == 3){
                                                    System.out.println(character + " uso Gravity");
                                                    mana = mana - 75;
                                                    daño = 100;
                                                }
                                                else{
                                                    System.out.println("Opcion equivocada");
                                                    break;
                                                }
                                                Heartlesses = Heartlesses - daño;
                                                
                                                if (Heartlesses < 0){
                                                    Heartlesses = 0;
                                                }
                                                if(mana < 0){
                                                    mana = 0;
                                                }
                                                int vida = (int) Math.round((Party.get(cont).HP) - (AHeartlesses * df));                                           
                                                Personaje p2 = new Personaje(character, vida, mana, dmg, df2);
                                                Party.set(cont, p2);
                                                if(cantH > 1){
                                                    System.out.println("Los Heartless han atacado!");
                                                    System.out.println("Los Heartles les queda: " + Heartlesses);
                                                }
                                                else{
                                                    System.out.println("El Heartles ha atacado!");
                                                    System.out.println("Al Heartless le queda " + Heartlesses);
                                                }
                                                System.out.println("");
                                            }
                                            else{
                                                System.out.println("No tiene mana para atacar");
                                                System.out.println("");
                                            }
                                        break;
                                       }
                                    }
                                }break;
                            
                                case 3:{
                                    //////utilizar items
                                    for (int cont = 0; cont < Party.size(); cont++) {                                        
                                        if (character.equals(Party.get(cont).Nombre)){
                                            for (int tnoc = 0; tnoc < Items.size(); tnoc++) {
                                                System.out.println(tnoc + ".- " + Items.get(tnoc).toString());
                                                if (Items.size() == 0){
                                                    break;
                                                }
                                            }
                                            System.out.println("Elige un item: ");
                                            
                                            double df2 = Party.get(cont).DefensePoints;
                                            double df = (Party.get(cont).DefensePoints) / 100;
                                            
                                            int item = sc.nextInt();
                                            int Mp = Items.get(item).MPpoints;
                                            int mana = Party.get(cont).MP + Mp; 
                                            
                                            int Hp = Items.get(item).HPpoints;                                           
                                            
                                            Items.remove(item);
                                            
                                            int vida = (int) Math.round((Party.get(cont).HP) - (AHeartlesses * df) + Hp);                                                                                                                                   
                                            int dmg = Party.get(cont).AttackPoints;
                                                                                       
                                            Personaje p2 = new Personaje(character, vida, mana, dmg, df2);
                                            Party.set(cont, p2);
                                        }
                                        if (Items.size() == 0){
                                            System.out.println("");
                                            System.out.println("Te has quedado sin items");
                                            break;
                                        }
                                    }
                                    System.out.println("");
                                }break;
                            
                                case 4:{
                                    ///// sustitucion de personaje en equipo
                                    //////No me dio tiempo por arreglar una exception en el caso de arriba
                                }break;
                            }
                        }
                        
                       
                    }break;
                    
                    case 2:{
                        //cofre con una pocion
                        System.out.println("Te has encontrado un cofre con una pocion");
                        Items.add(I1);
                        for (int cont = 0; cont < Items.size(); cont++) {
                            System.out.println(cont + ".- " + Items.get(cont).toString());
                        }
                    }break;
                    
                    case 3:{
                        //cofre con un ether
                        System.out.println("Te has encontrado un cofre con un ether");
                        Items.add(I2);
                        for (int cont = 0; cont < Items.size(); cont++) {
                            System.out.println(cont + ".- " + Items.get(cont).toString());
                        }
                    }break;
                    
                    case 4:{
                        //cofre con un elixir
                        System.out.println("Te has encontrado un cofre con un elixir");
                        Items.add(I3);
                        for (int cont = 0; cont < Items.size(); cont++) {
                            System.out.println(cont + ".- " + Items.get(cont).toString());
                        }
                    }break;
                    
                    case 5:{
                        //salen amigos que te roban items
                        System.out.println("Te has encontrado amigos que ocupan te ayuda y te ofreces a ayudar con un item");
                        Items.remove(0);
                        for (int cont = 0; cont < Items.size(); cont++) {
                            System.out.println(cont + ".- " + Items.get(cont).toString());
                        }
                    }break;
                }
                System.out.println("Desea continuar? [s/n]");
                continuar = sc.next().charAt(0); 
                if (continuar == 's' || continuar == 'S'){
                    contador++;
                    break;
                }
            }   
           if (continuar != 's' && continuar != 'S'){
               break;
           }    
        }
    }
    
}
