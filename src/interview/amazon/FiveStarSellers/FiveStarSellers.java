package interview.amazon.FiveStarSellers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium.FiveStarSellers
 * @date 10/8/20
 * @comment:
 */
public class FiveStarSellers {
  public static void main(String[] args) {
    List<List<Integer>> ratings = new ArrayList(){
      {
        add(Arrays.asList(4,4));
        add(Arrays.asList(1,2));
        add(Arrays.asList(3,6));
      }
    };
    int threshold = 77;
    System.out.println(fiveStarReviews(ratings, threshold));
  }

  private static int fiveStarReviews(List<List<Integer>> ratings, int threshold) {

    int count = 0;
    if (threshold > 100) {
      return 0;
    }

    for (List<Integer> rating : ratings) {
      if (rating.get(0) > rating.get(1)) {
        return 0;
      }
    }

    double currentRating = 0;
    PriorityQueue<List<Integer>> ratingsQueue = new PriorityQueue<>((rating1, rating2) -> (diff(rating2) - diff(rating1)));
    for (List<Integer> rating : ratings) {
      ratingsQueue.offer(rating);
      currentRating += 100.0 * rating.get(0) / rating.get(1);
    }

    while (currentRating / 3 < threshold) {
      List<Integer> rating = ratingsQueue.poll();
      List<Integer> newRating = Arrays.asList(rating.get(0) + 1, rating.get(1) + 1);
      ratingsQueue.offer(newRating);
      currentRating = currentRating - 100.0 * rating.get(0) / rating.get(1) + 100.0 * newRating.get(0) / newRating.get(1);
      count++;
    }

    return count;
  }

  private static int diff(List<Integer> rating) {
    double oldPercentage = 100.0 * rating.get(0) / rating.get(1);
    double newPercentage = 100.0 * (rating.get(0) + 1) / (rating.get(1) + 1);
    return (int) (newPercentage - oldPercentage);
  }
}
