import java.util.ArrayList;

public class MyList {
    private String name;
    ArrayList<String> items = new ArrayList<>();

    //name: rename
    //items: add , rename, delete
    public MyList(String name) {
        this.name=name;
    }

    public void renameList(String newName){
        this.name = newName;
    }

    @Override
    public String toString(){
        return this.name;
    }
    
    public void addItem(String itemName){
        this.items.add(itemName);
    }

    public void addItem(String itemName, int index){
        this.items.add(index, itemName);
    }

    public void renameItem(int index, String newName){
        this.items.remove(index);
        this.items.add(index, newName);
    }

    public void moveItem(int index , int destinationIndex){
        String itemToMove = this.items.get(index);
        final int OFFSET = 1;

        if(destinationIndex > index){
            this.items.add(destinationIndex + OFFSET, itemToMove);
            this.items.remove(index);
        }else {
            this.items.add(destinationIndex, itemToMove);
            this.items.remove(index + OFFSET);
        }
    }

    public void removeItem(int index){
        this.items.remove(index);
    }

    public String itemString(){
        int n = 1;
        String stringOfItems = "";
        for(String item : items){
            stringOfItems+= (n++) + ". " + item + "\n";
        }
        return stringOfItems;
    }
}
