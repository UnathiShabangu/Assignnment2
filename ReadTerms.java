//Unathi Shabangu
//SHBUNA001
//2024/03/19
//A class to read the contents of a file containing only terms
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTerms {
    private String fileName;
    private Scanner fileReader;
    private AVLTree<WordAVL> terms;
    
    
    public ReadTerms(String fileName)throws FileNotFoundException{
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            terms = new AVLTree<>();
            while(fileReader.hasNextLine()){
                append(fileReader.nextLine());
            }
            fileReader.close(); 
        } 
        catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found: " + fileName);
        }
    }
    private void append(String term){
        WordAVL w = new WordAVL(term);
        terms.insert(w);
    }
    public AVLTree<WordAVL> getList(){return terms;}
        
}
        
