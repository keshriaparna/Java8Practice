/*
Given an array of integers, group the numbers by the range in which they belong.
Input: int[] arr = {2,3,10,14,20,24,30,34,40,44,50,54};
Output: {0=[2,3],10=[10,14],20=[20,24],30=[30,34],40=[40,44],50=[50,54]}
 */
void main() {
    /*
        Converting the primitive array to Stream<integer> (primitive integer)
        then to Stream<Integer> that is Object type, collecting to a list.
        Taking that list and iterating to group based on the starting point of the range.
        The range here is 0-9,10-19 and so on.
        using groupBy function to group, using linked hashmap to maintain the insertion order.
         collecting it in a list of integer for each group.
        collectors.groupingBy returns a map, so getting the result in a map.
     */
    int[] arr = {2,3,10,14,20,24,30,34,40,44,50,54};

    List<Integer> list = Arrays.stream(arr).boxed()
            .collect(Collectors.toList());

    Map<Integer,List<Integer>> mapListing = list.stream()
            .collect(Collectors.groupingBy(x->x/10*10,
                    LinkedHashMap::new,Collectors.toList()));
    System.out.println(mapListing);
}