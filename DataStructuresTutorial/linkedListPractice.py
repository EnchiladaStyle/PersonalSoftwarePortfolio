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
    
    def addSong(self, song):
        
        current = self.head
        while current != None:
            if current.data == song:
                

                if current.prev != None:
                    current.prev.next = current.next
                else:
                    self.head = current.next
                    break
                if current.next != None:
                    current.next.prev = current.prev
                break
        
            current = current.next

        
        playList.insert_tail(song)
    
playList = LinkedList()

songs = ["Take On Me", "Sweet Home Alabama", "What Does the Fox Say?", "Heyah", "I'm Blue", "Bad Romance", "Shake It Off", "Moskau"]

for song in songs:
    playList.addSong(song)

playList.addSong("Take On Me")
playList.addSong("I'm Blue")
print(playList.forward())

