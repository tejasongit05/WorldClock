import javax.swing.*;
import java.awt.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class WorldClock {

    //labels for live time
    static JLabel indiaTime;
    static JLabel londonTime;
    static JLabel newYorkTime;
    static JLabel tokyoTime;

    // Time format
    static DateTimeFormatter format =
            DateTimeFormatter.ofPattern("hh:mm:ss a");

    public static void main(String[] args) {

        // Main window
        JFrame frame = new JFrame("World Clock System");

        frame.setSize(700, 500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());


        // TITLE

        JLabel title = new JLabel("WORLD CLOCK SYSTEM");

        title.setFont(new Font("Arial", Font.BOLD, 30));

        title.setHorizontalAlignment(SwingConstants.CENTER);

        frame.add(title, BorderLayout.NORTH);

        // CLOCK PANEL


        JPanel clockPanel = new JPanel();

        clockPanel.setLayout(new GridLayout(2, 2, 20, 20));



        // INDIA


        JPanel indiaPanel = new JPanel();

        indiaPanel.setLayout(new GridLayout(3, 1));

        JLabel indiaName = new JLabel("INDIA");

        indiaName.setHorizontalAlignment(SwingConstants.CENTER);

        indiaName.setFont(new Font("Arial", Font.BOLD, 20));

        indiaTime = new JLabel();

        indiaTime.setHorizontalAlignment(SwingConstants.CENTER);

        indiaTime.setFont(new Font("Arial", Font.BOLD, 25));

        JLabel indiaZone = new JLabel("Asia/Kolkata");

        indiaZone.setHorizontalAlignment(SwingConstants.CENTER);

        indiaPanel.add(indiaName);
        indiaPanel.add(indiaTime);
        indiaPanel.add(indiaZone);

        clockPanel.add(indiaPanel);



        // LONDON


        JPanel londonPanel = new JPanel();

        londonPanel.setLayout(new GridLayout(3, 1));

        JLabel londonName = new JLabel("LONDON");

        londonName.setHorizontalAlignment(SwingConstants.CENTER);

        londonName.setFont(new Font("Arial", Font.BOLD, 20));

        londonTime = new JLabel();

        londonTime.setHorizontalAlignment(SwingConstants.CENTER);

        londonTime.setFont(new Font("Arial", Font.BOLD, 25));

        JLabel londonZone = new JLabel("Europe/London");

        londonZone.setHorizontalAlignment(SwingConstants.CENTER);

        londonPanel.add(londonName);
        londonPanel.add(londonTime);
        londonPanel.add(londonZone);

        clockPanel.add(londonPanel);



        // NEW YORK

        JPanel newYorkPanel = new JPanel();

        newYorkPanel.setLayout(new GridLayout(3, 1));

        JLabel newYorkName = new JLabel("NEW YORK");

        newYorkName.setHorizontalAlignment(SwingConstants.CENTER);

        newYorkName.setFont(new Font("Arial", Font.BOLD, 20));

        newYorkTime = new JLabel();

        newYorkTime.setHorizontalAlignment(SwingConstants.CENTER);

        newYorkTime.setFont(new Font("Arial", Font.BOLD, 25));

        JLabel newYorkZone =
                new JLabel("America/New_York");

        newYorkZone.setHorizontalAlignment(SwingConstants.CENTER);

        newYorkPanel.add(newYorkName);
        newYorkPanel.add(newYorkTime);
        newYorkPanel.add(newYorkZone);

        clockPanel.add(newYorkPanel);



        // TOKYO

        JPanel tokyoPanel = new JPanel();

        tokyoPanel.setLayout(new GridLayout(3, 1));

        JLabel tokyoName = new JLabel("TOKYO");

        tokyoName.setHorizontalAlignment(SwingConstants.CENTER);

        tokyoName.setFont(new Font("Arial", Font.BOLD, 20));

        tokyoTime = new JLabel();

        tokyoTime.setHorizontalAlignment(SwingConstants.CENTER);

        tokyoTime.setFont(new Font("Arial", Font.BOLD, 25));

        JLabel tokyoZone = new JLabel("Asia/Tokyo");

        tokyoZone.setHorizontalAlignment(SwingConstants.CENTER);

        tokyoPanel.add(tokyoName);
        tokyoPanel.add(tokyoTime);
        tokyoPanel.add(tokyoZone);

        clockPanel.add(tokyoPanel);


        // Add clock panel to frame
        frame.add(clockPanel, BorderLayout.CENTER);



        // UPDATE TIME FIRST

        updateTime();



        // TIMER


        Timer timer = new Timer(1000, e -> {

            updateTime();

        });

        timer.start();


        // Show window
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }



    // UPDATE ALL TIMES

    public static void updateTime() {

        // India
        ZonedDateTime india =
                ZonedDateTime.now(
                        ZoneId.of("Asia/Kolkata")
                );

        indiaTime.setText(
                india.format(format)
        );


        // London
        ZonedDateTime london =
                ZonedDateTime.now(
                        ZoneId.of("Europe/London")
                );

        londonTime.setText(
                london.format(format)
        );


        // New York
        ZonedDateTime newYork =
                ZonedDateTime.now(
                        ZoneId.of("America/New_York")
                );

        newYorkTime.setText(
                newYork.format(format)
        );


        // Tokyo
        ZonedDateTime tokyo =
                ZonedDateTime.now(
                        ZoneId.of("Asia/Tokyo")
                );

        tokyoTime.setText(
                tokyo.format(format)
        );
    }
}