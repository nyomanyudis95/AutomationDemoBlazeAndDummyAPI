@api @User
Feature: Check all request with path user
  Background: Set valid Header
    Given set header with valid api key


    Scenario: request get list user positive
      When request to get list user
      Then check data schema with file "getListUserSchema.json"
      And check status response by "200"


    Scenario: request get user by userID positive
      Given get first userID
      When request to get user by userID
      Then check data schema with file "getUserByIDSchema.json"
      And check status response by "200"


    Scenario: request get user by userID with invalid userID
      When request to get user by invalid userID
      Then check data schema with file "errorSchema.json"
      And check error message by "PARAMS_NOT_VALID"
      And check status response by "400"


    Scenario: request create user with no body
      When request create user
      Then check data schema with file "errorBodySchema.json"
      And check respond data create user by error message must be filled
      And check error message by "BODY_NOT_VALID"
      And check status response by "400"

    Scenario: request create user with body empty String
      Given set body create user with empty string
      When request create user
      Then check data schema with file "errorBodySchema.json"
      And check error message by "BODY_NOT_VALID"
      And check respond data create user by error message must be filled
      And check status response by "400"


    Scenario: request create user with body invalid format email
      Given set body create user with invalid format email
      When request create user
      Then check data schema with file "errorBodySchema.json"
      And check error message by "BODY_NOT_VALID"
      And check respond data create user by error message invalid format email
      And check status response by "400"


    Scenario: request create user with body existing email
      Given set body create user with existing email
      When request create user
      Then check data schema with file "errorBodySchema.json"
      And check error message by "BODY_NOT_VALID"
      And check respond data create user by error message existing email
      And check status response by "400"

    @currentTest
    Scenario: request create and delete user positive
      Given set body create user with generated user
      When request create user
      Then check data schema with file "createUserSuccessSchema.json"
      And check respond data create user same with body
      And check status response by "200"
      When request delete user
      Then check data schema with file "deleteUserSchema.json"
      And check status response by "200"
      And check respond data delete user with same userID


    Scenario: request delete user with invalid userID
      When request delete user with invalid userID
      Then check data schema with file "errorSchema.json"
      And check status response by "400"
      And check error message by "PARAMS_NOT_VALID"

#    Scenario: request delete user with invalid userID
#      When request delete user
#      Then check data schema with file "deleteUserSchema.json"
#      And check status response by "200"
#      And check respond data delete user with same userID



