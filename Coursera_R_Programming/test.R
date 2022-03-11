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

