/*
Given a list of strings, create a list that contains only integers.
Input: String[] s = {"abc","123","456","xyz"};
Output: [123,456]

The approach we are using for this question is regular expression as there are sequence of characters to deal with,
we can do pattern matching and find out for the numeric part, extract it and put that in a list.
 */
void main() {
    String[] s = {"abc","123","456","xyz"};
    List<Integer> ans = Arrays.stream(s).filter(x->x.matches("[0-9]+")).map(Integer::valueOf)
            .collect(Collectors.toList());
    System.out.println(ans);
}
/*
Explanation
String[] s = {"abc", "123", "456", "xyz"};
```

---

### Step 1: `Arrays.stream(s)`
Converts `String[]` into **`Stream<String>`**:
```
Stream<String> → "abc", "123", "456", "xyz"
```

---

### Step 2: `.filter(x -> x.matches("[0-9]+"))`

This is the **main logic** — let me break the regex:

#### What is `[0-9]+`?
```
[0-9]  → matches any digit from 0 to 9
+      → one or more of the preceding character
```

#### So `[0-9]+` means:
> **"Entire string must contain only digits, at least one digit"**
```
"abc" → matches("[0-9]+") → false ❌ (has letters)
"123" → matches("[0-9]+") → true  ✅ (all digits)
"456" → matches("[0-9]+") → true  ✅ (all digits)
"xyz" → matches("[0-9]+") → false ❌ (has letters)
```

#### After filter:
```
Stream<String> → "123", "456"
```
---
### Step 3: `.map(Integer::valueOf)`
Converts each **String → Integer**:
```
"123" → Integer.valueOf("123") → 123
"456" → Integer.valueOf("456") → 456

Stream<Integer> → 123, 456

.map(Integer::valueOf)
// is same as
.map(x -> Integer.valueOf(x))
```
---

### Step 4: `.collect(Collectors.toList())`
Collects into **`List<Integer>`**:
```
List<Integer> → [123, 456]
```
---
### Output:
```
[123, 456]
```
---
### Full Flow Visualized:
```
String[] = {"abc", "123", "456", "xyz"}
        ↓ Arrays.stream(s)
Stream<String> → "abc", "123", "456", "xyz"
        ↓ filter(x -> x.matches("[0-9]+"))
"abc" ❌
"123" ✅
"456" ✅
"xyz" ❌
Stream<String> → "123", "456"
        ↓ map(Integer::valueOf)
Stream<Integer> → 123, 456
        ↓ collect(Collectors.toList())
List<Integer> → [123, 456]

// ✅ Filter only alphabetic strings
Arrays.stream(s)
      .filter(x -> x.matches("[a-zA-Z]+"))
      .collect(Collectors.toList());
// Output: ["abc", "xyz"]

// ✅ Filter alphanumeric strings
Arrays.stream(s)
      .filter(x -> x.matches("[a-zA-Z0-9]+"))
      .collect(Collectors.toList());
// Output: ["abc", "123", "456", "xyz"]

// ✅ Convert numeric strings to Integer and find sum
int sum = Arrays.stream(s)
               .filter(x -> x.matches("[0-9]+"))
               .mapToInt(Integer::parseInt)
               .sum();
// Output: 579  (123 + 456)

Regex Quick Reference:
Pattern              Meaning                    Example match
[0-9]              single digit                     "5"
[0-9]+             one or more digits               "123"
[a-z]+          one or more lowercase letters       "abc"
[A-Z]+          one or more uppercase letters       "ABC"
[a-zA-Z]+       one or more letters (any case)      "abc" or "ABC"
[a-zA-Z0-9]+    one or more letters or digits       "abc123"

All Quantifiers in Regex:
Symbol      Meaning         Example         Matches
+       one or more         [0-9]+      "1", "12", "123"
*       zero or more        [0-9]*       "", "1", "12"
?       zero or one         [0-9]?       "", "1" only
{n}     exactly n           [0-9]{3}       "123" only
{n,}    n or more           [0-9]{2,}    "12", "123", "1234"
{n,m}   between n and m    [0-9]{2,4}    "12","123", "1234"
 */