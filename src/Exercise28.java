/*
Remove all non-numeric characters from a list.
Input: List<String> list = Arrays.asList("a1b2c3","1a2b3c","123abc");
Output: [123,123,123]
 */
void main() {
    List<String> list = Arrays.asList("a1b2c3","1a2b3c","123abc");
    Pattern pattern = Pattern.compile("[^0-9]");
    List<String> ans = list.stream().map(x->pattern.matcher(x).replaceAll(""))
            .collect(Collectors.toList());
    System.out.println(ans);
}
/*
Line 1 — Creating the List

List<String> list = Arrays.asList("a1b2c3","1a2b3c","123abc");
```
Creates a `List<String>` with 3 strings:
```
list → ["a1b2c3", "1a2b3c", "123abc"]

Line 2 — Pattern.compile("[^0-9]")

Pattern pattern = Pattern.compile("[^0-9]");
```
This compiles a **regex pattern**. Let's break the regex `[^0-9]`:

| Part | Meaning |
|------|---------|
| `[ ]` | Character class — matches one character inside the brackets |
| `0-9` | Any digit from 0 to 9 |
| `^` (inside `[ ]`) | **Negation** — means "anything that is NOT" |

So `[^0-9]` means → **match any character that is NOT a digit.**
```
"a1b2c3"  →  a, b, c  are matched (non-digits)
             1, 2, 3  are NOT matched (digits)
Pattern.compile() is used outside the stream intentionally — so the regex
is compiled once and reused, instead of recompiling for every element
inside the stream (which would be inefficient).

Line 3 — .map(x -> pattern.matcher(x).replaceAll(""))

list.stream().map(x -> pattern.matcher(x).replaceAll(""))
```
Breaking this lambda down:

**`list.stream()`** — converts the list into a `Stream<String>`

**`.map(x -> ...)`** — transforms each string `x` one by one

Inside the lambda, for each string `x`:

**`pattern.matcher(x)`** — creates a `Matcher` object that applies the pattern against string `x`
```
x = "a1b2c3"  →  Matcher scans "a1b2c3" looking for [^0-9] matches
                  finds → 'a', 'b', 'c'
```

**`.replaceAll("")`** — replaces **every match** (all non-digits) with `""` (empty string), effectively removing them
```
"a1b2c3"  →  removes 'a','b','c'  →  "123"
"1a2b3c"  →  removes 'a','b','c'  →  "123"
"123abc"  →  removes 'a','b','c'  →  "123"

So .map() produces a new Stream<String> with digits-only strings.

Line 4 — .collect(Collectors.toList())

.collect(Collectors.toList())
```
Terminal operation — collects the transformed stream back into a `List<String>`.
```
Stream<String> ["123", "123", "123"]  →  List<String> ["123", "123", "123"]
 */