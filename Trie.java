import java.util.Collections;
import java.util.Comparator;
import java.util.*;

public class Trie {
    private static final TrieNode root = new TrieNode() ;

     public void insert(String word) {

        if(word == null || word.isEmpty())
            return;

        TrieNode current = root;

        for(char c : word.toCharArray()) {
            if(!current.hasChild(c)) {
                current.addChild(c);
            }
            current = current.getChild(c);
        }

        current.setIsWord(true);
        current.setWord(word);

    }

    public static TrieNode searchPrefix(String prefix) {
        return searchPrefix(prefix, root) ;
    }


    public static TrieNode searchPrefix(String prefix, TrieNode root) {

        TrieNode current = root ;

        for(char c: prefix.toCharArray()) {

            if(!current.hasChild(c)) {
                return null ;
            }

            current = current.getChild(c) ;
        }

        return current;
    }

    public void updateUsage(String word) {

        TrieNode current = root; // start from root of the trie

        for (char ch : word.toCharArray()) { // loop through each character in the word

            if (!current.hasChild(ch)) { // check if the path exists
                return;
            }

            current = current.getChild(ch); // move to the next node
        }

        if (current != null && current.getIsWord()) { // check if this node is a valid word
            current.incrementFrequency(); // increase frequency
            current.updateLastUsed(); // update last used time
        }
    }


    public void preOrder(TrieNode node, List <TrieNode> list){

        if(node == null){
            return;
        }

        if(node.getIsWord()){
            list.add(node); //Adds to the list we passed
        }

        for(TrieNode child : node.children.values()){
            preOrder(child, list);
        }
    }



    public static class TrieNodeComparator implements Comparator<TrieNode> {
        @Override
        public int compare(TrieNode a, TrieNode b){

            if(b.getFrequency() != a.getFrequency()){
                return b.getFrequency() - a.getFrequency();
            }

            return Long.compare(b.getLastUsed(), a.getLastUsed());
        }
    }

    public List<String> getSuggestions(String prefix){

        //save the prefix in a separate node object so we can use
        TrieNode node = searchPrefix(prefix);


        //if the prefix input is not found then just return an empty list instead of null to avoid Exceptions and errors
        if(node == null){
            return Collections.emptyList();
        }

        //create an empty list
        List<TrieNode> list = new ArrayList<>();

        //collect all words of this prefix using method preorder and put them in the empty list
        preOrder(node, list);
        //sort the list we filled according to the comparator method of frequency & recency
        list.sort(new TrieNodeComparator());

        //convert it to a list of strings and create a result list with all possible Suggestions
        List<String> result = new ArrayList<>();
        for(TrieNode n: list){
            result.add(n.getWord());
        }

        //return the resulted suggestions we got
        return result;

    }



}










