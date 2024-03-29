package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class TreeNode{
    public int[] coord;
    public char type;
    public boolean start = false, goal = false;
    public ArrayList<Edge> AdjacencyList;
    public TreeNode parent;
    public double g, h, w, f; // start node's g should be 0
    public long elapsedTime;


 public TreeNode(int r, int c) {
  this.coord = new int[]{r,c};
  AdjacencyList = new ArrayList<>();
  this.f = -1;
  this.g = -1;
  this.w = -1;
  this.h = -1;
 }

 public void addChild(Edge child){
   AdjacencyList.add(child);
   child.getDest().parent = this;
 }

 public List<TreeNode> getChildren() {
     List<TreeNode> tn = new ArrayList<>();
     for ( Edge edge : AdjacencyList){
         tn.add(edge.getDest());
     }
    return tn;
 }

 public static int findDistance(TreeNode root, int[] goalVertex){
  if(root.getChildren() == null)
    return -1;

  int distance = -1;

  int[] rootVert = root.coord;
  List<TreeNode> childrenList = root.getChildren();
  int numOfChildren = childrenList.size();

  if(Arrays.equals(rootVert,goalVertex))
  {
    return distance + 1;
  }

  TreeNode currNode;
  for(int i = 0; i < numOfChildren; i++){
    currNode = childrenList.get(i);
    if( (distance = findDistance(currNode, goalVertex)) >= 0)
      return distance + 1;
  }
  return distance;
 }

 //Reference: http://www.geeksforgeeks.org/find-distance-root-given-node-binary-tree/
 // modified for 2d list
}
