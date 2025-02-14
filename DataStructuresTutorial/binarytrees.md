

myPlaylist.insert("Take On Me", 5)
myPlaylist.insert("Sweet Home Alabama", 3)
myPlaylist.insert("What Does the Fox Say?", 7)
myPlaylist.insert("Heyah", 2)
myPlaylist.insert("I'm Blue", 6)
myPlaylist.insert("Bad Romance", 4)
myPlaylist.insert("Shake it Off", 8)
myPlaylist.insert("Moskau", 1)

```

Inserting in this order makes a balanced tree. Notice how if the song with the rating of 1 was inserted first, that song would become the root, and all the other songs would end up on the right side. That would produce an inbalanced tree, which would not be optimal for searching. This shows that order is important when inserting data into a binary search tree.

## Coding Challenge

Your challenge is to write a function that will find and display the names of the highest and the lowest rated songs in the binary tree. You should use the code in the example problem above to get started. 
To see a solution to this challenge, [click here](binarytreepractice.py)