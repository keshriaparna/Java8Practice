/*
Find the product of the first two elements from an array.
Input: int arr[] = {12,5,6,9,2,4};
Output: 60
 */
void main() {
    int[] arr = {12,5,6,9,2,4};
    int ans =Arrays.stream(arr).limit(2)
            .reduce(1,(a,b)->a*b);
    System.out.println(ans);
}
/*
### Visualizing the full flow:
```
int[] = {12, 5, 6, 9, 2, 4}
           ↓
    Arrays.stream(arr)
           ↓
  IntStream → 12, 5, 6, 9, 2, 4
           ↓
        limit(2)
           ↓
  IntStream → 12, 5
           ↓
   reduce(1, (a,b)->a*b)
           ↓
  a=1,  b=12  →  1  * 12 = 12
  a=12, b=5   →  12 * 5  = 60
           ↓
          60

First value in reduce is called identity.
It must be neutral-it  should not change result.
Operation      Identity      Why
Multiplication *    1       n * 1 = n
Addition +          0       n + 0 = n
Division /          1       n / 1 = n
Subtraction -       0       n - 0 = n

reduce works like a running total — it starts with the identity value,
then picks elements one by one from the stream and applies the
function repeatedly until no elements are left. Here it starts with 1,
multiplies 12 → gets 12, then multiplies 5 → gets 60!

int[] arr = {12, 5, 6, 9, 2, 4};


reduce with different operations:

// Multiply first 2
Arrays.stream(arr).limit(2).reduce(1, (a,b)->a*b);  // 12*5 = 60

// Sum first 2
Arrays.stream(arr).limit(2).reduce(0, (a,b)->a+b);  // 12+5 = 17

// Multiply ALL elements
Arrays.stream(arr).reduce(1, (a,b)->a*b);  // 12*5*6*9*2*4 = 25920

// Sum ALL elements
Arrays.stream(arr).reduce(0, (a,b)->a+b);  // 12+5+6+9+2+4 = 38
// same as → Arrays.stream(arr).sum()
 */