import java.util.Scanner;
public class Main {
    public static void main(String[] args){        
        Scanner input = new Scanner(System.in);
        //List toDoList = new List("To Do");
        //List shopping = new List("Shopping");
        ListMaker maker = new ListMaker();
        int option;
        int listNr;
        
        System.out.println("|| MAIN MENU ||");
        ListMaker.getLists();
        System.out.println(("\nOptions:\n1. Create list\n2. Consult list\n3. Modify list\n4. Delete list"));
        option=input.nextInt();
        

        switch(option){
            case 1 -> maker.createList();
            case 2 -> {
                System.out.println("Enter list number to consult: ");
                listNr = input.nextInt();
                //maker.getItems(String.valueOf())
            }
        }
    }
}