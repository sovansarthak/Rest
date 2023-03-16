Feature: Validating Place API

@AddPlace @Regression
Scenario Outline: Verify whether place is successfully added using AddPlace API
Given AddPlace API payload with "<name>" "<language>" "<address>"
When User calls "AddPlaceApi" with "POST" http request
Then API call got success with "200" status code
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify that "place_id" created maps to "<name>" using "GetPlaceApi"

Examples:
| name       |language           |address                      |
| Sovan      |  Odia-IN          |  230, hsr layout, cohen 09  |
| Sarthak    |  Hindi-IN         |  231, hsr layout, cohen 10  |


@DeletePlace @Regression
Scenario: Verify if DeletePlaceApi is working
Given DeletePlaceApi palyload
When User calls "DeletePlaceApi" with "POST" http request
Then API call got success with "200" status code
And "status" in response body is "OK"
