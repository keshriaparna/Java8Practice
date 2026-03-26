/*
Write a stream program to multiply 1st and last element,
2nd and 2nd last element etc numbers in an array.
Input: int[] arr = {4,5,1,7,2,9};
Output: 36       //4*9(first and last element)
        10       //5*2(second and second last element)
        7        //1*7(third and third last element)
 */
void main() {
    int[] arr = {4,5,1,7,2,9};
    IntStream.range(0,arr.length/2)
            .map(x->arr[x]*arr[arr.length-x-1])
            .forEach(System.out::println);
}
/*
int[] arr = {4, 5, 1, 7, 2, 9};
//  index →  0  1  2  3  4  5
```

---

### Step 1: `arr.length / 2`
```
arr.length = 6
6 / 2 = 3
```

---

### Step 2: `IntStream.range(0, 3)`
Generates indexes **0 to 2** only:
```
IntStream → 0, 1, 2
```

> Only half the array length — because we are **pairing** elements from start and end!

---

### Step 3: `.map(x -> arr[x] * arr[arr.length - x - 1])`

This is the **main logic** — pairs each element from **start** with its **mirror element from end**:
```
arr.length - x - 1
→ always gives the MIRROR index from the end!

When x=0 → arr.length-0-1 = 5  (last element)
When x=1 → arr.length-1-1 = 4  (second last)
When x=2 → arr.length-2-1 = 3  (third last)
```

#### Round by round:
```
arr = {4, 5, 1, 7, 2, 9}
//     0  1  2  3  4  5

x=0 → arr[0] * arr[5] = 4 * 9 = 36
         ↑                 ↑
      first             last

x=1 → arr[1] * arr[4] = 5 * 2 = 10
         ↑                 ↑
      second          second last

x=2 → arr[2] * arr[3] = 1 * 7 = 7
         ↑                 ↑
      middle left      middle right
```

---

### Step 4: `.forEach(System.out::println)`
Prints each result:
```
36
10
7
```

---

### Full Flow Visualized:
```
arr = {4,  5,  1,  7,  2,  9}
       ↑                   ↑   → 4  * 9 = 36
           ↑           ↑       → 5  * 2 = 10
               ↑   ↑           → 1  * 7 = 7

IntStream.range(0, 3) → 0, 1, 2
        ↓ map(x -> arr[x] * arr[length-x-1])
        36, 10, 7
        ↓ forEach
36
10
7
```

---

### Output:
```
36
10
7
 */