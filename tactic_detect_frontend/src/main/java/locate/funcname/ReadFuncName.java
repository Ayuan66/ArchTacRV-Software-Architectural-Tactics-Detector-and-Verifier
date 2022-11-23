package locate.funcname;

public class ReadFuncName {

    public String readFuncName(String source){

        String name = source.split("<<")[0];

        name = name.split(":")[1];

        return name;
    }
}
