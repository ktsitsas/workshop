You can get this program from the repository located at https://github.com/ktsitsas/workshop
To run it just click on run.bat or run.sh (depending on your environment) and it will produce inside dist folder an output.txt file.
1) Assuming that the average string consists of 8 utf-8 chars, each string's size is 16bytes, so the maximum number of strings is 12.500.000.
2) To increase this limit I would set the Xmx parameter of the JVM to more than 200m.
3) The program is not that efficient as it uses relatively slower sets to avoid duplicates and at the end it sorts a huge list lexicographically.
4) To increase the execution performance, if unique values or sorting couldn't be avoided or storing data not in utf-8 encoding, we could use more efficient data structures like binary search or balanced trees.
