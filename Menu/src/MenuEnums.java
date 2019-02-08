import java.awt.*;
import java.util.Scanner;

public class MenuEnums {

    public void printMenu(){
        System.out.println("Menu: ");
        for ( MenuPosition m : MenuPosition.values())
            System.out.println(m);
    }

    public void show(){
        String keyMenu;
        Scanner sc = new Scanner(System.in);
        printMenu();
        do{
            keyMenu = sc.nextLine().toUpperCase();
            try{
                MenuPosition.get(keyMenu).getPrintable().print();
            }catch (Exception e) {}
        } while (!keyMenu.equals("Q"));
    }

}


enum MenuPosition{
    METHOD1("1",MenuPosition::myMethod1),
    METHOD2("2",MenuPosition::myMethod2),
    METHOD3("3",MenuPosition::myMethod3),
    METHOD4("4",MenuPosition::myMethod4);

    private String character;
    private Printable printable;

    MenuPosition(String c, Printable p){
        character = c;
        printable = p;
    }

    static void myMethod1(){
        System.out.println("myMethod1");
    }
    static void myMethod2(){
        System.out.println("myMethod1");
    }
    static void myMethod3(){
        System.out.println("myMethod1");
    }
    static void myMethod4(){
        System.out.println("myMethod1");
    }

    public Printable getPrintable() {
        return printable;
    }

    public String getCharacter() {
        return character;
    }

    static public MenuPosition get(String key){
        for (MenuPosition temp : MenuPosition.values()) {
            if (temp.getCharacter().equals(key)) return temp;
        }
        return null;

    }
}