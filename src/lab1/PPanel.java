/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.io.File;
import javax.swing.JTextArea;
import lab1.io.*;

/**
 *
 * @author Tom
 */
public class PPanel extends javax.swing.JPanel {

    static final boolean DEBUG = false;
    PatternList patterns;
    Ptron tron;

    /**
     * Creates new form PPanel
     */
    public PPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        openButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        theTA = new javax.swing.JTextArea();
        echoButton = new javax.swing.JButton();
        runButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        outputTA = new javax.swing.JTextArea();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        openButton.setText("Open");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        theTA.setEditable(false);
        theTA.setColumns(20);
        theTA.setRows(5);
        jScrollPane2.setViewportView(theTA);

        echoButton.setText("Echo");
        echoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                echoButtonActionPerformed(evt);
            }
        });

        runButton.setText("Ptron Run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        outputTA.setColumns(20);
        outputTA.setRows(5);
        jScrollPane3.setViewportView(outputTA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(openButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 417, Short.MAX_VALUE)
                .addComponent(echoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openButton)
                    .addComponent(saveButton)
                    .addComponent(echoButton)
                    .addComponent(runButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        MyReader mr = new MyReader();
        while (mr.hasMoreData()) {
            theTA.append(mr.giveMeTheNextLine() + "\n");
        }
        mr.close();
    }//GEN-LAST:event_openButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        MyWriter mw = new MyWriter();
        mw.print(theTA.getText());
        mw.close();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void echoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_echoButtonActionPerformed

        theTA.setText(""); // Clear the TA before every time a file is echoed into the TA
        try {
            File file = new File(getDirectoryName());
            System.out.println("file = " + file);
            inputData(file);
            String path = file.toString();//Put the Data from a selected file into the PatternList "patterns"
            tron = new Ptron(this, path);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        //tron.displayPatterns(patterns); // original
        
        tron.displayPattern(patterns.get(0));
    }//GEN-LAST:event_echoButtonActionPerformed

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        tron.run();

        System.out.println("FINISHED");
    }//GEN-LAST:event_runButtonActionPerformed

    public PatternList getPatterns() {
        return patterns;
    }

    public void setPatterns(PatternList patterns) {
        this.patterns = patterns;
    }

    public Ptron getTron() {
        return tron;
    }

    public void setTron(Ptron tron) {
        this.tron = tron;
    }

    public JTextArea getTheTA() {
        return theTA;
    }

    public void inputData(File directory) { // adding all files from a directory to PatternList "patterns"
        patterns = new PatternList();
        if (DEBUG) {
            System.out.println("\n " + directory + "\n");
        }
        java.io.File[] list = directory.listFiles();
        for (int i = 0; i < list.length; i++) {
            if (DEBUG) {
                System.out.println("reading... " + list[i]);
            }
            if (!list[i].isDirectory()) {
                patterns.addPattern(new Pattern(list[i].getAbsolutePath()));
            }
        }
    }

    void spew(Pattern p) {
        theTA.append(p.toString() + "\n");

    }

    private String getDirectoryName() {
        System.setProperty("apple.awt.fileDialogForDirectories", "true"); // added so that when the FileDialog opens, you may select directories
        FileDialog fd = new FileDialog(new Frame(), "Select Input File");
        fd.setDirectory("/Users/Tom/Desktop/Machine Learning/Lab1/ptronData");

        fd.setVisible(true);
        System.out.println(fd.getDirectory());
        System.out.println(fd.getFile());

        System.setProperty("apple.awt.fileDialogForDirectories", "false");// Changing this back
        return fd.getDirectory() + fd.getFile();
        // return the complete path

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton echoButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton openButton;
    private javax.swing.JTextArea outputTA;
    private javax.swing.JButton runButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextArea theTA;
    // End of variables declaration//GEN-END:variables

    void setTheTA(String s) {
        theTA.append(s);
    }

    void setTACarat(int i) {
        theTA.setCaretPosition(i);
    }

    void setTheOutputTA(String s) {
        outputTA.append(s);
    }

    void setOutputTACarat(int i) {
        outputTA.setCaretPosition(i);
    }

    void setTAFont(Font font) {
        theTA.setFont(font);
    }

    void setTAFontColor(Color c) {
        theTA.setForeground(c);
    }

    void clearTheTA() {
        theTA.setText("");
    }

}