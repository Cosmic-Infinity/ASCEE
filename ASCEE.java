
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.nio.file.Files;
import java.nio.file.Path;

public class ASCEE {
    //user exposed variables
    private static boolean inversion = false; //inverts the black and white colour space.
    private static float compressionfactor = 4f; // higher the number, smaller the ascii art.
    private static byte mode = 2; // 1 = high bit depth mode. 2 = low bit depth mode

    //lookup constants
    private static final char strLOW[] = {'@','%','#','*','+','=','-',':','.',' '};
    //private static final char str[] = {'$','@','B','%','8','&','W','M','#','*','o','a','h','b','d','p','q','w','m','Z','O','0','L','C','J','U','Y','X','z','c','v','u','n','x','r','j','f','t','/',(char)92,'(',')','1','{','}','[',']','?','-','+','~','<','>','i','!','l',';',':',',','"','^',(char)39,'.',' '};

    private static final char str[] = {'$' ,'$' ,'$' ,'$' ,'@' ,'@' ,'@' ,'@' ,'B' ,'B' ,'B' ,'B' ,'%' ,'%' ,'%' ,'%' ,'8' ,'8' ,'8' ,'8' ,'&' ,'&' ,'&' ,'&' ,'W' ,'W' ,'W' ,'W' ,'M' ,'M' ,'M' ,'M' ,'#' ,'#' ,'#' ,'#' ,'*' ,'*' ,'*' ,'*' ,'o' ,'o' ,'o' ,'o' ,'a' ,'a' ,'a' ,'a' ,'h' ,'h' ,'h' ,'h' ,'b' ,'b' ,'b' ,'b' ,'d' ,'d' ,'d' ,'d' ,'p' ,'p' ,'p' ,'p' ,'q' ,'q' ,'q' ,'q' ,'w' ,'w' ,'w' ,'w' ,'m' ,'m' ,'m' ,'m' ,'Z' ,'Z' ,'Z' ,'Z' ,'O' ,'O' ,'O' ,'O' ,'0' ,'0' ,'0' ,'0' ,'L' ,'L' ,'L' ,'L' ,'C' ,'C' ,'C' ,'C' ,'J' ,'J' ,'J' ,'J' ,'U' ,'U' ,'U' ,'U' ,'Y' ,'Y' ,'Y' ,'Y' ,'X' ,'X' ,'X' ,'X' ,'z' ,'z' ,'z' ,'z' ,'c' ,'c' ,'c' ,'c' ,'v' ,'v' ,'v' ,'v' ,'u' ,'u' ,'u' ,'u' ,'n' ,'n' ,'n' ,'n' ,'x' ,'x' ,'x' ,'x' ,'r' ,'r' ,'r' ,'r' ,'j' ,'j' ,'j' ,'j' ,'f' ,'f' ,'f' ,'f' ,'t' ,'t' ,'t' ,'t' ,'/' ,'/' ,'/' ,'/' ,(char)92 ,(char)92,(char)92,(char)92 ,'(' ,'(' ,'(' ,'(' ,')' ,')' ,')' ,')' ,'1' ,'1' ,'1' ,'1' ,'{' ,'{' ,'{' ,'{' ,'}' ,'}' ,'}' ,'}' ,'[' ,'[' ,'[' ,'[' ,']' ,']' ,']' ,']' ,'?' ,'?' ,'?' ,'?' ,'-' ,'-' ,'-' ,'-' ,'+' ,'+' ,'+' ,'+' ,'~' ,'~' ,'~' ,'~' ,'<' ,'<' ,'<' ,'<' ,'>' ,'>' ,'>' ,'>' ,'i' ,'i' ,'i' ,'i' ,'!' ,'!' ,'!' ,'!' ,'l' ,'l' ,'l' ,'l' ,';' ,';' ,';' ,';' ,':' ,':' ,':' ,':' ,',' ,',' ,',' ,',' ,'"' ,'"' ,'"' ,'"' ,'^' ,'^' ,'^' ,'^' ,(char)39 ,(char)39 ,(char)39 ,(char)39 ,'.' ,'.' ,'.' ,'.' ,' ' ,' ' ,' ' ,' '};
    private static final char strinv[] = {' ' ,' ' ,' ' ,' ' ,'.' ,'.' ,'.' ,'.' ,(char)39 ,(char)39 ,(char)39 ,(char)39 ,'^' ,'^' ,'^' ,'^' ,'"' ,'"' ,'"' ,'"' ,',' ,',' ,',' ,',' ,':' ,':' ,':' ,':' ,';' ,';' ,';' ,';' ,'l' ,'l' ,'l' ,'l' ,'!' ,'!' ,'!' ,'!' ,'i' ,'i' ,'i' ,'i' ,'>' ,'>' ,'>' ,'>' ,'<' ,'<' ,'<' ,'<' ,'~' ,'~' ,'~' ,'~' ,'+' ,'+' ,'+' ,'+' ,'-' ,'-' ,'-' ,'-' ,'?' ,'?' ,'?' ,'?' ,']' ,']' ,']' ,']' ,'[' ,'[' ,'[' ,'[' ,'}' ,'}' ,'}' ,'}' ,'{' ,'{' ,'{' ,'{' ,'1' ,'1' ,'1' ,'1' ,')' ,')' ,')' ,')' ,'(' ,'(' ,'(' ,'(' ,(char)92 ,(char)92 ,(char)92 ,(char)92 ,'/' ,'/' ,'/' ,'/' ,'t' ,'t' ,'t' ,'t' ,'f' ,'f' ,'f' ,'f' ,'j' ,'j' ,'j' ,'j' ,'r' ,'r' ,'r' ,'r' ,'x' ,'x' ,'x' ,'x' ,'n' ,'n' ,'n' ,'n' ,'u' ,'u' ,'u' ,'u' ,'v' ,'v' ,'v' ,'v' ,'c' ,'c' ,'c' ,'c' ,'z' ,'z' ,'z' ,'z' ,'X' ,'X' ,'X' ,'X' ,'Y' ,'Y' ,'Y' ,'Y' ,'U' ,'U' ,'U' ,'U' ,'J' ,'J' ,'J' ,'J' ,'C' ,'C' ,'C' ,'C' ,'L' ,'L' ,'L' ,'L' ,'0' ,'0' ,'0' ,'0' ,'O' ,'O' ,'O' ,'O' ,'Z' ,'Z' ,'Z' ,'Z' ,'m' ,'m' ,'m' ,'m' ,'w' ,'w' ,'w' ,'w' ,'q' ,'q' ,'q' ,'q' ,'p' ,'p' ,'p' ,'p' ,'d' ,'d' ,'d' ,'d' ,'b' ,'b' ,'b' ,'b' ,'h' ,'h' ,'h' ,'h' ,'a' ,'a' ,'a' ,'a' ,'o' ,'o' ,'o' ,'o' ,'*' ,'*' ,'*' ,'*' ,'#' ,'#' ,'#' ,'#' ,'M' ,'M' ,'M' ,'M' ,'W' ,'W' ,'W' ,'W' ,'&' ,'&' ,'&' ,'&' ,'8' ,'8' ,'8' ,'8' ,'%' ,'%' ,'%' ,'%' ,'B' ,'B' ,'B' ,'B' ,'@' ,'@' ,'@' ,'@' ,'$' ,'$' ,'$' ,'$'};
    //working variables. used by program
    private static BufferedImage image;
    private static int width;
    private static int height;
    private static String ext;

