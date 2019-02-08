public class Main {

    static public void main(String ... args){
        BinaryTree<String, String> map = new BinaryTree<>();

        map.put("1rgt","hello");
        map.put("df;l,2", "world");
        map.put("2dofg", "world1");
        map.put("248hwi", "world2");
        map.put("112rwef", "world3");


        System.out.println(map.size());
        System.out.println(map);


        map.remove("248hwi");

        System.out.println(map.size());
        System.out.println(map);
    }
}
