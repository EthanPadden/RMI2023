set currentDir=%cd%
echo %currentDir%
javac ShareServerImpl.java
java -cp %cd% -Djava.rmi.server.codebase=file:/%cd% -Djava.security.policy=server-windows.policy ShareServerImpl