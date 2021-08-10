Feature: Google Calculator Estimate

  Scenario: Comparison of Google Calculator Estimate from the site and from the mail
    Given I opened Google Cloud site
    When I search Google Cloud Platform Pricing Calculator
    And I open Google Cloud Pricing Calculator page
    And I enter Compute Engine parameters
    And I send Email Estimete
    And I opened Email letter
    Then Calculator Estimate equals to Email Estimate
