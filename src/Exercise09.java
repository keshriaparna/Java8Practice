/*
Given an int[] array, re-arrange the elements to form the
highest/lowest possible value
Input: int[] arr = {1,2,3,4,5};
Output: 54321/12345
 */
void main() {
    //lowest
    int[] nums = {8,2,7,4,5};
    Arrays.stream(nums).mapToObj(x->x).sorted()
            .forEach(System.out::print);
    System.out.println();
    //highest
    int[] arr = {1,2,3,4,5};
    Arrays.stream(arr).mapToObj(x->x).sorted(Collections.reverseOrder())
            .forEach(System.out::print);
}
/*
In this we are converting primitive type to object type and then
sorting and then printing each element.
 */