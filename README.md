bayes-dota
==========

This is the [task](TASK.md).

Description
============
Database: PostgreSQL

* JPA: Used to reading and managing data from your java object to relational tables in the database.


* @Query: Is used In order to create custom queries. 


* Tuple is used to get generic data structure from the queries.


* Enum class is used because we have a set of text which is to be used throughout the code so to avoid repetition and to gain more readability enum class is used which contains regex expressions. The regex expressions are used here to identify a pattern of text throughout the entire text file.


* Separate repositories are created to handle each of the entity separately. For example, if any new methods are to be added in future or alter a specific table the methods can be created on the relevant repository.
And since JPA is followed, logical implementation for finding a specific id or value will not be needed to be implemented. Because it provides a set of inbuilt methods and a structure to customize them easily.


* A parent class named Match is created and the rest of the other classes inherit the parent because they capture the extra variables along with the parent variables. Thus by using inheritance the child classes will extend the parent to get access to their variables as well. And the parent class is an abstract class. In order to avoid object initialization.
