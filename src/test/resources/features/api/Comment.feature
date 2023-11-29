@api @Comment
Feature: Check all request with path comment
  Background: Set valid Header
    Given set header with valid api key


    Scenario: request get list comment positive
      When request to get list comment
      Then check data schema with file "getListCommentSchema.json"
      And check status response by "200"


    Scenario: request get comment by postID positive
      Given get first postID
      When request to get comment by postID
      Then check data schema with file "getListCommentSchema.json"
      And check status response by "200"


    Scenario: request get comment by invalid postID
      When request to get comment by invalid postID
      Then check data schema with file "errorSchema.json"
      And check status response by "400"
      And check error message by "PARAMS_NOT_VALID"


    Scenario: request get comment by invalid userID
      When request to get comment by invalid userID
      Then check data schema with file "errorSchema.json"
      And check status response by "400"
      And check error message by "PARAMS_NOT_VALID"