package org.example.compositePattern.problemStatement;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    String dirName;
    List<Object> dirObjects;

    public Directory(String dirName){
        this.dirName = dirName;
        this.dirObjects = new ArrayList<>();
    }

    public void add(Object dirObject){
        dirObjects.add(dirObject);
    }

    public void ls(){
        System.out.println("Directory name - " + dirName);
        for(Object obj : dirObjects){
            if(obj instanceof File){
                ((File) obj).ls();
            }else if(obj instanceof Directory){
                ((Directory) obj).ls();
            }
        }
    }
}
