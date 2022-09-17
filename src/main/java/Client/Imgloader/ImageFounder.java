package Client.Imgloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImageFounder {

    private String getString(String fileName){

        BufferedReader br;
        StringBuilder sb = new StringBuilder();

        try {

            br = new BufferedReader(new FileReader(new File(fileName)));

            String line;

            while ((line = br.readLine()) != null){

                sb.append(line);

            }


        } catch (IOException e) {

            throw new RuntimeException(e);

        }

        return sb.toString();

    }

    public ArrayList<String> getImages(String filename){

        ArrayList<String> strings = new ArrayList<>();

            String lineOf = getString(filename);

            String[] linesImg = lineOf.split("src=\"//");

            for (int i = 0; i < linesImg.length; i++) {

                String str = "";

                for (int j = 0; j < linesImg[i].length(); j++) {

                    str += linesImg[i].charAt(j);

                    if (linesImg[i].charAt(j) == '.' && linesImg[i].charAt(j + 1) == 'p' &&linesImg[i].charAt(j + 2) == 'n' && linesImg[i].charAt(j + 3) == 'g'||(linesImg[i].charAt(j) == '.' && linesImg[i].charAt(j + 1) == 'j' &&linesImg[i].charAt(j + 2) == 'p' && linesImg[i].charAt(j + 3) == 'g')){

                       strings.add(str);
                       str = "";
                       break;

                    }

                }

            }

        return strings;
    }
}
