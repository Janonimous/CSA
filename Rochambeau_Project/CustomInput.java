package Rochambeau_Project;

public class CustomInput {
    
    private boolean caseSensitive;

    public CustomInput() {
        this.caseSensitive = true;
    }

    public CustomInput(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    // Harder to implement as console inputs are stored as strings
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

    public boolean multipleEquals(String s, String[] qa) {
        boolean result = false;
        for(String q: qa) {
            if(s.equals(q)) result = true;
        }
        return result;
    }

    public boolean yesNo(char c) {
        return equals(c, 'y');
    }

    // Cleanse up for later use
    public boolean yesNo(String s) {
        boolean answ = false;
        boolean valid = equals(s, "no") || equals(s, "n") || equals(s, "yes") || equals(s, "y");
        do {
            if(equals(s, "yes") || equals(s, "y")) answ = true;
            else if(equals(s, "no") || equals(s, "n")) answ = false;
            if(!valid) System.out.println("Please enter y, yes, n, or no");
        } while(!valid);
        
        return answ;
    }
}
