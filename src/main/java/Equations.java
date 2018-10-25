// package applications;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Equations {

    private final String COMMA_DELIMITER = ",";
    private final String NEW_LINE_SEPARATOR = "\n";

    private Map<String, String> mp;

    //CSV file header
    private final String FILE_HEADER = "CNAME,EQUATION_A,URL_A,EQUATION_B,URL_B,EQUATION_C,URL_C";

    public String cname,cname1, cname2, cname3;
    private String abbreviation;
    private String[] words;
    public String singles, word1AfterSingles,word2AfterSingles;

    private final String suffix = ""; // ".co.uk";
    private final String prefix = ""; // "www.";

    public String getCname2(){
        return singles+" "+word1AfterSingles;
    }

    public String getCname3(){
       try{
           return words[0]+" "+words[1];
       }catch(Exception x){
           return "";
       }
    }

    public String getCname1(){
        int x = 0;
        if(words[words.length-1].equals("limited")||words[words.length-1].equals("ltd")){
            x = 1;
        }
        String ret = "";
        for(int i=0; i<words.length-x; i++){
            ret+=words[i]+" ";
        }
        return ret;//+words[words.length-x];
    }

    public Equations(){ cname = ""; abbreviation=""; }
    public Equations(String cname)  throws Exception{
        this.cname = cname.toLowerCase();
        words = cname.split("\\W+");
        setAbbreviation();
        setSingles();

        mp = new TreeMap<String, String>();

        setMp();
    }

    private void setMp() throws Exception{
        mp.put("engineering", "eng");
        mp.put("residential", "res");
    }

    private void setAbbreviation() throws Exception{
        int l = words.length;
        int n = 0;
        if(words[l-1].equals("limited") ||words[l-1].equals("ltd") ){
            n=1;
        }

        for(int i=0; i<l-n; i++){
            if(words[i].charAt(0)!='&')
                this.abbreviation+=words[i].charAt(0);
        }
    }

    void setSingles() throws Exception{
        int i=0;
        singles = "";
        word1AfterSingles = "";

        try{
            while (words[i].length()==1){
                if(!words[i].equals("&")){singles+=words[i];}
                i++;
            }
            word1AfterSingles = words[i];
            word2AfterSingles = words[i+1];
        }catch (Exception x){
            //System.out.println(x.toString());
        }

    }

    /**
     *
     * KIND OF FACTORY PATTERN... RETURNS METHOD OUTPUTS, NOT OBJECTS...
     * IN: EQN NUM
     * OUT: CORRESPONDING URL
     * */
    public String Factory(int n){
        String ret = "";
        switch (n){
            case 1: ret = eqn1();
                break;
            case 2: ret = eqn2();
                break;
            case 3: ret = "---";
                break;
            case 4: ret = eqn4();
                break;
            case 5: ret = eqn5();
                break;
            case 6: ret = eqn6();
                break;
            case 7: ret = eqn7();
                break;

            case 8: ret = eqn8();
                break;
            case 9: ret = eqn9();
                break;
            case 10: ret = eqn10();
                break;
            case 11: ret = eqn11();
                break;

            case 12: ret = eqn12();
                break;
            case 13: ret = eqn13();
                break;

            case 14: ret = eqn14();
                break;
            case 15: ret = eqn15();
                break;

            case 16: ret = eqn16();
                break;
            case 17: ret = eqn17();
                break;
            case 18: ret = eqn18();
                break;
            case 19: ret = eqn19();
                break;
            case 20: ret = eqn20();
                break;

            case 21: ret = eqn21();
                break;
            case 22: ret = eqn22();
                break;
            case 23: ret = eqn23();
                break;
            case 24: ret = eqn24();
                break;
            case 25: ret = eqn25();
                break;
            case 26: ret = eqn26();
                break;
            case 27: ret = eqn27();
                break;
            case 28: ret = eqn28();
                break;
            case 29: ret = eqn29();
                break;

            case 30: ret = eqn30();
                break;

            case 31: ret = eqn31();
                break;
            case 32: ret = eqn32();
                break;
            case 33: ret = eqn33();
                break;

            case 34: ret = eqn34();
                break;
        }

        return ret;
    }
    /**
     *           //1	"full company name".suffix
     *         // CLOVER STROUD LIMITED
     *         // http://www.cloverstroud.com/
     *         // .co.uk	please see instruction file
     *
     *
     * */
    public String eqn1(){
        String url=""+prefix;
        int end = 0;
        if(words[words.length-1].equals("limited") || words[words.length-1].equals("ltd") ){
            end = 1;
        }
        for(int i=0; i<words.length-end; i++){   url+=words[i];  }
        url+=suffix;
        if(url.equals("")){ url = "xxx"; }
        return url;
    }

    /**
     * 2	"full company name"ltd/limited.suffix
     * CLOVER SECURITY SERVICES LTD
     * http://www.cloversecurityservicesltd.com/
     * .com	please see instruction file
     * */
    public String eqn2(){
        String url=""+prefix;
        int end = 0;
        if(words[words.length-1].equals("limited") || words[words.length-1].equals("ltd") ){
            end = 1;
        }
        for(int i=0; i<words.length-1-end; i++){   url+=words[i];  }
        url+="ltd";
        url+=suffix;
        return url;
    }

    /**
     * 4
     * word1word2.suffix
     * CLOVER ROOFING SERVICES LIMITED
     * http://www.cloverroofing.co.uk/
     * .org	please see instruction file
     * */
    public String eqn4(){
        try{
            String url=""+prefix;
            url+=words[0]+words[1];
            url+=suffix;
            return url;
        }catch (Exception x){
            //System.out.println(x);
        }return "---";

    }

    /**
     * 5
     * word1.suffix
     * COBOLT SYSTEMS LIMITED
     * https://www.cobolt.co.uk
     * .edu	please see instruction file
     * */
    public String eqn5(){
        try{
            String url=""+prefix;
            url+=words[0];
            url+=suffix;
            return url;
        }catch (Exception x){
            //System.out.println(x);
        }return "---";

    }


    /**
     * 6
     * word1word3.suffix
     * CLOVER POWDER COATINGS LIMITED
     * http://www.clovercoatings.co.uk/
     * */

    public String eqn6(){
        try{        String url=""+prefix;
            url+=words[0]+words[2];
            url+=suffix;
            return url;
        }catch (Exception x){
            //System.out.println(x);
        }return "---";

    }

    /**
     * 7
     * word1-word2.suffix
     * Clyde Electrical Contractors Ltd
     * http://www.clyde-electrical.com/
     * */
    public String eqn7(){
        try{
            String url=""+prefix;
            url+=words[0]+"-"+words[1];
            url+=suffix;
            return url;
        }catch (Exception x){
            //System.out.println(x);
        }return "---";

    }

    /**
     * 8	word1-word3.suffix	X	X
     * */
    public String eqn8(){
        try{
            String url=""+prefix;
            url+=words[0]+"-"+words[2];
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x);
        }return "---";
    }

    /**
     * 9	"abbreviation"word2.suffix	COASTAL ENGINEERING SERVICES LIMITED	https://www.cesengineering.co.uk/
     * */
    public String eqn9(){
        try{
            String url=""+prefix;
            url+=this.abbreviation+words[1];
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x);
        }return "---";
    }

    /**
     * 10	"abbreviation"-word2.suffix	COBURN VEHICLE SYSTEMS LIMITED	http://www.cvs-vehicles.co.uk/
     * */

    public String eqn10(){
        try{
            String url=""+prefix;
            url+=suffix;
            url+=this.abbreviation+"-"+words[1];
            return url;
        }catch(Exception x){
            //System.out.println(x);
        }return "---";
    }

    /**
     * 11	"abbreviation"word3.suffix	X	X
     * */

    public String eqn11(){
        try{
            String url=""+prefix;
            url+=this.abbreviation+words[2];
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x);
        }return "---";
    }

    /**
     * 12	"word1 abbre""&>and""word2 abbre"word3.suffix	CLYDE & SOLWAY SYSTEMS LTD	http://www.candssystems.co.uk/
     * */

    public String eqn12(){
        try{
            String url=""+prefix;
            if(words[1].equals("&")){
                url +=words[0].charAt(0)+"and"+words[2].charAt(0)+words[3];
            }else{
                url +=words[0].charAt(0)+"and"+words[1].charAt(0)+words[2];
            }
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x);
        }return "---";
    }

    /**
     * 13	word1word2ing.suffix
     *
     * CLOVERLEAF LANDSCAPE & DESIGN LIMITED
     *
     * https://www.cloverleaflandscaping.co.uk/
     *
     * e or y after word2 will be deleted
     * id = id.substring(0, id.length()-4);
     * */
    public String eqn13(){
        try{
            int l = words[1].length()-1;
            if(words[1].charAt(l)=='e'||words[1].charAt(l)=='y'){
                words[1] = words[1].substring(0, words[1].length()-2);
            }

            String url=""+prefix;
            url+=words[0]+words[1]+"ing";
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x);
        }return "---";
    }

    /**
     * 14	"&>and".suffix	D & B MARINE LTD	www.dandbmarine.com
     * */

    public String eqn14(){  // same as eqn 12? o.O
        try{
            String url=""+prefix;
            if(words[1].equals("&")){
                url +=words[0].charAt(0)+"and"+words[2].charAt(0)+words[3];
            }else{
                url +=words[0].charAt(0)+"and"+words[1].charAt(0)+words[2];
            }
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x);
        }return "---";
    }

    /**
     * 15	"abbreviation".suffix	D & P ELECTRICAL SERVICES LTD	www.dpes.co.uk
     * */

    public String eqn15(){
        try{
            String url=""+prefix;
            url+=this.abbreviation;
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x);
        }return "---";
    }

    /**
     * 16	"abbreviation"ltd.suffix	D & K TRAVEL LIMITED	www.dktltd.co.uk
     * */

    public String eqn16(){
        try{
            String url=""+prefix;
            url+=abbreviation+"ltd";
            url+=suffix;
            return url;
        }catch(Exception x){
           // System.out.println(x);
        }return "---";
    }

    /**
     * 17	"full company name"uk.suffix	D H EXPRESS LIMITED	www.dhexpressuk.com
     * */
    public String eqn17(){
        try{
            String url=""+prefix;
            for(int i=0; i<words.length-1; i++){
                if(words[i].equals("&")){}
                else{
                    url+=words[i];
                }
            }
            if(words[words.length-1].equals("limited") || words[words.length-1].equals("ltd")){

            }else{
                url+=words[words.length-1];
            }

            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x);
        }return "---";
    }

    /***
     * 18	singles-word1.suffix	D B SECURITY LIMITED	www.db-security.co.uk
     */
    public String eqn18(){
        try{
            String url=""+prefix;
            url+=singles+"-"+word1AfterSingles;
            url+=suffix;
            return url;
        }catch(Exception x){
           // System.out.println(x);
        }return "---";
    }

