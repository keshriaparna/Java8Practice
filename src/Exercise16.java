/*
Group/Pair anagrams from a list of strings. For 1 word consider
only 1 anagram.
Input: String s = {"pat","tap","pan","nap","Team","tree","meat"};
Output: [[pan,nap],[pat,tap],[Team,meat],[tree]]
 */
void main() {
    String[] s = {"pat","tap","pan","nap","Team","tree","meat"};
    List<String> list = Arrays.asList(s);
    Collection<List<String>> ans = list.stream().collect(Collectors
            .groupingBy(x->Arrays.stream(x.toLowerCase().split("")).sorted()
                    .collect(Collectors.toList()))).values();
    System.out.println(ans);
}
/*
### Full Flow Visualized:
```
{"pat","tap","pan","nap","Team","tree","meat"}
        ↓ list.stream()
Stream<String>
        ↓ groupingBy(x -> sorted letters of x)

"pat"  → sort letters → [a,p,t]   ┐
"tap"  → sort letters → [a,p,t]   ┘ same key → ["pat","tap"]

"pan"  → sort letters → [a,n,p]   ┐
"nap"  → sort letters → [a,n,p]   ┘ same key → ["pan","nap"]

"Team" → sort letters → [a,e,m,t] ┐
"meat" → sort letters → [a,e,m,t] ┘ same key → ["Team","meat"]

"tree" → sort letters → [e,e,r,t]   unique key → ["tree"]
 ↓ .values()
 Collection<List<String>>
[[pat,tap],[pan,nap],[Team,meat],[tree]]

Key Concepts used:
Method                    Purpose
x.toLowerCase()      makes comparison case-insensitive
split("")            splits word into individual letters
sorted()             sorts letters alphabetically
collect(toList())    makes sorted letters into a List (used as key)
groupingBy(...)      groups words with same sorted letters together
.values()            extracts only values from Map, discards keys


// Without toLowerCase() ❌
"Team" → sort → [T,a,e,m]   ← T is uppercase!
"meat" → sort → [a,e,m,t]   ← t is lowercase!
// Different keys → NOT grouped together! ❌

// With toLowerCase() ✅
"Team" → toLowerCase → "team" → sort → [a,e,m,t]
"meat" → toLowerCase → "meat" → sort → [a,e,m,t]
// Same keys → grouped together! ✅

This program groups anagrams together! The trick is
— for each word, sort its letters alphabetically to
create a key. Words that are anagrams will have the
exact same key after sorting! groupingBy groups them
by this key, and .values() gives us just the groups
without the keys!
 */