package locate.prehandle;

import locate.callgraph.ClassCallParse;

import java.io.IOException;

public class ProjectPreHandle {

    private String projectZipJarPath;

    private String sourceTxtPath;

    public ProjectPreHandle(String zip_jar_Path, String srcPath){
        this.projectZipJarPath = zip_jar_Path;
        this.sourceTxtPath = srcPath;
    }

    public void readFilesDir() throws IOException {
        new ClassCallParse().process(projectZipJarPath, sourceTxtPath);
    }

//    public static void main(String[] args) throws IOException {
//        String path = "E:\\TestProject\\PingEcho_Projects\\zhangleiking-zlg-master.zip";
//        String des = "E:\\TestProject\\PingEcho_Projects";
//        new ProjectPreHandle(path, des).readFilesDir();
//    }
}
