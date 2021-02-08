const { Given, When, Then } = require("cucumber");

Given("John, a customer from the USA", function () {});

When("John purchases a novel costing 50", function () {});

Then("the invoice total amount should be 56,35", function () {
  expect(1).toBe(0);
});
