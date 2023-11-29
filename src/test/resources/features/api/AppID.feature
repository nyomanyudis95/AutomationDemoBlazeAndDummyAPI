@api @AppID
Feature: App ID API
  Scenario Outline: Check all request with empty header app id
    Given set header without api-key
    When request api with path "<path>" and method "<method>"
    Then check respond api_id_missing
    And check status response by "403"
    And check data schema with file "errorSchema.json"
    And check error message by "APP_ID_MISSING"
    Examples:
    | path            | method |
    | user/           | get    |
    | user/12         | get    |
    | user/create     | post   |
    | user/12         | put    |
    | user/12         | delete |
    | post/           | get    |
    | user/12/post    | get    |
    | tag/12/post     | get    |
    | post/12         | get    |
    | post/create     | post   |
    | post/12         | put    |
    | post/12         | delete |
    | comment/        | get    |
    | post/12/comment | get    |
    | user/12/comment | get    |
    | comment/create  | post   |
    | comment/12      | delete |
    | tag/            | get    |

  Scenario Outline: Check all request with invalid header app id
    Given set header with invalid api-key
    When request api with path "<path>" and method "<method>"
    Then check respond api_id_missing
    And check status response by "403"
    And check data schema with file "errorSchema.json"
    And check error message by "APP_ID_MISSING"
    Examples:
      | path            | method |
      | user/           | get    |
      | user/12         | get    |
      | user/create     | post   |
      | user/12         | put    |
      | user/12         | delete |
      | post/           | get    |
      | user/12/post    | get    |
      | tag/12/post     | get    |
      | post/12         | get    |
      | post/create     | post   |
      | post/12         | put    |
      | post/12         | delete |
      | comment/        | get    |
      | post/12/comment | get    |
      | user/12/comment | get    |
      | comment/create  | post   |
      | comment/12      | delete |
      | tag/            | get    |
