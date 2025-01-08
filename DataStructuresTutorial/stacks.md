



```
the above code adds "1" to the end of the list

## Remove From Stack
to remove from a stack in python, we remove the end using the pop function.

```python
stackList = [1]
stackList.pop()
# Time complexity: O(1)
```
the above code removes "1" from the list.


## Example Problem

The program below uses a stack to keep track of songs played from a playlist and allow replay functionality.

```python
#playList represents an actual playlist in a program like spotify or apple music
#listened is an empty list that will be used as a stack to keep track of which songs have been played
playList = ["Take On Me", "Sweet Home Alabama", "What Does the Fox Say?", "Heyah", "I'm Blue", "Bad Romance", "Shake It Off", "Moskau"]
listened = []

def listen():
    #this function mimics a music app playing a random song from the playlist
    play(random.choice(playList))

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