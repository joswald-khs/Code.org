# Painter Class 
_Adapted from Code.org Unit1, but using Processing and BlueJ_

The `Painter` class provides three methods:

* `move` which moves the painter in the direction it is facing
* `paint` which places paint down on the grid in the current location
* `turnLeft` which rotates the painter left

To get this to work:

1. Compile the BlueJ project
2. Right click `GridCanvas` and select `void main(String args[])`. You should now be able to find a running program
3. Right click `GridCanvas` again and select `GridCanvas getCanvas()`. You accept the defaults and then dismiss the window when the GridCanvas object appears in the object bench
4. Right click `Painter` and select `new Painter()`
5. Right click the `GridCanvas` **object** in the object bench and select `addPainterToCanvas...` the click on your `Painter` **object** in the object bench 
6. You should now see the painter object in the GridCanvas and be able to manipulate it through the object bench.  

> [!IMPORTANT]
> If you pick `drawL` or `paintSpiral` or anything with a required `Color` object, you can simply type `new Color(0,128,128)` (for teal) or use whatever RGB values you like
