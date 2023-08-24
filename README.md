
## **Primates Sanctuary - MVC based Java Application**

### **About/Overview**<br>
The Primates Sanctuary is a comprehensive system designed to manage the monkeys within a sanctuary. The problem it solves is the tracking and managing of various species of monkeys, including their details, health status, enclosure, etc. It allows the user to efficiently register monkeys, move monkeys, and list monkeys, all in an intuitive graphical interface.

### **List of Features**<br>
- Register Monkey: Allows the registration of a new monkey into the sanctuary.
- Move to Enclosure: Enables moving a healthy monkey in isolation to a specific enclosure.
- View Enclosure Monkeys: List monkeys in the selected enclosure.
- View All Enclosures: Lists all enclosures and their associated monkeys.
- View All Monkeys: Lists all monkeys within the sanctuary.
- Notification: Users will be notified if there is no room for new monkeys or any error inputs for registration.

### **How to Use the Program**<br>
The program presents a graphical interface to interact with:<br>

**Register New Monkey:**
- To add a new monkey, simply fill out the text fields for Name, Weight, Age, and select the appropriate options from the dropdown menus for Species, Sex, Size, Favorite Food, and Is Healthy. Click on "Register Monkey" to complete the registration.
- Note that all fields must be filled out, and each monkey's name must be unique to register successfully.
- Once registered, monkeys are automatically placed in isolation and displayed in the "Monkeys in Isolation" dropdown tab, showing their name and health condition. 
- The isolation area has a maximum capacity of 20, once the monkeys in isolation reach this capacity, the user will be unable to register new monkeys, so user can move healthy monkeys to enclosures to release spaces.


**Move to Enclosure:** 
- To transfer a healthy monkey from isolation to an enclosure, select the monkey from the "Monkeys in Isolation" dropdown tab and click "Move to Enclosure." 
- The selected monkey will be moved to its desired enclosure based on its species. 
- If the monkey is unhealthy or not found, an error message will be displayed.
- After successfully moving the monkey, the "Monkeys in Isolation" list will be updated.


**View Selected Enclosure:**
- Select a species housed in the desired enclosure from the "Select Enclosure" dropdown tab, then click the "View Selected Enclosure" button. 
- It will produce a list showing each individual monkey currently housed in the selected enclosure, or a message if the enclosure is empty.


**View All Enclosures:**
- Click the "View All Enclosures" button, and it will produce a list showing all enclosures and their associated monkeys.


**View All Monkeys:**
- Click the "View All Monkeys" button, and it will produce an alphabetical list (by name) showing all monkeys housed in the sanctuary.


### **Design/Model Changes**<br>

**Original Design**<br>
The initial design of the Primate Sanctuary application focused solely on the Model part of the MVC pattern. This Model included classes and methods responsible for representing and managing monkeys, enclosures, health status, etc. The design was confined to the logical structure and functionality of the application without consider the user interface or how the data would be presented to the end-users.

**Changes and Reasons**

**Addition of View and Controller:**<br> 
The View and Controller parts were added to the original Model to form a complete MVC architecture.<br>
- View:<br>
This part of the design added graphical user interface components, allowing users to interact with the application in a more intuitive and engaging way.<br>
- Controller:<br>
The Controller was implemented to handle the user input and coordinate the actions between the Model and View. It plays a vital role in translating user actions into updates in the Model and reflecting those changes in the View.<br>

**Enhanced Usability:**<br> 
The transition to the MVC model has resulted in a more cohesive and maintainable code structure, allowing for better scalability and extensibility in future updates.


### **Assumptions**<br>
- Monkeys marked with "Yes" under "Is Healthy" are assumed to have already received medical attention and are eligible to be moved to an enclosure.
- The input weight is assumed to be in kilograms.
- The input age is assumed to be in years.

### **Limitations**
- The program lacks a saving function, further development should integrate a database, such as MongoDB, to facilitate data storage and retrieval.
- The user interface can be further improved, such as displaying the lists in table format, and the overall design could be made more user-friendly.

### **Summary**<br>
The Primates Sanctuary Java application stands as a beacon of efficiency and usability in managing monkeys within a sanctuary. 
By leveraging the MVC architecture, the application not only enhances user experience through its graphical interface but also ensures systematic management of each monkey's details, health, and enclosure status.