/**19	singles-word2.suffix	D M INDUSTRIAL INSULATION LTD	www.dm-insulation.co.uk
 */
public String eqn19(){
    try{
        String url=""+prefix;
        url+=singles+"-"+word2AfterSingles;
        url+=suffix;
        return url;
    }catch(Exception x){
        //System.out.println(x);
    }return "---";
}

/**
 * 20	singlesword1.suffix	D B THERMAL INSULATION LIMITED	www.dbthermal.co.uk
 * */


    public String eqn20(){
        try{
            String url=""+prefix;
            url+=singles+word1AfterSingles;
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x);
        }return "---";
    }

    /**
     *21	word1-uk.suffix	DAA RESIDENTIAL LIMITED	www.daa-uk.com
     * */
    public String eqn21(){
        try{
            String url=""+prefix;
            url+=words[0]+"-uk";
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x);
        }return "---";
    }

    // 22	singlesword1s.suffix	D K MODEL MANAGEMENT LIMITED	www.dkmodels.net


    public String eqn22(){
        try{
            String url=""+prefix;
            url+=singles+word1AfterSingles + "s";
            url+=singles+word1AfterSingles + "s";
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x);
        }return "---";
    }

    // 23	"no &"singles-word1.suffix	D & P SUPPLIES LIMITED	www.dp-supplies.com

    public String eqn23(){
        try{
            String url=""+prefix;
            url+=singles+"-"+word1AfterSingles;
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x);
        }return "---";
    }

    // 24	"abbreviation"lword2.suffix	DATAWEIGH SYSTEMS LIMITED	www.dslsystems.net
    public String eqn24(){
        try{
            String url=""+prefix;
            url+=abbreviation+"l"+word2AfterSingles;
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x);
        }return "---";
    }

