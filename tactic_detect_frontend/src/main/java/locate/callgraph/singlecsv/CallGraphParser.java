package locate.callgraph.singlecsv;

import java.io.*;
import java.util.*;

public class CallGraphParser {

    private String des;

    private HashMap<String, List<String>> callGraphMap;

    public CallGraphParser(String str){
        callGraphMap = new HashMap<String, List<String>>();
        des = str;
    }

    public void parseCallGraph(String source) throws IOException {

        File desfile = new File(des + "\\callgraph.csv");
        FileWriter fileWriter = new FileWriter(desfile.getAbsolutePath());

        File src = new File(source + "\\source.txt");
        FileReader in = null;

        if (src.isFile() && src.exists()) {

            in = new FileReader(src);
            BufferedReader bf = new BufferedReader(in);

            String now = null;

            while ((now = bf.readLine()) != null) {

                String key = now.split("<<")[0];

                if(callGraphMap.containsKey(key)){
                    List val = callGraphMap.get(key);
                    val.add(now.split("==>")[1]);
                    callGraphMap.put(key, val);
                }else {
                    List<String> val = new ArrayList<String>();
                    val.add(now.split("==>")[1]);
                    callGraphMap.put(key, val);
                }
            }
        } else {
            System.out.println("No source file, please prehandle project!");
        }

        Iterator iter = callGraphMap.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            List val = (List) entry.getValue();
            fileWriter.write(key + "," + valParse(val) + "\r\n");
            fileWriter.flush();
        }
        fileWriter.close();

    }

    private String valParse(List<String> val){

        StringBuilder result = new StringBuilder();

        for(String str : val){
            result.append(str + " ; ");
        }

        return result.toString();
    }
}
