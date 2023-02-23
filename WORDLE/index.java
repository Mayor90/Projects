import java.util.*;

public class index{
    public static void main(String[] args) {
        
        String word = "BSWFH";

        System.err.println("Enter a five letter word. R equals red, Y equals yellow, G equals green. You have five attempts");
        int count = 0;
        while (count < 5){
            Scanner scanner = new Scanner (System.in);
            System.out.println("Enter a five letter word");
            String input = scanner.nextLine();
            input = input.toUpperCase();
            if (input.length() != 5){
                System.out.println("Please ensure your word has five letters");
                
            }
            else {
                HashMap<Character, Integer> storage = convtoMap(word);
                String form = "GGGGG";
                String value = wordle(input, storage, word);
                System.out.println("Result: " + value);
                if (value .equals(form)) {
                    System.out.println("Congratulations, you have achieved my goal");
                    break;
                }
                count++;
            }
            
            
            
        }
        if (count == 5) {
            System.out.println("You are a failiure");
            System.out.println("The correct word is " + word);
    }
        

   
    }

    private static String wordle(String input, HashMap<Character, Integer> storage, String word) {
        String value = "";
        for(int i = 0; i < input.length(); i++){
           
            char key = input.charAt(i);
            if (!storage.containsKey(key)){
                value += "R";
            }
            else {
                int freq = storage.get(key);
                freq--;
                if (freq == 0) storage.remove(key);
                else storage.put(key, freq);
                
                if (input.charAt(i) == word.charAt(i)) value += "G";
                else value += "Y";
            }
        }
        return value;
    }

    private static HashMap<Character, Integer> convtoMap(String word) {
        HashMap<Character, Integer> storage = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            char key = word.charAt(i);
            if (!storage.containsKey(word.charAt(i))){
                storage.put(key, 1);
            }
            else {
                int freq = storage.get(key);
                freq++;
                storage.put(key, freq);

            }
        }
        return storage;
    }

}