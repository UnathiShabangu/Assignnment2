/***
2024/03/20
Unathi Shabangu
SHBUNA001
A program utilizing the the following classes
-ReadFileAVL
-WordAVL
-ReadTerms
-AVLTree
***/
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Testing{
    public static void main(String[] args){
        System.out.println("Reading the data from the \"GenericsKB\" file");
        ReadFileAVL file= null;
        try{
            file = new ReadFileAVL("GenericsKB.txt");
            System.out.println("Done");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        System.out.println("Reading the list of terms from the \"GenericsKB queries.txt\" file");
        Scanner read = new Scanner("GenericsKB-queries.txt");
        System.out.println("Done");
        /**
        TEst 1
        Finding a word in the AVL Tree 
        **/
        System.out.println("***Test 1***\nFinding a specific word in GenericsKB");
        System.out.println("criminologist");
        System.out.println("Test Begin");
        if(file.findWord("criminologist").equals("criminologist : Criminologists are workers. (1.0)")){
           System.out.println("Pass");
        }
        else{
            System.out.println("FAIL.");
            System.out.println("Expected output: criminologist : Criminologists are workers. (1.0)");
            System.out.printf("Recived output: %s",file.findWord("criminologist"));
            System.out.println();
        }
        System.out.println("Test end");
        /**
        Test 2
        Finding any random word in the AVL tree from term list
        **/
        System.out.println("***TEST 2***\nFinding a specific word in GenericsKB from GenericsKB queries.txt");
        System.out.println("misuse");
        System.out.println("Test Begin");
        System.out.println(file.findWord("misuse"));
        System.out.println("Test end");
        
        
    }
}  