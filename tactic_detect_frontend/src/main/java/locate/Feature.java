package locate;

import java.util.List;

public class Feature {

    private String name;

    private List<String> call_list;

    private List<String> args;

    private String returnType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCall_list() {
        return call_list;
    }

    public void setCall_list(List<String> call_list) {
        this.call_list = call_list;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }
}
