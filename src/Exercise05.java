/*
Given a sentence, find the occurences of each word.
Input : String s = "I am learning Streams API in Java Java"
Output : {Java=2,in=1,I=1,API=1,learning=1,am=1,Streams=1}
 */
void main() {
    String s = "I am learning Streams API in Java Java";
    Map<String,Long> ans =Arrays.stream(s.split(" "))
            //instead of Function.identity we can also write x->x
            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    System.out.println(ans);
}
/*
String s = "I am learning Streams API in Java Java";
```
---
### Step 1: `s.split(" ")`
Splits the string by space into a **String array**:
```
["I", "am", "learning", "Streams", "API", "in", "Java", "Java"]
```
---
### Step 2: `Arrays.stream(...)`
Converts String array into **`Stream<String>`**:
```
Stream → "I", "am", "learning", "Streams", "API", "in", "Java", "Java"
```

---

### Step 3: `.collect(...)`
**Terminal operation** — triggers the pipeline and collects results into a **Map**.

---

### Step 4: `Collectors.groupingBy(Function.identity(), Collectors.counting())`

This has **2 parts** — let's understand each:

#### Part 1️⃣ — `Function.identity()`
> "Group by the element itself (the word)"
```
"I"        → key = "I"
"am"       → key = "am"
"learning" → key = "learning"
"Streams"  → key = "Streams"
"API"      → key = "API"
"in"       → key = "in"
"Java"     → key = "Java"

It means use the word itself as the Map key.

Function.identity() is just shorthand for x -> x

javaFunction.identity()  ==  x -> x   // same thing!
```

#### Part 2️⃣ — `Collectors.counting()`
> "Count how many times each key (word) appears"
```
"I"        → 1
"am"       → 1
"learning" → 1
"Streams"  → 1
"API"      → 1
"in"       → 1
"Java"     → 2
```
---

### Step 5: Result stored in `Map<String, Long>`

| Key | Value (count) |
|---|---|
| `"I"` | `1` |
| `"am"` | `1` |
| `"learning"` | `1` |
| `"Streams"` | `1` |
| `"API"` | `1` |
| `"in"` | `1` |
| `"Java"` | `2` |

---

### Output:
```
{I=1, am=1, learning=1, Streams=1, API=1, in=1, Java=2}
 */