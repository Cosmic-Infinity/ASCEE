# ASCEE

Ah yes, ASCII, the great grandfather of Unicode, the first chapter of any computer book, the source of so many security vulnerabilities (well, unicode is to blame, but who's reading this anyways), and a way of creating sick art? Yes, <a href="https://wikipedia.org/wiki/ASCII_art" target="blank">ASCII Art is a thing</a>. And long before images on computers, ascii art was all you could get, all 7 bits of it.


Creating ASCII Art is hard. And let's face it, hardly anyone is creating them by hand these days _(No offense to the one 0.01%)_. So here's simple _"tool"_ to do just that.
### _Say hello to ASCEE._


<br/>

## **Why?**

Just because I can goddamnit. I was bored, okay? It was a slow Friday afternoon. Had this idea to turn images into ASCII art, so I did it. Now I'm not ashamed to admit that I may have had some help from stackexchange, but that's besides the point. 😘

It was cleaned up and rewritten over the weekend and I may or may not be be writing this _introduction_ a week from then, so don't mind the messy code, I tried my best. Cut me some slack.


<br/>

## **How do I boogie?**

1. Just `download/copy` over the code over to a new `.java` file and run it.
2. Make sure you have an image file on the `Desktop` named `image` or else you'll get this lovely error. (Supported format : `.jpg` , `.jpeg` , `.png` , `.gif` (animation data is ignored))

<p align="center">
<img width="383" alt="Screenshot 2022-06-19 150752" src="https://user-images.githubusercontent.com/64971616/174474841-5b9b1478-2a4e-4d2e-8bd8-b8b560b5e8f1.png">
</p>

3. Once the processing is done, you'll see a new file on you desktop named `ascii.txt` which will contain your result.


NOTE : Based on image size, compression parameter, you PC's general performance, processing may take time. Processing is finished when `Ready` is displayed on the terminal. Do not be alarmed if it's taking time. Although if you're not playing around with the parameters too drastically, it's unlikely you'll have to wait.

<br/>
<img align = "left" width="208" alt="Screenshot 2022-06-19 154634" src="https://user-images.githubusercontent.com/64971616/174476287-fd24ab02-5c4b-413e-9310-3a2678d36dc7.png">
<br/>

<img align = "right" width="206" alt="Screenshot 2022-06-19 154800" src="https://user-images.githubusercontent.com/64971616/174476338-029e8930-2803-4a91-ada1-5dc3cb989dcf.png">
<br/>

<br clear="left">
<p aligh="left">
 <br/>
Not finished. Still Processing
</p>


<br clear="right"/>
<p align="right">
Finished. Done Processing.
</p>


## **How do I boogie some more?**


What? You want more? Alright alright. See those variables in the code? Not all of them are meant to be touched. **DO NOT TOUCH THEM ALL**. Though you may touch these<p align="center">

  
⦿ `boolean inversion` : flag used to invert the colour space. Set it `ture` and the black and white will invert.
  
⦿ `int compressionfactor` : Determines how much smaller the ascii art should be. Higher the numbe = more the compression = smaller the ascii art. Images have a lot of pixels, all of them can't be used for character based art. Therefore I also don't recommend setting this number to 1. Trust me, you don't wanna wait for 90 seconds to get your image out. (Range : 1 to 10, maybe? it's not hardcoded, so go nuts)
  
⦿ `byte mode` : This generator comes with 2 modes. `high` and `low` bit depth, determined by `1 or 2`. Based on your preference or the image, one might give more pleasing result than the other.

⦿ It is not recommended to play around with working variables or lookup constants unless you know exactly what you're doing.
  
⦿ Non-exposed variable can be tweaked if you're feeling adventurous. `int scaledownConstant` scales down every image by a particular amount before the main scaling process runs. Too small a number can lead thigher processing time. But you do you.



