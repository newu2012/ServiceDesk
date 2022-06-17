# ServiceDesk-in-work
Рабочий репозиторий проекта Service Desk. 
### Прочитать README.  
Build Structure Settings in Intelij IDEA:  Java 11; JDK - Amazon Corretto 11; Language Level - 11;

# Build
Для запуска нужно скачать JavaFX SDK 11. Ссылка на скачивание JavaFX SDK 11 - https://gluonhq.com/products/javafx/
В настройках VM установить: 
``--module-path
"path/to/file"/lib
--add-modules
javafx.controls,javafx.fxml
--add-opens
javafx.base/com.sun.javafx.runtime=ALL-UNNAMED
--add-opens
javafx.controls/com.sun.javafx.scene.control.behavior=ALL-UNNAMED
--add-opens
javafx.controls/com.sun.javafx.scene.control=ALL-UNNAMED
--add-opens
javafx.base/com.sun.javafx.binding=ALL-UNNAMED
--add-opens
javafx.base/com.sun.javafx.event=ALL-UNNAMED
--add-opens
javafx.graphics/com.sun.javafx.stage=ALL-UNNAMED
``

# Package build
Сборка Jar производится командой mvn package

# GUI
Для работы с GUI также лучше скачать JavaFX Scene Builder (https://gluonhq.com/products/scene-builder/#download), а также установить в него библиотеку JFoeniX (https://search.maven.org/remotecontent?filepath=com/jfoenix/jfoenix/9.0.10/jfoenix-9.0.10.jar).
