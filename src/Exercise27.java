/*
Find the kth smallest element in a list of integers.
Input: List<Integer> list1 = Arrays.asList(7,1,6,2,1,3,4,5);
k=3
Output:[2]
 */
void main() {
    List<Integer> list = Arrays.asList(7,1,6,2,1,3,4,5);
    int k=3;
    int ans = list.stream().sorted().skip(k-1).findFirst().get();
    System.out.println(ans);
}
/*
list.stream() - converts it into
here we are sorting the Stream<Integer> then skipping till
k-1 elements and then picking the first after skipping
using get to unwrap optional
 */