//    25	"and>n".suffix	X	X

    public String eqn25(){
        try{
            String url=""+prefix;
            for(int i=0; i<words.length; i++){
                if(words[i].equals("and") || words[i].equals("&")){
                    url+="n";
                }else{
                    url+=words[i];
                }
            }
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x.toString());
        }return "---";
    }

    /**
     26	"abbreviation"l.suffix	X	X
     * */

    public String eqn26(){
        try{
            String url=""+prefix;
            url+=abbreviation+"l";
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x.toString());
        }return "---";
    }

    // 27	word1word2-uk.suffix	X	X

    public String eqn27(){
        try{
            String url=""+prefix;
            url+=words[0]+words[1]+"-uk";
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x.toString());
        }return "---";
    }

    // 28	word1uk.suffix	X	X

    public String eqn28(){
        try{
            String url=""+prefix;
            url+=words[0]+"uk";
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x.toString());
        }return "---";
    }

    //29	word1word2uk.suffix	X	X
    public String eqn29(){
        try{
            String url=""+prefix;
            url+=words[0]+words[1]+"uk";
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x.toString());
        }return "---";
    }

//    30	singlesword1ing.suffix	X	X	e or y after word1 will be deleted

    public String eqn30(){
        try{
            String url=""+prefix;
            url+=singles;
            if(word1AfterSingles.charAt(word1AfterSingles.length()-1)=='e' ||
                    word1AfterSingles.charAt(word1AfterSingles.length()-1)=='y'
            ){
                word1AfterSingles = word1AfterSingles.substring(0, word1AfterSingles.length()-2);
            }

            url+=singles+word1AfterSingles+"ing";
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x.toString());
        }return "---";
    }

