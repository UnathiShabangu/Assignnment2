/**
Unathi Shabangu 
SHBUNA001
2024/03/21
GenericsKbAVLApp
**/
import java.util.Scanner;
import java.io.*;
public class GenericsKbAVLApp{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Scanner readQuery = null;
        ReadFileAVL file = null;
        System.out.println("***Welcome***");
        String menu ="1. Load Knowledge base.\n2. Create a new query file.\n3. Load an existing query file\n4. Find a Term from Query file in the knowledge base.\n5. Exit application";
        System.out.println(menu);
        int x = input.nextInt();
        input.nextLine();
        while (x!=5){
        if (x==1){
            System.out.println("Enter the name of the knowledge base");
            String filename = input.nextLine();
            try{
                file = new ReadFileAVL(filename);
                System.out.println("Done");
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
            System.out.println(menu);
            x = input.nextInt();
            input.nextLine();
        }
        else if (x==2){
            //Manually loading a new query file
            System.out.println("Enter the name the new query file");
            String name = input.nextLine();
            try{
                FileWriter write = new FileWriter(name, true);
                System.out.println("Enter the number items to add to the query list");
        
                int n= input.nextInt();
                input.nextLine();
                for(int i = 0;i<n;i++){
                    System.out.println("Enter the term you wish to add to the query list.");
                    write.write(input.nextLine()+"\n");
                }
            write.close();
            }
            catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
            
            System.out.println("The Query file has been updated");
            readQuery = new Scanner(name);
            System.out.println(menu);
            x = input.nextInt();
            input.nextLine();
        }
        else if (x == 3) {
            System.out.println("Enter name of existing Query file");
            String queryFileName = input.nextLine();
            try {
                FileInputStream fileInputStream = new FileInputStream(queryFileName);
                readQuery = new Scanner(fileInputStream);
                System.out.println("Query File has been loaded");
                System.out.println(menu);
                x = input.nextInt();
                input.nextLine();
                
            }        
            catch (FileNotFoundException e) {
                System.out.println("Query file not found!");
                System.out.println(menu);
                x = input.nextInt();
                input.nextLine();
            }
        }
        else if (x == 4) {
            if (readQuery != null) {
            while (readQuery.hasNextLine()) {
                String w = readQuery.nextLine();
                System.out.println(file.findWord(w));
            }
            } else {
                System.out.println("No query file loaded.");
            }
            System.out.println("***End of words***");
            System.out.println(menu);
            x = input.nextInt();
            input.nextLine();
        }
        else if (x==5){
            break;
        }
        }
        System.out.println("Good Bye");
        input.close();
        readQuery.close();
    }
}