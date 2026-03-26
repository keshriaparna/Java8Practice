/*
Given the string[] group the strings based on the middle character.
Input: String[] str = {"ewe","jji","jhj","kwk","aha"};
Output: {w=[ewe,kwk],h=[jhj,aha],j=[jji]}
 */
void main() {
    String[] str = {"ewe","jji","jhj","kwk","aha"};
    System.out.println(Stream.of(str).collect(Collectors.groupingBy(x->x.toString()
            .substring(1,2))));
}
/*
Stream.of(str) - Converts the array into a Stream<String> so we can apply functional operations on it.

.collect(Collectors.groupingBy(x -> x.toString().substring(1, 2)))
```
This is the core part. Breaking it down further:

| Part | What it does |
|---|---|
| `x -> x.toString()` | Each string `x` as-is (redundant here since `x` is already a String) |
| `.substring(1, 2)` | Extracts the **middle character** (index 1 to 2, exclusive) from each string |
| `Collectors.groupingBy(...)` | Groups elements into a `Map` using the extracted character as the **key** |

---

### What `substring(1,2)` extracts:

| Word | Middle Char |
|---|---|
| `"ewe"` | `"w"` |
| `"jji"` | `"j"` |
| `"jhj"` | `"h"` |
| `"kwk"` | `"w"` |
| `"aha"` | `"h"` |

---

### Output
```
{w=[ewe, kwk], j=[jji], h=[jhj, aha]}
 */