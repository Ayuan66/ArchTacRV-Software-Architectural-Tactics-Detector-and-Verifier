package locate.funcargs.singlecsv;

import java.io.*;
import java.util.*;

public class FuncArgsParser {

    private String des;

    private HashMap<String, List<String>> argsMap;

    public FuncArgsParser(String str){
        argsMap = new HashMap<String, List<String>>();
        des = str;
    }

    public void parseCallGraph(String source) throws IOException {

        File desfile = new File(des + "\\funcargs.csv");
        FileWriter fileWriter = new FileWriter(desfile.getAbsolutePath());

        File src = new File(source + "\\source.txt");
        FileReader in = null;

        if (src.isFile() && src.exists()) {

            in = new FileReader(src);
            BufferedReader bf = new BufferedReader(in);

            String now = null;

            while ((now = bf.readLine()) != null) {

                String key = now.split("<<")[0];

                String list = now.split("<<")[1].split(">>")[0];

                if(list.equals("[]")){

                    argsMap.put(key, null);

                }else {

                    list = list.substring(1, list.length() - 1);

                    List<String> val = Arrays.asList(list.split(", "));

                    argsMap.put(key, val);

                }
            }
        } else {
            System.out.println("No source file, please prehandle project!");
        }

        Iterator iter = argsMap.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            List val = (List) entry.getValue();
            if(val == null){
                fileWriter.write(key + "," + "\r\n");
            }else {
                fileWriter.write(key + "," + valParse(val) + "\r\n");
            }
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
