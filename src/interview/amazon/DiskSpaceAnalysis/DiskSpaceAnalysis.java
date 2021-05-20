package interview.amazon.DiskSpaceAnalysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium.DiskSpaceAnalysis
 * @date 10/6/20
 * @comment:
 */
public class DiskSpaceAnalysis {
  public static void main(String[] args) {
    int numComputer = 5;
    int[] hardDiskSpace = {8,2,4,3,1};
    int segmentLength = 2;

    System.out.println(solve(numComputer, hardDiskSpace, segmentLength));
  }

  private static int solve(int numComputer, int[] hardDiskSpace, int segmentLength) {
    if (numComputer != hardDiskSpace.length || numComputer < segmentLength) {
      throw new RuntimeException("Invalid input");
    }

    List<Integer> minimas = new ArrayList<>();
    int segCount = 0;
    int index = 0;
    int min = Integer.MAX_VALUE;
    while (true) {
      if (segCount == segmentLength) {
        segCount = 0;
        minimas.add(min);
        index--;
        min = Integer.MAX_VALUE;
        continue;
      }
      if (index == numComputer) {
        break;
      }
      if (min > hardDiskSpace[index]) {
        min = hardDiskSpace[index];
      }
      segCount++;
      index++;
    }

    Collections.sort(minimas, Collections.reverseOrder());
    return minimas.get(0);
  }
}
