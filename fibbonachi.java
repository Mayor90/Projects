import java.util.HashMap;

/* Given a number n, Calculate the nth fibonacci number*/

public class fibbonachi {
    public static void main(String[] args) {
        HashMap<Integer, Integer> value = new HashMap<>();
        for(int i = 0; i < 10; i++){
            System.out.println(fib(i, value));
        }
    }
     static int fib(int n, HashMap<Integer, Integer> value){
        if(value.containsKey(n)) return value.get(n);
        if(n <= 0) return 0;
        if (n == 1 || n == 2){
            return 1;
        }
         value.put(n, (fib(n - 1, value) + fib(n - 2, value)));
         return value.get(n);
    }
}

    