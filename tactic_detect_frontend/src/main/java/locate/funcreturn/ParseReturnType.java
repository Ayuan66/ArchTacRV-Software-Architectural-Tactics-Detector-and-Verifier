package locate.funcreturn;

public class ParseReturnType {

    public String parseReturnType(String source){

        String returnType = source.split("@@")[1];

        return returnType;
    }

}
