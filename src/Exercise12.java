/*
Given a string, find the first repeated character
Input: String s = "Hello World"
Output: l
Explanation is similar to previous question only filter condition is different
 */
void main() {
    String s = "Hello World";
    Map<Character,Long> charMap = s.chars().mapToObj(c->(char)c)
            .collect(Collectors.groupingBy(Function.identity(),
                    LinkedHashMap::new,
                    Collectors.counting()));
    List<Character> ans = charMap.entrySet().stream().filter(m->m.getValue()>1)
            .map(m->m.getKey()).collect(Collectors.toList());
    System.out.println(ans);
}