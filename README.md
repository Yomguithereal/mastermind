#Clojure Mastermind

This program is a command line implementation of the mastermind game. If you do not know
the rules of this game, you should really go and read this [page][1].

[1]: <http://en.wikipedia.org/wiki/Mastermind_(board_game)>

#Installation

To use the program, you should have Java >= 6 and leiningen installed on your machine. Then run the
following commands within the game's directory.

```sh
# Running the game with lein
lein trampoline run

# Compiling the game into a .jar
lein uberjar
java -jar mastermind-1.0.0-SNAPSHOT-standalone.jar
```

# How to play

The code length is five and the different possible colors are : [red green yellow purple cyan blue].

To propose a guess to the program, type a combination of five colors' initials (Example : bycbr) or, if you want to be exhaustive, type every color separated by a comma (Example : blue, purple, cyan, blue, red).

To quit the game, just type "quit" or "exit".

# Bonus
Why is this command line mastermind better than some others? 

Because it has fancy colors! Yeah!

# Dependencies

    Java >= 6
    Leiningen
    Clojure 1.5.1