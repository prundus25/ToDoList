
//create list object, rename, delete
//import java.util.List;

import java.util.ArrayList;

public class ListManager {
   ArrayList<MyList> lists = new ArrayList<>();
   
   public String createList(String name){
      if(isNameValid(name)){lists.add(new MyList(name)); return "List \"" + name + "\" created.";}
      else return "List already exists";
   }

   public String createList(String name, int index){
      if(isNameValid(name)){lists.add(index, new MyList(name)); return "List created.";}
      else return "List already exists";
   }

   public void moveList(int index , int destinationIndex){
      MyList listToMove = lists.get(index);
      final int OFFSET = 1;

      if(destinationIndex > index){
         lists.add(destinationIndex + OFFSET, listToMove);
         lists.remove(index);
      }else {
         lists.add(destinationIndex, listToMove);
         lists.remove(index + OFFSET);
      }  
   }

   public String getLists(){
      int n = 1;
      String stringOfLists="Your lists are:\n***************\n";

      for(MyList list : lists){
         stringOfLists += (n++) + ". " + list + "\n";
      }
      return stringOfLists;
   }

   public String getList(int index){
      String listName = lists.get(index).toString();
      return "Items from list \"" + listName + "\":\n" + lists.get(index).itemString();
   }

   public boolean isNameValid(String name){
      return !lists.toString().contains(name);
   }

   public void renameList(int index, String newName){
      lists.get(index).renameList(newName);
   }
}
