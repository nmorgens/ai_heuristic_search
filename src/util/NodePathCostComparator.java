/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Comparator;

/**
 *
 * @author seobo
 */
public class NodePathCostComparator implements Comparator<Node>{
    double ep = 0.00001;
    public int compare(Node a, Node b){
        if (equals(a,b))
            return 0;
        else if ((a.g - b.g) > ep){
            return 1;
        }
        else if ((a.g - b.g) < -ep){
            return -1;
        }
        else return 0;
    }
    public boolean equals(Node a, Node b){
        if (a.g*(1 + ep)>  b.g || a.g*(1-ep) < b.g)
            return false;
        else return true;
    }
}