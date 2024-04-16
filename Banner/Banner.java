
public class Banner {

    // Definition des Zeichensatzes für 0123456789-
    static String[][] fontChars = {{
            "  ###   ",
            " #   #  ",
            "#     # ",
            "#     # ",
            "#     # ",
            " #   #  ",
            "  ###   "}, {
            "   #    ",
            "  ##    ",
            " # #    ",
            "   #    ",
            "   #    ",
            "   #    ",
            " #####  "}, {
            " #####  ",
            "#     # ",
            "      # ",
            " #####  ",
            "#       ",
            "#       ",
            "####### "}, {
            " #####  ",
            "#     # ",
            "      # ",
            " #####  ",
            "      # ",
            "#     # ",
            " #####  "}, {
            "#       ",
            "#    #  ",
            "#    #  ",
            "#    #  ",
            "####### ",
            "     #  ",
            "     #  "}, {
            "####### ",
            "#       ",
            "#       ",
            "######  ",
            "      # ",
            "#     # ",
            " #####  "}, {
            " #####  ",
            "#     # ",
            "#       ",
            "######  ",
            "#     # ",
            "#     # ",
            " #####  "}, {
            "####### ",
            "#    #  ",
            "    #   ",
            "   #    ",
            "  #     ",
            "  #     ",
            "  #     "}, {
            " #####  ",
            "#     # ",
            "#     # ",
            " #####  ",
            "#     # ",
            "#     # ",
            " #####  "}, {
            " #####  ",
            "#     # ",
            "#     # ",
            " ###### ",
            "      # ",
            "#     # ",
            " #####  "}, {
            "        ",
            "        ",
            "        ",
            " #####  ",
            "        ",
            "        ",
            "        "}};

    public static void main(String[] args) 
    {
        // Schreiben Sie Ihre Loesung hier.
	//Ueberpruefung der Eingabe 
	if(args.length != 1){
			System.out.println("Bitte geben Sie eine dezimal Ganzzahl ein.");
			System.exit(-1);
	}
	char[] zahl = args[0].toCharArray();
	// UEberpruefung ob alle Zeichen gueltig sind
	for(int z : zahl){
		if(!(z >= 48 && z <= 57 || z == '-')){
			System.out.println("Bitte geben Sie eine dezimal Ganzzahl ein.");
			System.exit(-1);
		}
	}
	// Veraenderung jeder Ziffer zum Idex des fontChars Array
	for(int i = zahl.length -1 ; i >= 0; i--){
		zahl[i] = (zahl[i] == '-') ? (char)10 : (char) (zahl[i] - 48);
	}
	
	//Ausgabe der Zeichen
	for(int i = 0; i < fontChars[0].length; i++){
		for(int z : zahl){
			System.out.print(fontChars[z][i]);
		}
		System.out.println();
	}
	
    }

}
