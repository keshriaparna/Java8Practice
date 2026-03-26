/*
Write a stream program to move all zero's to beginning of
array int[]
Input: int[] arr = {5,0,1,0,8,0};
 */
void main() {
    int[] arr = {5,0,1,0,8,0};
    List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

    // Approach 1
    /*
    Filtering in a list all the zeroes
    Filtering all the non zeroes element
    Concatenating both list, first list containing zeroes then non-zero list.
     */
    List<Integer> zeroes = list.stream().filter(x->x==0).collect(Collectors.toList());
    List<Integer> nonZeroes = list.stream().filter(x->x!=0).collect(Collectors.toList());
    List<Integer> listFinal = new ArrayList<>();
    listFinal.addAll(zeroes);
    listFinal.addAll(nonZeroes);
    System.out.println(listFinal);

    // Approach 2
/*
    Step 1:
    Map<Boolean, List<Integer>> partitionMap = list.stream()
            .collect(Collectors.partitioningBy(x->x!=0));
    System.out.println(partitionMap); // Output- {false=[0, 0, 0], true=[5, 1, 8]}

    Step 2:
    Collection<List<Integer>> collectionView = partitionMap.values();
    System.out.println(collectionView); // Output-  [[0, 0, 0], [5, 1, 8]]

    Step 3:
    collectionView.stream().flatMap(x->x.stream()).collect(Collectors.toList())
            .forEach(System.out::print); // Output-  000518
 */

    List<Integer> ans = list.stream()
            .collect(Collectors.partitioningBy(x->x!=0)).values().stream()
            .flatMap(x->x.stream()).collect(Collectors.toList());
    System.out.println(ans);

}


