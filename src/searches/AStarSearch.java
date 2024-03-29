/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searches;

import heuristics.*;
import util.TreeNode;

/**
 *
 * @author seobo
 */
public class AStarSearch extends AbstractSearch{
    
    public TreeNode aStarSearch(TreeNode[][] list, int[] start, int[] goal, String heur){
        chooseHeuristic(heur);
        long s = System.nanoTime();
        TreeNode res = super.abstractSearch(list, start, goal);
        this.elapsedTime = System.nanoTime() - s;;
        setTime(list);
        return res;
    }
    @Override
    public void setFandH(TreeNode node, int[] goal){
        node.h = h.getHeuristic(node,goal);
        node.f = node.g + node.h;
    }
}

