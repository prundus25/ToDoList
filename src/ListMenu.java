import java.util.Scanner;
public abstract class ListMenu {
    static Scanner input = new Scanner(System.in);
    static String name = "***// LIST MENU \\\\***";
    static String elementName;
    static String elementNewName;
    static int itemIndex;
    static final String ENTERNUMBER = "Enter item number: ";
    static String options = "Options: 1 Add item | 2 Rename item | 3 Delete item | 4 Move item | 0 Exit to Main Menu\n";
    static final int OFFSET = 1;

    public static String mainMessage(ListManager manager, int listIndex) {
        return name + "\n" + options + "\n" + manager.getList(listIndex) + "\nEnter option: ";
    }

    public static String addCommand(ListManager manager, int listIndex){
        System.out.print("Enter item name: ");
        elementName = input.nextLine();
        return manager.lists.get(listIndex).addItem(elementName);
    }

    public static String renameCommand(ListManager manager, int listIndex){
        System.out.println(ENTERNUMBER);
        itemIndex = input.nextInt() - OFFSET ;
        input.skip("\n");
        System.out.println("Enter a new name: ");
        elementNewName = input.nextLine();
        return manager.lists.get(listIndex).renameItem(itemIndex, elementNewName);
    }

    public static String removeCommand(ListManager manager, int listIndex){
        System.out.println(ENTERNUMBER);
        itemIndex = input.nextInt() - OFFSET ;
        return manager.lists.get(listIndex).removeItem(itemIndex);
    }
    
    public static String moveCommand(ListManager manager, int listIndex){
        System.out.println(ENTERNUMBER);
        itemIndex = input.nextInt() - OFFSET ;
        System.out.println("Enter the destination position for the item: ");
        int destinationIndex = input.nextInt() - OFFSET ;
        return manager.lists.get(listIndex).moveItem(itemIndex, destinationIndex);
    }
}
