# Importantly
- The program is under development and is not a final product
- The program is the implementation of the technical task

# The task of the program
 - The program should display the list of users downloaded from the server and the possibility of sorting.
 - Perform sorting on your phone because the server does not sort. 
 - asynchronously parsite the list and display the ready-made objects on the screen

# Solving the problem

- create a database where we will transfer data from the server
- create [`service.`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication) It will work in backgraun to receive data from the server and store it in [`database`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/database)
- create [`aplication.`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication) It will work with the database and display it on the UI


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
MyApp.java це головний клас нашого додотку. До нього за контекстом звиртаються з [repository](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository) та [`utils`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils)

## utils
```diff
Festivality/app/src/main/java/test/mb/festivality/utils/
```
utils- пакет в допоміжними файлами

- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`fragmentanimator`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils/fragmentanimator) - пакет якій працює з Сервером
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`models`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils/models) - пакет якій працює з Базою данних
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`parser`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils/parser) - файл памятає що ми вже не першийв программі
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`views`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils/views) - файл памятає що ми вже не першийв программі


## repository
```diff
Festivality/app/src/main/java/test/mb/festivality/repository/
```
repository розбитий на 2 пакети та 1 файл

- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`communication`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication) - пакет якій працює з Сервером
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`database`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/database) - пакет якій працює з Базою данних
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`SharedPreferencesManager.java`](https://github.com/gamestudiostandart/Festivality/blob/master/app/src/main/java/test/mb/festivality/repository/SharedPreferencesManager.java) - файл памятає що ми вже не першийв программі

### communication
```diff
Festivality/app/src/main/java/test/mb/festivality/repository/communication/
```
communication розбитий на 3 пакети
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`retrofit`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication/retrofit) - інструмент для полегшення роботи зі запросами на сервер
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`userlist`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication/userlist) - пакет з реалізацією [методу](https://api.festivality.co/v2/user-list/44779) 
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`services`]((https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication)) - сервіс який ми запускаємо в паралельному потоці


## aplication
```diff
Festivality/app/src/main/java/test/mb/festivality/aplication/
```
aplication це пакет який працює суто з інтерфейсом і віно розбитий на 3 пакети. кожен пакет містить в собі файли, які йлму потрібні для відтворення відповівної механіки.

- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`details`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication/details) - сторінка деталей користувача
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`login`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication/login) - сторінка логіну
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`main`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication/main) - сторінка списку та сортування користувачів





