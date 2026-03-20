/*
Given a list of integers, divide it into two lists one having
an even number and the other having an odd number.
Input: int[] arr = {1,2,3,4,5,6,7,8};
Output: [[1,3,5,7],[2,4,6,8]]
 */
void main() {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
    //convert the primitive array to list of integers using boxed function and then collecting in new List
    List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
    List<List<Integer>> checkList = list.stream()
            .collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.toList()))
                    .entrySet().stream().map(x->x.getValue()).collect(Collectors.toList());

    System.out.println(checkList);
}
/*
int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
```
## 🔷 Part 1: Convert primitive array to List

### Line 1: `Arrays.stream(arr)`
Converts `int[]` into **`IntStream`**:
```
IntStream → 1, 2, 3, 4, 5, 6, 7, 8
```

### Line 2: `.boxed()`
Converts **primitive `int`** → **`Integer` objects**:
```
IntStream        → Stream<Integer>
(primitives)       (objects/wrapper class)

1 → Integer(1)
2 → Integer(2)
... and so on
```
> ⚠️ We need `.boxed()` because **`Collectors.toList()` needs objects, not primitives!**

### Line 3: `.collect(Collectors.toList())`
Collects into **`List<Integer>`**:
```
List<Integer> → [1, 2, 3, 4, 5, 6, 7, 8]

int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
```
---
## 🔷 Part 1: Convert primitive array to List

### Line 1: `Arrays.stream(arr)`
Converts `int[]` into **`IntStream`**:
```
IntStream → 1, 2, 3, 4, 5, 6, 7, 8
```
### Line 2: `.boxed()`
Converts **primitive `int`** → **`Integer` objects**:
```
IntStream        → Stream<Integer>
(primitives)       (objects/wrapper class)

1 → Integer(1)
2 → Integer(2)
... and so on
```
> ⚠️ We need `.boxed()` because **`Collectors.toList()` needs objects, not primitives!**

### Line 3: `.collect(Collectors.toList())`
Collects into **`List<Integer>`**:
```
List<Integer> → [1, 2, 3, 4, 5, 6, 7, 8]

🔷 Part 2: Using groupingBy approach
javaList<List<Integer>> checkList = list.stream()
    .collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.toList()))
    .entrySet().stream()
    .map(x -> x.getValue())
    .collect(Collectors.toList());
```

### Step 1: `list.stream()`
```
Stream<Integer> → 1, 2, 3, 4, 5, 6, 7, 8
```

### Step 2: `groupingBy(x -> x % 2 == 0, Collectors.toList())`
Groups into **Map<Boolean, List\<Integer\>>**:
```
1 % 2 == 0 → false (odd)
2 % 2 == 0 → true  (even)
3 % 2 == 0 → false (odd)
4 % 2 == 0 → true  (even)
...

Map:
{
  false → [1, 3, 5, 7]   // odd
  true  → [2, 4, 6, 8]   // even
}

### Step 3: `.entrySet().stream()`
Converts Map entries into a Stream:
```
Stream → Entry(false,[1,3,5,7]), Entry(true,[2,4,6,8]

### Step 4: `.map(x -> x.getValue())`
Extracts only the **values** (Lists), discards keys:
```
[1, 3, 5, 7]
[2, 4, 6, 8]
```
### Step 5: `.collect(Collectors.toList())`
Wraps into **`List<List<Integer>>`**:
```
[[1, 3, 5, 7], [2, 4, 6, 8]]
```
### Output:
```
[[1, 3, 5, 7], [2, 4, 6, 8]]

🔷 Part 3: Same thing using partitioningBy
javaList<List<Integer>> checkList = list.stream()
    .collect(Collectors.partitioningBy(x -> x % 2 == 0))
    .entrySet().stream()
    .map(x -> x.getValue())
    .collect(Collectors.toList());

System.out.println(checkList);
```

### Step 1: `partitioningBy(x -> x % 2 == 0)`
Splits into exactly **2 groups — true and false**:
```
Map<Boolean, List<Integer>>:
{
  false → [1, 3, 5, 7]   // odd  (condition false)
  true  → [2, 4, 6, 8]   // even (condition true)
}
```
### Step 2: `.entrySet().stream()`
```
Stream → Entry(false,[1,3,5,7]), Entry(true,[2,4,6,8])
```
### Step 3: `.map(x -> x.getValue())`
```
[1, 3, 5, 7]
[2, 4, 6, 8]
```

### Step 4: `.collect(Collectors.toList())`
```
[[1, 3, 5, 7], [2, 4, 6, 8]]
```
### Output:
```
[[1, 3, 5, 7], [2, 4, 6, 8]]
```
---
## 🔷 Full Flow Comparison:
```
int[] arr = {1, 2, 3, 4, 5, 6, 7, 8}
        ↓ Arrays.stream(arr)
IntStream → 1,2,3,4,5,6,7,8  (primitives)
        ↓ .boxed()
Stream<Integer> → 1,2,3,4,5,6,7,8  (objects)
        ↓ collect(toList())
List<Integer> → [1,2,3,4,5,6,7,8]
        ↓
   groupingBy ──────────────── partitioningBy
        ↓                            ↓
{false→[1,3,5,7],          {false→[1,3,5,7],
 true→[2,4,6,8]}            true→[2,4,6,8]}
        ↓                            ↓
   entrySet().stream()          entrySet().stream()
        ↓                            ↓
   map(getValue())             map(getValue())
        ↓                            ↓
[[1,3,5,7],[2,4,6,8]]    [[1,3,5,7],[2,4,6,8]]

🔷 groupingBy vs partitioningBy:
Feature          groupingBy              partitioningBy
Key type       Map<K, List> — any type   Map<Boolean, List> — only true/false
No of groups    many groups possible      always exactly 2 groups
Condition        any classifier           only predicate (true/false)
Empty group    missing if no elements     always has both keys even if empty
Use when       grouping by category       splitting by condition
 */