public class Main {

    public static boolean validate(String exp) throws Exception {
        ArrayStack<Character> stack = new ArrayStack<>(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            char symbol = exp.charAt(i);
            if (symbol == '(' || symbol == '{' || symbol == '[') {
                stack.PUSH(symbol);
            } else if (symbol == ')' || symbol == '}' || symbol == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char item = stack.POP();
                    if ((symbol == ')' && item != '(') ||
                            (symbol == '}' && item != '{') ||
                            (symbol == ']' && item != '[')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static String infixToPostfix(String exp) {
        String postfix = "";
        ArrayStack<Character> operatorStack = new ArrayStack<>(exp.length());

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix += ch;
            } else if (ch == '(') {
                operatorStack.PUSH(ch);
            } else if (ch == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix += operatorStack.POP();
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.POP();
                }
            } else {
                while (!operatorStack.isEmpty() && precedence(ch) <= precedence(operatorStack.peek())) {
                    postfix += operatorStack.POP();
                }
                operatorStack.PUSH(ch);
            }
        }

        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek() == '(') {
                return "Invalid Expression";
            }
            postfix += operatorStack.POP();
        }

        return postfix;
    }

    private static int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }
    public static int evaluatePostfix(String postfixExpression) throws Exception {
        ArrayStack<Integer> stack = new ArrayStack<>(postfixExpression.length());
        for (int i = 0; i < postfixExpression.length(); i++) {
            char symbol = postfixExpression.charAt(i);
            if (Character.isDigit(symbol)) {
                int operand = Character.getNumericValue(symbol);
                stack.PUSH(operand);
            } else if (isOperator(symbol)) {
                int operand2 = stack.POP();
                int operand1 = stack.POP();
                int result = applyOperator(symbol, operand1, operand2);
                stack.PUSH(result);
            }
        }
        return stack.POP();
    }

    private static boolean isOperator(char symbol) {
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';
    }

    private static int applyOperator(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+' -> {
                return operand1 + operand2;
            }
            case '-' -> {
                return operand1 - operand2;
            }
            case '*' -> {
                return operand1 * operand2;
            }
            case '/' -> {
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }


    public static void main(String[] args) throws Exception {

        String infixExpression = "(A+B)/B+A-C+(B-C)";
        System.out.println(infixToPostfix(infixExpression));

        System.out.println("Taking A = 3, B = 2, and C = 1");

        String postfixExpression = "3 2 + 2 / 3 + 1 - 2 1 - +";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result); // Should print "Result: 5"



    }
}


