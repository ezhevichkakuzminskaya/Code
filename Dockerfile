# Используем образ openjdk:11 в качестве базового образа с именем builder
FROM openjdk:11 as builder

# Создаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем директории target/classes из каждого проекта внутрь контейнера
COPY mr-231/target/classes/ /app/mr-231
COPY mr-231-3/target/classes/ /app/mr-231-3
COPY startApp/target/classes/ /app/startApp

# Выводим список скопированных файлов для отладки
RUN ls -R /app

# Открываем порт 8000 для взаимодействия с приложением
EXPOSE 8000

# Запускаем приложение при старте контейнера
CMD ["java", "-cp", "/app/mr-231:/app/mr-231-3:/app/startApp", "org.example.App"]
