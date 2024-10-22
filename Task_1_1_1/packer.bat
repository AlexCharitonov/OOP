javac -d bin ./src/main/java/org/example/Heap.java ./src/main/java/org/example/Main.java
"C:\Program Files\Java\jdk-22\bin\javadoc.exe" -d doc ./src/main/java/org/example/Heap.java ./src/main/java/org/example/Main.java
cd ./bin
"C:\Program Files\Java\jdk-22\bin\jar.exe" cvf /org/example/heap.jar /org/example/Main.class /org/example/Heap.class
"C:\Program Files\Java\jdk-22\bin\jar.exe" --create --file heap.jar --main-class=org/example/Main Main.class Heap.class
java org/example/Main org/example/Heap