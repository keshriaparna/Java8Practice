/*
Given a sentence, find the words with a specified number of vowels.
No. of vowels: 2
Input : String s = "I am learning Streams API in Java"
Output : Streams
         API
         Java
 */
void main() {
    String s = "I am learning Streams API in Java";
    Arrays.stream(s.split(" ")).filter(x->x.replaceAll("[^aeiouAEIOU]","").length()==2)
            .forEach(System.out::println);
}
/*
String s = "I am learning Streams API in Java";
```

---

### Step 1: `s.split(" ")`
Splits string by space into **String array**:
```
["I", "am", "learning", "Streams", "API", "in", "Java"]
```

---

### Step 2: `Arrays.stream(...)`
Converts array into **`Stream<String>`**:
```
Stream → "I", "am", "learning", "Streams", "API", "in", "Java"
```

---

### Step 3: `.filter(x -> x.replaceAll("[^aeiouAEIOU]", "").length() == 2)`

This is the **main logic** — let me break the filter condition itself:

#### What is `[^aeiouAEIOU]`?
It is a **regex pattern**:
```
[aeiouAEIOU]  → matches vowels  (a, e, i, o, u — upper and lower)
[^aeiouAEIOU] → matches NON-vowels (consonants, spaces, symbols)
                 ↑
                 ^ means NOT
What does .replaceAll("[^aeiouAEIOU]", "") do?
replaceAll() - remove all matching characters(means not vowels)
Removes all non-vowels — keeps only vowels in the word!

java"I"        → replaceAll → "I"        → length = 1
"am"       → replaceAll → "a"        → length = 1
"learning" → replaceAll → "eai"      → length = 3
"Streams"  → replaceAll → "ea"       → length = 2  ✅
"API"      → replaceAll → "AI"       → length = 2  ✅
"in"       → replaceAll → "i"        → length = 1
"Java"     → replaceAll → "aa"       → length = 2  ✅
```

#### `.length() == 2`
> Keeps only words that have **exactly 2 vowels**!
```
"I"        → 1 vowel  ❌ filtered out
"am"       → 1 vowel  ❌ filtered out
"learning" → 3 vowels ❌ filtered out
"Streams"  → 2 vowels ✅ kept!
"API"      → 2 vowels ✅ kept!
"in"       → 1 vowel  ❌ filtered out
"Java"     → 2 vowels ✅ kept!
```

---

### Step 4: `.forEach(System.out::println)`
Prints each word that passed the filter:
```
Streams
API
Java
```

---

### Full Flow Visualized:
```
"I am learning Streams API in Java"
        ↓ split(" ")
["I", "am", "learning", "Streams", "API", "in", "Java"]
        ↓ Arrays.stream()
Stream<String>
        ↓ filter(x -> x.replaceAll("[^aeiouAEIOU]","").length() == 2)

"I"        → "I"   → length 1 ❌
"am"       → "a"   → length 1 ❌
"learning" → "eai" → length 3 ❌
"Streams"  → "ea"  → length 2 ✅
"API"      → "AI"  → length 2 ✅
"in"       → "i"   → length 1 ❌
"Java"     → "aa"  → length 2 ✅

        ↓ forEach(System.out::println)
Streams
API
Java
 */