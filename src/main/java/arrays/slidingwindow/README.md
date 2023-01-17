# Pattern : Sliding Window

## Algorithm pattern

### Fixed site sliding window
```java
class Solution {
    
    // initialze the flag
  int start , end ;
    
  while ( end < input.length){
      //computation step. This is really important
    
    if ( end - start + 1 < k){
        // if the window is smaller then, increase the size
      end ++ ;
    } else {
        
        //compute the result step
      
      //reverse the first element step
    }
  }
}

``` 

### Variable site sliding window
```java
class Solution {
    
    // initialze the flag
  int start , end ;
    
  while ( end < input.length){
      //computation step. This is really important
    
    if ( validate the condition){
        // if the condition not met then increase the window
      end ++ ;
    } else if ( condition is true){
        then compute the result
    } else {
        
        //compute the result step
      
      //reverse until the condition becomes valid.
            // This is mostly reversing the action we did for first or slow pointer
            // example. reduce the sum until it becomes less than k 
    }
  }
}

``` 