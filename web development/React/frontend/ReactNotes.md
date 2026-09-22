# react is simeple lightweight library that can:
## integrate into any existing application
## with some part of the application not using react at all and partial application running on react
## with some part of the application using react and some part using other libraries like angular or vue
## provides an easy to segregate functinalities  int the form of modular components (seperation of concerns)
## the components are much more efficient than the traditional way of rendering the entire page on every change

# react uses jsx
## browser cannot natively understand jsx
## but the browser understand js only, so in order for the browser to understand jsx, we need to convert jsx into js
## so for that we need an addtionaly library to convert jsx into js, that library is called babel

# react html
## in jsx we write complete html just like we write in a normal js file
## whatever html that we write jsx is not native html. every tag is wrapper on top of existing html tags. so the browser cannot understand jsx, so we need to convert jsx into js using babel 

# react state

## state belongs to a component and it is used to store the data of that component. whenever the state of a component changes, the component re-renders itself and updates the UI accordingly.

# virtual dom

## Real DOM: In normal scenariom when we are updating the without react, every update that is coming is pushed to dom directly, dom operationg is generally considered a heavy operation, so if we are updating the dom frequently, it will lead to performance issues.
### Virtual DOM: In react, whenever we are updating the state of a component, the virtual dom is updated first, then the virtual dom compares the new virtual dom with the previous virtual dom and finds out what has changed and then updates only those parts of the real dom that have changed. This way react is able to optimize the performance of the application.


## Dom update wrt to the browser is kind of eqilvalent to saying a component re-render

# React hooks 
## are the functions used for different purposes
## useState() - refer react state secion above
## useEffect 
## useMemo

# components re-render
## Component re-render basically mean the component function is called again

## It doesn't re-initialze the state nor update the real DOM directly(unless there are any changes)

## Componenet re-render happens these 3 cases:

### state update
### props update
### parent component is re-rendered

## All the hooks of react can be used in top level of the component function only, not inside any other function or block of code.

## Memoization 
### React.memo (HOF- higher order function) - Memoizing a component 
### useMemo (React Hook) - Memoizing a value
### useCallback (React Hook) - Memoizing a function

## React data handling
### componeent state - defined using a hook  usestate
### can be changed (SetState methods)- this is why state is called mutable
### props - incoming/input data props are immutables (cannot be changed/modified)
#### can we modify props OR should we even modify props
#### useRef - This is used for creating a stable reference to a value that persists across re-renders of a component. It can be used to store mutable values that do not trigger a re-render when changed. This is useful for storing values that need to be accessed or modified without causing unnecessary re-renders, such as DOM references or timers.

### sharing data between components
#### pass data from parent to child component - can be done using props
#### pass data from child to parent component - can be done using props
##### we can send data from child to parent using return - But in react component it has to return a jsx
##### it is not passing the data anymore
##### Another way is send a callback function from parent component to child component and then call the callback function from child component and pass the data as an argument to the callback function. This way the parent component can receive the data from the child component.
