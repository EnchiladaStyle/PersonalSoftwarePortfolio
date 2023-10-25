# Linked List
A linked list is a connection of nodes. Similar to a scavenger hunt, each node leads the program to the next node until it reaches the end. 
The first node in the linked list is called the Head. The last node in the linked list is called the Tail. Each node in the linked list contains data, and points to two other nodes, Previous and Next. Previous for the head is Null. Next for the Tail is Null.
Because the data is organized in this way, it can be iterated through using a loop either from start to end, or end to start.

## Linked List Class
Classes are used to create a linked list. 
The code below writes the new linked list. The default values for Head and tail are set to None.


```python

    

    class LinkedList:
        
        def __init__(self):
        
        self.head = None
        self.tail = None
```

to activate a new linked list, make a new instance of the class.

```python
newInstance = LinkedList()
```

the code below should be written within the LinkedList class. It writes a new node, setting Next and Prev to None. Data is required as a parameter.
```python     
        class Node:
        
            def __init__(self, data):
            
            self.data = data
            self.next = None
            self.prev = None
```

this functionality can only be accessed through an insert method shown below.


## Insert at Head
the code below enitiates a new node and inserts it at the head. It starts by checking if the linked list is empty. If it is, then the new node is written as both the head and tail of the list.

```python
def insert_head(self, value):
        
        new_node = LinkedList.Node(value)  
        
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        
        else:
            new_node.next = self.head
            self.head.prev = new_node
            self.head = new_node
    
    # Time complexity: O(1)
```

To utilize the above code, call the method through the instance of the LinkedList class. Make sure to pass data to the parameter.


```python
newInstance.insert_head(value)
```

## Insert at End

very similar to the code above, The code below enitiates a new node and inserts it at the tail. 

```python
def insert_tail(self, value):
        
        new_node = LinkedList.Node(value)

        if self.head is None:
            self.head = new_node
            self.tail = new_node


        else:
            new_node.prev = self.tail
            self.tail.next = new_node
            self.tail = new_node
    # Time complexity: O(1)
```

To utilize the above code, call the method through the instance of the LinkedList class. Make sure to pass data to the parameter.


```python
newInstance.insert_tail(value)
```

## Removing a node from the list
The code below removes the head node of the linked list. If there is only one item in the list, it sets the head and the tail to None. Otherwise, it removes the first node and sets the second as the head.

```python
def remove_head(self):
        
        if self.head == self.tail:
            self.head = None
            self.tail = None
        
        elif self.head is not None:
            self.head.next.prev = None  
            self.head = self.head.next

    # Time complexity: O(1)
```

The code below removes the tail of the linked list.

```python
def remove_tail(self):
        
        self.tail.prev.next = None
        self.tail = self.tail.prev
    # Time complexity: O(1)
```


To utilize the above functions, call the method through the instance of the LinkedList class.


```python
newInstance.remove_head()
newInstance.remove_tail()
```

To remove a node that is neither on the head or the tail of the linked list, you need to reassign the pointers of both the Prev and the Next of the target node to point to eachother. The solution code won't be displayed here because it will be relevant for the coding challenge at the end of this tutorial. 

## Iterating through a linked list

The code below iterates through the linked list. It uses current to look at each node and store the data in a list. It uses the pointers to move to the next node. the first function moves backwards. The second function moves forwards.

```python
def reverse(self):
        
        list1 = []
        current = self.tail
        while current != None:
            list1.append(current.data)
            current = current.prev
        return list1
    # Time complexity: O(n)

def forward(self):
        list1 = []
        current = self.head
        while current != None:
            list1.append(current.data)
            current = current.next
        return list1
    # Time complexity: O(n)
```

To utilize the above functions, call the method through the instance of the LinkedList class.


```python
newInstance.reverse()
newInstance.forward()
```


## Example Problem

The code below simulates a user adding a song to a playlist. It starts by iterating through the linked list to ensure that the song has not already been added. If the song already exists in the playlist, it does not add it. Otherwise, it inserts at the tail to ensure that the most recently added song is at the end of the list.

```python

def addSong(self, song):
        qualified = True
        current = self.head
        while current != None:
            if current.data == song:
                qualified = False
                break
        
            current = current.next

        if qualified:
            playList.insert_tail(song)
    
    # Time complexity: O(n)

```

## Coding Challenge

The addSong function effectively adds a new song to the playlist, however, if a user tries to add a song that already exists, it just ignores the command. It might help the user if the song was re added to the tail of the linked list, instead of just remaining in its current position.
Your challenge is to modify the addSong function so that if a song is added that already exists in the playlist, the node that contains the target song will be removed from the linked list, and a new node containing the song will be added to the tail of the linked list. The code below is just the above functions set together in a usable way. You can use it to complete your assignment.
To see a solution to this challenge, [click here](linkedListPractice.py)
```python
class LinkedList:
        
    def __init__(self):
        
        self.head = None
        self.tail = None

    class Node:
        
        def __init__(self, data):
            
            self.data = data
            self.next = None
            self.prev = None

    def insert_head(self, value):
        
        new_node = LinkedList.Node(value)  
        
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        
        else:
            new_node.next = self.head
            self.head.prev = new_node
            self.head = new_node

    def insert_tail(self, value):
        
        new_node = LinkedList.Node(value)

        if self.head is None:
            self.head = new_node
            self.tail = new_node


        else:
            new_node.prev = self.tail
            self.tail.next = new_node
            self.tail = new_node

    def remove_head(self):
        
        if self.head == self.tail:
            self.head = None
            self.tail = None
        
        elif self.head is not None:
            self.head.next.prev = None  
            self.head = self.head.next

    def remove_tail(self):
        
        self.tail.prev.next = None
        self.tail = self.tail.prev

    def forward(self):
        list1 = []
        current = self.head
        while current != None:
            list1.append(current.data)
            current = current.next
        return list1

    def __reversed__(self):
        
        list1 = []
        current = self.tail
        while current != None:
            list1.append(current.data)
            current = current.prev
        return list1
    
    # Start of your coding challenge
    def addSong(self, song):
        # Modify this function to put re added songs at the tail of the linked list.
        qualified = True
        current = self.head
        while current != None:
            if current.data == song:
                qualified = False
                break
        
            current = current.next

        if qualified:
            playList.insert_tail(song)
    # End of your coding challenge
    
playList = LinkedList()

songs = ["Take On Me", "Sweet Home Alabama", "What Does the Fox Say?", "Heyah", "I'm Blue", "Bad Romance", "Shake It Off", "Moskau"]

for song in songs:
    playList.addSong(song)

print(playList.forward())

```