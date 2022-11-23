package utils;

import java.io.File;

public class ListenerUtils extends Thread {

    /**
     * 启动监听线程
     * @param 要监听的文件路径
     * @param 要监听的文件名称
     */
    private String filePath;
    private String name;
    private boolean flag = false;

    public ListenerUtils(String filePath, String name) {
        this.filePath = filePath;
        this.name = name;
    }

    @Override
    public void run() {
        File file = new File(filePath);
        File fileList[] = file.listFiles();
        while (true) {
            for (File f : fileList) {
                String fileName = f.getName();
                if (fileName.equals(name)) {
                    flag = true;
                    System.out.println("GET Out OK");
                }
            }

            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 判断out文件夹是否存在
     * @return
     */
    public boolean successOrFail() {
        return flag;
    }

}
