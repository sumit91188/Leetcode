package interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package interview.amazon
 * @date 5/15/21
 * @comment: Input The input to the function/method consists of five arguments - numCompetitors, an
 * integer representing the number of competitors for the Echo device; topNCompetitors, is an
 * integer representing the maximum number of competitors that Amazon wants to identify;
 * competitors, a list of strings representing the competitors; numReviews, an integer representing
 * the number of reviews from different websites that are identified by the automated webcrawler;
 * reviews, a list of string where each element is a string that consists of space-separated words
 * representing user reviews.
 * <p>
 * Output Return a list of strings representing Amazon's top N competitors in order of most
 * frequently mentioned to least frequent.
 * <p>
 * Note The comparison of strings is case-insensitive. If the value of topNCompetitors is more than
 * the number of competitors discussed in the reviews then output the names of only the competitors
 * mention. If competitors have the same count (e.g. newshop=2, shopnow=2, mymarket=4), sort
 * alphabetically. topNCompetitors=2, Output=[mymarket, newshop]
 * <p>
 * Example Input: numCompetitors=6 topNCompetitors = 2 competitors = [newshop, shopnow, afashion,
 * fashionbeats, mymarket, tcellular] numReviews = 6 reviews = [ "newshop is providing good services
 * in the city; everyone should use newshop", "best services by newshop", "fashionbeats has great
 * services in the city", "I am proud to have fashionbeats", "mymarket has awesome services",
 * "Thanks Newshop for the quick delivery"]
 * <p>
 * Output ["newshop", "fashionbeats"]
 * <p>
 * Explanation "newshop" is occurring in 3 different reviews. "fashionbeats" is occuring in 2
 * different user reviews and "mymarket" is occurring in only 1 review.
 */
public class TopNumCompetitors {

  public static void main(String[] args) {
    int numCompetitors = 6;

    int topNCompetitors = 2;

    List<String> competitorsList = new ArrayList<>();
    competitorsList.add("newshop");
    competitorsList.add("shopnow");
    competitorsList.add("afashion");
    competitorsList.add("fashionbeats");
    competitorsList.add("mymarket");
    competitorsList.add("tcellular");

    int numReviews = 6;

    String[] reviews = new String[]{
        "newshop is providing good services in the city; everyone should use newshop",
        "best services by newshop",
        "fashionbeats has great services in the city",
        "I am proud to have fashionbeats",
        "mymarket has awesome services",
        "Thanks Newshop for the quick delivery"};

    List<String> reviewList = Arrays.asList(reviews);

    Solution solution = new Solution();
    List<String> topCompetitors = solution
        .topNumCompetitors(numCompetitors, topNCompetitors, competitorsList, numReviews, reviewList);
  }

  private static class Solution {

    public List<String> topNumCompetitors(int numCompetitors, int topNCompetitors,
        List<String> competitorsList, int numReviews, List<String> reviewList) {

      List<HashSet<String>> reviewsSetList = new ArrayList<>();

      for (int i = 0; i <= numReviews - 1; i++) {
        HashSet<String> set = new HashSet<>();
        String[] words = reviewList.get(i).split("\\s");
        for (String word : words) {
          set.add(word);
        }
        reviewsSetList.add(set);
      }

      HashMap<String, Integer> countMap = new HashMap<>();

      for (String competitor: competitorsList) {
        for (HashSet<String> set: reviewsSetList) {
          if (set.contains(competitor)) {
            int count = countMap.getOrDefault(competitor, 0);
            countMap.put(competitor, ++count);
          }
        }
      }

      ArrayList<String> competitors = new ArrayList<>();

      for (Entry<String, Integer> entry: countMap.entrySet()) {
        competitors.add(entry.getValue() + entry.getKey());
      }

      Collections.sort(competitors, Collections.reverseOrder());
      List<String> result = new ArrayList<>();
      for (int i = 0; i <= Math.min(topNCompetitors, competitors.size()) - 1; i++) {
        result.add(competitors.get(i).substring(1));
      }
      return result;
    }
  }
}
