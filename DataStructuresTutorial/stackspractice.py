import random

#playList represents an actual playlist in a program like spotify or apple music
#listened is an empty list that will be used as a stack to keep track of which songs have been played
playList = ["Take On Me", "Sweet Home Alabama", "What Does the Fox Say?", "Heyah", "I'm Blue", "Bad Romance", "Shake It Off", "Moskau"]
listened = []
listened2 = []

def listen():
    #this function mimics a music app playing a random song from the playlist
    if len(listened2) == 0:
        play(random.choice(playList))
    else:
        play(listened2.pop())

def play(song, repeat=False):
    #this function displays which song is being played
    #it also records the current song into a stack if the song is not being replayed
    
    
    
    
    print(f"playing: {song}")
    
    if not repeat:
        listened.append(song)

def listenToPreviousSong():
    prev = listened.pop()
    play(prev, True)
    listened2.append(prev)

listen()
listen()
listen()
listen()
listen()

print("done")
listenToPreviousSong()
listenToPreviousSong()
listenToPreviousSong()
listenToPreviousSong()
listenToPreviousSong()
print("done")
listen()
listen()
listen()