package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor {

    public Graph fetchFromFile(String localPath){
        File graphFile = new File(localPath);
        ArrayList<String[]> fetchedEdges = new ArrayList<String[]>();
        try{
            Scanner fileRead = new Scanner(graphFile);
            while(fileRead.hasNext()){
                fetchedEdges.add(fileRead.next().split(",(?![^(]*[A-Za-z],[A-Za-z]\\))"));
            }


        }catch(FileNotFoundException fileNotFound){
            fileNotFound.printStackTrace();
        }


        return null;
    }

}
