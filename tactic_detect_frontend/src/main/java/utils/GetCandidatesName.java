package utils;

import com.alibaba.fastjson.JSONObject;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetCandidatesName {
    static String filePath = ZipUtils.filePath;

    public static List<String> getMethodName(String tactic) {
        String namePath = filePath + "target\\namedata.csv";
        List<String> result = new ArrayList<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(namePath));
            String[] record = null;
            while ((record = csvReader.readNext()) != null) {
                result.add(record[0]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", 1);
        jsonObject.put("age", 2);

        List<String> results = new ArrayList<>();
        results.add("name");
        results.add("age");

        for (String item : results) {
            System.out.println(jsonObject);
        }
    }

}
