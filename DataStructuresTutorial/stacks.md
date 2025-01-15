
def play(song, repeat=False):
    #this function displays which song is being played
    #it also records the current song into a stack if the song is not being replayed
    print(f"playing: {song}")
    
    if not repeat:
        listened.append(song)

def listenToPreviousSong():
    prev = listened.pop()
    play(prev, True)
    # Time complexity: O(1)
```

you can try running this code if you would like. To simulate listening to a song, use the function listen(). To simulate replaying a song, use the function listenToPreviousSong(). no parameters are needed for either function.

## Coding Challenge

the code above effectively replays songs, but each time it goes back to a previous song, it forgets everything that came after. 

Your challenge is to update the program with a second stack, that keeps track of the song played before we went back. 

Then update the program to only provide a random song if the there is not a predetermined song in the new stack.

To view a solution to this challenge, [click here](stackspractice.py)