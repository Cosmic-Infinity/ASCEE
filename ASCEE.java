
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.nio.file.Files;
import java.nio.file.Path;

public class ASCEE {
    private static boolean inversion = false; //inverts the black and white colour space.
    private static short compressionfactor = 5; // higher the number, smaller the ascii art.
    private static byte mode = 1; // 1 = high bit depth mode. 2 = low bit depth mode
    
    private static char strLOW[] = {'@','%','#','*','+','=','-',':','.',' '};
    private static char str[] = {'$','@','B','%','8','&','W','M','#','*','o','a','h','b','d','p','q','w','m','Z','O','0','L','C','J','U','Y','X','z','c','v','u','n','x','r','j','f','t','/',(char)92,'(',')','1','{','}','[',']','?','-','+','~','<','>','i','!','l',';',':',',','"','^',(char)39,'.',' '};

    
    
    private static BufferedImage image;
    private static int width;
    private static int height;

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
    }

    private static void load()throws IOException{
        //load
        System.out.println("Loadig Image...");
        try {

            File input = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "image.png");
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
        int scalefactor = 1;
        scalefactor = ((Math.max(width,height)/750)*compressionfactor);
        if(scalefactor<1)
            image = scale(image, width, height);
        else{
            image = scale(image, width/scalefactor, height/scalefactor);
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
            File output_file = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "imageCOMPLETE.png");
            ImageIO.write(image, "png", output_file);
            System.out.println("Image printed.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    private static char decideHIGH(double g){
        if(inversion){
            if (g >= 252) 
                return str[0];
            else if (g >= 248) 
                return str[1];
            else if (g >= 244) 
                return str[2];
            else if (g >= 240) 
                return str[3];
            else if (g >= 236) 
                return str[4];
            else if (g >= 232) 
                return str[5];
            else if (g >= 228) 
                return str[6];
            else if (g >= 224) 
                return str[7];
            else if (g >= 220) 
                return str[8];
            else if (g >= 216) 
                return str[9];
            else if (g >= 212) 
                return str[10];
            else if (g >= 208) 
                return str[11];
            else if (g >= 204) 
                return str[12];
            else if (g >= 200) 
                return str[13];
            else if (g >= 196) 
                return str[14];
            else if (g >= 192) 
                return str[15];
            else if (g >= 188) 
                return str[16];
            else if (g >= 184) 
                return str[17];
            else if (g >= 180) 
                return str[18];
            else if (g >= 176) 
                return str[19];
            else if (g >= 172) 
                return str[20];
            else if (g >= 168) 
                return str[21];
            else if (g >= 164) 
                return str[22];
            else if (g >= 160) 
                return str[23];
            else if (g >= 156) 
                return str[24];
            else if (g >= 152) 
                return str[25];
            else if (g >= 148) 
                return str[26];
            else if (g >= 144) 
                return str[27];
            else if (g >= 140) 
                return str[28];
            else if (g >= 136) 
                return str[29];
            else if (g >= 132) 
                return str[30];
            else if (g >= 128) 
                return str[31];
            else if (g >= 124) 
                return str[32];
            else if (g >= 120) 
                return str[33];
            else if (g >= 116) 
                return str[34];
            else if (g >= 112) 
                return str[35];
            else if (g >= 108) 
                return str[36];
            else if (g >= 104) 
                return str[37];
            else if (g >= 100) 
                return str[38];
            else if (g >= 96) 
                return str[39];
            else if (g >= 92) 
                return str[40];
            else if (g >= 88) 
                return str[41];
            else if (g >= 84) 
                return str[42];
            else if (g >= 80) 
                return str[43];
            else if (g >= 76) 
                return str[44];
            else if (g >= 72) 
                return str[45];
            else if (g >= 68) 
                return str[46];
            else if (g >= 64) 
                return str[47];
            else if (g >= 60) 
                return str[48];
            else if (g >= 56) 
                return str[49];
            else if (g >= 52) 
                return str[50];
            else if (g >= 48) 
                return str[51];
            else if (g >= 44) 
                return str[52];
            else if (g >= 40) 
                return str[53];
            else if (g >= 36) 
                return str[54];
            else if (g >= 32) 
                return str[55];
            else if (g >= 28) 
                return str[56];
            else if (g >= 24) 
                return str[57];
            else if (g >= 20) 
                return str[58];
            else if (g >= 16) 
                return str[59];
            else if (g >= 12) 
                return str[60];
            else if (g >= 8) 
                return str[61];
            else if (g >= 4) 
                return str[62];
            else 
                return str[63];
        }
        else{
            if (g >= 252) 
                return str[63];
            else if (g >= 248) 
                return str[62];
            else if (g >= 244) 
                return str[61];
            else if (g >= 240) 
                return str[60];
            else if (g >= 236) 
                return str[59];
            else if (g >= 232) 
                return str[58];
            else if (g >= 228) 
                return str[57];
            else if (g >= 224) 
                return str[56];
            else if (g >= 220) 
                return str[55];
            else if (g >= 216) 
                return str[54];
            else if (g >= 212) 
                return str[53];
            else if (g >= 208) 
                return str[52];
            else if (g >= 204) 
                return str[51];
            else if (g >= 200) 
                return str[50];
            else if (g >= 196) 
                return str[49];
            else if (g >= 192) 
                return str[48];
            else if (g >= 188) 
                return str[47];
            else if (g >= 184) 
                return str[46];
            else if (g >= 180) 
                return str[45];
            else if (g >= 176) 
                return str[44];
            else if (g >= 172) 
                return str[43];
            else if (g >= 168) 
                return str[42];
            else if (g >= 164) 
                return str[41];
            else if (g >= 160) 
                return str[40];
            else if (g >= 156) 
                return str[39];
            else if (g >= 152) 
                return str[38];
            else if (g >= 148) 
                return str[37];
            else if (g >= 144) 
                return str[36];
            else if (g >= 140) 
                return str[35];
            else if (g >= 136) 
                return str[34];
            else if (g >= 132) 
                return str[33];
            else if (g >= 128) 
                return str[32];
            else if (g >= 124) 
                return str[31];
            else if (g >= 120) 
                return str[30];
            else if (g >= 116) 
                return str[29];
            else if (g >= 112) 
                return str[28];
            else if (g >= 108) 
                return str[27];
            else if (g >= 104) 
                return str[26];
            else if (g >= 100) 
                return str[25];
            else if (g >= 96) 
                return str[24];
            else if (g >= 92) 
                return str[23];
            else if (g >= 88) 
                return str[22];
            else if (g >= 84) 
                return str[21];
            else if (g >= 80) 
                return str[20];
            else if (g >= 76) 
                return str[19];
            else if (g >= 72) 
                return str[18];
            else if (g >= 68) 
                return str[17];
            else if (g >= 64) 
                return str[16];
            else if (g >= 60) 
                return str[15];
            else if (g >= 56) 
                return str[14];
            else if (g >= 52) 
                return str[13];
            else if (g >= 48) 
                return str[12];
            else if (g >= 44) 
                return str[11];
            else if (g >= 40) 
                return str[10];
            else if (g >= 36) 
                return str[9];
            else if (g >= 32) 
                return str[8];
            else if (g >= 28) 
                return str[7];
            else if (g >= 24) 
                return str[6];
            else if (g >= 20) 
                return str[5];
            else if (g >= 16) 
                return str[4];
            else if (g >= 12) 
                return str[3];
            else if (g >= 8) 
                return str[2];
            else if (g >= 4) 
                return str[1];
            else 
                return str[0];
        }
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
