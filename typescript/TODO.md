X Add language and Currency Items
X Look for the command to watch with yarn jest
  - yarn jest --watchAll
X what's the best typescript setup for visual studio code?
  - Many things are already built-in for Typescript https://code.visualstudio.com/docs/languages/typescript
  X Add recommended extensions for jest
  X jest watcher is failing within Visual Studio Code
    - jest --watch falls into a conflict because sub-dir and branch had the same name 
      https://github.com/facebook/jest/issues/10149
    X Rename the branch to typescript-branch
. Find the best practices around
  X is there a better way to define getters, especially on immutable objects
    - there is a readonly keyword, and an immutability.js lib for data structures
      https://medium.com/cloudverse/immutability-and-builders-with-typescript-b69a51c94e8c
    X change attributes to readonly fields
  . handling packages and directory structure
  . case best practice for file names
. Setup prettier
. I started from https://github.com/Pablorg99/typescript-kata-template that uses .nvmrc, should we update 
  this version? is nvmrc the way to go?
. Test equality for Country objects
  - I did not find a built-in way to compare identical instances. Same problems as in Java
    People seem to suggest a hack with JSON.Stringify https://dmitripavlutin.com/how-to-compare-objects-in-javascript/
