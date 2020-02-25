package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.*;

public class ToRead {

    public void setBr() throws IOException {
        File file = new File("./data/Pantry_Items.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
    }

}


