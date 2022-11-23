package locate.traindata;

import locate.callgraph.ParseCallGraph;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TraindataGen {

    private String des;

    private String source;

    public TraindataGen(String str){
        des = str;
        source = str + "\\source.txt";
    }

    public void getTrainData() throws Exception {
        File desfile = new File(des + "\\train.csv");
        FileWriter fileWriter = new FileWriter(desfile.getAbsolutePath());
        fileWriter.write("text" + "," + "label" + "\r\n");
        File src = new File(source);
        FileReader in = null;

        if (src.isFile() && src.exists()) {

            in = new FileReader(src);
            BufferedReader bf = new BufferedReader(in);
            String now;
            String keynow = "";
            while ((now = bf.readLine()) != null) {
                String key = now.split("<<")[0];
                if(!key.equals(keynow)){
                    keynow = key;
                    String traindata = "";
                    traindata += key.split(":")[1];
                    traindata += " - ";
                    traindata += now.split("<<")[1].split(">>")[0].replace(',',' ');
                    traindata += " - ";
                    traindata += now.split("@@")[1];
                    traindata += " - ";
                    ParseCallGraph p = new ParseCallGraph();
                    List<String> callGraph = p.parseCallGraph(src.getAbsolutePath(), key);
                    traindata += callGraph.toString().replace(',',' ');
                    fileWriter.write(traindata + "," + "0" + "\r\n");
                }else{
                    continue;
                }
            }
        } else {
            System.out.println("No source file, please prehandle project!");
        }

        fileWriter.close();
    }
}
