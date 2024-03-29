//Unathi Shabangu
//SHBUNA001
//2024/03/19
//A class to create word objects
public class WordAVL implements Comparable<WordAVL>{
    private String word;
    private String def;
    private String score;
    
    public WordAVL(String word){
        this.word = word;
    }
    public WordAVL(String word,String def,String score){
        this.word = word;
        this.def = def;
        this.score = score;
    }
    //getter methods
    public String getWord(){return word;}
    public String getDef(){return def;}
    public String getScore(){return score;}
    @Override//compareTo method for Word objects
    public int compareTo(WordAVL other) {return this.word.compareTo(other.word);}
    //updating methods
    public void newDef(String newDef){this.def = newDef;}
    public void newScore(String newScore){this.score = newScore;}
    //to string method
    public String toString(){
        return String.format("Word: %s\nDefinition: %s\nConfidence Score:%s",word,def,score);
    }
}
