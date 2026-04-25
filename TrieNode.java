//Jumanah
import java.util.HashMap;

public class TrieNode {

    HashMap<Character, TrieNode> children;

    private boolean isWord ;
    private int frequency ;
    private long lastUsed ;
    private String word ;


    public TrieNode() {

        children = new HashMap<>() ;
        isWord = false ;
        frequency = 0 ;
        lastUsed = 0 ;

    }

    public TrieNode getChild(char c) {
        return children.get(c);
    }

    public boolean hasChild(char c) {
        return children.containsKey(c);
    }

    public void addChild(char c) {
        children.put(c, new TrieNode()) ;
    }

    public boolean getIsWord() {
        return isWord;
    }

    public void setIsWord(boolean value) {
        this.isWord = value;
    }

    public int getFrequency() {
        return frequency;
    }

    public void incrementFrequency() {
        frequency++ ;
    }

    public long getLastUsed() {
        return lastUsed;
    }

    public void updateLastUsed() {
        lastUsed = System.currentTimeMillis() ;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }


}
