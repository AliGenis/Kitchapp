# Kitchapp
# CS102 ~ Design Project ~ Fall 2020/2021
****
## g1B ~~ KitchApp ~~
## Project Description
By using this application, we hope that people can easily control their kitchen as they know the ingredients in it with details and which foods they can cook. Furthermore, if users cannot decide what they want to eat, they can use the suggestion section.
 What has been done?

→ We have mainly finished our project according to what we have planned. There are just minor details such as multi user feature.The user can add ingredients to the Room Database and show them on the Fridge and Shopping List screen. Additionally, the user can change the amount of ingredients in the fridge/shopping list by using +/-/delete buttons. The application can get ingredients and recipes from the room database and the application can automatically use increment/decrement features of the ingredients if the recipe is cooked. Moreover, the user can get suggestions according to what she/he has got in her/his fridge and while getting suggestions, the user can see calorie/preparation time of the meal.
→ We have used Android Studio 4.1.1 and we received help from GSON, androidx, and room libraries. For our database operations; we benefit from Room Database. For testing our app we used an emulator inside Android Studio.
→ In order to use kitchapp, the user has to connect her/his android or use an emulator. We have operated on Pixel 3 as an emulator. If the user presses play Android, the app does download and set up operations on its own and app opens. After the app has started, the user can easily discover the app with icons on the navigation bar.


What remains to be done?

→ Although we have planned to make this app as a multi-user app , currently, there is just one default user to test this app. Thus, the settings part of the kitchapp is not functional but we are planning to fix it.
→ We need to build pre pre-populated database. Right now we add our recipes manually for test purposes with the help of method in MainActivity.



Contributions

Gülçin ÖZKAHYA: Before we have changed our database decision from Firebase database to Room Database, I have mostly worked on Ingredient and Fridge classes, Fridge’s user interface and I have worked on firebase database . After this decision I mostly worked on Recipe classes. I have added visuals and features to suggestion’s and oneRecipe’s screens UI and created a logo for our app! 

Emre ERDAL: In the first weeks of the project, I worked on connecting the firebase database to the project. Then, we have changed it to room database. Apart from that, I worked on various classes' UI design such as designing the layouts and adding buttons. I added some images to the app to needed positions. I worked on fixing some logic errors in the main class. 

Ali GENİŞ: Before we started UI, I worked on IngredientList class and Firebase database. Then we moved to the local database(Room) so I helped the connection between code and our new database. I worked on shopping list and suggestion UIs, and I also worked on oneRecipe’s fragment. I established data flow between fragments. I added some emojis and funny messages to make the app more user-friendly and funny.

Şulenur YILMAZ: Before we changed the code, I have worked on Recipe and Recipe Fragment classes  and their UIs. After the changes, I worked on MainActivity class. I specified the recipes for the application’s database. And I hardcoded them one by one. Besides, I found some images to use on the screens and I edited them. 

Tarık DEMİRÖREN:  Within the first couple of weeks after we started the project, I focused my work on generally Recipe and User classes and UI’s of the relevant classes. I worked with others who were trying to fix and connect firebase database. Although I was short on work in the first couple of weeks I worked hard on the last couple of days like every other member of my group. We decided to not implement the user class so my work load decreased drastically so I stored my effort in helping others while I was available. I made connections with our classes to the room database. I worked some more at the backend of our code, simplifying the structure and resolving some bugs. I found and added recipes through the internet and my own knowledge and prepopulated the database with them via a method I created. I could not do it in an efficient manner though. I added a collection of toast messages for users to enjoy even more(Even though in the first try a group member thought the phone got hacked due to a message in the poll being in italian). On the last day, I found myself working on solving some logic errors and bugs, and testing the program for bugs and getting rid of what I found in the process. 

Ömer Burak DOĞAN: I searched for different local database methods. Me and Ali implemented Room database , which is the system that we can adapt to the project most easily. And, i tried to make connections between database and fragments. I made some of the Fridge UI and I made the connection between Fridge and Shopping List fragments.
