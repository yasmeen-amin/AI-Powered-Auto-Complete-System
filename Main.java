import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Trie trie = new Trie();
        Scanner sc = new Scanner(new File("google-10000-english.txt"));
        Scanner input = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String word = sc.nextLine().trim();

            if (!word.isEmpty()) {
                trie.insert(word);
            }

        }

        System.out.println("Hello! This is a word AI powered Auto-complete system ☆*: .｡. o(≧▽≦)o .｡.:*☆"
                + "(Which learns from you !!)\nTo start the system enter the" + " first few letters of any legit word");

        while (true) {
            String prefix = input.nextLine().toLowerCase().trim();

            if (prefix.equals("quit") || prefix.equals("exit")) {
                System.out.println("Goodbye! (❁´◡`❁)");
                break;
            }

            List<String> suggestions = trie.getSuggestions(prefix);

            if (!suggestions.isEmpty()) {

                char current = 'a';
                System.out.printf("suggested words are: ");

                for (int i = 0; i < suggestions.size() && i < 4; i++) {

                    System.out.printf("%c.%s   ", current, suggestions.get(i));
                    current++;
                }
                System.out.printf("%nPlease write your selection (example: 'a', 'b' , etc...) : ");

                String se = input.nextLine() ;
                while(se.length() != 1 || !Character.isLetter(se.charAt(0))) {

                    System.out.println("Invalid Selection (╯▔皿▔)╯!!");
                    System.out.printf("%nPlease write a correct selection (example: 'a', 'b' , etc...) : ");
                    se = input.nextLine() ;
                }
                char selected = se.charAt(0);

                String word;

                switch (selected) {

                    case 'a':
                        word = suggestions.get(0);
                        System.out.println("Selected " + word);
                        trie.updateUsage(word);
                        break;

                    case 'b':
                        if (suggestions.size() > 1) {
                            word = suggestions.get(1);
                            System.out.println("Selected " + word);
                            trie.updateUsage(word);
                        } else {
                            System.out.println("Invalid Selection (╯▔皿▔)╯!!");
                        }
                        break;

                    case 'c':
                        if (suggestions.size() > 2) {
                            word = suggestions.get(2);
                            System.out.println("Selected " + word);
                            trie.updateUsage(word);
                        } else {
                            System.out.println("Invalid Selection (╯▔皿▔)╯!!");
                        }
                        break;

                    case 'd':
                        if (suggestions.size() > 3) {
                            word = suggestions.get(3);
                            System.out.println("Selected " + word);
                            trie.updateUsage(word);
                        } else {
                            System.out.println("Invalid Selection (╯▔皿▔)╯!!");
                        }
                        break;
                    default:
                        System.out.println("Invalid Selection (╯▔皿▔)╯!!");
                        break;
                }
            }

            else {
                System.out.println("Sorry we do not have suggestions ㄟ( ▔, ▔ )ㄏ ");
            }
            System.out.println("\nRenter the first few legit letters of your word or type"
                    + " ('quit'/'exit') to exit the system");
            suggestions.clear();

        }

    }

}
