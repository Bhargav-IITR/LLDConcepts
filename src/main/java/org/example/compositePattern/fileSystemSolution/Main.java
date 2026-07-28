package org.example.compositePattern.fileSystemSolution;


public class Main {
    public static void main(String [] args){
        Directory systemDesign = new Directory("System design");
        File compDp = new File("Composite design pattern");
        Directory hld = new Directory("HLD");
        File chash = new File("Consistent hashing");
        File lb = new File("Load balancer");
        hld.add(chash);
        hld.add(lb);
        systemDesign.add(compDp);
        systemDesign.add(hld);

        systemDesign.ls();
    }
}
