import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ComplexityTest {
	
	public static void main(String[] atgs) throws FileNotFoundException {
		Trie trie = new Trie() ;
		Scanner sc = new Scanner(new File("google-10000-english.txt"));
		
		while (sc.hasNextLine()) {
			String word = sc.nextLine().trim();

			if (!word.isEmpty()) {
				trie.insert(word);
			}

		}
		
		String[] prefix = {
				"c",
			    "co",
			    "com",
			    "comp",
			    "compl",
			    "comple",
			    "complex",
			    "complexi",
			    "complexit",
			    "complexity"
			};
		
		
		for (String pre : prefix) {
			
			long total = 0 ;
			
			for (int i = 0; i < 10000; i++) {

				long start = System.nanoTime();

				trie.getSuggestions(pre);

				long end = System.nanoTime();
				
				total += (end - start) ;
			}
			
			long avg = (total)/ 2 ;
			System.out.printf("%s average getting suggestions time: %d ns%n", pre, avg) ;
		}
	}

}
