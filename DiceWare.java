import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class DiceWare {
    private List<String> lines = new ArrayList<>();

    private Map<String, String> map;

    public DiceWare() throws FileNotFoundException {
        // you may want to change the path to the file
        String fileName = "/Users/jimmy/dice";
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }

        // putting the key-value pairs into the map
        map = new HashMap<>();
        for (String line : lines) {
            String[] words = line.split(" ");
            map.put(words[0],words[1]);
            //System.out.println(Arrays.toString(words));

            // your code goes here
        }
    }

    public String generatePassword() {
        // we generate a password by
        // generating 6 codes and concatenating the 6 corresponding words
        String code;
        String word;
        String pass = "";
        for (int i = 0; i < 7; i++){
              code = generateCode();
              word = map.put(code,code);
              pass = pass + word;
        }
        // your code goes here
        return pass;
    }

    private String generateCode() {
        // each code consists of 5 digits, each digit is a number from 1 to 6
        Random number = new Random();
        int res = 0;
        for (int i = 0; i< 5; i++){
            res = res * 10 +(number.nextInt(6)+1);   //Multiply res by 10 each time in order to create the next digit of the 5 digit number
        }
        return String.valueOf(res);
        // your code goes here

    }

    public static void main(String[] args) throws FileNotFoundException {
        DiceWare diceWare = new DiceWare();
        for (int i = 0; i < 20; i++) {
            System.out.println(diceWare.generatePassword());
        }

    }
}
