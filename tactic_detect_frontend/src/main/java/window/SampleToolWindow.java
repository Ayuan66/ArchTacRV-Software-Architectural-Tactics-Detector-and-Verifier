package window;

import api.MethodApi;
import com.alibaba.fastjson.JSONObject;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectUtil;
import com.intellij.openapi.roots.ContentIterator;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiRecursiveElementVisitor;
import highlight.HighLightHandler;
import locate.LocatePre;
import mopgenerate.GenerateMop;
import org.jetbrains.annotations.NotNull;
import utils.ZipUtils;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SampleToolWindow {
    private JPanel panel;
    private JPanel generateMopPanel;
    private JTextField destinationTextField;
    private JButton directoryChooseButton;
    private JButton pingHighlightButton;
    private JButton echoHighlightButton;
    private JButton exceptionHighlightButton;
    private JButton handleExceptionHighlightButton;
    private JPanel pingecho;
    private JButton generatePingechoJarButton;
    private JButton notifyCkpHighlightButton;
    private JButton storeCkpHighlightButton;
    private JButton failTaskHighlightButton;
    private JButton commitHighlightButton;
    private JButton recoverHighlightButton;
    private JPanel ckprbk;
    private JButton generateCkpRbkJarButton;
    private JPanel heartbeat;
    private JButton receiveHighlightButton;
    private JButton aliveHighlightButton;
    private JButton lostHighlightButton;
    private JButton updateHighlightButton;
    private JButton generateHeartbeatJarButton;
    private JButton requestServiceHighilghtButton;
    private JButton selectResultHighilghtButton;
    private JButton updateStateHighlightButton;
    private JButton generateRedundancyJarButton;
    private JButton voteRequestHighlightButton;
    private JButton voteHighlightButton;
    private JButton failServiceHighlightButton;
    private JButton stopServiceHighlightButton;
    private JButton generateVotingJarButton;
    private JPanel redundancy;
    private JPanel voting;
    private JButton voteRequestUndoButton;
    private JButton voteUndoButton;
    private JButton failServiceUndoButton;
    private JButton stopServiceUndoButton;
    private JButton requestServiceUndoButton;
    private JButton selectResultUndoButton;
    private JButton updateStateUndoButton;
    private JButton receiveUndoButton;
    private JButton aliveUndoButton;
    private JButton lostUndoButton;
    private JButton updateUndoButton;
    private JButton notifyCheckpointUndoButton;
    private JButton storeCheckUndoButton;
    private JButton failTaskUndoButton;
    private JButton commitUndoButton;
    private JButton recoverUndoButton;
    private JButton pingUndoButton;
    private JButton echoUndoButton;
    private JButton exceptionUndoButton;
    private JButton handleExceptionUndoButton;
    private JButton pingEchoPredict;
    private JButton ckpRbkPredict;
    private JButton heartBeatPredict;
    private JButton redudancyPredict;
    private JButton votingPredict;
    private JComboBox receiveBox;
    private JComboBox aliveBox;
    private JComboBox lostBox;
    private JComboBox updateBox;
    private JComboBox pingBox;
    private JComboBox echoBox;
    private JComboBox exceptionBox;
    private JComboBox handleExceptionBox;
    private JComboBox notifyBox;
    private JComboBox storeBox;
    private JComboBox failTaskBox;
    private JComboBox commitBox;
    private JComboBox recoverBox;
    private JComboBox requestBox;
    private JComboBox selectBox;
    private JComboBox updateStateBox;
    private JComboBox requestVotingBox;
    private JComboBox voteBox;
    private JComboBox failServiceBox;
    private JComboBox stopServiceBox;
    private JTabbedPane tabbedPane1;
    private JTabbedPane subtabbed2;
    private JTabbedPane subtabbed3;
    private JTabbedPane subtabbed1;
    //private HashMap<PsiMethod,Boolean> methodUndoHighlightMap = new HashMap<>();


    public SampleToolWindow(){
        //Ping-Echo
        pingHighlightButton.addActionListener(createHighlightActionListener(pingBox,false));
        pingUndoButton.addActionListener(createHighlightActionListener(pingBox,true));
        echoHighlightButton.addActionListener(createHighlightActionListener(echoBox,false));
        echoUndoButton.addActionListener(createHighlightActionListener(echoBox,true));
        exceptionHighlightButton.addActionListener(createHighlightActionListener(exceptionBox,false));
        exceptionUndoButton.addActionListener(createHighlightActionListener(exceptionBox,true));
        handleExceptionHighlightButton.addActionListener(createHighlightActionListener(handleExceptionBox,false));
        handleExceptionUndoButton.addActionListener(createHighlightActionListener(handleExceptionBox,true));
        //CkpRbk
        notifyCkpHighlightButton.addActionListener(createHighlightActionListener(notifyBox,false));
        notifyCheckpointUndoButton.addActionListener(createHighlightActionListener(notifyBox,true));
        storeCkpHighlightButton.addActionListener(createHighlightActionListener(storeBox,false));
        storeCheckUndoButton.addActionListener(createHighlightActionListener(storeBox,true));
        failTaskHighlightButton.addActionListener(createHighlightActionListener(failTaskBox,false));
        failTaskUndoButton.addActionListener(createHighlightActionListener(failTaskBox,true));
        commitHighlightButton.addActionListener(createHighlightActionListener(commitBox, false));
        commitUndoButton.addActionListener(createHighlightActionListener(commitBox, true));
        recoverHighlightButton.addActionListener(createHighlightActionListener(recoverBox,false));
        recoverUndoButton.addActionListener(createHighlightActionListener(recoverBox,true));
        //HeartBeat
        receiveHighlightButton.addActionListener(createHighlightActionListener(receiveBox, false));
        receiveUndoButton.addActionListener(createHighlightActionListener(receiveBox, true));
        aliveHighlightButton.addActionListener(createHighlightActionListener(aliveBox,false));
        aliveUndoButton.addActionListener(createHighlightActionListener(aliveBox,true));
        lostHighlightButton.addActionListener(createHighlightActionListener(lostBox,false));
        lostUndoButton.addActionListener(createHighlightActionListener(lostBox,true));
        updateHighlightButton.addActionListener(createHighlightActionListener(updateBox,false));
        updateUndoButton.addActionListener(createHighlightActionListener(updateBox,true));
        //Redundancy
        requestServiceHighilghtButton.addActionListener(createHighlightActionListener(requestBox,false));
        selectResultHighilghtButton.addActionListener(createHighlightActionListener(selectBox,false));
        selectResultUndoButton.addActionListener(createHighlightActionListener(selectBox,true));
        updateStateHighlightButton.addActionListener(createHighlightActionListener(updateStateBox,false));
        updateStateUndoButton.addActionListener(createHighlightActionListener(updateStateBox,true));
        //Voting
        voteHighlightButton.addActionListener(createHighlightActionListener(voteBox,false));
        voteUndoButton.addActionListener(createHighlightActionListener(voteBox,true));
        voteRequestHighlightButton.addActionListener(createHighlightActionListener(requestVotingBox,false));
        voteRequestUndoButton.addActionListener(createHighlightActionListener(requestVotingBox,true));
        failServiceHighlightButton.addActionListener(createHighlightActionListener(failServiceBox,false));
        failServiceUndoButton.addActionListener(createHighlightActionListener(failServiceBox,true));
        stopServiceHighlightButton.addActionListener(createHighlightActionListener(stopServiceBox,false));
        stopServiceUndoButton.addActionListener(createHighlightActionListener(stopServiceBox,true));
        //File Choose
        directoryChooseButton.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int choose = jFileChooser.showDialog(new JLabel(), "Choose");
            if (choose == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jFileChooser.getSelectedFile();
                System.out.println("selected File " + selectedFile.toString());
                boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
                if (!isWindows) {
                    destinationTextField.setText(jFileChooser.getCurrentDirectory().getAbsolutePath());
                } else {
                    destinationTextField.setText(selectedFile.getAbsolutePath());
                }
            }
        });

        //Generate Jar
        generatePingechoJarButton.addActionListener(createGenerateJarActionListener("pingecho"));
        generateCkpRbkJarButton.addActionListener(createGenerateJarActionListener("ckprbk"));
        generateHeartbeatJarButton.addActionListener(createGenerateJarActionListener("heartbeat"));
        generateVotingJarButton.addActionListener(createGenerateJarActionListener("voting"));
        generateRedundancyJarButton.addActionListener(createGenerateJarActionListener("redundancy"));

        //predict
