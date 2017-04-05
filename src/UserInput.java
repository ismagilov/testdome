class TextInput {
    private StringBuffer chars = new StringBuffer();

    public void add(char c) {
        chars.append(c);
    }

    public String getValue() {
        return chars.toString();
    }
}

class NumericInput extends TextInput {
    public void add(char c) {
        if (Character.isDigit(c))
            super.add(c);
    }

}

public class UserInput {
    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}