import java.util.Scanner;
public class Main {
    public static void main(String[] args){        
        Scanner input = new Scanner(System.in);
        ListMaker maker = new ListMaker();
        int option;
        String separator = "===============================";
        
        while(true){
            System.out.println("|| MAIN MENU ||");
            System.out.println(maker.getLists());
            System.out.println(("\nOptions:\n0 -> Exit.\n1. Create list\n2. Consult list\n3. Rename list\n4. Delete list"));
            option=input.nextInt();
            
            if (option == 0){ System.out.println("Exiting..."); break;}
            System.out.println(separator);

            switch(option){
                case 1 -> maker.createList();
                case 2 -> {// menu with: add item, remove item, rename item
                    int listNr = maker.listNames.size()+1;
                    while(!maker.isListNrCorrect(listNr)){
                        System.out.println(ListMaker.ENTER);
                        listNr = input.nextInt();
                    }

                    while (true) {
                        System.out.println("|| LIST MENU ||");
                        System.out.println(maker.getItems(listNr-1));
                        System.out.println(("\nOptions:\n0 -> Return to main menu.\n1. Add item\n2. Remove item\n3. Rename item"));
                        option=input.nextInt();
                        input.skip("\n");
                        if (option == 0)break;
                        System.out.println(separator);

                        switch(option){
                            case 1 -> maker.addItem(listNr-1);
                            case 2 -> maker.deleteItem(listNr-1);
                            case 3 -> maker.renameItem(listNr-1);
                            default -> System.out.println("Wrong option number.");
                        }
                    } 
                } 
                case 3 -> maker.renameList();
                case 4 -> maker.deleteList();

                default -> System.out.println("Wrong option number.");
            }
            System.out.println(separator);
        }
    }
}