import java.util.ArrayList;
import java.util.Scanner;
public class ListMaker {
    Scanner input = new Scanner(System.in);
    static ArrayList<String> lists = new ArrayList<>();
    String name;

    public ListMaker() {
        
    }

    public static String getLists(){
        String listString = buildString(lists, false);

        return (lists.isEmpty()) ? "You currently have no lists." : "You currently have " + lists.size() + " list(s):\n"+listString;
    }

    public void createList(){
        System.out.println("Enter the name of the list: ");
        this.name = input.nextLine();
        boolean alreadyExists=false;
        if (!lists.isEmpty()){
            //Object[] listsArray = lists.toArray();
            for (String element : lists) {
                if (element.equalsIgnoreCase(name)) alreadyExists = true;
            }
        }
        if (alreadyExists) System.out.println("List already exists.");
        else {
            lists.add(this.name);
            ArrayList<String> name = new ArrayList<>();
        }
    }

    public String getItems(ArrayList<String> list){
        /* 
        Object[] itemsArray = list.toArray();
        StringBuilder bld = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            bld.append(String.valueOf(i+1));
            bld.append(". ");
            bld.append(itemsArray[i]);
            bld.append("\n");
        }
        String itemString = bld.toString();
        */
        System.out.println(name);
        String itemString = buildString(list, true);
        return (list.isEmpty()) ? "The list is empty." : itemString;
    }

    private static String buildString(ArrayList<String> list, boolean isItemList){
        //Object[] array = list.toArray();
        StringBuilder bld = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            bld.append(i+1).append(". ").append(list.get(i));
            if(isItemList) bld.append("\n");
            else if (i != list.size()-1)bld.append(" ; ");
        }
        return bld.toString();
    }
    
}
