# Code-Library
#### Video Demo: https://youtu.be/M1j2wCUSHHg <URL HERE>
#### Description:

The project includes a virtual library where you can store snippets of programmer's code.

#### There are different requirements:
* You must have Java to run the program. A more recent version is best.
* A database is needed to store the code sections. I used Xampp with MySQL and Apache to create LocalHost.
* Packages are managed with Maven.

##### The project consists of 3 classes:

The DBClass connects to the Sql database using various functions and imported libraries. 
In addition, the functions for updating the list, 
inserting new records, removing records and searching for records are defined here.

The ListObject class is only there to cache the primary key and title.

The CodeLibraryFrame class defines all visually visible objects and the frame itself. 
In addition, some simple functions are defined that either use other functions of the DBClass or do not query any SQL statements.

#### Usage:

You can select items in the list on the left by pressing on them. The title and code then appear on the right.

One can filter for entries using the search bar. The library searches the title and code for the search term.

Entries can be deleted by selecting them in the list and then pressing the Delete key.

You can add new entries with the NEW button. A new entry appears with the title: Title and the text: Text.

You can edit selected entries at any time, simply click in the right text fields and make the change.

