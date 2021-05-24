package interview.amazon;

import java.util.*;

/**
 * @author Sumit Deo
 * @Date 5/19/21
 * @Project Leetcode
 * @Comments
 */
public class ProcessLogs {
    public static void main(String[] args) {
        String[] logs = new String[]{"88 99 100", "088 099 300", "99 32 100", "012 12 15"};
        Solution solution = new Solution();

        List<String> results = solution.processLogs(Arrays.asList(logs), 2);
        System.out.println(results);
    }

    private static class Solution {
        public List<String> processLogs(List<String> logs, int threshold) {
            List<String> result = new ArrayList<>();
            Map<String, Integer> countMap = new TreeMap<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int i1 = Integer.parseInt(o1);
                    int i2 = Integer.parseInt(o2);
                    if (i1 > i2) return -1;
                    if (i2 > i1) return 1;
                    else return 0;
                }
            });

            for (String log: logs) {
                String[] words = log.split("\\s");
                countMap.put(words[0], countMap.getOrDefault(words[0], 0) + 1);

                if (Integer.parseInt(words[0]) == Integer.parseInt(words[1])) {
                    continue;
                }

                countMap.put(words[1], countMap.getOrDefault(words[1], 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() >= threshold) {
                    result.add(entry.getKey());
                }
            }
            return result;
        }
    }
}
