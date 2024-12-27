



    
    
    
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