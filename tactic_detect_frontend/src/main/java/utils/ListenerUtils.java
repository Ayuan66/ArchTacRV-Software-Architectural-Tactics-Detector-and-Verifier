package utils;

import java.io.File;

public class ListenerUtils extends Thread {

    /**
     * ���������߳�
     * @param Ҫ�������ļ�·��
     * @param Ҫ�������ļ�����
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
     * �ж�out�ļ����Ƿ����
     * @return
     */
    public boolean successOrFail() {
        return flag;
    }

}
