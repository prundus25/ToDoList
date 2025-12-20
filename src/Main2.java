import java.util.Scanner;
public class Main2 {
    public static void main(String[] args){        
        Scanner input = new Scanner(System.in);
        int option;
        final String SEPARATOR = "===============================";
        final String SEPARATOR2 = "*******************************";
        ListManager manager = new ListManager();

        // while (exit function is false)
        //      execute main menu function
        //

        while (true) {
            String name;
            int index;
            String newName;
            System.out.println("***// MAIN MENU \\\\*** ");
            System.out.println("Options: 1 Create list | 2 Consult list | 3 Rename list | 4 Delete list | 5 Move list | 0 Exit App\n");
            System.out.println(manager.getLists());
            System.out.print("Enter option: ");
            option = input.nextInt();
            input.skip("\n");
            if (option == 0){System.out.println("Exiting..."); break;}

            System.out.println(SEPARATOR2);
            switch(option){
                case 1 -> {
                    System.out.print("Enter the name of the list: ");
                    name = input.nextLine();
                    manager.createList(name);
                }
                case 2 -> {
                    System.out.println("Enter list number: ");
                    index = input.nextInt()-1;

                    System.out.println(SEPARATOR2);
                    System.out.println("\n\n");
                    while (true) { 
                        System.out.println("***// LIST MENU \\\\*** ");
                        System.out.println("Options: 1 Add item | 2 Rename item | 3 Delete item | 4 Move item | 0 Exit to Main Menu\n");
                        System.out.println(manager.getList(index)); 
                        System.out.print("Enter option: ");
                        option = input.nextInt();
                        input.skip("\n");
                        if (option == 0){System.out.println("Exiting..."); break;}

                        System.out.println(SEPARATOR2);
                        switch(option){
                            case 1 -> {
                                System.out.print("Enter item name: ");
                                name = input.nextLine();
                                manager.lists.get(index).addItem(name);
                            }
                            case 2 -> {
                                System.out.println("Enter item number: ");
                                index = input.nextInt()-1;
                                input.skip("\n");
                                System.out.println("Enter a new name: ");
                                newName = input.nextLine();
                                manager.lists.get(index).renameItem(index, newName);
                            }
                            case 3 ->{
                                System.out.println("Enter item number: ");
                                index = input.nextInt()-1;
                                manager.lists.get(index).removeItem(index);
                            }
                            case 4 ->{
                                System.out.println("Enter item number: ");
                                index = input.nextInt()-1;
                                System.out.println("Enter the destination of the item: ");
                                int destinationIndex = input.nextInt()-1;
                                manager.lists.get(index).moveItem(index, destinationIndex);
                            }
                            default -> System.out.println("Invalid option.");
                        }
                        System.out.println(SEPARATOR2);
                        System.out.println("\n\n");
                    }
                    
                }
                case 3 -> {
                    System.out.println("Enter list number: ");
                    index = input.nextInt()-1;
                    System.out.println("Enter the new name for the list: ");
                    newName = input.nextLine();
                    manager.renameList(index, newName);
                }
                case 4 -> {
                    System.out.println("Enter list number: ");
                    index = input.nextInt()-1;
                    manager.removeList(index);
                }
                case 5 -> {
                    System.out.println("Enter list number: ");
                    index = input.nextInt()-1;
                    System.out.println("Enter the destination of the list: ");
                    int destinationIndex = input.nextInt()-1;
                    manager.moveList(index, destinationIndex);
                }
                default -> System.out.println("Invalid option.");
            }
            System.out.println(SEPARATOR2);
            System.out.println("\n\n");
        }
    } 
}