# Project 2: Dictionary

- The dictionary is specified as an argument each time and the program runs
	- Make no assumptions about dictionary length/content
	- *It can literally be ANYTHING*
- You are only responsible for handling ASCII character (0-127)
	- `/usr/share/dict/words` is unfortunately UTF-8, so some words have characters outside that range.
	- It is safe to ignore words with non-ASCII characters.
- `ctype.h` has many useful functions/macros: `isalpha()`, `isupper()`, `tolower()`
- For our purposes, all characters are letters, whitespace, or other
	- Treat symbols, numbers, control characters like punctuation.
- If you can't get all the features working, get as many as you can.