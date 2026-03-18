/*
Remove duplicates from the string and return in the same order
Input : String s = "dabcadefg";
Output: dabcefg
 */
void main() {
    /*
    chars() - return Intstream(ascii value of characters)
    distinct() - used on Intstream, to remove duplicates
    mapToObj() - to convert the numerical values of character back
    into the object(explicitly typecasting it into character)
    forEach() - to print each character of the string
     */
    String s = "dabcadefg";
    s.chars().distinct().mapToObj(x->(char)x).forEach(System.out::print);

    /*
    Another approach
    Arrays.stream(s.split(""))- this will given array of chartacters, here delimiter is nothing
    and it is splitting based on each character, distinct method is applied on stream of characters
    in this approach
     */
    System.out.println();
    Arrays.stream(s.split("")).distinct().forEach(System.out::print);
}