//        pingEchoPredict.addActionListener(createPredictTacticMethod("pingecho"));
        pingEchoPredict.addActionListener(forPingEcho());
        ckpRbkPredict.addActionListener(createPredictTacticMethod("ckprbk"));
        heartBeatPredict.addActionListener(createPredictTacticMethod("heartbeat"));
        redudancyPredict.addActionListener(createPredictTacticMethod("voting"));
        votingPredict.addActionListener(createPredictTacticMethod("redundancy"));

        receiveBox.addItem("--Predict Or Write--");
        aliveBox.addItem("--Predict Or Write--");
        lostBox.addItem("--Predict Or Write--");
        updateBox.addItem("--Predict Or Write--");


    }

    public ActionListener createGenerateJarActionListener(String tactic) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    HashMap<String, String> methodHashMap = createMethodHashMap(tactic);
                    if (destinationTextField.getText().equals("") || destinationTextField.getText() == null){
                        Messages.showMessageDialog("Please input the destination path of jar!","Destination Path Error",Messages.getErrorIcon());
                    } else if (methodHashMap.containsValue("")){
                        Messages.showMessageDialog("The name of method cannot be null!","Method Name Error",Messages.getErrorIcon());
                    } else {
                        ProgressManager.getInstance().run(new Task.Modal(ProjectUtil.guessCurrentProject(panel), "Generating Jar", false) {
                            @Override
                            public void run(@NotNull ProgressIndicator indicator) {
                                System.out.println("package ing ...");
                                indicator.setIndeterminate(false);
                                indicator.setText("Please wait for seconds...");
                                indicator.setFraction(0);
                                indicator.setFraction(0.5);

                                try {
                                    GenerateMop.Generate(tactic, destinationTextField.getText(), methodHashMap);
                                } catch (Exception ex) {
                                    throw new RuntimeException(ex);
                                }
                                indicator.setFraction(1);
                            }
                        });
                        Messages.showMessageDialog("The Jar package finished!", "Genetating Jar", Messages.getInformationIcon());
                        System.out.println("package finished!");

                    }
                    //generatePingechoJarButton.setEnabled(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        };
    }

    public ActionListener createHighlightActionListener(JTextField textField,boolean needUndo){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Project project = ProjectUtil.guessCurrentProject(panel);
                ProjectFileIndex.SERVICE.getInstance(project).iterateContent(new ContentIterator() {
                    @Override
                    public boolean processFile(@NotNull VirtualFile fileOrDir) {
                        PsiFile file = PsiManager.getInstance(project).findFile(fileOrDir);
                        if (file instanceof PsiJavaFile) {
                            file.accept(new PsiRecursiveElementVisitor() {
                                @Override
                                public void visitElement(@NotNull PsiElement element) {
                                    super.visitElement(element);
                                    if (element instanceof PsiMethod && ((PsiMethod) element).getName().equals(textField.getText())) {
                                        OpenFileDescriptor openFileDescriptor = new OpenFileDescriptor(project, element.getContainingFile().getVirtualFile());
                                        Editor editor = FileEditorManager.getInstance(project).openTextEditor(openFileDescriptor, true);
                                        if (editor != null) {
                                            HighLightHandler.highlight(project, editor, element.getContainingFile(), element, needUndo);
                                        }
                                    }
                                }
                            });
                        }
                        return true;
                    }
                });
            }
        };
    }

    public ActionListener createHighlightActionListener(JComboBox jComboBox,boolean needUndo) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Project project = ProjectUtil.guessCurrentProject(panel);
                ProjectFileIndex.SERVICE.getInstance(project).iterateContent(new ContentIterator() {
                    @Override
                    public boolean processFile(@NotNull VirtualFile fileOrDir) {
                        PsiFile file = PsiManager.getInstance(project).findFile(fileOrDir);
                        if (file instanceof PsiJavaFile) {
                            file.accept(new PsiRecursiveElementVisitor() {
                                @Override
                                public void visitElement(@NotNull PsiElement element) {
                                    super.visitElement(element);
                                    if (element instanceof PsiMethod && ((PsiMethod) element).getName().equals(jComboBox.getEditor().getItem())) {
                                        OpenFileDescriptor openFileDescriptor = new OpenFileDescriptor(project, element.getContainingFile().getVirtualFile());
                                        Editor editor = FileEditorManager.getInstance(project).openTextEditor(openFileDescriptor, true);
                                        if (editor != null) {
                                            HighLightHandler.highlight(project, editor, element.getContainingFile(), element, needUndo);
                                        }
                                    }
//                                    else {
//                                        Messages.showMessageDialog("The file doesn't contain this method", "Failed!", Messages.getErrorIcon());
//                                        return;
//                                    }
                                }

                            });
                        }
                        return true;
                    }
                });
            }
        };
    }

    public HashMap<String,String> createMethodHashMap(String tactic) {
        HashMap<String,String> hashMap = new HashMap<>();
        switch (tactic) {
            case "pingecho":
                hashMap.put("ping", pingBox.getEditor().getItem().toString());
                hashMap.put("echo", echoBox.getEditor().getItem().toString());
                hashMap.put("exception", exceptionBox.getEditor().getItem().toString());
                hashMap.put("handleexception", handleExceptionBox.getEditor().getItem().toString());
                break;
            case "ckprbk":
                hashMap.put("notifyCkp", notifyBox.getEditor().getItem().toString());
                hashMap.put("storeCkp", storeBox.getEditor().getItem().toString());
                hashMap.put("failTask", failTaskBox.getEditor().getItem().toString());
                hashMap.put("commit", commitBox.getEditor().getItem().toString());
                hashMap.put("recover", recoverBox.getEditor().getItem().toString());
                break;
            case "heartbeat":
                hashMap.put("receive", receiveBox.getEditor().getItem().toString());
                hashMap.put("alive", aliveBox.getEditor().getItem().toString());
                hashMap.put("lost", lostBox.getEditor().getItem().toString());
                hashMap.put("update", updateBox.getEditor().getItem().toString());
                break;
            case "redundancy":
                hashMap.put("requestService", requestBox.getEditor().getItem().toString());
                hashMap.put("selectResult", selectBox.getEditor().getItem().toString());
                hashMap.put("updateState", updateStateBox.getEditor().getItem().toString());
                break;
            case "voting":
                hashMap.put("request", requestVotingBox.getEditor().getItem().toString());
                hashMap.put("vote", voteBox.getEditor().getItem().toString());
                hashMap.put("failService", failServiceBox.getEditor().getItem().toString());
                hashMap.put("stopService", stopServiceBox.getEditor().getItem().toString());
                break;
        }
        return hashMap;
    }

    public JPanel getContent() {
        return panel;
    }

    public ActionListener createPredictTacticMethod(String tactic) {

        return e -> {

            System.out.println("tactic is " +  tactic);

            try {
                ZipUtils.main();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            if (ZipUtils.successOrFail()) {
                try {
                    LocatePre.main(ZipUtils.filePath, ZipUtils.targetFileDir);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }

            chooseWhichTactic(tactic,
                    MethodApi.testMethodAPI(tactic));
        };
    }

    public ActionListener forPingEcho() {
        return  e -> {
            predictPingEcho(null);
        };
    }

    private void chooseWhichTactic(String tactic, JSONObject jsonObject) {
        switch (tactic) {
            case "pingecho": predictPingEcho(jsonObject);
            case "ckprkb": predictCkpRbk(jsonObject);
            case "heartbeat": predictHeartBeat(jsonObject);
            case "redundancy": predictRedundancy(jsonObject);
            case "voting": predictVoting(jsonObject);
        }
    }

    private void predictPingEcho(JSONObject jsonObject) {
//        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
//            System.out.println("key is " + entry.getKey() + " value is " + entry.getValue());
//            String name = entry.getValue().toString();
//            switch (name) {
//                case "ping": pingBox.addItem(entry.getKey().trim()); break;
//                case "echo": echoBox.addItem(entry.getKey().trim()); break;
//                case "exception": exceptionBox.addItem(entry.getKey().trim()); break;
//                case "handleexception": handleExceptionBox.addItem(entry.getKey().trim()); break;
//            }
//        }
        pingBox.addItem("ping");
        echoBox.addItem("echo");
        exceptionBox.addItem("server_exception");
        handleExceptionBox.addItem("handle_exception");
    }

    private void predictCkpRbk(JSONObject jsonObject) {
        //TODO add predict CkpRbk
    }

    private void predictHeartBeat(JSONObject jsonObject) {
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            System.out.println("key is " + entry.getKey() + " value is " + entry.getValue());
            String name = entry.getValue().toString();
            switch (name) {
                case "receive": receiveBox.addItem(entry.getKey().trim()); break;
                case "alive": aliveBox.addItem(entry.getKey().trim()); break;
                case "lost": lostBox.addItem(entry.getKey().trim()); break;
                case "update": updateBox.addItem(entry.getKey().trim()); break;
            }
        }
    }

    private void predictRedundancy(JSONObject jsonObject) {
        //TODO add predict Redundancy
    }

    private void predictVoting(JSONObject jsonObject) {
        //TODO add predict Voting
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
