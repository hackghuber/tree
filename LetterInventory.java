import java.util.ArrayList;

public class LetterInventory {
    private ArrayList<Integer> inventory = new ArrayList<>();
    private int size;
    public LetterInventory(String data){     // constructor
        char [] new_data=data.toLowerCase().toCharArray();
        for(char i='a'-1;i<'z';i++) {
            int num = 0;
            for (char newDatum : new_data) {
                if (newDatum == i) {
                    num++;
                    size++;// default size is 0
                    inventory.add(num);
                }
            }
        }
    }public int get(char letter) throws IllegalArgumentException{
        return inventory.get((letter-'a'));

    }public void set(char letter,int value) throws IllegalArgumentException {
        inventory.set(letter-'a',value);
    }public int size(){
       return size;
    }public boolean isEmpty(){
        return size==0;
    }public String toString(){
        StringBuilder result = new StringBuilder("[");
        for (int i=0;i<26;i++){
            for (int j=0;j<inventory.get(i);j++){
                result.append((char) i + 97);
            }
        }result.append("]");
        return result.toString();
    }public LetterInventory add(LetterInventory other){
        LetterInventory result = new LetterInventory("");
        for (int i=0;i<26;i++){
            result.set((char) (i+97),this.get((char) (i+97))+other.get((char) (i+97)));
        }return result;
    }public LetterInventory subtract(LetterInventory other){
        LetterInventory result = new LetterInventory("");
        for (int i=0;i<26;i++){
            if (this.get((char) (i+97))-other.get((char) (i+97))<0){
                size=0;
                return null;
            }else{
            result.set((char) (i+97),this.get((char) (i+97))-other.get((char) (i+97)));
            }
        }return result;
    }

}
