### Assignment: Caching the Inverse of a Matrix

Matrix inversion is usually a costly computation and there may be some benefit to caching the inverse of a matrix rather than computing it repeatedly (there are also alternatives to matrix inversion that we will not discuss here). Your assignment is to write a pair of functions that cache the inverse of a matrix.

Write the following functions:

1.  `makeCacheMatrix`: This function creates a special "matrix" object
    that can cache its inverse.

```R
makeCacheMatrix <- function(x = matrix()) {
    inv <- NULL                        # A placeholder of inverse matrix
    set <- function(temp) {            # When a new value set, the inv must be reset
        x <<- temp
        inv <<- NULL
    }
    get <- function() x                # Get the matrix's data
    setInv <- function(Inv_temp) {     # Set the inverse matrix's value
        inv <<- Inv_temp
    }
    getInv <- function() inv           # Get the inverse matrix's value
    list(
        set = set, 
        get = get,
        setInv = setInv,
        getInv = getInv
    )
}
```

2.  `cacheSolve`: This function computes the inverse of the special
    "matrix" returned by `makeCacheMatrix` above. If the inverse has
    already been calculated (and the matrix has not changed), then
    `cacheSolve` should retrieve the inverse from the cache.


```R
cacheSolve <- function(x, ...) {
        ## Return a matrix that is the inverse of 'x'
    inv <- x$getInv()
    if(!is.null(inv)) {
        message("Cached data loading...") # If the value of inv is not NULL, 
                                          # that means we have already calculated the inverse.
    } else {
        x$setInv(
            solve( x$get() )    # Extract the original matrix and put the calculated 
                                # inverse value back into the list
        )
        inv <- x$getInv()       # reload the value, or it would be NULL
    }
    return(inv)                 # return the inverse value
}
```

### Test and result


```R
test <- makeCacheMatrix()	# Make a special list mentioned above
A <- matrix(1:4, 2, 2)	# A matrix used to set the value of list
test$set(A)
test$getInv()
	# out put: NULL
cacheSolve(test)
```

> Output :
>
> <table class="dataframe">
> <caption>A matrix: 2 × 2 of type dbl</caption>
> <tbody>
> 	<tr><td>-2</td><td> 1.5</td></tr>
> 	<tr><td> 1</td><td>-0.5</td></tr>
> </tbody>
> </table>


```R
cacheSolve(test)
	# out put(1): Cached data loading...
```

> Output(2):
>
> <table class="dataframe">
> <caption>A matrix: 2 × 2 of type dbl</caption>
> <tbody>
> 	<tr><td>-2</td><td> 1.5</td></tr>
> 	<tr><td> 1</td><td>-0.5</td></tr>
> </tbody>
> </table>