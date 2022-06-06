## Problem specification
Assume that you are trying to implement syntax highlighting in a programming language editor. The editor currently supports 3 languages (C, CPP and Python). To perform this, you need to be able to parse the .c, .cpp and .py source files. Each language has specific rules of parsing. All the parsers implement an interface named Parser which contains all the functions required to parse a file. There is an Interface for the fonts of the source codes. The editor uses Courier New, Monaco
and Consolas font for C, CPP and Python respectively. Assume that multiple instances of the
editor cannot run simultaneously. The input will be the file name with extension and the output
will be the selected font while showing environment and parser name when running parsing
method of the editor.  
Tasks:  
- Identify the design pattern(s) that can best capture the scenario above.
- Implement the scenario in Java