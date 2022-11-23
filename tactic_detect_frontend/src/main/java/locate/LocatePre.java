package locate;

import locate.callgraph.singlecsv.CallGraphParser;
import locate.funcargs.singlecsv.FuncArgsParser;
import locate.funcname.singlecsv.FuncNameReader;
import locate.funcreturn.singlecsv.ReturnTypeParser;
import locate.prehandle.ProjectPreHandle;
import locate.traindata.NameGen;
import locate.traindata.TraindataGen;

import java.io.File;
import java.io.IOException;

public class LocatePre {
    public static void main(String sourceFile, String targetFile) throws Exception {

        LocatePre locatePre = new LocatePre();

        //设置输入路径

        String path = sourceFile;

        String jar = targetFile;

        String target = path + "\\" + "target";

        File file = new File(target);

        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }

        locatePre.LocatePreHandle(jar, target);

        locatePre.getTrainData(target);

        locatePre.getNameData(target);
    }

    public void LocatePreHandle(String project_zip_jar_Path, String desFolder) throws IOException {

        ProjectPreHandle projectPreHandle = new ProjectPreHandle(project_zip_jar_Path, desFolder);

        projectPreHandle.readFilesDir();

        FuncNameReader funcNameReader = new FuncNameReader(desFolder);

        funcNameReader.readFuncName(desFolder);

        CallGraphParser callGraphParser = new CallGraphParser(desFolder);

        callGraphParser.parseCallGraph(desFolder);

        FuncArgsParser funcArgsParser = new FuncArgsParser(desFolder);

        funcArgsParser.parseCallGraph(desFolder);

        ReturnTypeParser returnTypeParser = new ReturnTypeParser(desFolder);

        returnTypeParser.readFuncName(desFolder);
    }

    public void getTrainData(String dataFolder) throws Exception {

        TraindataGen traindataGen = new TraindataGen(dataFolder);

        traindataGen.getTrainData();
    }

    public void getNameData(String dataFolder) throws Exception {

        NameGen nameGen = new NameGen(dataFolder);

        nameGen.getTrainData();
    }
}
