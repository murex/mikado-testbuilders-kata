# Test Data Builders

## Summary
'Test Data Builders' is technique that leverages on the [Builder Pattern](https://en.wikipedia.org/wiki/Builder_pattern#Java) 
to construct complex objects in tests.  
With 'Test Data Builders' we can emmit fields or properties that do not 
contribute to the behavior of the object being tested.  
A test data builder class has the following features: 
1. Has a field for each constructor parameter 
1. The fields are initialized to a default safe value
1. Has 'chainable' public methods to override the default values 
1. Has a 'build' method that returns an instance of object initialized with 
the fields' values. 

## Examples
Below is an example of a TestBuilder for the Country object we in our code:

    public class CountryTestBuilder {
        private String name = "";
        private Currency currency = Currency.US_DOLLAR;
        private Language language = Language.ENGLISH;
    
        public static CountryTestBuilder aCountry() {
            return new CountryTestBuilder();
        }
    
        public CountryTestBuilder withName(String name) {
            this.name = name;
            return this;
        }
    
        public CountryTestBuilder withCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }
    
        public CountryTestBuilder withLanguage(Language language) {
            this.language = language;
            return this;
        }
    
        public Country build() {
            return new Country(name, currency, language);
        }   
    }

Using the above code-snippet, we can create an instance of France with this code: 

    Country france = CountryTestBuilder.aCountry()
            .withName("France")
            .withCurrency(Currency.EURO)
            .withLanguage(Language.FRENCH)
            .build();

## Benefits
Here are some 
1. Wrap up most of the syntax noise when creating new objects 
1. Make default case simple, and special cases not much complicated
1. Protect tests against changes in the object structure. Existing tests will 
not fail if a new field is adding to an existing object.  
1. Makes core more readable and easier to spot the errors

## Variations

### Test Constants
### Dealing with dependencies in constructors with JUnitRules or RAII

inject a fake (cf Working effectively with Legacy Code)
Use something to rollback
These small bricks are compatible with Mikado

### Dealing with cyclic dependencies between objects