// 31	singlesword2s.suffix	X	X
public String eqn31(){
    try{
        String url=""+prefix;
        url += singles+word2AfterSingles+"s";
        url+=suffix;
        return url;
    }catch(Exception x){
        //System.out.println(x.toString());
    }return "---";
}

// 32	word1shrink.suffix
// DANLEY ENGINEERING SERVICES LIMITED
// www.danleyeng.co.uk
// Shrink Dictionary Required	same shrink can produce multple url; use equation 32/1 ; 32/2 ; etc

    public String eqn32(){
        try{
            String url=""+prefix;
            String shrink = "";
            try{
                for(int i=0; i<words.length; i++){
                    if(mp.containsKey(words[i])){
                        shrink=mp.get(words[i]);
                    }
                }
                url+=words[0]+shrink;
                url+=suffix;
            }catch(Exception x){x.printStackTrace();}
            return url;
        }catch(Exception x){
            //System.out.println(x.toString());
        }return "---";
    }

// 33	word1word2shrink.suffix
// DANIEL ROSE RESIDENTIAL LIMITED
// www.danielroseres.com
// Shrink Dictionary Required	same shrink can produce multple url; use equation 33/1 ; 33/2 ; etc

    public String eqn33() {
        try{
            String url=""+prefix;
            String shrink = "";
            for(int i=0; i<words.length; i++){
                if(mp.containsKey(words[i])){
                    shrink=mp.get(words[i]);
                }
            }
            url+=words[0]+words[1]+shrink;
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x.toString());
        }return "---";
    }

    // 34	"w/o &".suffix	D & G ASSIST LIMITED	www.dgassist.co.uk

    public String eqn34(){
        try{
            String url=""+prefix;
            for(int i=0; i<words.length-1; i++){
                if(!words[i].equals("&") && !words[i].equals("and")){
                    url+=words[i];
                }
            }

            if(!words[words.length-1].equals("limited") && !words[words.length-1].equals("ltd")){
                url+=words[words.length-1];
            }
            url+=suffix;
            return url;
        }catch(Exception x){
            //System.out.println(x.toString());
        }return "---";
    }
    /**
     *
     public String eqn(){
     try{
     String url=""+prefix;

     url+=suffix;
     return url;
     }catch(Exception x){
     System.out.println(x.toString());
     }return "---";
     }
     *
     * */






}

