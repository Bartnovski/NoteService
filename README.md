# Примечание
**При проектировании сервисов были пропущены следующие поля:**
- *sort* - Сортировка результатов (0 — по дате создания в порядке убывания, 1 - по дате создания в порядке возрастания).
- *offset* - Смещение, необходимое для выборки определенного подмножества заметок.
- *count* - Количество заметок, информацию о которых необходимо получить.
- *needWiki* - Определяет, требуется ли в ответе wiki-представление заметки (работает, только если запрашиваются заметки текущего пользователя).
- *noteIds* - Идентификаторы заметок, информацию о которых необходимо получить.
- *userId* - Идентификатор пользователя, информацию о заметках которого требуется получить.
- *privacyView* - Настройки приватности просмотра заметки в специальном формате.
- *privacyComment* - Настройки приватности комментирования комментария в специальном формате.
- *guid* - Уникальный идентификатор, предназначенный для предотвращения повторной отправки одинакового комментария.

Данные поля не являются ключевыми для демонстрации работы сервисов в данном ДЗ


- метод **getFriendsNotes** согласно документации устарел.