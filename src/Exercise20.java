/*
In a given array of integers, return true if it contains all distinct values and false otherwise.
Input: int[] arr = {5,0,1,0,8,0};
Output: false
 */
void main() {
    int[] arr = {5,0,1,0,8,0};
    List<Integer> list = Arrays.stream(arr).boxed()
            .collect(Collectors.toList());
    /*
    Map<Integer,Long> map = list.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
    System.out.println(map);
    Collection<Long> view = map.values();
    boolean distinctChecker = view.stream().noneMatch(x->x>1);
    System.out.print(distinctChecker);
     */

    boolean ans = list.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()))
            .values().stream().noneMatch(x->x>1);
    System.out.println(ans);
}