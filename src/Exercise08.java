/*
Given a word, find the occurrence of each character
Input: String s = "Mississippi"
Output: {p=2,s=4,i=4,M=1}
 */
void main() {
    String s = "Mississippi";
    Map<String,Long> charOccurence = Arrays.stream(s.split(""))
            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    System.out.println(charOccurence);
}
/*
Instead of function.identity we can also write x->x.
When ever we need to occurences of elements we use groupingBy
and this gives a map, so we are storing it in a map.
 */