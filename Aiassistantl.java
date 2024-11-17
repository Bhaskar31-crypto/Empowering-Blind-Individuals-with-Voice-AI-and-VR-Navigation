import java.util.Scanner;

public class AIAssistant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        
        System.out.println("Hello! I am your AI Assistant. How can I help you today?");
        
        // Loop to keep the AI Assistant running until "exit" is typed
        while (true) {
            System.out.print("You: ");
            userInput = scanner.nextLine();
            
            // Exit condition
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("AI Assistant: Goodbye! Have a great day!");
                break;
            }
            
            // Generate and print a response
            String response = generateResponse(userInput);
            System.out.println("AI Assistant: " + response);
        }
        
        scanner.close();
    }

    // Method to generate responses based on user input
    public static String generateResponse(String input) {
        // Check for simple keywords and return predefined responses
        if (input.toLowerCase().contains("hello") || input.toLowerCase().contains("hi")) {
            return "Hello! How can I assist you today?";
        } else if (input.toLowerCase().contains("how are you")) {
            return "I'm just a program, but I'm functioning as expected! How can I help you?";
        } else if (input.toLowerCase().contains("help")) {
            return "Sure, I'm here to assist you. Please tell me what you need help with.";
        } else if (input.toLowerCase().contains("time")) {
            return "I can't tell the exact time, but you can check your system clock!";
        } else {
            return "I'm not sure how to respond to that. Can you please rephrase?";
        }
    }
}
