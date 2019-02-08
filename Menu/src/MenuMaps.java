import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuMaps {

    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;

    public MenuMaps(){
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();
        menu.put("1", "method1");
        menu.put("2", "method2");
        menu.put("3", "method3");
        menu.put("4", "method4");
        menu.put("Q", "quit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("1", this::method1);
        methodsMenu.put("2", this::method2);
        methodsMenu.put("3", this::method3);
        methodsMenu.put("4", this::method4);

    }


    private void printMenu(){
        System.out.println("\nMENU:\n");
        for (String s : menu.values())
            System.out.println(s);
    }

    public void show(){
        String keyMenu;
        Scanner sc = new Scanner(System.in);
        printMenu();
        do{
            keyMenu = sc.nextLine().toUpperCase();
            try{
                methodsMenu.get(keyMenu).print();
            }catch (Exception e) {}
        } while (!keyMenu.equals("Q"));
    }


    public void method1(){
        System.out.println("ACTION1");
    }
    public void method2(){
        System.out.println("ACTION2");
    }
    public void method3(){
        System.out.println("ACTION3");
    }
    public void method4(){
        System.out.println("ACTION4");
    }


}

@FunctionalInterface
interface Printable {
    void print();
}