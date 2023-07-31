package programmers.dfs_bfs;

public class TargetNumber {
  static int answer, res;
  static int[] arr;
  static public void DFS(int cur, int index) {
    if (index == arr.length) {
      if (cur == res)
        ++answer;
      return;
    }

    DFS(cur + arr[index], index + 1);
    DFS( cur - arr[index], index + 1);
  }
  static public int solution(int[] numbers, int target) {
    arr = numbers;
    res = target;
    DFS(0, 0);
    return answer;
  }

  public static void main(String[] args) {
//    int[] numbers = {1,1,1,1, 1};
//    System.out.println(solution(numbers, 3)); // 5
    int[] numbers = {4,1,2,1};
    System.out.println(solution(numbers, 4)); // 2
  }

}
