/*
Given a string, find the first repeated character
Input: String s = "Hello World"
Output: l
Explanation is similar to previous question only filter condition is different

Function.identity is a static method which returns whatever input give to it(can also
be written as x-> x
collectors.groupingBy returns a map.
 */
void main() {
    String s = "Hello World";
    Map<Character,Long> charMap = s.chars().mapToObj(c->(char)c)
            .collect(Collectors.groupingBy(Function.identity(),
                    LinkedHashMap::new,
                    Collectors.counting()));
    char ans = charMap.entrySet().stream().filter(m->m.getValue()>1)
            .map(m->m.getKey()).findFirst().get();

    System.out.println(ans);
    /*
    // can also be done like this
    char ans1 = s.chars().mapToObj(c->(char)c)
            .collect(Collectors.groupingBy(Function.identity(),
                    LinkedHashMap::new,
                    Collectors.counting()))
            .entrySet().stream().filter(m->m.getValue()>1)
            .map(m->m.getKey()).findFirst().get();

      // to collect all the duplicates, collect it in a list.
      List<Integer> duplicates = s.chars().mapToObj(c->(char)c)
            .collect(Collectors.groupingBy(Function.identity(),
                    LinkedHashMap::new,
                    Collectors.counting()))
            .entrySet().stream().filter(m->m.getValue()>1)
            .map(m->m.getKey()).collect(Collectors.toList());
     */
}