# Messages App

This is a short practice project of a Java application that stores messages in a MySQL database

Requires the **messages_app** database using these credentials: user **juan**, pass **admin**

As an user with privileges:

1. CREATE USER 'juan'@'localhost' IDENTIFIED BY 'admin';
2. CREATE DATABASE messages_app;
3. GRANT ALL PRIVILEGES ON messages_app.* TO 'juan'@'localhost';
4. mysql -u juan -p < messages_app.sql
