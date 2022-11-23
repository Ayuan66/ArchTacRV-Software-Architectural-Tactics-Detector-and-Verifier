package api;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FilePositionData {
    String filePosition;

    public String getFilePosition() {
        return filePosition;
    }

    public void setFilePosition(String filePosition) {
        this.filePosition = filePosition;
    }

    public FilePositionData(String filePosition) {
        this.filePosition = filePosition;
    }

    public static String getJSONStr(String filePosition){
        FilePositionData filePositionData = new FilePositionData(filePosition);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("position", filePositionData.filePosition);
        String paramStr = JSONObject.toJSONString(paramMap);
        return paramStr;
    }


}
