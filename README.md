# Mikado Method and Test Data Builders Kata

_A kata or a workshop to teach how to combine Test Data Builders and the Mikado
Method to add tests on a bug in a legacy codebase without freezing features_

Developers working on legacy code are always told to write tests before fixing 
any bug. In theory, it is very nice, but in practice, it is a lot more tricky!

We know we need to add tests, but it’s easier said than done.  
In legacy codebase, just setting up the objects for the test is most often an 
unjustifiable nightmarish 2 weeks work. Mocks are a common workaround, but 
mocking legacy codebase usually makes them more difficult to change, not less!

In this hands-on pair programming dojo, you will learn how to combine the 
mikado method with test-data-builders to build a baby-step plan to add your
first test to a legacy codebase. You will also learn how to draw a graph of
nested test-data-builders so that you can instantiate test data, without mocks.

## What this is

This repository contains some code and instructions to guide you through fixing
and testing a bug in a legacy code base using test data builders and the mikado
method.

The workshop is expected to last for 2 hours and 30 minutes.

When you are done, you should have a good enough understanding of the concept
to start to use them in your daily work.

## Who is this for?

If you are a developer dealing with legacy code, it might a good idea to
practice this kata, alone or even better, with your team.

If you are a technical coach, you might host a session of this kata as a 
workshop with many developers.

## Where to start

* All kata instructions are in the docs folder. It starts with
[Introduction.md](./docs/1_Introduction.md)

## License

The `mikado-testbuilders-kata` and the accompanying materials are made available 
under the terms of the MIT License ([here](LICENSE.md)) which accompanies this
distribution, and is available at the Open Source site [here](https://opensource.org/licenses/MIT)

## Contributors 
 
1. [Ahmad Atwi](https://github.com/aatwi)
1. [Philippe Bourgau](https://github.com/philou) 
1. [Christophe Cadilhac](https://github.com/cadichris) 

----
[Start...](./docs/1_Introduction.md)
