@api @Tag
Feature: Check request with path tag
  Background: Set valid Header
    Given set header with valid api key


  Scenario: request get list tag positive
    When request to get list tag
    Then check data schema with file "getListTagSchema.json"
    And check status response by "200"


  Scenario: request get post by tag positive
    Given get Tag from firstPostID
    When request to get post by tag
    Then check data schema with file "getListPostSchema.json"
    And check status response by "200"


  Scenario: request get post by invalid tag
    When request to get post by invalid tag
    Then check data schema with file "getEmptyPostByTagSchema.json"
    And check status response by "200"