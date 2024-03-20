//Unathi Shabangu
//SHBUNA001
//2024/03/19
//A class to read the contents of a file containing terms,sentences and confidence scores
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileAVL {
    private String fileName;
    private Scanner fileReader;
    private AVLTree<WordAVL> wordList;
    
    
    public ReadFileAVL(String fileName)throws FileNotFoundException{
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            wordList = new AVLTree<>();
            appendTree(fileReader);
            fileReader.close(); 
        } 
        catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found: " + fileName);
        }
   } 
   public void appendTree(WordAVL w){
        wordList.insert(w);
    }
    //creating a Word object from the String and add it to the wordList tree
    private void appendTree(Scanner fileReader) {
        fileReader.useDelimiter("\t");
        while (fileReader.hasNextLine()) {
            String word = fileReader.next();
            String def = fileReader.next();
            String score = fileReader.nextLine();
            WordAVL wordOBJ = new WordAVL(word, def, score);
            wordList.insert(wordOBJ);
        }
    }
    public String findWord(String word) {
        BinaryTreeNode<WordAVL> node = wordList.find(new WordAVL(word, "", ""));
        if (node != null) {
            return String.format("%s : %s (%s)", node.data.getWord(), node.data.getDef(), node.data.getScore().trim());
        } 
        else {
            return String.format("The word \"%s\" was not found.", word);
        }
    }
    public AVLTree<WordAVL> getList(){return wordList;}

}
    