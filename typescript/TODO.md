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
X Get config changes that I did on cucumber-js branch
  X revert .vscode/extensions.json (remove wallaby)
  X copy tsconfig.json file
  X upgrade .nvmrc version
  X reinstall yarn (and npm) to have it part of the package
X Experiment refactorings in JetBrains's Webstorm
  X How to sync Webstorm and prettier styles? could https://editorconfig.org help?
  X How to reformat on save?
    - There are Simple Webstorm settings for this https://www.jetbrains.com/help/webstorm/prettier.html#ws_prettier_apply_code_style
X Reproduce and test bug in ReportGenerator
      const s = Currency.Euro.toString();

      const repository = new InMemoryRepository();
      MainRepository.override(repository);

      const USA = new Country("USA", Currency.Dollar, Language.English);
      const steinbeck = new Author("John Steinbeck", USA);
      const grapesOfWrath = new Novel(
      "GrapesOfWrath",
      9.99,
      steinbeck,
      Language.English,
      Immutable.Set()
      );
      const France = new Country("France", Currency.Euro, Language.French);
      const invoice = new Invoice("John Doe", France);
      invoice.addPurchasedBook(new PurchasedBook(grapesOfWrath, 1));

      repository.addInvoice(invoice);

      const reportGenerator = new ReportGenerator();

      expect(reportGenerator.getTotalAmount()).toBe(10.95);
X Implement Client package
  X Client class
  X Order interface
  X BooksOrder class
  X Add equals hashCode to book interface
  X Implement Equals and HashCode for Novel and EducationalBook
    X need to do it recursively on Author, Country (?and enums?)
      - no with fast deep equal lib :-)
    X Are there helpers for that?
      X [fast deep equal lib](https://www.npmjs.com/package/fast-deep-equal)
        X test it to see how it works
        - You can create inline objects like js objects
        - works well!
      X [hash-it lib](https://www.npmjs.com/package/hash-it)
      - not sure we'll need these since fast deep equal seems to be doing fine
        - [typecheck lib](https://github.com/gkz/type-check#type-check)
        - [generic code](https://www.codegrepper.com/code-examples/javascript/check+if+type+of+two+object+is+equal+in+typescript)
    X Can Webstorm generate equals and hashcode?
        - does not look so  
    X Is there a way to provide generic implementation in the Book interface?
        - workaround is Mixins.  
- You can destructure 'unknown' types with declarations like
  private toCountry({currency, language, name}: {currency: string; language: string; name: string}) {
X Implement the main app
  - No main in Typescript, just run a script file
  - I installed ts-node to run the Application.ts file through yarn
    X Find out how to run this through Webstorm https://www.jetbrains.com/help/webstorm/running-and-debugging-typescript.html#ws_ts_run_debug_server_side
  X Implement the JsonRepository
    - You can load (and compile) json files to setup some data. Types are built automatically by the compiler
  X Reproduce the bug
X Has Typescript some part of homoiconic language features like Lisps? -> NO
. Setup github actions
- Improvements
  X understand how to create a mutable map
    - there are asMutableMap and asImmutableMap functions in the immutable map objects
    - EcmaScript6 has Map, Set, and TypedArrays (https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map)
    X Check what version of ES I am running?
      - https://stackoverflow.com/questions/47374678/how-to-detect-ecmascript-version
      - node v12.18.0 supports ECMAScript 6!
    - Typescript 2.1 now features Record<K,V> https://stackoverflow.com/questions/30019542/es6-map-in-typescript but it's only for fully compile time known properties and simple key types
    - Best way: use ES6 new Map<K,V>(...)
  X understand how to initialize an immutable (or mutable) map with complex key type inline
    - Record seems to be the best alternative for immutable maps, unfortunately, it does not work so well with enums (needs numbers)
    - Best way: instantiate an immutable-js map from an ES6 typed inline map; 
  X I started from https://github.com/Pablorg99/typescript-kata-template that uses .nvmrc, should we update this version? is nvmrc the way to go?
    - Yes, nvm is the way to go
    X I could upgrade to the latest node
  . See how to configure a docker dev env with VSCode
- Understanding Typescript better
  . understand typescript's way for errors (exceptions vs Either)
  . Is there a way to create polymorphic enums (à la Java)?
  . How to continuously run the tests?
  . Try TCR?
  . understand the difference between properties, getters, functions and fields in ts
  . Learn more about typescript type system      
  . Look into [Typescript mixins](https://www.typescriptlang.org/docs/handbook/mixins.html)