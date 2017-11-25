package main;

import controllers.MapController;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static javax.script.ScriptEngine.FILENAME;
import models.Grid;
import models.MapModel;
import searches.*;
import util.Coordinates;
import util.TreeNode;
import views.ButtonGridView;
import static views.MapSelection.a;
import static views.MapSelection.sa;
import static views.MapSelection.ucs;
import static views.MapSelection.wa;
import views.MapView;

public class RunMVCTestExperimental {

    public RunMVCTestExperimental(char[][] char_map, ArrayList<Coordinates> start_end_pair, String selectedSearch, String selectedH, double weight, double w2) throws Exception{
      //The map and variant will be passed to buttonGridView
      ButtonGridView theBGView  = new ButtonGridView(char_map, start_end_pair);
      int[] start = new int[] {start_end_pair.get(0).get_x_coordinate(), start_end_pair.get(0).get_y_coordinate()};
      int[] goal = new int[] {start_end_pair.get(1).get_x_coordinate(), start_end_pair.get(1).get_y_coordinate()};

      MapModel theModel = new MapModel(new Grid(char_map,start,goal));
      TreeNode res;


      String FILENAME = selectedSearch;

      if(!selectedSearch.equals(ucs))
          FILENAME += selectedH;

      PrintStream output = new PrintStream(new FileOutputStream(FILENAME + ".txt", true));

      //for(int i = 0; i < 5; i++)
      if (selectedSearch.equals(ucs)){
        UniformCostSearch ucs = new UniformCostSearch();
        res = ucs.uniformCostSearch(theModel.grid.g.list,start,goal);
        theModel.updateCoordinates(goal[0],goal[1]);

        output.println("Explored Count: " + ucs.getExploredCount());
        output.println("f-value: "        + String.format("%.4f",theModel.get_f_value()));
        output.println("g-value: "        + String.format("%.4f",theModel.get_g_value()));
        output.println("Total time: "     + String.format("time:  %.3f ms", (double)theModel.get_time_value() / Math.pow(10, 6)));
      }

      else if (selectedSearch.equals(a)){
        AStarSearch ass = new AStarSearch();
        res = ass.aStarSearch(theModel.grid.g.list, start, goal,selectedH);

        theModel.updateCoordinates(goal[0],goal[1]);
        output.println("Explored Count: " + ass.getExploredCount());
        output.println("f-value: "        + String.format("%.4f",theModel.get_f_value()));
        output.println("g-value: "        + String.format("%.4f",theModel.get_g_value()));
        output.println("Total time: "     + String.format("time:  %.3f ms", (double)theModel.get_time_value() / Math.pow(10, 6)));
      }
      /*
      else if (selectedSearch.equals(wa))
      {
        WeightedAStarSearch wass = new WeightedAStarSearch();
        res = wass.weightedAStarSearch(theModel.grid.g.list, start, goal, weight,selectedH);
      }
      else if (selectedSearch.equals(sa)){
          SequentialAStarSearch sass = new SequentialAStarSearch();
          res =  sass.sequentialAStarSearch(theModel.grid.g.list, start, goal, weight, w2);
      }
      else res = null;
      if (res == null) throw new Exception("goal not found");

      output.printf("result = %d, %d \n",res.coord[0], res.coord[1]);
      theBGView.tracePath(res);

      MapView        theMapView = new MapView(theBGView);


      //MapController theMapController = new MapController(theMapView,theModel);
      MapController theMapController = new MapController(theBGView, theMapView, theModel);
      //theMapView.setVisible(true);
      */



    }
}
//reference: http://www.newthinktank.com/2013/02/mvc-java-tutorial/
