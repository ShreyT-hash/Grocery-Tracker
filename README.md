# A Grocery Tracker

## Allows users to manage grocery purchases and give recipe suggestions based off what they buy.


Once the user the groceries have been put into the application, it will be able to provide the following information to the user
- Potential recipes that can be made 
- Notify user of any expiration dates
- Nutritional value of the food
- Financial summary (budgeting)

This application is targeted for those people who want 
to be more efficient when it comes to purchasing groceries.
For people who want to save some money and not waste food. 
Ideally, this application will be used by **university students**,
and **parents**.

As a university student myself, a lot of times its hard to keep track of
what is in my fridge and what to cook every day. A lot of times I end up
not having the right ingredients or end up throwing stuff out. By creating
a tracker, hopefully I can prevent this from happening.

##User Stories
- As a user, I want to be able to add my groceries to a collection.
- As a user, I want to be able to view the total amount of money I spent after every grocery run.
- As a user, I want to be able to view what items I currently have in my fridge/ inventory at home and whether or not 
they are perishable.
- As a user, I want to be able to see how many perishable items I have in my fridge after inputting all the groceries 
that I bought.
- As a user, I want to be able to save the grocery items that I have 
purchased and their attributes to a text file.
- As a user, I want to be able to load the grocery items that I previously
saved into my current pantry upon starting the program. 

# <h4> Instructions for grader</h4>	
- You can generate the first user story by clicking
'Go to My Pantry', then 'Add Grocery' and then
entering what the dialog boxes ask you to enter.  

- You can generate the second and fourth user stories by clicking the
'View Summary' button. Click 'Back To Pantry' to generate the other events.

- Once you have added a few groceries, you can trigger
my visual component and generate the third user story
by clicking on 'View Pantry Items' (*there is a chance groceries may not show up on the first click, 
ensure 'View Pantry is clicked at least twice'*)

- You can save the state of my application by clicking on 'Save Items'

# <h4> Phase 4: Task 2</h4>	
Chosen to make 'Inventory' into a more robust class. 
'addItemToInventory' now throws a new InputException. 'jPaneDo' in 'AddGroceryScene' also 
throws it and it is caught in 'actionPerformed' in 'AddGroceryScene'. 

# <h4> Phase 4: Task 3</h4>	
- First problem fix: The 'AddGroceryScene' class was sharing implementation 
details with the 'Inventory' class. Rather than using 'Inventory'
 methods (sumToString) I was recreating the toString methods 
 from scratch in the 'ui' package. Deleted redundant implementation,
 made another helper called (perishToString) in 'Inventory' and referenced
 both toString methods from there. Fixed redundancy, lowered coupling and fewer implementation 
 details shared. 
 
- Second problem fix: Reduced coupling by creating another helper method 'setBasicScene' in the 
'UserInterface' class and using it to instantiate basic parameters for the JFrames. 
Rather than repeating same lines of code, now, I just need to  pass JFrame in as a parameter. 
Reduces redundancy, cleaner code and I now have single point of control for JFrame instantiation. 


