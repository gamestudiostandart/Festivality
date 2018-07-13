# Важливо

Програма являється реалізацією технічного завдання, не являє собою комерційного продукту та створина для відкритого доступу та демонстріціі коду 


# Головна поставлена задача

 - Програма повинна відобрадати список користувачів скачаний з серверу та можливістю сортовання.
 - Сервер не виконує сортування тому нам потрібно перемістити весь список з серверу на телефон(максимальна кількість обєктів)

# Вирішення задачі

- в програмі тримати такі великі мписки теж не варіант тому створюємо базу данних куди будемо переносити данні з серверу
- створюємо [`сервіс`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication) в який буде працювати в паралельному потоці приймати з серверу данні і зберігати в [`базу данних`](https://pages.github.com/)
- створити [`додаток`](https://pages.github.com/) який буде працювати з базою данних і вже з неї проводити сортування та виводити на UI поток



# Архітектура коду
## Root
```diff
Festivality/app/src/main/java/test/mb/festivality/
```
Root нашого проетку розбитий на 3 пакети та 1 файл

- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`aplication`](https://pages.github.com/) - пакет якій працює з UI
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`repository`](https://pages.github.com/) - пакет якій працє з Данними(Данні з інернети, або данні з бази данних)
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`utils`](https://pages.github.com/) - пакет з моделями класі, сонверторами, парсерами...
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`MyApp.java`](https://pages.github.com/) - Главний клас в прогламме которая роздайот контекст


## repository
```diff
Festivality/app/src/main/java/test/mb/festivality/repository/
```
repository розбитий на 2 пакети та 1 файл

- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`communication`] - пакет якій працює з Сервером
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`database`] - пакет якій працює з Базою данних
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`SharedPreferencesManager.java`] - файл памятає що ми вже не першийв программі




