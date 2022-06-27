Feature: Начальный тест для изучения Cucumber

  Scenario: Простой тест без тела

  Scenario: Простой тест с Given
    Given open browser

  Scenario: Простой текст с Given и When
    Given open browser
    When login page is opened

  Scenario: Простой текст со всеми ключевыми словами
    Given open browser
    When login page is opened
    Then username field is displayed

  Scenario: Использование And в Given
    Given open browser
    And login page is opened

  Scenario: Использование And в Given
    Given open browser
    * login page is opened
    Then username field is displayed