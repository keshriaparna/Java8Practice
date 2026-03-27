/*
Sort a list of strings in alphabetical order.
Input: List<String> str = Arrays.asList("Zudio","Puma","Addidas","MAC","H&M");
Output: [Addidas,H&M,MAC,Puma,Zudio]
 */
void main() {
    List<String> str = Arrays.asList("Zudio","Puma","Addidas","MAC","H&M");
    List<String> sorted = str.stream().sorted().collect(Collectors.toList());
    System.out.println(sorted);
}