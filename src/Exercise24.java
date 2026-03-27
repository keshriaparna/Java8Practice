/*
Convert a list of integers to a list of their squares.
Input: List<Integer> list = Arrays.asList(1,2,3,4,5);
Output: [1,4,9,16,25]
 */
void main() {
    List<Integer> list = Arrays.asList(1,2,3,4,5);
    List<Integer> listSquare = list.stream().map(x->x*x).collect(Collectors.toList());
    System.out.println(listSquare);
}
/*
map in Streams API
1. Transformation: The 'map' function helps to transform the element
from one form to another.
Eg: If we have to convert a list of strings to a list of
string length.
2.Immutability: The 'map' function does not modify the original
stream or collector. It produces a new stream with the transformed element
preserving the immutability principle key to functional programming.
3.Conciseness: the code becomes concise, we are not using explicit
loops or temporary variables.
4. Pipeline Processing: With the 'map' we can chain multiple
operations for complex data processing.
5.Parallel Processing: The 'map' function is helpful in the
performance of large datasets.
 */