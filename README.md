# Code-Library
#### Video Demo: https://youtu.be/M1j2wCUSHHg <URL HERE>
#### Description:

The project includes a virtual library where you can store snippets of programmer's code.

##### There are different requirements:
* You must have Java to run the program. A more recent version is best.
* A database is needed to store the code sections. I used Xampp with MySQL and Apache to create LocalHost.
* Packages are managed with Maven.

##### The project consists of 3 classes:

<b>The DBClass connects to the Sql database using various functions and imported libraries. 
In addition, the functions for updating the list, 
inserting new records, removing records and searching for records are defined here. </b>

Functions:

* addNewField: adds a new record using SQL statement Insert


* updateTitle: ensures that the current title is always displayed in the list on the left and thus the text is also saved (happens when you click in another field), the Sql command UPDATE is used here


* deleteData: as the name suggests, this function deletes the selected entry, the Sql command DELETE is used here


* searchData: ensures that the text and title are searched for the entered term, the SQL command SELECT/ WHERE is used here


* getText: is a function that returns the appropriate entry for a given primary key, the SQL command SELECT/ WHERE is also used here


<b> The ListObject class is only there to cache the primary key and title. </b>

Functions:

* constructor ListObject: is required to define the object


* getPK: returns the stored primary key when called


* gettitle: returns the saved text when called

<b>The CodeLibraryFrame class defines all visually visible objects and the frame itself. 
In addition, some simple functions are defined that either use other functions of the DBClass or do not query any SQL statements.</b>

Functions:

* refresh: uses the DBCLass to update the text and title


* delete: deletes a selected entry using DBCClass


* updateTitle: update the title using the DBCLass


* updateContent updates the text using the DBCClass


* addContent adds an entry with title: TITLE and text: TEXT (using DBCClass)


* CodelibraryFrame: defines the visually visible objects (and also a few non-visible objects/ The frame consists of, among other things: a mainPanel, a searchField and the listDataSetsTitles

##### Design:

I thought and tried a lot about the design. 
In the end I decided on a very simple dark one. 
This protects the eyes when used at night. 

A blue with red and orange as contrasting colors was chosen. 
The writing is mostly light beige.

##### Usage:

You can select items in the list on the left by pressing on them. The title and code then appear on the right.

One can filter for entries using the search bar. The library searches the title and code for the search term.

Entries can be deleted by selecting them in the list and then pressing the Delete key.

You can add new entries with the NEW button. A new entry appears with the title: Title and the text: Text.

You can edit selected entries at any time, simply click in the right text fields and make the change.

#### Information about the POM.xml:

* The project title or the artifactId is specified in the POM: was set to "java-project".

* The project package is specified in the POM: was set to "com.myproject"

* in the POM the maven.compiler.source is also set: was set to 18

* Alternatively, the Java version can also be defined there

#### General information

* the project continues and is being worked on

Example functions for the future:

* multiple search terms

* changeable theme

* direct modification of the database