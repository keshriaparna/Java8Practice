/*
Find and print the strings containing only digits.
Input: List<String> list = Arrays.asList("123","abc","123abc","45");
Output: [123, 45]
 */
void main() {
    List<String> list = Arrays.asList("123","abc","123abc","45");
    List<String> ans = list.stream().filter(x->x.matches("[0-9]+")) // another regular expression -> x.matches("\\d+"))
            .collect(Collectors.toList());
    System.out.println(ans);
}
/*
filtering out based on the regular expression
 */