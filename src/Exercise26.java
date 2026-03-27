/*
Find the union of two lists of integers.
Input: List<Integer> list1 = Arrays.asList(1,2,3,4,5);
List<Integer> list2 = Arrays.asList(6,7,8,9,10);
Output: [1,2,3,4,5,6,7,8,9,10]

 */
void main() {
    List<Integer> list1 = Arrays.asList(1,2,3,4,5);
    List<Integer> list2 = Arrays.asList(6,7,8,9,10);
    List<Integer> ans = Stream.concat(list1.stream(), list2.stream())
            //Stream.concat takes a stream not list
            .collect(Collectors.toList());
    System.out.println(ans);
}
/*
Line 1 & 2 — Creating the Lists
List<Integer> list1 = Arrays.asList(1,2,3,4,5);
List<Integer> list2 = Arrays.asList(6,7,8,9,10);
```
`Arrays.asList()` converts the given values into a `List<Integer>`.
```
list1 → [1, 2, 3, 4, 5]
list2 → [6, 7, 8, 9, 10]

Line 3 — list1.stream() and list2.stream()
javalist1.stream()  →  Stream<Integer> of [1, 2, 3, 4, 5]
list2.stream()  →  Stream<Integer> of [6, 7, 8, 9, 10]
Each list is converted into its own separate Stream<Integer>.

Line 4 — Stream.concat()
javaStream.concat(list1.stream(), list2.stream())
```
`Stream.concat()` is a **static method** that takes **two streams** and joins them end-to-end into a **single stream**.
```
Stream<Integer> → [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

It does not modify the original lists — it just creates a new combined stream.

Line 5 — .collect(Collectors.toList())
java.collect(Collectors.toList())
```
`.collect()` is a **terminal operation** that ends the stream and gathers the elements into a collection. `Collectors.toList()` tells it to collect into a `List<Integer>`.
```
Stream<Integer> [1,2,3,4,5,6,7,8,9,10]  →  List<Integer> [1,2,3,4,5,6,7,8,9,10]
```
 */