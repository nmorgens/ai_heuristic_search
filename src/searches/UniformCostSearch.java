/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searches;

import util.TreeNode;

/**
 *
 * @author seobo
 */
public class UniformCostSearch extends AbstractSearch{
    public TreeNode uniformCostSearch(TreeNode[][] list, int[] start,  int[] goal){
        return super.abstractSearch(list, start, goal);
    }
    
    @Override
    public void calcH(TreeNode node, int[]goal){
        //node.g = node.g + weight;
    }
    @Override
    public void setF(TreeNode node){
        node.f = node.g;
    }
    
}
