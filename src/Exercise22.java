/*
Find the sum of all the elements in a list.
Input: List<Integer> num = Arrays.asList(!,2,3,4,5);
Output: 15
 */
void main() {
    List<Integer> num = Arrays.asList(1,2,3,4,5);
    /*
    this value is boxed, means a wrapping is provided to
    primitive value so that it gets converted into an object,
    whenever we need to do any arithmetic operation we need to
    convert it to back to primitive(a kind of unboxing happens),
    by using mapToInt() we are avoiding boxing and unboxing overhead
    this gives us performance benefits and memory efficiency because
    the boxed value takes  more space than the primitives, that's why
    we used mapToInt().This is the advantage, keep it in mind and
    u can use when doing arithmetic operation.


     */

    /*
    num is a list of integer, when stream acted upon it, it
    gets converted to stream of integer, we need to perform
    summation, for all these arithmetic operations primitives
    are the best, for this purpose we are using mapToInt()
    which converts the Stream<Integer> to Intstream, which is
    a specialized kind of int primitive, we are using method
    reference extracting the integer value using intValue method
    of Integer class. mapToInt() is a intermediate operation
    then using sum() which is a terminal operation
     */
    int sum = num.stream().mapToInt(Integer::intValue).sum();
    System.out.println(sum);
}