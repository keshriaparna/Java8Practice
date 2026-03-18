/*
Question - Given a sentence, find the word that has the highest length.
Input : String s = "I am learning Streams API in Java"
Output : learning
 */
void main(){
    String s = "I am learning Streams API in Java";
    /*
    s.split(" ") - converting the String into String[], space is the delimiter here
    Arrays.stream - is converting String[] into Stream<String>
    then comparing the length of the string and getting max out of it
    get() - because before get the operations written that returns optional so that's why used get
    */
    String longestString = Arrays.stream(s.split(" "))
            .max(Comparator.comparing(String::length)).get();
    System.out.println(longestString);
}

