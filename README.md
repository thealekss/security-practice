# security-practice

Проект security-custom-users-storage

  
    -Реализована аутентификация и авторизация пользователей через имя пользователя и пароль. Данные берутся из html-формы.
    -Данные пользователей хранятся не в стандартных таблицах базы данных с предопределенной структурой, а в наших собственных.
    -Решена проблема иерархии. Пользователь с ролью 'admin' имеет право доступа ко всем ресурсам, доступным пользователю с ролью "user"