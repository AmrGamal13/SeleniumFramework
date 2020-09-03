Feature: User Registeration
I want to check that the user can regitser on e-commerce website

Scenario Outline: user registeration successfully

Given the user is on the home page
When I click on the register link
And I entered "<firstname>", "<lastname>", "<email>", "<password>"
Then  the registeration page displays successfully

Examples: 

|firstname | lastname | email | password |
|adel | gamak | adhamada@teqst.com | 123456766 |
|ahmed | gamal | assdahamadsa@tesf.com | 123456766 |
