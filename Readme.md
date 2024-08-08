1. Используя команду cat в терминале операционной системы Linux, создать два файла: Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животные, заполнив файл лошадьми, верблюдами и ослами), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).

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
2. Создать директорию, переместить файл туда.

     mkdir Final_control_work

     mv "Друзья человека.txt" Final_control_work/
3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.

     sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.17-1_all.deb

     sudo dpkg -i mysql-apt-config_0.8.17-1_all.deb
4. Установить и удалить deb-пакет с помощью dpkg.

     wget http://ftp.us.debian.org/debian/pool/main/s/sl/sl_5.02-1_amd64.deb

     sudo dpkg -i sl_5.02-1_amd64.deb

     sl

     sudo dpkg -r sl
5. Выложить историю команд в терминале ubuntu
![История команд](https://github.com/Svetlana00713/FinalControlWork_2.git.row/master/Linux/Screens/5.GIF)


