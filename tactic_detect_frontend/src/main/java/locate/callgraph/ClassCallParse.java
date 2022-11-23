package locate.callgraph;

import org.apache.bcel.classfile.ClassParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassCallParse {
    public void process(String path, String des) throws IOException {
        File desfile = new File(des+"\\source.txt");
        if(!desfile.exists()){
            desfile.createNewFile();
        }else {
            desfile.delete();
            desfile.createNewFile();
        }
        FileWriter desfileWriter = new FileWriter(desfile.getAbsolutePath());
        ClassParser cp;
        try {
            File f = new File(path);
            if (!f.exists()) {
                System.err.println("Jar file " + "DynamicCheck.jar" + " does not exist");
            }

            JarFile jar = new JarFile(f);
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.isDirectory())
                    continue;

                if (!entry.getName().endsWith(".class"))
                    continue;

                cp = new ClassParser(path, entry.getName());
                ClassVisitor visitor = new ClassVisitor(cp.parse(), desfileWriter);
                visitor.start();
            }
        } catch (IOException e) {
            System.err.println("Error while processing jar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
