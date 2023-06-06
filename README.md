# ASCEE

Ah yes, ASCII, the great grandfather of Unicode, the first chapter of any computer book, the source of so many security vulnerabilities (unicode is to blame, but who's reading this anyways), and a way of creating sick art? Yes, <a href="https://wikipedia.org/wiki/ASCII_art" target="blank">ASCII Art is a thing</a>. And long before images on computers, ascii art was all you could get, all 7 bits of it.


Creating ASCII Art is hard. And let's face it, hardly anyone is creating them by hand these days _(No offense to the one 0.01%)_. So here's simple _"tool"_ to do just that.
### _Say hello to ASCEE._


<br/>

## **Why?**

Just because I can. It was a slow Friday afternoon, and I was bored. Had this idea to turn images into ASCII art, so here it is. Now I'm not ashamed to admit that I may have had some help from stackexchange, but that's besides the point. 😘

It was cleaned up and rewritten over the weekend and I may or may not be be writing this _introduction_ a week from then, so don't mind the messy code, I tried my best. Cut me some slack.


<br/>

## **How do I boogie?**



1. Just `download/copy` the code over to a new `.java` file and run it.
2. Make sure you have an image file on the `Desktop` named `image` or else you'll get this lovely error. (Supported format : `.jpg` , `.jpeg` , `.png` , `.gif` (animation data is ignored))

<p align="center">
<img width="383" alt="Sample Error" src="https://user-images.githubusercontent.com/64971616/174474841-5b9b1478-2a4e-4d2e-8bd8-b8b560b5e8f1.png">
</p>

3. Once the processing is done, you'll see a new file on you desktop named `ascii.txt` which will contain your result.



<br/>

## For your own sanity.

**Windows Notepad has difficulty recognising character encoding at times**. Or maybe windows just hates my program implementation in particular. If your ascii art output looks like complete gibbrish, try using <a href="https://notepad-plus-plus.org/downloads/" target="blank">Notepad++</a>. Oh and also, remember to zoom out on the text `Ctrl + mouse scroll`





<p align="center">
<img width="295" alt="Erroneous Processing" src="https://user-images.githubusercontent.com/64971616/174497531-08e956a4-bed0-406f-a209-068ac2267f00.png">
</br clear="left">I did not type that
</p>

<br/>
Based on image size, compression parameter, and  your PC's general performance, processing may take time. Processing is finished when **READY** is displayed on the terminal. Do not be alarmed if it's taking time. Although if you're not playing around with the parameters too drastically, it's unlikely you'll have to wait.


<br/>


<table align="center" border=0>
<tr>
<th><img align = "center" width="208" alt="Processing" src="https://user-images.githubusercontent.com/64971616/174476287-fd24ab02-5c4b-413e-9310-3a2678d36dc7.png">
  </br clear="left">Sill Processing.</th>
<th><img align = "center" width="206" alt="Ready" src="https://user-images.githubusercontent.com/64971616/174476338-029e8930-2803-4a91-ada1-5dc3cb989dcf.png">
  </br clear="left">Finished processing.</th>
</tr>
</table>
<br/>

Talking about processing, you'll noice that the program isn't multithread. That's because I do not know multithreading. LOL. So don't be alarmed if you see things like this <3
<p align="center">
<img width="490" alt="Brrrrrrr" src="https://user-images.githubusercontent.com/64971616/206483092-0b544314-1470-41f0-aeb8-1444e698a068.png">
</br clear="left">Thread 2 go BRRRRRRRRR
</p>

## **Samples**

<table align="center" border=0>
<tr>
<th><img align = "center" width="325" alt="Input" src="https://user-images.githubusercontent.com/64971616/206462921-641f9d32-3185-4f27-935c-2aee1681514c.png">
</br clear="left">Input Image</th>
<th><img align = "center" width="325" alt="Input" src="https://user-images.githubusercontent.com/64971616/206469561-03db75ad-2012-4103-8673-29ab0e53be39.png">
</br clear="left">Scaled and Decoloured</th>
<th><img width="325" alt="Output" src="https://user-images.githubusercontent.com/64971616/206462363-792d45df-9e02-4336-a549-46ed730b0c34.png">
</br clear="left">ASCII Output</th>
</tr>

<tr>
<th><img  width="336" align = "center" alt="Input" src="https://user-images.githubusercontent.com/64971616/206464053-b2df1755-639c-4c0b-b4ec-490f291c62e0.png">
</br clear="left">Input Image</th>
<th><img width="336" alt="Output Normal" src="https://user-images.githubusercontent.com/64971616/206464602-2186a0b1-905e-406c-84cb-52673b115013.png">
</br clear="left">ASCII Output</th>
<th><img width="336" alt="Output Inverted" src="https://user-images.githubusercontent.com/64971616/206465009-d59fd490-7693-43ff-9d28-ea05f676ab7e.png">
</br clear="left">ASCII Output Inverted</th>
</tr>

<tr>
<th><img width="358" align = "center" alt="Input" src="https://user-images.githubusercontent.com/64971616/206466434-7fbc1aa6-aa6e-41ab-987b-112e993de5ce.jpg">
</br clear="left">Input Image</th>
<th><img width="358" alt="Output High" src="https://user-images.githubusercontent.com/64971616/206466758-ee60af38-627d-40b4-8b0e-6606f6a7c4d5.png">
</br clear="left">ASCII High Bit-Depth</th>
<th><img width="358" alt="Output Low" src="https://user-images.githubusercontent.com/64971616/206467165-498f6425-e800-4c16-a490-797a8a9d6659.png">
</br clear="left">ASCII Low Bit-Depth</th>
</tr>

</table>

_Size_, _Scale_, _Amount of Detail_, everything can be controlled by modifying the in-built variables.

</br>

## **How do I boogie some more?**


What? You want more? Alright alright. See those variables in the code? Not all of them are meant to be touched. **DO NOT TOUCH THEM ALL**. Though you may touch these



⦿ `boolean inversion` : flag used to invert the colour space. Set it `ture` and the black and white will invert.
  
⦿ `int compressionfactor` : Determines how much smaller the ascii art should be. Higher the numbe = more the compression = smaller the ascii art. Images have a lot of pixels, all of them can't be used for character based art. Therefore I also don't recommend setting this number to 1. Trust me, you don't wanna wait for 90 seconds to get your image out. (Range : 1 to 10, maybe? it's not hardcoded, so go nuts)
  
⦿ `byte mode` : This generator comes with 2 modes. `high` and `low` bit depth, determined by `1 or 2`. Based on your preference or the image, one might give more pleasing result than the other.

⦿ It is not recommended to play around with working variables or lookup constants unless you know exactly what you're doing.
  
⦿ Non-exposed variable can be tweaked if you're feeling adventurous. `int scaledownConstant` scales down every image by a particular amount before the main scaling process runs. Too small a number can lead higher processing time. But you do you.



