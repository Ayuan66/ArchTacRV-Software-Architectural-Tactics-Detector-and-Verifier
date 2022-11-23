package locate.callgraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParseCallGraph {

    public static void main(String[] args) throws Exception {

        System.out.println(new ParseCallGraph().parseCallGraph("C:\\Users\\Leo\\Desktop\\train\\java-ping\\source.txt",
                "coordinated.AbstractPingClient:<init>").toString());

    }

    public List<String> parseCallGraph (String sourcefile, String source) throws Exception {

        List<String> result = new ArrayList<String>();

        File src = new File(sourcefile);

        FileReader in = null;

        if (src.isFile() && src.exists()) {

            in = new FileReader(src);
            BufferedReader bf = new BufferedReader(in);

            String now = null;

            while ((now = bf.readLine()) != null) {

                if(source.equals(now.split("<<")[0])){

                    result.add(now.split("==>")[1]);

                }

            }
        } else {
            System.out.println("No source file, please prehandle project!");
        }

        return result;
    }

}
