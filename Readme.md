# Итоговая работа по блоку специализация
## Ход выполнения
### Linux
1. **Используя команду cat в терминале операционной системы Linux, создать два файла: Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животные, (заполнив файл лошадьми, верблюдами и ослами), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).**
```
     cat > "Домашние животные.txt"

     Собаки

     Кошки

     Хомяки

     cat > "Вьючные животные.txt"

     Лошади

     Верблюды

     Ослы

     cat "Домашние животные.txt" "Вьючные животные.txt" > "Животные.txt"

     cat "Животные.txt"

     mv "Животные.txt" "Друзья человека.txt"
```
2. **Создать директорию, переместить файл туда.**
```
     mkdir Final_control_work

     mv "Друзья человека.txt" Final_control_work/
```
3. **Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.**
```
     sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.17-1_all.deb

     sudo dpkg -i mysql-apt-config_0.8.17-1_all.deb
```
4. **Установить и удалить deb-пакет с помощью dpkg.**
```
     wget http://ftp.us.debian.org/debian/pool/main/s/sl/sl_5.02-1_amd64.deb

     sudo dpkg -i sl_5.02-1_amd64.deb

     sl

     sudo dpkg -r sl
```
5. **Выложить историю команд в терминале ubuntu.**
![История команд](https://github.com/Svetlana00713/FinalControlWork_2/blob/master/Linux/Screens/5.png)

6. **Нарисовать диаграмму, в которой есть классы: родительский класс, "Домашние животные" и "Вьючные животные", в составы которых в случае "Домашних животных" войдут классы: "Собаки", "Кошки", "Хомяки", а в класс "Вьючные животные" войдут: "Лошади", "Верблюды" и "Ослы".**
![Human_friends](https://github.com/Svetlana00713/FinalControlWork_2/blob/master/Diagramm/Human_friends.png)

7. **В подключенном MySQL репозитории создать базу данных “Друзья человека”.**
![Вход в репозиторий](https://github.com/Svetlana00713/FinalControlWork_2/blob/master/MySQL/Screens/1.png)
![Создание БД](https://github.com/Svetlana00713/FinalControlWork_2/blob/master/MySQL/Screens/2.png)

8. **Создать таблицы с иерархией из диаграммы в БД.**
[Script.sql](https://github.com/Svetlana00713/FinalControlWork_2/blob/master/MySQL/Script.sql)
![Таблицы](https://github.com/Svetlana00713/FinalControlWork_2/blob/master/MySQL/Screens/3.png)

9. **Заполнить низкоуровневые таблицы именами животных, командами, которые они выполняют, и датами рождения.**
![Таблица "Pets"](https://github.com/Svetlana00713/FinalControlWork_2/blob/master/MySQL/Screens/4.png)

10. **Удалить из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы "Лошади" и "Ослы" в одну таблицу.**
![Результат операции](https://github.com/Svetlana00713/FinalControlWork_2/blob/master/MySQL/Screens/5.png)

11. **Создать новую таблицу “Молодые животные”, в которую попадут все животные старше 1 года, но младше 3 лет, и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице.**
![Таблица young_animals и выборка из нее](https://github.com/Svetlana00713/FinalControlWork_2/blob/master/MySQL/Screens/6.png)

12. **Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.**
![Объединенная таблица](https://github.com/Svetlana00713/FinalControlWork_2/blob/master/MySQL/Screens/7.png)

13.







