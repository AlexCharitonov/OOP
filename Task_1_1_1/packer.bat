cd C:/Users/KAI/Documents/GitHub/OOP/Task_1_1_1
"C:\Program Files\Java\jdk-22\bin\javadoc.exe" -d doc ./src/main/java/org/example/Heap.java ./src/main/java/org/example/Main.java
cd ./src/main/java
javac -d jar_dir org/example/Main.java org/example/Heap.java
"C:\Program Files\Java\jdk-22\bin\jar.exe" --create --file jar_dir/Heap.jar --main-class=org/example/Main -C ./jar_dir/ .
java -jar jar_dir/Heap.jar