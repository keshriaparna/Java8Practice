/*
Remove duplicates from the string and return in the same order
Input : String s = "dabcadefg";
Output: dabcefg
 */
void main() {
    /*
    chars() - return Intstream(ascii value of characters)
    distinct() - to remove duplicates
    mapToObj() - to convert the numerical values of character back
    into the object(explicitly typecasting it into character)
    forEach() - to print each character of the string
     */
    String s = "dabcadefg";
    s.chars().distinct().mapToObj(x->(char)x).forEach(System.out::print);

    /*
    Another approach
    Arrays.stream(s.split(""))- this will give array of characters, here delimiter is nothing
    and it is splitting each character, this gives array of string(Single character string, distinct
    method is applied on stream of string in this approach
     */
    System.out.println();
    Arrays.stream(s.split("")).distinct().forEach(System.out::print);
}
