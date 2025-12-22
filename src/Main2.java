import java.util.Scanner;
public class Main2 {
    static ListManager manager = new ListManager();
    public static void main(String[] args){        
        Scanner input = new Scanner(System.in);
        int option;
        int option2;
        final String SEPARATOR = "===============================";
        final String SEPARATOR2 = "*******************************";
        int listIndex;
        int index;

        // while (exit function is false)
        //      execute main menu function
        //

        while (true) {
            String name;
            String newName;
            System.out.print(MainMenu.mainMessage(manager));
            option = input.nextInt();
            input.skip("\n");
            if (option == 0){System.out.println("Exiting..."); break;}

            System.out.println(SEPARATOR2);
            switch(option){
                case 1 -> {
                    System.out.println(MainMenu.addCommand(manager));
                }
                case 2 -> {
                    System.out.println("Enter list number: ");
                    index = input.nextInt()-1;
                    int itemIndex;
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
                                itemIndex = input.nextInt()-1;
                                input.skip("\n");
                                System.out.println("Enter a new name: ");
                                newName = input.nextLine();
                                manager.lists.get(index).renameItem(itemIndex, newName);
                            }
                            case 3 ->{
                                System.out.println("Enter item number: ");
                                itemIndex = input.nextInt()-1;
                                manager.lists.get(index).removeItem(itemIndex);
                            }
                            case 4 ->{
                                System.out.println("Enter item number: ");
                                itemIndex = input.nextInt()-1;
                                System.out.println("Enter the destination position for the item: ");
                                int destinationIndex = input.nextInt()-1;
                                manager.lists.get(index).moveItem(itemIndex, destinationIndex);
                            }
                            default -> System.out.println("Invalid option.");
                        }
                        System.out.println(SEPARATOR2);
                        System.out.println("\n\n");
                    }
                    
                }
                case 3 -> {
                    System.out.println(MainMenu.renameCommand(manager));
                }
                case 4 -> {
                    System.out.println(MainMenu.removeCommand(manager));
                }
                case 5 -> {
                    System.out.println(MainMenu.moveCommand(manager));
                }
                default -> System.out.println("Invalid option.");
            }
            System.out.println(SEPARATOR2);
            System.out.println("\n\n");
        }
    } 
}