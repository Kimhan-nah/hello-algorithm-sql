import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int[] arr1 = new int[N - N / 2];
		int[] arr2 = new int[N / 2];
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			if (i < arr1.length) {
				arr1[i] = Integer.parseInt(st.nextToken());
			} else {
				arr2[i - arr1.length] = Integer.parseInt(st.nextToken());
			}
		}

		combi(arr1, list1, 0, 0);
		combi(arr2, list2, 0, 0);

		list1.sort(null);
		list2.sort(null);

		solution(list1, list2);
	}

	private static void solution(List<Integer> list1, List<Integer> list2) {
		int answer = 0;
		for (Integer weight : list1) {
			int remainderWeight = C - weight;
			if (remainderWeight < 0) {
				break;
			}
			int count = binarySearch(list2, remainderWeight);
			answer += count;
		}
		System.out.println(answer);
	}

	private static void combi(int[] arr, List<Integer> list, int sum, int index) {
		if (index == arr.length || sum > C) {
			list.add(sum);
			return;
		}
		combi(arr, list, sum, index + 1);
		combi(arr, list, sum + arr[index], index + 1);
	}

	private static int binarySearch(List<Integer> list, int target) {
		int left = 0;
		int right = list.size() - 1;

		while (left <= right) {
			int mid = (right + left) / 2;
			if (list.get(mid) > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		while (left < list.size() && list.get(left) == target) {
			++left;
		}
		return left;
	}
}
