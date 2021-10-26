package Int2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MaxUnitsTruck {
  class Box{
    int numberOfBoxes;
    int unitsPerBox;
    public Box(int nob, int upb){
      this.numberOfBoxes=nob;
      this.unitsPerBox=upb;
    }
  }
  public int maximumUnits(int[][] boxTypes, int truckSize) {
    ArrayList<Box> boxes = new ArrayList<>();
    for(int i=0; i< boxTypes.length; i++){
      int nob = boxTypes[i][0];
      int upb = boxTypes[i][1];
      Box b = new Box(nob, upb);
      boxes.add(b);
    }

    Collections.sort(boxes, new Comparator<Box>() {
      @Override
      public int compare(Box o1, Box o2) {
        return o2.unitsPerBox - o1.unitsPerBox;
      }
    });

    int res =0;
    int i=0;
    while(truckSize > 0 && i < boxes.size()){
      if(truckSize - boxes.get(i).numberOfBoxes >= 0){
        res = res + boxes.get(i).numberOfBoxes * boxes.get(i).unitsPerBox;
        truckSize = truckSize - boxes.get(i).numberOfBoxes;
      }else{
        res = res + truckSize*boxes.get(i).unitsPerBox;
        truckSize=0;
      }
      i++;
    }
    return res;
  }
}
