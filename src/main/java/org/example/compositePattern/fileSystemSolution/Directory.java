package org.example.compositePattern.fileSystemSolution;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
    String dirName;
    List<FileSystem> dirObjs;
    public Directory(String dirName){
        this.dirName = dirName;
        this.dirObjs = new ArrayList<FileSystem>();
    }
    public void add(FileSystem obj){
        dirObjs.add(obj);
    }
    @Override
    public void ls() {
        System.out.println("Directory name - " + dirName);
        for(FileSystem obj : dirObjs ){
            obj.ls();
        }
    }
}
