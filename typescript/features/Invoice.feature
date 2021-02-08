Feature: Invoice

    Feature Description 

    Scenario: Applies tax rules when computing total amount

        Purchases from the USA apply 15% of taxes plus a 2% reduction on novels

        Given John, a customer from the USA
        When John purchases a novel costing 50
        Then the invoice total amount should be 56,35