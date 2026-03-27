/*
Convert a list of strings to uppercase.
Input: List<String> list = Arrays.asList("breaking bad",
"game of thrones", "big bang theory");
Output: [BREAKING BAD, GAME OF THRONES, BIG BANG THEORY]
 */
void main() {
    List<String> list = Arrays.asList("breaking bad",
            "game of thrones", "big bang theory");
    List<String> ans = list.stream().map(String::toUpperCase).collect(Collectors.toList());

    System.out.println(ans);
}