/*
Given an array find the sum of unique elements.
Input: int[] arr = {1,6,7,8,1,1,8,8,7}
Output: 22
 */
void main() {
    int[] arr = {1,6,7,8,1,1,8,8,7};
    int ans = Arrays.stream(arr).distinct().sum();
    System.out.println(ans);
}
/*
Arrays.stream - to convert the array into Stream<Integer>
distinct will return the intstream of distinct integers from the stream of integer
and then summing it up to get the final output
 */