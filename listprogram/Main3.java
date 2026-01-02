package listprogram;

import java.util.Scanner;
public class Main3 {
    public static void main(String[] args){        
        Scanner input = new Scanner(System.in);
        ListManager manager = new ListManager();
        int option;
        int option2;
        final String SEPARATOR2 = "*******************************";
        int listIndex;

        while (true) {
            System.out.println(MainMenu.mainMessage(manager));
            option = input.nextInt();
            if (option == 0) {System.out.println("Exiting...");break;}
            else if (option == 2){
                listIndex = MainMenu.consultCommand();
                while (true){
                    System.out.println(ListMenu.mainMessage(manager, listIndex));
                    option2 = input.nextInt();
                    System.out.println(SEPARATOR2);
                    if (option2 == 0) break;
                    else System.out.println(Maps.listMenu(manager, option2, listIndex));
                    System.out.println(SEPARATOR2+"\n\n\n");
                }
            }else{
                System.out.println(SEPARATOR2);
                System.out.println(Maps.mainMenu(manager, option));
                System.out.println(SEPARATOR2+"\n\n\n");
            }
        }
    }
}
