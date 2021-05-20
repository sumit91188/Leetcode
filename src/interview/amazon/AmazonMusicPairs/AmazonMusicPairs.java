package interview.amazon.AmazonMusicPairs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium.AmazonMusicPairs
 * @date 10/4/20
 * @comment: https://leetcode.com/discuss/interview-question/861432/
 */
public class AmazonMusicPairs {
  public static void main(String[] args) {
    int[] nums1 = { 37, 23, 60 };
    int[] nums2 = { 10, 50, 90, 30 };
    int[] nums3 = { 30, 20, 150, 100, 40 };
    int[] nums4 = { 60, 60, 60 };
    System.out.println(solve(nums1));
    System.out.println(solve(nums2));
    System.out.println(solve(nums3));
    System.out.println(solve(nums4));
  }

  private static int solve(int[] songs) {

    int result = 0;
    Map<Integer, Integer> map = new HashMap<>();

    /*for (int i = 0; i < songs.length - 1; i++) {
      for (int j = i + 1; j < songs.length; j++) {
        if ((songs[i] + songs[j]) % 60 == 0) {
          result++;
        }
      }
    }*/

    for (int song : songs) {
      int remainder = song % 60;
      if (map.containsKey(60 - remainder == 60 ? 0 : 60 - remainder)) {
        result = result + map.get(60 - remainder == 60 ? 0 : 60 - remainder);
      }
      map.put(remainder, map.getOrDefault(remainder, 0) + 1);
    }
    return result;
  }
}
