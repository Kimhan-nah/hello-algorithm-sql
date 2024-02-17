# hello-algorithm
알알못 기만나가 알잘알이 되는 그날까지..!!!!!

[![Solved.ac
프로필](http://mazassumnida.wtf/api/v2/generate_badge?boj=skqkdldhf98)](https://solved.ac/skqkdldhf98)

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
