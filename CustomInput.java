package Rochambeau_Project;

public class CustomInput {
    
    private boolean caseSensitive;

    public CustomInput() {
        this.caseSensitive = true;
    }

    public CustomInput(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public boolean equals(char c, char q) {
        char comparable = c;
        char compared = q;
        if(!caseSensitive) {
            comparable = Character.toLowerCase(c);
            compared = Character.toLowerCase(q);
        }
        return (comparable == compared);
    }

    public boolean equals(String s, String q) {
        String comparable = s;
        String compared = q;
        if(!caseSensitive) {
            comparable = s.toLowerCase();
            compared = q.toLowerCase();
        }
        return (comparable.equals(compared));
    }

    public boolean yesNo(char c) {
        return equals(c, 'y');
    }

    public boolean yesNo(String s) {
        return equals(s, "yes") || equals(s, "y");
    }
}
