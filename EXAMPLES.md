# Result Examples

This is the output obtained from running with the same input as the examples provided in the [challenge workable page](https://minderacraft.workable.com/j/85F6E6EF6F).  
The expected output (from that same page) is also present, for easier comparison. There are some differences in the output, but that was [considered okay](https://www.facebook.com/minderasoftwarecraft/posts/619592118245443?comment_id=621483951389593&reply_comment_id=621538798050775&comment_tracking=%7B%22tn%22%3A%22R8%22%7D).

## Example 1:

### Input:
* Array: [16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 67]
* Number of groups: 3

### Output:
[[16, 15, 14, 13, 23, 24, 25, 26, 28, 23, 29, 12, 23, 23, 12, 23, 23],  
[67, 67, 67],  
[34, 45, 34, 45, 34, 45]]

### Expected Output:
[[16, 15, 14, 13, 12, 12],  
[34, 23, 24, 25, 26, 28, 34, 23, 29, 23, 23, 34, 23, 23],  
[45, 45, 67, 45, 67, 67]]

## Example 2:

### Input:
* Array: [16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 670]
* Number of groups: 3

### Output:
[[16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 34, 23, 29, 12, 23, 23, 12, 34, 23, 23],  
[670],  
[45, 45, 67, 45, 67]]

### Expected Output:
[[16, 15, 14, 13, 23, 24, 25, 26, 28, 23, 29, 12, 23, 23, 12, 23, 23],  
[34, 45, 34, 45, 67, 34, 45, 67],  
[670]]

## Example 3:

### Input:
* Array: [160, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 670]
* Number of groups: 4

### Output:
[[160],  
[670],  
[15, 14, 13, 34, 23, 24, 25, 26, 28, 34, 23, 29, 12, 23, 23, 12, 34, 23, 23],  
[45, 45, 67, 45, 67]]

### Expected Output:
[[160],  
[15, 14, 13, 23, 24, 25, 26, 28, 23, 29, 12, 23, 23, 12, 23, 23],  
[34, 45, 34, 45, 67, 34, 45, 67],  
[670]]

## Example 4:

### Input:
* Array: [16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 67]
* Number of groups: 5

### Output:
[[16, 15, 14, 13, 12, 12],  
[67, 67, 67],  
[45, 45, 45],  
[34, 28, 34, 29, 34],  
[23, 24, 25, 26, 23, 23, 23, 23, 23]]

### Expected Output:
[[16, 15, 14, 13, 12, 12],  
[34, 34, 29, 34],  
[23, 24, 25, 26, 28, 23, 23, 23, 23, 23],  
[45, 45, 45],  
[67, 67, 67]]
