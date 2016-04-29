/**
 * Jordan Marx
 * 
 * Class for duplicating an image 6 times(3 by 2).
 * Each duplicate contains its own unique polarization.
 */

import java.awt.Color;

public class DuplicateAndPolarize
{
  
  public static void main (String[] args) 
  {

    // Select a picture from the computer
    String filename1;
    filename1 = FileChooser.pickAFile ();
    System.out.println (filename1);

    // Create the picture
    Picture pic1 = new Picture (filename1);
    
    // Call a method to duplicate the image
    Picture pic2;
    pic2 = duplicateImage(pic1);
    
    // Call a method to posterize the images
    posterizePicture(pic2);
    
    // Show the picture
    pic2.show();
    
    // Save the picture
    String filename2;
    filename2 = FileChooser.pickAFile ();
    pic2.write (filename2);

  }
  
  
// Method for duplicating image 3 x 2
public static Picture duplicateImage (Picture p)
  {
    Picture result = new Picture (  p.getWidth() * 3, p.getHeight() * 2  );
    
    int x;
    int y;
    int xMod1;
    int yMod1;
    Color c1;
    Pixel pix1, pixR;
    
    // Access all the pixels of the image
    for ( x = 0 ; x < p.getWidth()  ; ++x )
    {    
      for ( y = 0 ; y < p.getHeight()   ; ++y )
      {
        // Access the pixel at position (x,y)
        pix1 = p.getPixel (x, y);
        
        // Access the color value at that pixel
        c1 = pix1.getColor();
       
        /* Image Row 0 Col 0 */
        xMod1 = x + 0 * p.getWidth();
        yMod1 = y + 0 * p.getHeight();
        
        // Access the pixel at the modified position
        pixR = result.getPixel (xMod1, yMod1);
        
        // Store the color value in this second pixel
        pixR.setColor(c1);
 
        /* Image Row 1 Col 0  */
        xMod1 = x + 0 * p.getWidth();
        yMod1 = y + 1 * p.getHeight();
        
        // Access the pixel at the modified position
        pixR = result.getPixel (xMod1, yMod1);
        
        // Store the color value in this second pixel
        pixR.setColor(c1);
        
        /* Image Row 0 Col 1 */
        xMod1 = x + 1 * p.getWidth();
        yMod1 = y + 0 * p.getHeight();
        
        // Access the pixel at the modified position
        pixR = result.getPixel (xMod1, yMod1);
        
        // Store the color value in this second pixel
        pixR.setColor(c1);
 
        /* Image Row 1 Col 1 */
        xMod1 = x + 1 * p.getWidth();
        yMod1 = y + 1 * p.getHeight();
        
        // Access the pixel at the modified position
        pixR = result.getPixel (xMod1, yMod1);
        
        // Store the color value in this second pixel
        pixR.setColor(c1);
         
        /* Image Row 0 Col 2 */
        xMod1 = x + 2 * p.getWidth();
        yMod1 = y + 0 * p.getHeight();
        
        // Access the pixel at the modified position
        pixR = result.getPixel (xMod1, yMod1);
        
        // Store the color value in this second pixel
        pixR.setColor(c1);
        
        /* Image Row 1 Col 2 */
        xMod1 = x + 2 * p.getWidth();
        yMod1 = y + 1 * p.getHeight();
        
        // Access the pixel at the modified position
        pixR = result.getPixel (xMod1, yMod1);
        
        // Store the color value in this second pixel
        pixR.setColor(c1);
        
      }
    }
    return result;
  }
 


// Method for 6 unique posterizations
public static void posterizePicture (Picture p)
  {
    int x;
    int y;
    int width1, width2, width3;
    int height1, height2;
    int red, green, blue;
    int grayAmount;
    Pixel pix;
    
    // The duplicated images width and height length
    width1 = (p.getWidth()/3);
    width2 = (p.getWidth()/3) * 2;
    width3 = (p.getWidth());
    height1 = (p.getHeight()/2);
    height2 = (p.getHeight());
    
    
    // Posterize top left image
    for ( x = 0 ; x < width1 ; ++x )
    {
      for ( y = 0 ; y < height1 ; ++y )
      {
        // Access the pixel at position (x,y)
        pix = p.getPixel (x, y);
        
        // Access the color values at that pixel
        red = pix.getRed();
        green = pix.getGreen();
        blue = pix.getBlue();
        
        // Determine the grayAmount from the color at the pixel
        grayAmount  = (int)((red * 0.299)   + 
                            (green * 0.587) + 
                            (blue * 0.114));
        
        // Determine the final color value of the pixel
        if ( grayAmount < 43 )
        {
          // Set the pixel to Midnight blue
          pix.setRed(25);
          pix.setGreen(25);
          pix.setBlue(112);
        }
        else if ( grayAmount < 85 )
        {
          // Set the pixel to Dark Slate Blue
          pix.setRed(72);
          pix.setGreen(61);
          pix.setBlue(139);
        }
        else  if ( grayAmount < 128 )
        {
          // Set the pixel to Royal Blue
          pix.setRed(65);
          pix.setGreen(105);
          pix.setBlue(225);
        }
        else  if ( grayAmount < 171 )
        {
          // Set the pixel to Deep Sky Blue
          pix.setRed(0);
          pix.setGreen(191);
          pix.setBlue(255);
        }
        else  if ( grayAmount < 213 )
        {
          // Set the pixel to Pale Torquoise
          pix.setRed(175);
          pix.setGreen(238);
          pix.setBlue(238);
        }
        else
        {
          // Set the pixel to Light Cyan
          pix.setRed(224);
          pix.setGreen(255);
          pix.setBlue(255);
        }
      }
    }
    
    
    // Posterize bottom left image
    for ( x = 0 ; x < width1 ; ++x )
    {
      for ( y = height1 ; y < height2 ; ++y )
      {
        // Access the pixel at position (x,y)
        pix = p.getPixel (x, y);
        
        // Access the color values at that pixel
        red = pix.getRed();
        green = pix.getGreen();
        blue = pix.getBlue();
        
        // Determine the grayAmount from the color at the pixel
        grayAmount  = (int)((red * 0.299)   + 
                            (green * 0.587) + 
                            (blue * 0.114));
        
        // Determine the final color value of the pixel
        if ( grayAmount < 45 )
        {
          // Set the pixel to Indian Red
          pix.setRed(205);
          pix.setGreen(92);
          pix.setBlue(92);
        }
        else if ( grayAmount < 120 )
        {
          // Set the pixel to Chocolate
          pix.setRed(210);
          pix.setGreen(105);
          pix.setBlue(30);
        }
        else  if ( grayAmount < 200 )
        {
          // Set the pixel to Burlywood
          pix.setRed(222);
          pix.setGreen(184);
          pix.setBlue(135);
        }
        else
        {
          // Set the pixel to Gold
          pix.setRed(255);
          pix.setGreen(215);
          pix.setBlue(0);
        }
      }
    }
    
    
    // Posterize top middle image
    for ( x = width1 ; x < width2 ; ++x )
    {
      for ( y = 0 ; y < height1 ; ++y )
      {
        // Access the pixel at position (x,y)
        pix = p.getPixel (x, y);
        
        // Access the color values at that pixel
        red = pix.getRed();
        green = pix.getGreen();
        blue = pix.getBlue();
        
        // Determine the grayAmount from the color at the pixel
        grayAmount  = (int)((red * 0.299)   + 
                            (green * 0.587) + 
                            (blue * 0.114));
        
        // Determine the final color value of the pixel
        if ( grayAmount < 85 )
        {
          // Set the pixel to Spring Green
          pix.setRed(0);
          pix.setGreen(255);
          pix.setBlue(127);
        }
        else  if ( grayAmount < 120 )
        {
          // Set the pixel to Chartreuse
          pix.setRed(127);
          pix.setGreen(255);
          pix.setBlue(0);
        }
        else  if ( grayAmount < 179 )
        {
          // Set the pixel to Olive Drab
          pix.setRed(107);
          pix.setGreen(142);
          pix.setBlue(35);
        }
        else
        {
          // Set the pixel to Dark Orchid
          pix.setRed(153);
          pix.setGreen(50);
          pix.setBlue(204);
        }
      }
    }
    
    
    // Posterize bottom middle image
    for ( x = width1 ; x < width2 ; ++x )
    {
      for ( y = height1 ; y < height2 ; ++y )
      {
        // Access the pixel at position (x,y)
        pix = p.getPixel (x, y);
        
        // Access the color values at that pixel
        red = pix.getRed();
        green = pix.getGreen();
        blue = pix.getBlue();
        
        // Determine the grayAmount from the color at the pixel
        grayAmount  = (int)((red * 0.299)   + 
                            (green * 0.587) + 
                            (blue * 0.114));
        
        // Determine the final color value of the pixel
        if ( grayAmount < 43 )
        {
          // Set the pixel to Red
          pix.setRed(255);
          pix.setGreen(0);
          pix.setBlue(0);
        }
        else if ( grayAmount < 90 )
        {
          // Set the pixel to Saddle Brown
          pix.setRed(139);
          pix.setGreen(69);
          pix.setBlue(19);
        }
        else  if ( grayAmount < 165 )
        {
          // Set the pixel to Dark Orange
          pix.setRed(255);
          pix.setGreen(140);
          pix.setBlue(0);
        }
        else  if ( grayAmount < 205 )
        {
          // Set the pixel to Firebrick
          pix.setRed(178);
          pix.setGreen(34);
          pix.setBlue(34);
        }
        else
        {
          // Set the pixel to Forest Green
          pix.setRed(34);
          pix.setGreen(139);
          pix.setBlue(34);
        }
      }
    }
    
    
    // Posterize top right image
    for ( x = width2 ; x < width3 ; ++x )
    {
      for ( y = 0 ; y < height1 ; ++y )
      {
        // Access the pixel at position (x,y)
        pix = p.getPixel (x, y);
        
        // Access the color values at that pixel
        red = pix.getRed();
        green = pix.getGreen();
        blue = pix.getBlue();
        
        // Determine the grayAmount from the color at the pixel
        grayAmount  = (int)((red * 0.299)   + 
                            (green * 0.587) + 
                            (blue * 0.114));
        
        // Determine the final color value of the pixel
        if ( grayAmount < 41 )
        {
          // Set the pixel to Black
          pix.setRed(0);
          pix.setGreen(0);
          pix.setBlue(0);
        }
        else if ( grayAmount < 85 )
        {
          // Set the pixel to Sienna
          pix.setRed(160);
          pix.setGreen(82);
          pix.setBlue(45);
        }
        else  if ( grayAmount < 140 )
        {
          // Set the pixel to Sandy Brown
          pix.setRed(244);
          pix.setGreen(164);
          pix.setBlue(96);
        }
        else  if ( grayAmount < 185 )
        {
          // Set the pixel to Tan
          pix.setRed(210);
          pix.setGreen(180);
          pix.setBlue(140);
        }
        else  if ( grayAmount < 230 )
        {
          // Set the pixel to Dark Khaki
          pix.setRed(189);
          pix.setGreen(183);
          pix.setBlue(107);
        }
        else
        {
          // Set the pixel to Saddle Brown
          pix.setRed(139);
          pix.setGreen(69);
          pix.setBlue(19);
        }
      }
    }
      
    
    // Posterize bottom right image
    for ( x = width2 ; x < width3 ; ++x )
    {
      for ( y = height1 ; y < height2 ; ++y )
      {
        // Access the pixel at position (x,y)
        pix = p.getPixel (x, y);
        
        // Access the color values at that pixel
        red = pix.getRed();
        green = pix.getGreen();
        blue = pix.getBlue();
        
        // Determine the grayAmount from the color at the pixel
        grayAmount  = (int)((red * 0.299)   + 
                            (green * 0.587) + 
                            (blue * 0.114));
        
        // Determine the final color value of the pixel
        if ( grayAmount < 43 )
        {
          // Set the pixel to White
          pix.setRed(255);
          pix.setGreen(255);
          pix.setBlue(255);
        }
        else  if ( grayAmount < 171 )
        {
          // Set the pixel to Black
          pix.setRed(0);
          pix.setGreen(0);
          pix.setBlue(0);
        }
        else  if ( grayAmount < 215 )
        {
          // Set the pixel to White
          pix.setRed(255);
          pix.setGreen(255);
          pix.setBlue(255);
        }
        else
        {
          // Set the pixel to Dark Goldenrod
          pix.setRed(184);
          pix.setGreen(134);
          pix.setBlue(11);
        }
      }
    } 
  }
 
 
}