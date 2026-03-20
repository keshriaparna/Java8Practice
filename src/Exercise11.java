/*
Given a string, find the first non-repeated character
Input:  String s = "Hello World"
Output: H
 */
void main() {
    String s = "Hello World";
    /*
    Converting string into array of string(single character string) by splitting and then converting array of string into stream of string
    then filtering if the first index of character is same as the last index of the character then it has one occurrence(means not repeating)
    finding the first using findFirst() - it returns an optional so using get().

All terminal operations that return Optional:
.findFirst()   // → Optional  (first element)
.findAny()     // → Optional  (any element)
.min(...)      // → Optional  (minimum element)
.max(...)      // → Optional  (maximum element)
.reduce(...)   // → Optional  (reduced value)

Terminal operations that do NOT return Optional:
java.count()       // → long
.forEach()     // → void
.collect()     // → Collection
.sum()         // → int (IntStream)
.average()     // → OptionalDouble (special case!)

Safe ways to unwrap Optional (instead of .get()):

// ✅ Way 1 — .get() (unsafe — throws exception if empty!)
.findFirst().get();

// ✅ Way 2 — .orElse() (safe — gives default if empty)
.findFirst().orElse("Not Found");

// ✅ Way 3 — .orElseThrow() (throws custom exception if empty)
.findFirst().orElseThrow(() -> new RuntimeException("Not found!"));

// ✅ Way 4 — .isPresent() (check before getting)
Optional<String> opt = .findFirst();
if(opt.isPresent()) {
    System.out.println(opt.get());
}

// ✅ Way 5 — .ifPresent() (runs only if value exists)
.findFirst().ifPresent(System.out::println);
     */
    String ans = Arrays.stream(s.split(""))
            .filter(c->s.indexOf(c)==s.lastIndexOf(c))
            .findFirst().get();
    System.out.println(ans);
    //another way
    char ans1= s.chars().mapToObj(c->(char)c)
            .collect(Collectors.groupingBy(Function.identity(),
                    LinkedHashMap::new,
                    Collectors.counting()))
            .entrySet().stream()
            .filter(m->m.getValue()==1)
            .map(m->m.getKey())
            .findFirst().get();
    System.out.println(ans1);
    /*
    chars() - converts it into Intstream (ASCII value of characters),mapToObj() - mapping it to object and type casting it to char
    grouping on the character to count the occurrence of each character using LinkedHashMap to maintain the insertion order.
    entrySet().stream() - converting each entry to stream of entries and filter those which have the count equal to one (i.e. the value
    in LinkedHashmap) , getting the key and finding the first out of those characters, .get - to unwrap optional
     */
}