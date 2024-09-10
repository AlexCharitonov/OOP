javac -d bin ./src/main/java/org/example/Heap.java
javac -d bin ./src/main/java/org/example/Main.java
javadoc -d doc ./src/main/java/org/example/Heap.java ./src/main/java/org/example/Main.java
cd ./bin
java org/example/Main org/example/Heap