    //non exposed variable. meant for developer use
    private static int scaledownConstant = 400; //(this also determines the tolerence for small images. Lower the number, lesser will be the tolerence for skipping scaledwon process of small images)

    public static void main(String args[]) throws IOException {

        initialise();
        load();
        scale();
        decolour();
        art();
        printsample(); //optional

        System.out.println("Ready.");
    }

    private static void initialise(){
        BufferedImage image = null;
        width = 0;
        height = 0;
        ext = "";
    }

    private static void load()throws IOException{
        //load
        System.out.println("Loadig Image...");
        try {

            File input = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "image.jpg");
            ext = ".jpg";
            if(!(input.exists())){
                input = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "image.jpeg");
                ext = ".jpeg";
            }
            if(!(input.exists())){
                input = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "image.png");
                ext = ".png";
            }
            if(!(input.exists())){
                input = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "image.gif");
                ext = ".gif";
            }if(!(input.exists())){
                System.out.println("No image file with name \"image\" found.\nNOTE: Only JPG/JPEG, PNG and GIF is supported.");
                System.exit(1);
            }
            //File input = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "image.jpg");
            //File input = new File(System.getProperty("user.dir") + File.separator + "image.jpg");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
        System.out.println("Image loaded.");
    }

    private static void scale(){
        //scaleing
        System.out.println("Scaling.");
        float scalefactor = 1;
        scalefactor = ((Math.max(width,height)/scaledownConstant)*compressionfactor);
        if(scalefactor<1)
            image = scale(image, width, height);
        else{
            image = scale(image, (int)(width/scalefactor), (int)(height/scalefactor));
        }
        System.out.println("Finished Scaling.");
    }

    private static void decolour(){
        //decolouring
        System.out.println("Decolouring.");
        width = image.getWidth();
        height = image.getHeight();
        for(int y = 0; y<height; y++){
            for(int x = 0; x<width; x++){
                int p = image.getRGB(x,y);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;
                int avg = (r+g+b)/3;
                p = (a<<24) | (avg<<16) | (avg<<8) | avg;
                image.setRGB(x, y, p);
            }
        }
        System.out.println("Finished decolouring.");
    }

    private static void art() throws IOException {
        //create text file
        File textascii = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "ascii.txt");
        System.out.println("Text file created.");
        //creating ascii
        System.out.println("Creating ASCII Art...");
        String s = "";
        if(mode==1){
            for(int y = 0; y<height; y++){
                for(int x = 0; x<width; x++){
                    int p = image.getRGB(x,y);
                    int r = (p>>16)&0xff;
                    s = s+""+decideHIGH(r);
                    s = s+ " ";
                }
                s=s+"\n";
            }
        }
        else{
            for(int y = 0; y<height; y++){
                for(int x = 0; x<width; x++){
                    int p = image.getRGB(x,y);
                    int r = (p>>16)&0xff;
                    s = s+""+decideLOW(r);
                    s = s+ " ";
                }
                s=s+"\n";
            }
        }
        System.out.println("Finished creating.");

        try{
            //write text file
            Files.writeString(Path.of(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "ascii.txt"),s);
        }catch (IOException e) {
            System.out.println("Error: " + e);
        }
        System.out.println("Finished writing.");
    }

    private static void printsample(){
        //image output sample
        try {
            File output_file = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "imageCOMPLETE" + ext);
            ImageIO.write(image, "png", output_file);
            System.out.println("Image printed.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    private static char decideHIGH(double g){
        if(inversion){
             return(strinv[(int)g]);
        }
        else
            return(str[(int)g]);
    }

    private static char decideLOW(double g){

        int b = -1;
        int a = 0;
        if(inversion){
            b = 1;
            a = 9;
        }
        if (g >= 229.5) 
            return strLOW[(a-9)*b];
        else if (g >= 204) 
            return strLOW[(a-8)*b];
        else if (g >= 178.5) 
            return strLOW[(a-7)*b];
        else if (g >= 153) 
            return strLOW[(a-6)*b];
        else if (g >= 127.5) 
            return strLOW[(a-5)*b];
        else if (g >= 102) 
            return strLOW[(a-4)*b];
        else if (g >= 76.5) 
            return strLOW[(a-3)*b];
        else if (g >= 51) 
            return strLOW[(a-2)*b];
        else if (g >= 25.5) 
            return strLOW[(a-1)*b];
        else 
            return strLOW[(a-0)*b];
    }

    private static BufferedImage scale(BufferedImage imageToScale, int dWidth, int dHeight) {
        BufferedImage scaledImage = null;
        if (imageToScale != null) {
            scaledImage = new BufferedImage(dWidth, dHeight, imageToScale.getType());
            Graphics2D graphics2D = scaledImage.createGraphics();
            graphics2D.drawImage(imageToScale, 0, 0, dWidth, dHeight, null);
            graphics2D.dispose();
        }
        return scaledImage;
    }
}