$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/EndToEndFlow.feature");
formatter.feature({
  "line": 1,
  "name": "CustomerID",
  "description": "",
  "id": "customerid",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "End to end flow of customer create Get and delete request.",
  "description": "",
  "id": "customerid;end-to-end-flow-of-customer-create-get-and-delete-request.",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I have created customer through Post method",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "i retrieve the above created customer for confirmation",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I should be able to delete it.",
  "keyword": "Then "
});
formatter.match({
  "location": "EndToEndFlow.i_have_created_customer_through_Post_method()"
});
formatter.result({
  "duration": 2566072671,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndFlow.i_retrieve_the_above_created_customer_for_confirmation()"
});
formatter.result({
  "duration": 374756782,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndFlow.i_should_be_able_to_delete_it()"
});
formatter.result({
  "duration": 243726414,
  "status": "passed"
});
});