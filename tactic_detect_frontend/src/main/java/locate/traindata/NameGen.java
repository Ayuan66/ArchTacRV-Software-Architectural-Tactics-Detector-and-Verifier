package locate.traindata;

import locate.callgraph.ParseCallGraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class NameGen {

    private String des;

    private String source;

    public NameGen(String str){
        des = str;
        source = str + "\\name.csv";
    }

    public void getTrainData() throws Exception {
        File desfile = new File(des + "\\namedata.csv");
        FileWriter fileWriter = new FileWriter(desfile.getAbsolutePath());
        fileWriter.write("text" + "," + "label" + "\r\n");
        File src = new File(source);
        FileReader in = null;

        if (src.isFile() && src.exists()) {
            in = new FileReader(src);
            BufferedReader bf = new BufferedReader(in);
            String now;
            while ((now = bf.readLine()) != null) {
                fileWriter.write(now.split(",")[1] + "," + "0" + "\r\n");
            }
        }else {
            System.out.println("No source file, please prehandle project!");
        }
        fileWriter.close();
    }
}
