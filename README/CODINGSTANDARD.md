Coding Standard
===============

ESO.Quest is a mobile application that helps RPG players of the game Elder Scrolls Online remember the overall storylines of the game.

Table of Contents
-----------------

* [File Suffixes](#file-suffixes)
* [File Organization](#file-organization)
* [Indention](#indention)
* [Line length](#line-length)
* [Comments](#comments)
* [Declarations](#declarations)
* [Statements](#statements)
* [White Space](#white-space)
* [Naming Conventions](#naming-conventions)
* [Programming Practices](#programming-practices)
* [Logging](#logging)


File Suffixes
-------------
* Java source: .java
* Java bytecode: .class

File Organization
-----------------
* Source file formatting:
  * Each source file contains a single public class or interface. 
  * When private classes and interfaces are associated with a public class, you can put them in the same source file as the public class.
  * The public class should be the first class or interface in the file.
* Source file ordering:
  * Beginning comments
  * Package and Import statements
  * Class and interface declarations
    * Documentation comment
    * Class or interface statement
    * Class (static) variables
    * Instance variables
    * Constructors
    * Methods

Indention
---------
* Four spaces for indents
* Eight spaces for line wraps

Line Length
-----------
* Avoid lines longer than 100 characters
* When an expression will not fit on a single line, break it according to these general principles:
  * Break after a comma
  * Break after an operator
  * Prefer higher-level breaks to lower-level breaks
  * Align the new line with the beginning of the expression at the same level on the previous line
  * If the above rules lead to confusing code or to code that's squished up against the right margin, just indent 8 spaces instead
  * Line wrapping for if statements should use the 8-space rule

Comments
--------
* Should be used to give overviews of code and provide additional information that is not readily available in the code itself.
* Should contain only information that is relevant to reading and understanding the program
* Should not be enclosed in large boxes drawn with asterisks or other characters
* Should never include special characters

* Types:
  * Implementation Comments: /*...*/ and //...
    * Used for commenting out code and for comments about the particular implementation
    * Styles:
      * TODO: 
        * Used to designate code that is temporary, a short-term solution, or good enough but not perfect
      * Block: 
        * Used to provide descriptions of files, methods, data structures and algorithms
        * Should be used at the beginning of each file and before each method
        * Can be used within methods, if indented to the same level as the code they describe
        * Should be preceded by a blank line 
        * Should have an asterisk * at the beginning of each line but the first with indent(1)
      * Single-Line:
        * Indented to the level of the code it describes
        * Should be preceded by a blank line
      * Trailing:
        * Should be shifted far enough right to set them apart from the code
        * Avoid the assembly language style of commenting every line of executable code with a trailing comment
  * Documentation Comments: /**...*/
    * Every file should have a copyright statement at the top, followed by package and import statements (each block separated by a blank line), and finally the class or interface declaration. In the Javadoc comments, describe what the class or interface does.
    * Every class and nontrivial public method that you write must contain a Javadoc comment with at least one sentence describing what the class or method does. This sentence should start with a third person descriptive verb.
    * Used for describing the specification of the code, from an implementation-free perspective, for developers who might not have the source code at hand
    * Use use comment per API and should appear just before the declaration
    * Should have an asterisk * at the beginning of each line but the first with indent(1)
    * Should not be positioned inside a method or constructor definition block

Declarations
------------
* Number per line:
  * One declaration per line
  * Should never put variables and functions be declared on the same line
  * Should never put variables of different types on the same line
* Placement:
  * Put declared variables at the beginning of the block, not at their first use, (except for for loops)
  * Avoid declaring variables with the same name as variables in an outer block
* Initialization:
  * Try to initialize variable where they are declared
  * If the initial value depends on some computation occurring first, this can be ignored
* Class and Interface Declarations:
  * Should be no space between a method name and the parenthesis
  * Place open brace at the end of the same line as the declaration statement
  * Place closing brace at the start of its own line, indented to match the corresponding opening statement
  * Place closing brace at the end of the same line as the open brace if the block is null, space separated "{ }"

Statements
----------
* Simple:
  * Each line should contain at most one statement
* Compound:
  * Enclosed statements should be indented one more level than the compound statement
  * Place the opening brace the end of the line that begins the compound statement
  * Place the closing brace at the beginning of a new line and be indented to the beginning of the compound statement
  * Braces are used around all statements, even singletons, when they are part of a control structure
* Return:
  * Should not use parentheses unless it makes the return value more obvious
* If, if-else, if-else-if-else:
  * Always use braces, even if a singleton
  * Form:
    if (condition) {
      ...
    } else if (condition) {
      ...
    } else {
      ...
    }
* For:
  * Form:
    for (initialization; condition; update) {
      ...
    }
  * An empty for statement should omit the braces and have a semicolon at the end
  * Avoid using more than three variables in the initialization step of the for statement
* While:
  * Form:
    while (condition) {
      ...
    }
  * An empty while statement should omit the braces and have a semicolon at the end
* Do-while:
  * Form:
    do {
    ...
    } while (condition);
* Switch:
  * Form:
    switch (condition) {
    case ABC:
      ...;           
      /* falls through */
    case DEF:
      ...;
      break;
    case XYZ:
      ...;
      break;
    default:
      ...;
      break;
    }
  * Add a comment specifying there is no break, if there isn't
  * Always include a default case
* Try-catch:
  * Form:
    try {
      ...
    } catch (ExceptionClass e) {
      ...
    }

White Space
-----------
* Used to improve readability by setting off sections of code that are logically related
* Two spaces should always be used:
  * Between section of a source file
  * Between class and interface definitions
* One space should always be used:
  * Between methods
  * Between local variables in a method and its first statement
  * Before a block or single-line comment
  * Between logical sections inside a method to improve readability

Naming Conventions
------------------
* Classes and Interfaces: 
  * Should be nouns 
  * Mixed case (ImageSprite)
  * Simple and descriptive
  * Use whole words, unless the acronym is more common than the long form, but case the acronym as a word (HTML = Html)
* Methods:
  * Should be verbs
  * Camel case (runFast();)
* Variables:
  * Should be short yet meaningful, except for throwaway variables
  * Camel case (int myWidth;)
  * Non-public, non-static field names in classes should start with m
  * Static field names should start with s
* Constants (static final):
  * All caps with a _ between words (int MIN_WIDTH = 4;)

Programming Practices
---------------------
* Should be private or protected unless with a good reason
* Avoid using an object to access a class (static) variable or method. Use a class name instead
* Should use parentheses liberally in expressions involving mixed operators to avoid operator precedence problems
* Use WORKS in a comment to flag something that is bogus but works. Use ERROR to flag something that is bogus and broken
* Don't catch generic exceptions
* Should never avoid exceptions
  * Alternatives: 
    * Throw the exception up to the caller of your method (void setServerPort(String value) throws NumberFormatException { ... })
    * Throw a new exception that's appropriate to your level of abstraction (} catch (NumberFormatException e) { throw new ConfigurationException("Port is not valid"); })
    * Handle the error gracefully and substitute an appropriate value in the catch block (} catch (NumberFormatException e) { serverPort = 80; })
    * If you're confident that ignoring the exception is appropriate then you may ignore it, but you must also comment why with a good reason
* Fully qualify import statements
* Annotations:
  * Use @Deprecated, @Override, and @SuppressWarnings annotation liberally to remove warnings so that warning actually reflect problems in code
    * Only use SuppressWarnings if a warning passes that "impossible to eliminate" test

Logging
-------
* Log sparingly as it impacts performance
* Levels:
  * ERROR: Use when something fatal has happened
  * WARNING: Use when something serious and unexpected happened
  * INFORMATIVE: Use to note that something interesting happened that could affect something else later
  * DEBUG: Use to further note what's happening on the device that could be relevant to investigate and debug unexpected behaviors
    * Surround with if (LOCAL_LOGD) where LOCAL_LOGD is a constant defined in your class for easy disabling
  * VERBOSE: Use for everything else
    * Surround with if (LOCAL_LOGV) where LOCAL_LOGV is a constant defined in your class for easy disabling

