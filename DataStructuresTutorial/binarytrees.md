# Binary Trees
A binary tree is made up of nodes. You can visualize it as a family tree flipped upside down. Each family member in a family tree has two parents, who in turn have two parents each. In a binary tree, each parent node has to children, who in turn can each have two children. Each node in a binary tree is a little packet of information that includes data and two pointers to other nodes. The tree starts with a single node, which can branch out into many. Just like a linked list, a program can iterate through a binary tree. Binary search trees use this structure and organize the data for optimal searching. Each child node in a binary search tree is either placed to the left of its parent if the value is smaller, or to the right of the parent if the value is larger.

## Binary Tree Class
Classes are used to create binary trees. The code below creates a new tree and sets the root to None

```python

class BinaryTree:

    def __init__(self):
        self.root = None

```

To use this code, make an instance of the class.

```python
tree = BinaryTree()
```

## Node class

The code below should be nested inside of the Binary Tree class. It creates a new node within the tree and sets the right and left pointers to none.

```python

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

```

This code can only be used through the insert method described below.

## Inserting into a Binary Search Tree

The two functions below should be methods of the Binary Tree class. the insert() fuction is used to put data into the tree. First it checks to see if the tree is empty. If it is, then it creates a new node and sets it as the root of the tree. Otherwise, it calls the findPlace() function.

```python

def insert(self, data):
        
        if self.root is None:
            self.root = BinaryTree.Node(data)
        else:
            self.findPlace(data, self.root)


```

The findPlace() function starts by ensuring no duplicate data is added to the tree. Next it checks to see whether the data belongs on the left or the right of the current Node. It then searches for an empty slot to store that data using recursion. When it finds an empty slot, it creates a new node in that spot. This creates a binary search tree by ensuring that the nodes are correctly placed based on their data.

```python

    def findPlace(self, data, node):

        if data == node.data:
            return

        if node.data > data:
            if node.left is None:
                node.left = self.Node(data)
            else:
                self.findPlace(node.left)
            
        elif node.data < data:
            if node.right is None:
                node.right = self.Node(data)
            else:
                self.findPlace(node.right)

    # Time complexity: O(logN)

```

Use the two functions above by calling the insert method through the instance of BinaryTree. Make sure to include data as a parameter.

```python
tree.insert(data)
```

## Searching Within a Binary Search Tree

The function below searches the binary tree for a given value. It starts by checking if the current node contains the target value, returning True if it does. Next it determines whether the next node to check will be on the left or the right. If the next node is empty, It will return False, showing that the target value is not in the binary tree. Otherwise, it will use recursion to check the next node.

```python

def contains(self, data, node):
        
        if node.data == data:
            return True

        if data <= node.data:
            if node.left is None:
                return False
            
            return self.contains(data, node.left)

        if data >= node.data:
            if node.right is None:
                return False
            
            return self.contains(data, node.right)

    # Time complexity: O(logN)

```

 In a balanced Tree, this function will have a time complexity of O(logN), because it will eliminate half of the remaining nodes each time it runs.
 Use this code by calling the method. Make sure to include a target value and the root node as arguments.

```python
tree.contains(value, tree.root) 
```

 ## Traversing a Binary Tree

 The functions below work together to iterate through the entire binary tree and return the value of each node. yield is used to continue in that part of the function each time it is called in a loop. 

 ```python

def __iter__(self):
        
        yield from self._traverse_forward(self.root)
        
def _traverse_forward(self, node):
        
    if node is not None:
        yield from self._traverse_forward(node.left)
        yield node.data
        yield from self._traverse_forward(node.right)

    # Time complexity: O(N)

 ```

 To use these functions, call iter() in a for loop.

 ```python
for i in iter(tree):
    print(i)
 ```

## Example Problem

The linked list below simulates a playlist in a music app. Each node contains the name of a song, and a number rating. New songs are inserted based on their rating, to ensure that the tree can be used as a binary search tree.

```python

class PlayList:

    def __init__(self):
        self.root = None

    class Song:
        def __init__(self, name, rating):
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