package locate.funcreturn.singlecsv;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReturnTypeParser {

    private String des;

    private HashMap<String, String> returnMap;

    public ReturnTypeParser (String str){
        returnMap = new HashMap<String, String>();
        des = str;
    }

    public void readFuncName(String source) throws IOException {
        File desfile = new File(des + "\\return.csv");
        FileWriter fileWriter = new FileWriter(desfile.getAbsolutePath());
        File src = new File(source + "\\source.txt");
        FileReader in = null;

        if (src.isFile() && src.exists()) {

            in = new FileReader(src);
            BufferedReader bf = new BufferedReader(in);
            String now = null;

            while ((now = bf.readLine()) != null) {
                String key = now.split("<<")[0];
                String val = now.split("@@")[1];
                returnMap.put(key, val);
            }
        } else {
            System.out.println("No source file, please prehandle project!");
        }

        Iterator iter = returnMap.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            String val = (String) entry.getValue();
            fileWriter.write(key + "," + val + "\r\n");
            fileWriter.flush();
        }
        fileWriter.close();

    }
}
