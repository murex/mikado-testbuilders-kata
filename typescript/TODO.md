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
X is there a better way to define getters, especially on immutable objects
  - there is a readonly keyword, and an immutability.js lib for data structures
    https://medium.com/cloudverse/immutability-and-builders-with-typescript-b69a51c94e8c
  X change attributes to readonly fields
X Setup prettier
  - https://www.robertcooper.me/using-eslint-and-prettier-in-a-typescript-project
  - https://gist.github.com/pedrouid/71bb2d8b263731492dabfa302e7c6b67
  - https://morioh.com/p/9b424825b2cb
  X Find how to run prettier in VSCode
  X Find how to hook prettier to git
X Find best practices around namespacea and directory structures:
  - Don't use imports + namespace (https://stackoverflow.com/questions/37565709/how-to-use-namespaces-with-import-in-typescript)
  - Just rename as needed when importing
  - In the TypeScript handbook: "To reiterate why you shouldn’t try to namespace your module contents, the general idea of namespacing is to provide logical grouping of constructs and to prevent name collisions. Because the module file itself is already a logical grouping, and its top-level name is defined by the code that imports it, it’s unnecessary to use an additional module layer for exported objects."
X Find the best practices around case best practice for file names
  - Nothing clear
  - I found a typescript naming convention here https://makecode.com/extensions/naming-conventions
  - Which says that everything should be namespaced!!! cf point above
X Learn more about constructors overload
  - not allowed
  - can use static factory methods
  - or default parameters
X Learn about optional parameters
  - add ? to mark a param as optional
  - can provide a default value with = ...
  - if ? or =... is not the last arg, then you need to provide an explicit undefined for the arg
- You can block select in VSCode with Shift+Option
X Add TaxRule to be able to pass the invoice test
  - It's better to use free functions than static methods in Typescript
  - To check 'instanceof', you check for the presence of a member. Best way to do this is to write something like "function isX(y):boolean { return (y as X).xMember !== undefined; }"
X Remove the test from Invoice.spec.ts
X Look for other useful VS Code plugins for ts
  - https://scotch.io/bar-talk/11-awesome-javascript-extensions-for-visual-studio-code
  - Wallaby for continuous testing
  - Quoka for inline editor
  - All this makes VS Code slow as hell!
- Equality for objects
  - I did not find a built-in way to compare identical instances. Same problems as in Java
    People seem to suggest a hack with JSON.Stringify https://dmitripavlutin.com/how-to-compare-objects-in-javascript/
  - The question is: why it's needed in this kata? Do we put these objects in maps or sets?
  - this collection library uses a custom toString function to compare objects https://github.com/basarat/typescript-collections/blob/release/src/test/setTest.ts
  - With immutable.js, an object should implement ValueObject to provide equals() and hashCode() https://immutable-js.github.io/immutable-js/docs/#/is
. See how to configure a docker dev env with VSCode
. Try JetBrains's Webstorm
  . How to sync Webstorm and prettier styles?
  . How to reformat on save?
  . How to continuously run the tests ?
. I started from https://github.com/Pablorg99/typescript-kata-template that uses .nvmrc, should we update 
  this version? is nvmrc the way to go?
. Setup github actions
. Reproduce and test bug in ReportGenerator
      const USA = new Country("USA", Currency.Dollar, Language.English);
      const steinbeck = new Author("John Steinbeck", USA);
      const grapesOfWrath = new Novel(
        "GrapesOfWrath",
        9.99,
        steinbeck,
        Language.English,
        Immutable.Set()
      );
      const invoice = new Invoice("John Doe", USA);
      invoice.addPurchasedBook(new PurchasedBook(grapesOfWrath, 1));

      expect(invoice.computeTotalAmount()).toBe(
        grapesOfWrath.price * 1.15 * 0.98
      );
