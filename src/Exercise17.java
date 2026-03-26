/*
Write a stream program to multiply alternative numbers in
an array.
Input: int[] arr = {4,5,1,7,2,9,2};
Output: 16

we have multiplied 0,2,4,6 index values(even indexes).
to multiply odd indexes we just need to change filter condition .filter(x->x%2!=0)
instead of equal to even number, not equal to even number condition we have put.
 */
void main() {
    int[] arr = {4,5,1,7,2,9,2};
    int ans = IntStream.range(0,arr.length).filter(x->x%2==0)
            .map(x->arr[x]).reduce(1,(a,b)->a*b);
    System.out.println(ans);
}
/*

### Step 1: `IntStream.range(0, arr.length)`
Generates a stream of **index numbers** from 0 to 6:
```
arr.length = 7

IntStream.range(0, 7)
// range is EXCLUSIVE of end value!
// → 0, 1, 2, 3, 4, 5, 6


IntStream.range(0,7) vs IntStream.rangeClosed(0,7):

IntStream.range(0, 7)       // → 0,1,2,3,4,5,6   (excludes 7)
IntStream.rangeClosed(0, 7) // → 0,1,2,3,4,5,6,7 (includes 7)
```


IntStream.range() generates index numbers instead of values. We filter even
indexes (0,2,4,6), then use map(x -> arr[x]) to fetch values at those indexes (4,1,2,2)
and finally reduce multiplies them all together giving 16.

Variations of above question

// ✅ Product of values at ODD indexes
IntStream.range(0, arr.length)
         .filter(x -> x % 2 != 0)      // odd indexes → 1,3,5
         .map(x -> arr[x])             // arr[1]=5, arr[3]=7, arr[5]=9
         .reduce(1, (a, b) -> a * b);  // 5*7*9 = 315

// ✅ Sum of values at EVEN indexes
IntStream.range(0, arr.length)
         .filter(x -> x % 2 == 0)      // even indexes → 0,2,4,6
         .map(x -> arr[x])             // 4,1,2,2
         .reduce(0, (a, b) -> a + b);  // 4+1+2+2 = 9
// or simply → .sum()

// ✅ Values at even indexes as List
IntStream.range(0, arr.length)
         .filter(x -> x % 2 == 0)
         .map(x -> arr[x])
         .boxed()
         .collect(Collectors.toList()); // [4, 1, 2, 2]
 */