/*
Given a sentence, find the word that has the 2nd highest length
Input : String s = "I am learning Streams API in Java"
Output : Streams
 */
void main(){
    /*
    "I am learning Streams API in Java"
        ↓ split(" ") and Array.Stream - Splits the string by space into a String array
    ["I", "am", "learning", "Streams", "API", "in", "Java"]
        ↓ Arrays.Stream-Converts String array into Stream<String>
     Stream → "I", "am", "learning", "Streams", "API", "in", "Java"
        ↓ map(x -> x.length()) Converts each word → its length, giving Stream<Integer>
    [1, 2, 8, 7, 3, 2, 4]
        ↓ sorted(Comparator.reverseOrder()) - Sorts lengths highest to lowest
    [8, 7, 4, 3, 2, 2, 1]
        ↓ skip(1) - Skips the first element (8)— i.e., skips the longest word length
    [7, 4, 3, 2, 2, 1]
        ↓ findFirst().get() -Picks the first element from remaining stream
    7  ← 2nd longest word length ("Streams")
     */
    String s = "I am learning Streams API in Java";
    int ans = Arrays.stream(s.split(" ")).map(x->x.length())
            .sorted(Comparator.reverseOrder())
            .skip(1).findFirst().get();
    System.out.println(ans);
}
