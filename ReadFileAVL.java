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
}
    