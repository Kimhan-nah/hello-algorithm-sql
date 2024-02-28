# hello-algorithm
알알못 기만나가 알잘알이 되는 그날까지..!!!!!

[![Solved.ac
프로필](http://mazassumnida.wtf/api/v2/generate_badge?boj=skqkdldhf98)](https://solved.ac/skqkdldhf98)

# MST (Minimum Spanning Tree)
> 최소 신장 트리, Spanning Tree 중 사용된 가선들의 가중치 합이 최소인 트리
### 1. Kruskal MST Algorithm
 - greedy method 이용
 - 각 단계에서 사이클을 이루지 않는 최소 비용 간선 선택
 - 간선 선택 기반으로 하는 알고리즘
 - 이전 단계에서 만들어진 신장 트리와는 상관 없이 무조건 최소 간선만을 선택하는 방법

### 2. Prim MST Algorithm
 - 시작 정점에서부터 출발하여 신장트리 집합을 단계적으로 확장해 나가는 방법
 - 정점 선택 기반으로 하는 알고리즘
 - 이전 단계에서 만들어진 신장 트리를 확장하는 방법

# HashMap 활용
## 출력 방법
### 방법 1. entrySet()

```java
import java.util.HashMap;

class Main {
  public static void main(String[] args) {
    Map<Integer, Intger> map = new HashMap<>();
    Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
    for (Map.Entry<Integer, Integer> entry : entries) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }
}
```

### 방법 2. keySet()
```java
class Main {
  public static void main(String[] args) {
    Map<Integer, Intger> map = new HashMap<>();
    Set<Integer> integers = map.keySet();
    for (Integer key : map.keySet()) {
      System.out.println(key + " " + map.get(key));
    }
  }
}
```

### 방법 3. Lambda
```java
class Main {
  public static void main(String[] args) {
    Map<Integer, Intger> map = new HashMap<>();
    map.forEach((key, val) -> {
      System.out.println(key + " " + val);
    });
  }
}
```

### 방법 4. Stream 사용
- 내림차순
    ```java
    class Main {
      public static void main(String[] args) {
        Map<Integer, Intger> map = new HashMap<>();
        map.entrySet().stream().forEach(entry -> {
          System.out.println(entry.getKey() + " " + entry.getValue());
        });
      }
    }
    ```

- 오름차순
    ```java
    class Main {
      public static void main(String[] args) {
        Map<Integer, Intger> map = new HashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(entry -> {
          System.out.println(entry.getKey() + " " + entry.getValue());
        });
      }
    }
    ```

## 정렬 방법
### 방법 1. List 이용

### 방법 2. TreeMap 이용

### 방법 3. Stream 이용

### 방법 4. LinkedHashMap 이용
