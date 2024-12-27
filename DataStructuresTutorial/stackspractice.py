


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