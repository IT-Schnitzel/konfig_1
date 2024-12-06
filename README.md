Документация к эмулятору
Эмулятор командной строки (Shell Emulator) написан на Java и имитирует работу стандартной оболочки Unix-подобных операционных систем. Эмулятор поддерживает базовые команды и позволяет работать с виртуальной файловой системой, хранящейся в архиве формата zip. Команды, поддерживаемые эмулятором: ls, cd, echo, rmdir, exit.

Программа запускается из реальной командной строки, принимает аргументы для указания пользователя, компьютера, пути к архиву с файловой системой и стартовому скрипту (необязательный параметр), который автоматически выполняется при запуске. а путь к файловой системе - filesystem.zip

Поддерживаемые команды:

ls [directory] - Выводит содержимое текущей директории. Если папка пуста — вывод будет пустым. Можно дописать путь к папке, в таком случае выведет содержимое введенной директории.

cd [directory] - Изменяет текущую директорию. Поддерживается относительная и абсолютная навигация.

rmdir [directory] - удаляет пестую директорию

echo "message" - выводит в консоль определенное сообщение

exit - Завершает работу эмулятора.

![image](https://github.com/user-attachments/assets/f4d06fc9-22b4-4453-aa52-15476dc3ec69)

![image](https://github.com/user-attachments/assets/65d1f9f7-f892-4a99-8880-e5f58521d358)

![image](https://github.com/user-attachments/assets/5a99ac31-34bd-4d7d-b415-53d948ff7696)


