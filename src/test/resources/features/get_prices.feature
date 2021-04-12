Feature: Get prices from fallabela
  As user
  I want to get prices of products
  To list them

  Scenario: Search a product on fallabela
    Given that "Juan" is on Fallabela web page
    When he searches "Celular Huawei"
    Then he should see prices of every product