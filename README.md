


# About the aplication
 - The aplication should display the list of users downloaded from the server and the possibility of sorting.
 - Perform sorting on your phone because the server does not sort. 
 - asynchronously parsite the list and display the ready-made objects on the screen

# Solution 	
<details><summary>Solution</summary>
<p>	
- create a database where we will transfer data from the server
- create [`service.`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication) It will work in backgraun to receive data from the server and store it in [`database`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/database)
- create [`aplication.`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication) It will work with the database and display it on the UI
</p>
</details>



## collapsible markdown?
<details><summary>CLICK ME</summary>
<p>


</p>
</details>

# Manifest
## Permissions
+ internet
+ location
+ bluetooth
+ notification
## Aplication
+ service - ServiceMain
+ activity - ActivityLogin
+ activity - ActivityMain
+ activity - ActivityUserPage

# build.gradle dependencies
## Standard UI librarys
+ implementation fileTree(include: ['*.jar'], dir: 'libs')
+ implementation 'com.android.support:appcompat-v7:27.1.1'
+ implementation 'com.android.support:support-v4:27.1.1'
+ implementation 'com.android.support:design:27.1.1'
+ implementation 'com.android.support:cardview-v7:27.1.1'
+ implementation 'com.android.support:recyclerview-v7:27.1.1'

## Moxy(MVP)
+ implementation 'com.arello-mobile:moxy:1.5.3'
+ implementation 'com.arello-mobile:moxy-android:1.5.3'
+ implementation 'com.arello-mobile:moxy-app-compat:1.5.3'
+ annotationProcessor 'com.arello-mobile:moxy-compiler:1.5.3'

## Retofit
+ implementation 'com.squareup.retrofit2:retrofit:2.3.0'
+ implementation 'com.squareup.retrofit2:converter-gson:2.3.0'
+ implementation 'com.squareup.retrofit2:converter-scalars:2.3.0'
+ implementation 'com.squareup.okhttp3:logging-interceptor:3.10.0'

## Glide
+ implementation 'com.github.bumptech.glide:glide:3.8.0'

## Third-party libraries for working with UI
+ implementation 'com.crystal:crystalrangeseekbar:1.1.3'
+ implementation 'de.hdodenhof:circleimageview:2.2.0'
+ implementation 'me.everything:overscroll-decor-android:1.0.4'
+ implementation 'jp.wasabeef:recyclerview-animators:2.3.0'
+ implementation 'com.wang.avi:library:2.1.3'
+ implementation 'jp.wasabeef:blurry:2.1.1'


# Code architecture
## Root
```diff
Festivality/app/src/main/java/test/mb/festivality/
```
The root of our project is divided into 3 packages and 1 file

- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`aplication`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication) -  that package works with the UI
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`repository`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository) - that package works with the ([server](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication), or data from [database](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/database)
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`utils`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils) - Package with class models, converters, parsers ...
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`MyApp.java`](https://github.com/gamestudiostandart/Festivality/blob/master/app/src/main/java/test/mb/festivality/MyApp.java) - The main class in the program that distributes the context


## MyApp.java
```diff
Festivality/app/src/main/java/test/mb/festivality/MyApp.java
```
MyApp.java The main class in the program. They are referring to him in context [repository](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository) and [`utils`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils)

## utils
```diff
Festivality/app/src/main/java/test/mb/festivality/utils/
```
utils - auxiliary files package

- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`fragmentanimator`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils/fragmentanimator) - The package works with animation of fragments
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`models`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils/models) - This package contains models of user classes
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`parser`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils/parser) - pass the result from the server to the objects
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`views`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils/views) - packet with rewritten UI elements


## repository
```diff
Festivality/app/src/main/java/test/mb/festivality/repository/
```
repository works with the ([server](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication), or data from [database](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/database)
is divided into 3 packages

- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`communication`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication) - this package is working with the server
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`database`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/database) - this package is working with the database
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`SharedPreferencesManager.java`](https://github.com/gamestudiostandart/Festivality/blob/master/app/src/main/java/test/mb/festivality/repository/SharedPreferencesManager.java) - the file is responsible for skipping the Login page when re-using the program

### communication
```diff
Festivality/app/src/main/java/test/mb/festivality/repository/communication/
```
this package is working with the server
communication is divided into 3 packages
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`retrofit`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication/retrofit) - A tool for facilitating server requests
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`userlist`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication/userlist) - package with implementation of the [method user-list](https://api.festivality.co/v2/user-list/44779) 
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`services`]((https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication)) - This service we run in a Backgraund


## aplication
```diff
Festivality/app/src/main/java/test/mb/festivality/aplication/
```
This is a package that works purely with the interface and it is divided into 3 packages. By package to page. Each package contains the files that the hlm needs to reproduce the responsive mechanics.

- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`userpage`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication/userpage) - user details page
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`login`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication/login) - login page
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`main`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication/main) - List of pages and user sorting



# Notes
After clearing the cache, the permissions pages appear again. with native windows in android not as in IOS. about this I can tell in detail.



