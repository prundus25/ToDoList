import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class ListMaker {
    Scanner input = new Scanner(System.in);
    ArrayList<ArrayList<String>> lists = new ArrayList<>();
    String name;
    ArrayList<String> listNames = new ArrayList<>();
    
    static final String ENTER = "Enter the list's number: ";
    int listNr;

    public String getLists(){
        String listString = buildString(listNames);
        return (lists.isEmpty()) ? "You currently have no lists." : "You currently have " + lists.size() + " list(s):\n"+listString;
    }

    public void createList(){
        boolean alreadyExists=true;
        while(alreadyExists){
            System.out.println("Enter the name of the list: ");
            this.name = input.nextLine();
            alreadyExists=false;

            Iterator<String> namesIterator = listNames.iterator();
            while(namesIterator.hasNext()){
                String element = namesIterator.next();
                if(element.equalsIgnoreCase(name)) alreadyExists = true;
            }

            if (alreadyExists) System.out.println("List already exists.");
        }
        
        listNames.add(name);
        ArrayList<String> newList = new ArrayList<>();
        lists.add(newList);
    }

    public void deleteList(){
        if(listNames.isEmpty()){
            System.out.println("No lists to delete.");
        }else{
            int listNr = listNames.size()+1;
            while(!isListNrCorrect(listNr)){
                System.out.println(ENTER);
                listNr = input.nextInt();
            }
            listNames.remove(listNr-1);
            lists.remove(listNr-1);
        }
    }

    public void renameList(){
        int listNr = listNames.size()+1;
        while(!isListNrCorrect(listNr)){
            System.out.println(ENTER);
            listNr = input.nextInt();
        }
        input.nextLine();
        System.out.println("Enter new list name: ");
        String newName = input.nextLine();
        listNr-=1;
        listNames.remove(listNr);
        listNames.add(listNr, newName);
    }

    public String getItems(int listNr){
        String itemList = buildString(lists.get(listNr));
        return (lists.get(listNr).isEmpty()) ? "The list is empty." : listNames.get(listNr)+":\n"+itemList;
    }

    public void addItem(int listNr){
        System.out.println("Enter name of item: ");
        String item = input.nextLine();
        
        int itemPos=-1;
        
        if (lists.get(listNr).isEmpty()){
            lists.get(listNr).add(item);
        }else {
            while(itemPos<0 || itemPos > lists.get(listNr).size()+1){
            System.out.println("Enter position (number) for the new item. Enter 0 for default (add to the end).");
            itemPos = input.nextInt();
            input.nextLine();
        }
            itemPos-=1;
            lists.get(listNr).add(itemPos, item);
        }
    }

    public void deleteItem(int listNr){
        if(lists.get(listNr).isEmpty()){
            System.out.println("No lists to delete.");
        }else{
            int itemNr = lists.get(listNr).size()+1;
            while(itemNr<1 || itemNr > lists.get(listNr).size()){
                System.out.println("Enter item number: ");
                itemNr = input.nextInt();
                input.skip("\n");
            }
            itemNr--;
            lists.get(listNr).remove(itemNr);
        }
    }

    public void renameItem(int listNr){
        if(lists.get(listNr).isEmpty()){
            System.out.println("No items to rename.");
        }else{
            int itemNr = lists.get(listNr).size()+1;
            while(itemNr<1 || itemNr > lists.get(listNr).size()){
                System.out.println("Enter item number: ");
                itemNr = input.nextInt();
            }
            input.nextLine();
            System.out.println("Enter new item name: ");
            String newItemName = input.nextLine();
            itemNr--;
            lists.get(listNr).remove(itemNr);
            lists.get(listNr).add(itemNr, newItemName);
        }
    }

    private static String buildString(ArrayList<String> list){
        StringBuilder bld = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            bld.append(i+1).append(". ").append(list.get(i));
            bld.append("\n");
        }
        return bld.toString();
    }

    boolean isListNrCorrect(int listNr){
        return (listNr >= 1 && listNr <= listNames.size());
    } 
}
