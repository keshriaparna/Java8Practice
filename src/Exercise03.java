/*
Given a sentence, find the word that has the 2nd highest length
Input : String s = "I am learning Streams API in Java"
Output : Streams
 */
void main(){
    /*
    Arrays.stream(s.split(" ")) - this will first convert string array and then arrays.stream
    will convert string array into Stream<String>
    sorted() - sorting it based on the length of the strings
    as we are using Comparator we will have reverse().
    So, using reverse method to reverse the sorted stream of strings
    skiping first value an dthen finding first to get the second value
    of highest length, doing .get() because these operations were returning optional
     */
    String s = "I am learning Streams API in Java";
    String ans = Arrays.stream(s.split(" ")).sorted(Comparator.comparing(String::length)
            .reversed()).skip(1).findFirst().get();
    System.out.println(ans);
}
