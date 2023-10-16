package com.atm.utilities;

public class ConsoleUtils {

    /*
     *****************************************
     * ANSI Escape
     *****************************************
     */
    public String reset = "\033[0m";  // Text Reset

    /*
     *****************************************
     * Change Text Colour
     *****************************************
     */
    public String black = "\033[0;30m";   // BLACK
    public String red = "\033[0;31m";     // RED
    public String green = "\033[0;32m";   // GREEN
    public String yellow = "\033[0;33m";  // YELLOW
    public String blue = "\033[0;34m";    // BLUE
    public String purple = "\033[0;35m";  // PURPLE
    public String cyan = "\033[0;36m";    // CYAN
    public String white = "\033[0;37m";   // WHITE

    /*
     *****************************************
     * Make Text Bold and Change Colour
     *****************************************
     */
    public String blackBold = "\033[1;30m";  // BLACK
    public String redBold = "\033[1;31m";    // RED
    public String greenBold = "\033[1;32m";  // GREEN
    public String yellowBold = "\033[1;33m"; // YELLOW
    public String blueBold = "\033[1;34m";   // BLUE
    public String purpleBold = "\033[1;35m"; // PURPLE
    public String cyanBold = "\033[1;36m";   // CYAN
    public String whiteBold = "\033[1;37m";  // WHITE

    /*
     *****************************************
     * Underline the Text and Change Colour
     *****************************************
     */
    public String blackUnderlined = "\033[4;30m";  // BLACK
    public String redUnderlined = "\033[4;31m";    // RED
    public String greenUnderlined = "\033[4;32m";  // GREEN
    public String yellowUnderlined = "\033[4;33m"; // YELLOW
    public String blueUnderlined = "\033[4;34m";   // BLUE
    public String purpleUnderlined = "\033[4;35m"; // PURPLE
    public String cyanUnderlined = "\033[4;36m";   // CYAN
    public String whiteUnderlined = "\033[4;37m";  // WHITE

    /*
     *****************************************
     * Give Text a Background Colour
     *****************************************
     */
    public String blackBackground = "\033[40m";  // BLACK
    public String redBackground = "\033[41m";    // RED
    public String greenBackground = "\033[42m";  // GREEN
    public String yellowBackground = "\033[43m"; // YELLOW
    public String blueBackground = "\033[44m";   // BLUE
    public String purpleBackground = "\033[45m"; // PURPLE
    public String cyanBackground = "\033[46m";   // CYAN
    public String whiteBackground = "\033[47m";  // WHITE

    /*
     *****************************************
     * Increased Intensity of Background Colour
     *****************************************
     */
    public String blackBrightBackground = "\033[0;100m";// BLACK
    public String redBrightBackground="\033[0;101m";// RED
    public String greenBrightBackground="\033[0;102m";// GREEN
    public String yellowBrightBackground="\033[0;103m";// YELLOW
    public String blueBrightBackground="\033[0;104m";// BLUE
    public String purpleBrightBackground="\033[10;105m";// PURPLE
    public String cyanBrightBackground="\033[0;106m";// CYAN
    public String whiteBrightBackground="\033[0;107m";// WHITE
}
