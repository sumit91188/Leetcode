package amazon.arraysAndStrings;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/27/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/502/
 */
public class VersionNums {
  public static void main(String[] args) {
    String version11 = "1.01", version21 = "1.001";
    String version12 = "1.0", version22 = "1.0.0";
    String version13 = "0.1", version23 = "1.1";
    String version14 = "1.0.1", version24 = "1";
    String version15 = "7.5.2.4", version25 = "7.5.3";

    System.out.println(compareVersion(version11, version21));
    System.out.println(compareVersion(version12, version22));
    System.out.println(compareVersion(version13, version23));
    System.out.println(compareVersion(version14, version24));
    System.out.println(compareVersion(version15, version25));
  }

  private static int compareVersion(String version1, String version2) {
    /*int revCount1 = (int) version1.chars().filter(ch -> ch == '.').count();
    int revCount2 = (int) version2.chars().filter(ch -> ch == '.').count();

    if (revCount1 < revCount2) {
      while (revCount2 - revCount1 > 0) {
        version1 += ".0";
        revCount1++;
      }
    }
    else if (revCount2 < revCount1) {
      while (revCount1 - revCount2 > 0) {
        version2 += ".0";
        revCount2++;
      }
    }

    int comparedRev = 0;
    while (comparedRev <= revCount1) {
      String str1, str2;
      if (version1.indexOf('.') != -1) {
        str1 = version1.substring(0, version1.indexOf('.'));
        str2 = version2.substring(0, version2.indexOf('.'));
      }
      else {
        str1 = version1;
        str2 = version2;
      }


      if (Integer.valueOf(str1) < Integer.valueOf(str2)) {
        return -1;
      }
      else if (Integer.valueOf(str1) > Integer.valueOf(str2)) {
        return 1;
      }
      else {
        version1 = version1.substring(version1.indexOf('.') + 1);
        version2 = version2.substring(version2.indexOf('.') + 1);
        comparedRev++;
      }
    }

    return 0;*/
    String[] version1List = version1.split("\\.");
    String[] version2List = version2.split("\\.");

    for (int i = 0; i <= Math.max(version1List.length, version2List.length); i++) {
      int i1 = i < version1List.length ? Integer.parseInt(version1List[i]) : 0;
      int i2 = i < version2List.length ? Integer.parseInt(version2List[i]) : 0;
      if (i1 < i2) {
        return -1;
      }
      else if (i1 > i2) {
        return 1;
      }
    }
    return 0;
  }
}
