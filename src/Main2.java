import java.util.Scanner;
public class Main2 {
    public static void main(String[] args){        
        Scanner input = new Scanner(System.in);
        int option;
        final String SEPARATOR = "===============================";
        final String SEPARATOR2 = "*******************************";
        ListManager manager = new ListManager();

        manager.createList("compra");
        manager.createList("compra2");
        manager.createList("compra3");
        manager.createList("compra4");

        manager.lists.get(0).addItem("cosa1");
        manager.lists.get(1).addItem("cosa2");
        manager.lists.get(2).addItem("cosa3");
        manager.lists.get(3).addItem("cosa4");


        System.out.println(manager.getLists());
        manager.moveList(3, 1);
        System.out.println(manager.getLists());

        System.out.println(manager.getList(1));
        System.out.println(manager.getList(3));
    }
}