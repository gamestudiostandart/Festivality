# Важливо

Програма являється реалізацією технічного завдання, не являє собою комерційного продукту та створина для відкритого доступу та демонстріціі коду 

# Головна поставлена задача

 - Програма повинна відобрадати список користувачів скачаний з серверу та можливістю сортовання.
 - Сервер не виконує сортування тому нам потрібно перемістити весь список з серверу на телефон(максимальна кількість обєктів)

# Вирішення задачі

- в програмі тримати такі великі мписки теж не варіант тому створюємо базу данних куди будемо переносити данні з серверу
- створюємо [`сервіс`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication) в який буде працювати в паралельному потоці приймати з серверу данні і зберігати в [`базу данних`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/database)
- створити [`додаток`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication) який буде працювати з базою данних і вже з неї проводити сортування та виводити на UI поток


# Архітектура коду
## Root
```diff
Festivality/app/src/main/java/test/mb/festivality/
```
Root нашого проетку розбитий на 3 пакети та 1 файл

- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`aplication`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication) - пакет якій працює з UI
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`repository`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository) - пакет якій працє з Данними([Данні з інернети](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication), або данні з [бази данних](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/database)
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`utils`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils) - пакет з моделями класі, сонверторами, парсерами...
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`MyApp.java`]https://github.com/gamestudiostandart/Festivality/blob/master/app/src/main/java/test/mb/festivality/MyApp.java) - Главний клас в прогламме которая роздайот контекст


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





