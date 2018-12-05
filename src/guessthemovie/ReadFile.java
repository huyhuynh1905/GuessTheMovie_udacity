
package guessthemovie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFile {
    ArrayList<String> listfilm = new ArrayList<>();
    
    public ArrayList<String> ReadFileIO(){
        String x;
        try {
            FileReader fr = new FileReader("movies.txt");
            BufferedReader br = new BufferedReader(fr);
            while((x = br.readLine())!=null){
                listfilm.add(x);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listfilm;
    }
}
