
package guessthemovie;
public class FactoryString {
    private String namefilm;
    private String guess;

    public FactoryString(String namefilm) {
        this.namefilm = namefilm;
        this.guess = this.toGuessFilm();
    }

    public String getNamefilm() {
        return namefilm;
    }

    public String getGuess() {
        return guess;
    }
    
    private String toGuessFilm(){
        String x = "";
        for(int i=0;i<namefilm.length();i++){
            String cha = ""+this.namefilm.charAt(i);
            if(cha.equals(" ")){
                x+=" ";
            }
            else x+="_";
        }
        return x;
    }
    public boolean checkFilm(String s){
        String[] arrguess = this.guess.split("");
        if(this.namefilm.contains(s)&&this.guess.contains(s)==false){
            for(int i=0; i<this.namefilm.length();i++){
                String check = ""+this.namefilm.charAt(i);
                if(check.equals(s)&&arrguess[i].equals("_")){
                    arrguess[i]=s;
                }
            }
            this.guess=this.arrToString(arrguess);
            System.out.println("You are guessing:"+this.guess);
            return true;
        }
        else{
            System.out.println("You are guessing:"+this.guess);
            return false;
        }
    }
    public String arrToString(String[] arr){
        String s="";
        for(String x:arr){
            s+=x;
        }
        return s;
    }
}
