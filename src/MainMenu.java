import java.util.Scanner;
public abstract class MainMenu {
    static Scanner input = new Scanner(System.in);
    static String name = "***// MAIN MENU \\\\***";
    static String elementName;
    static String elementNewName;
    static int index;
    static int destinationIndex;
    static final String ENTERNUMBER = "Enter list number: ";
    static String options = "Options: 1 Create list | 2 Consult list | 3 Rename list | 4 Delete list | 5 Move list | 0 Exit App\n";
    static final int OFFSET = 1;

    public static String mainMessage(ListManager manager) {
        return name + "\n" + options + "\n" + manager.getLists() + "\nEnter option: ";
    }

    public static String addCommand(ListManager manager){
        System.out.print("Enter list name: ");
        elementName = input.nextLine();
        System.out.println(manager.createList(elementName));
        return manager.createList(elementName);
    }

    public static int consultCommand(){
        System.out.println(ENTERNUMBER);
        index = input.nextInt() - OFFSET;
        return index;
    }

    public static String renameCommand(ListManager manager){
        System.out.print(ENTERNUMBER);
        index = input.nextInt() - OFFSET;
        System.out.print("Enter the new name for the list: ");
        elementNewName = input.nextLine();
        return manager.renameList(index, elementNewName);
    }

    public static String removeCommand(ListManager manager){
        System.out.println(ENTERNUMBER);
        index = input.nextInt() - OFFSET;
        return manager.removeList(index);
    }
    
    public static String moveCommand(ListManager manager){
        System.out.println(ENTERNUMBER);
        index = input.nextInt() - OFFSET;
        System.out.println("Enter the destination position for the list: ");
        destinationIndex = input.nextInt() - OFFSET;
        return manager.moveList(index, destinationIndex);
    }
}

