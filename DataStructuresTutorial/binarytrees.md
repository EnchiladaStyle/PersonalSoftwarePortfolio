
            self.rating = rating
            self.name = name
            self.left = None
            self.right = None

    def insert(self, name, rating):
        
        if self.root is None:
            self.root = PlayList.Song(name, rating)
        else:
            self.findPlace(name, rating, self.root)
        

    def findPlace(self, name, rating, song):

        if rating == song.rating:
            return

        if song.rating > rating:
            if song.left is None:
                song.left = self.Song(name, rating)
            else:
                self.findPlace(name, rating, song.left)
            
        elif song.rating < rating:
            if song.right is None:
                song.right = self.Song(name, rating)
            else:
                self.findPlace(name, rating, song.right)

        # Time complexity: O(logN)

```

Let's say We had the following list of songs and ratings and we needed to insert it into the playlist. {"Moskau": 1, "Heyah": 2, "Sweet Home Alabama": 3, "Bad Romance": 4, Take On Me": 5, "I'm Blue": 6, "What Does the Fox Say?": 7, "Shake it Off": 8}
In order to make it a balanced tree, with optimal search performance, we will need to insert each song in the correct order. below is one way of inserting the data manually in the correct order.

```python

myPlaylist = PlayList()

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