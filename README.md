# Performance Comparison of Buffering Strategies in Java

## Description

This project compares the performance of different buffering strategies in Java. The strategies are:

- FileChannel with indirect buffers
- FileChannel with direct buffers
- FileChannel using the transferTo() operation
- Buffered I/O Stream
- Stream read into a byte array managed by the programmer

The results are presented in the following table:

| Type of buffering                                       | SmallFile and Buffer = 1024 | BigFile and Buffer = 1024 | SmallFile and Buffer = 65536 | BigFile and Buffer = 65536 |
|--------------------------------------------------------|-----------------------------|---------------------------|------------------------------|----------------------------|
| FileChannel with indirect buffers                       | 30 ms                       | 84 ms                     | 14 ms                        | 17 ms                      |
| FileChannel with direct buffers                         | 2 ms                        | 32 ms                     | 2 ms                         | 6 ms                       |
| FileChannel using the transferTo() operation            | 6 ms                        | 27 ms                     | 0 ms                         | 31 ms                      |
| Buffered I/O Stream                                     | 0 ms                        | 14 ms                     | 44 ms                        | 46 ms                      |
| Stream read into a byte array managed by the programmer | 9 ms                        | 18 ms                     | 5 ms                         | 0 ms                       |

## How to run

The project is a Java Project. To run it, you need to have Java installed on your machine.
After that, you can run the project by opening a terminal in the directory and executing the following commands depending on your operating system:

### Mac/Linux

give the permission to execute the script (only the first time):

```bash
chmod +x exec.sh
```

and then execute it:

```bash
./exec.sh
```

### Windows

Just execute it:

```batch
.\exec.bat
```
