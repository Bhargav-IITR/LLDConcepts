package org.example.compositePattern.problemStatement;

public class File {
    String fileName;
    public File(String fileName){
        this.fileName = fileName;
    }

    void ls(){
        System.out.println("File name : " + fileName);
    }
}
