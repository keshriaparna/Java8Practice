/*
Find and print the distinct odd numbers.
Input: List<Integer> list = Arrays.asList(1,2,3,4,5,6,8,9,9,10);
Output: [1,3,5,7,9]
 */
void main() {
    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,9,10);
    List<Integer> uniqueList = list.stream().filter(x->x%2!=0)
            .distinct().collect(Collectors.toList());
    System.out.println(uniqueList);
}