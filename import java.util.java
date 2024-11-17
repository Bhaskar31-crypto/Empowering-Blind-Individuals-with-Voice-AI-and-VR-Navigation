import java.util.Scanner;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.util.Locale;

public class VoiceAIAssistant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        // Initialize the Text-to-Speech (TTS) synthesizer
        try {
            Synthesizer synthesizer = Central.createSynthesizer(
                new SynthesizerModeDesc(Locale.US)
            );
            synthesizer.allocate();
            synthesizer.resume();

            System.out.println("Hello! I am your AI Assistant. How can I help you today?");
            synthesizer.speakPlainText("Hello! I am your AI Assistant. How can I help you today?", null);
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

            // Loop to keep the AI Assistant running until "exit" is spoken or typed
            while (true) {
                System.out.print("You: ");
                userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("exit")) {
                    String farewell = "Goodbye! Have a great day!";
                    System.out.println("AI Assistant: " + farewell);
                    synthesizer.speakPlainText(farewell, null);
                    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
                    break;
                }

                // Generate and speak a response
                String response = generateResponse(userInput);
                System.out.println("AI Assistant: " + response);
                synthesizer.speakPlainText(response, null);
                synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
            }

            synthesizer.deallocate();
        } catch (Exception e) {
            e.printStackTrace();
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
