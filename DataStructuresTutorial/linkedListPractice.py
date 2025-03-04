
playList = LinkedList()

songs = ["Take On Me", "Sweet Home Alabama", "What Does the Fox Say?", "Heyah", "I'm Blue", "Bad Romance", "Shake It Off", "Moskau"]

for song in songs:
    playList.addSong(song)

playList.addSong("Take On Me")
playList.addSong("I'm Blue")
print(playList.forward())

