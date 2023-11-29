@api @Post
Feature: Check all request with path Post
  Background: Set valid Header
    Given set header with valid api key


    Scenario: request get list positive positive
      When request to get list post
      Then check data schema with file "getListPostSchema.json"
      And check status response by "200"


    Scenario: request get post by userID positive
      Given get first userID
      When request to get post by userID
      Then check data schema with file "getListPostSchema.json"
      And check status response by "200"


    Scenario: request get post by postID positive
      Given get first postID
      When request to get post by postID
      Then check data schema with file "getPostByIDSchema.json"
      And check status response by "200"


    Scenario: request get post by invalid userID
      When request to get post by invalid userID
      Then check data schema with file "errorSchema.json"
      And check error message by "PARAMS_NOT_VALID"
      And check status response by "400"


    Scenario: request get post by invalid postID
      When request to get post by invalid postID
      Then check data schema with file "errorSchema.json"
      And check error message by "PARAMS_NOT_VALID"
      And check status response by "400"

