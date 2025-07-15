public class CountVowelAndConsonant {
    public static void main(String[] args) {
        String s="poonam";
        int vowel=0;
        int consonant=0;
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c>='a' && c<='z'){
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                    vowel++;
                }
                else{
                    consonant++;
                }
            }
        }
        System.out.println("number of vowels are:" +vowel);
        System.out.println("number of consonant are:" +consonant);

    }
}
