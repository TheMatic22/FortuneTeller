import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private JTextArea fortuneDisplay;
    private String[] fortunes;
    private int lastFortuneIndex = -1;
    private Random random = new Random();

    public FortuneTellerFrame() {
        super("Trey Sims Fortune Teller Reader");

        fortunes = new String[] {
                "You will find a great parking spot... in someone else's dream.",
                "A wise investment today is a nap.",
                "Beware of free samples that turn into subscriptions.",
                "Your Wi-Fi will disconnect at the worst possible moment.",
                "Fortune favors those who double-check their code before running it.",
                "The next email you send will have a typo in it.",
                "You will lose one sock this week, and it will never be found.",
                "A stranger will compliment your shoes. Wear good ones.",
                "Great success awaits you, right after a long nap.",
                "Your next snack will be more satisfying than expected.",
                "Someone is about to text you 'we need to talk.' It's about pizza toppings.",
                "You will finally beat that one level you've been stuck on."
        };


        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(51, 153, 255));

        this.add(createTopPanel(), BorderLayout.NORTH);
        this.add(createMiddlePanel(), BorderLayout.CENTER);
        this.add(createBottomPanel(), BorderLayout.SOUTH);
    }

    private JPanel createTopPanel() {
        ImageIcon image = new ImageIcon("logo.png");

        JLabel label = new JLabel("Fortune Teller", image, JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setFont(new Font("Times New Roman", Font.BOLD, 20));

        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        topPanel.add(label);
        return topPanel;
    }

    private JScrollPane createMiddlePanel() {
        fortuneDisplay = new JTextArea();
        fortuneDisplay.setEditable(false);
        fortuneDisplay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        fortuneDisplay.setLineWrap(true);
        fortuneDisplay.setWrapStyleWord(true);
        fortuneDisplay.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        fortuneDisplay.setBackground(new Color(250, 250, 245));

        JScrollPane scrollPane = new JScrollPane(fortuneDisplay);
        return scrollPane;
    }

    private JPanel createBottomPanel() {
        JButton readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        readFortuneButton.addActionListener(e -> {
            showRandomFortune();
        });

        quitButton.addActionListener(e -> {
            System.exit(0);
        });

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        return bottomPanel;
    }

    private void showRandomFortune() {
        int newIndex;
        do {
            newIndex = random.nextInt(fortunes.length);
        } while (newIndex == lastFortuneIndex);

        lastFortuneIndex = newIndex;
        fortuneDisplay.append(fortunes[newIndex] + "\n");
    }
}