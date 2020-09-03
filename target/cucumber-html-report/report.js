$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("UserRegisteration.feature");
formatter.feature({
  "line": 1,
  "name": "User Registeration",
  "description": "I want to check that the user can regitser on e-commerce website",
  "id": "user-registeration",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "user registeration successfully",
  "description": "",
  "id": "user-registeration;user-registeration-successfully",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "the user is on the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I click on the register link",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I entered \"\u003cfirstname\u003e\", \"\u003clastname\u003e\", \"\u003cemail\u003e\", \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "the registeration page displays successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "user-registeration;user-registeration-successfully;",
  "rows": [
    {
      "cells": [
        "firstname",
        "lastname",
        "email",
        "password"
      ],
      "line": 13,
      "id": "user-registeration;user-registeration-successfully;;1"
    },
    {
      "cells": [
        "adel",
        "gamak",
        "adhamada@teqst.com",
        "123456766"
      ],
      "line": 14,
      "id": "user-registeration;user-registeration-successfully;;2"
    },
    {
      "cells": [
        "ahmed",
        "gamal",
        "assdahamadsa@tesf.com",
        "123456766"
      ],
      "line": 15,
      "id": "user-registeration;user-registeration-successfully;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "user registeration successfully",
  "description": "",
  "id": "user-registeration;user-registeration-successfully;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "the user is on the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I click on the register link",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I entered \"adel\", \"gamak\", \"adhamada@teqst.com\", \"123456766\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "the registeration page displays successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRegisteration.the_user_is_on_the_home_page()"
});
formatter.result({
  "duration": 182799268,
  "status": "passed"
});
formatter.match({
  "location": "UserRegisteration.i_click_on_the_register_link()"
});
formatter.result({
  "duration": 1606579223,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "adel",
      "offset": 11
    },
    {
      "val": "gamak",
      "offset": 19
    },
    {
      "val": "adhamada@teqst.com",
      "offset": 28
    },
    {
      "val": "123456766",
      "offset": 50
    }
  ],
  "location": "UserRegisteration.i_entered(String,String,String,String)"
});
formatter.result({
  "duration": 2595781744,
  "status": "passed"
});
formatter.match({
  "location": "UserRegisteration.the_registeration_page_displays_successfully()"
});
formatter.result({
  "duration": 1219249545,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "user registeration successfully",
  "description": "",
  "id": "user-registeration;user-registeration-successfully;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "the user is on the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I click on the register link",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I entered \"ahmed\", \"gamal\", \"assdahamadsa@tesf.com\", \"123456766\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "the registeration page displays successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRegisteration.the_user_is_on_the_home_page()"
});
formatter.result({
  "duration": 1292745,
  "status": "passed"
});
formatter.match({
  "location": "UserRegisteration.i_click_on_the_register_link()"
});
formatter.result({
  "duration": 686906250,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ahmed",
      "offset": 11
    },
    {
      "val": "gamal",
      "offset": 20
    },
    {
      "val": "assdahamadsa@tesf.com",
      "offset": 29
    },
    {
      "val": "123456766",
      "offset": 54
    }
  ],
  "location": "UserRegisteration.i_entered(String,String,String,String)"
});
formatter.result({
  "duration": 2304540318,
  "status": "passed"
});
formatter.match({
  "location": "UserRegisteration.the_registeration_page_displays_successfully()"
});
formatter.result({
  "duration": 1907993269,
  "status": "passed"
});
});