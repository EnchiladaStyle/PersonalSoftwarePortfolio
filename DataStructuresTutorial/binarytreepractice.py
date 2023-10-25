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

    # This is an example solution for the practice problem.

    def MostAndLeast(self):
        self.findLeastRated(self.root)
        self.findMostRated(self.root)

    def findLeastRated(self, song):
        
        if song.left == None:
            print(f"The lowest rated song is {song.name}")

        else:
            self.findLeastRated(song.left)

    def findMostRated(self,song):

        if song.right == None:
            print(f"the highest rated song is {song.name}")

        else:
            self.findMostRated(song.right)

    # This is the end of an example solution of the practice problem.
    


        
myPlaylist = PlayList()

myPlaylist.insert("Take On Me", 5)
myPlaylist.insert("Sweet Home Alabama", 3)
myPlaylist.insert("What Does the Fox Say?", 7)
myPlaylist.insert("Heyah", 2)
myPlaylist.insert("I'm Blue", 6)
myPlaylist.insert("Bad Romance", 4)
myPlaylist.insert("Shake it Off", 8)
myPlaylist.insert("Moskau", 1)

myPlaylist.MostAndLeast()
