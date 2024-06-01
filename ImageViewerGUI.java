package ImageViewer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.awt.image.RescaleOp;

public class ImageViewerGUI extends JFrame implements ActionListener{
    JButton selectFileButton;
    JButton showImageButton;
    JButton resizeButton;
    JButton grayscaleButton;
    JButton brightnessButton;
    JButton closeButton;
    JButton showResizeButton;
    JButton showBrightnessButton;
    JButton backButton;
    JTextField widthTextField;
    JTextField heightTextField;
    JTextField brightnessTextField;
    String filePath = "D:\\Amirkabir\\Java\\new java\\ImageViewer\\Girl.jpg";
    File file;
    JFileChooser fileChooser = new JFileChooser(filePath);
    int h = 900;
    int w = 1200;
    float brightenFactor = 1;

    ImageViewerGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Image Viewer");
        this.setSize(700, 300);
        this.setVisible(true);
        this.setResizable(true);

        mainPanel();
    }

    public void mainPanel(){
        // Create main panel for adding to Frame
        JPanel mainPanel = new JPanel();
    	JLabel ImageViewerLabel= new JLabel();
    	
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.gray);

        ImageViewerLabel.setText("Image Viewer");
        ImageViewerLabel.setForeground(Color.BLACK);
        ImageViewerLabel.setBounds(270, 50, 200, 50);
        ImageViewerLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));
        

        // Create Grid panel for adding buttons to it, then add it all to main panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 2));
        buttonsPanel.setBounds(110, 100, 470, 100);

        selectFileButton = new JButton("Choose Image");
        selectFileButton.addActionListener(this);
        showImageButton = new JButton("Show Image");
        showImageButton.addActionListener(this);
        brightnessButton = new JButton("Brightness");
        brightnessButton.addActionListener(this);
        grayscaleButton = new JButton("Gray Scale");
        grayscaleButton.addActionListener(this);
        resizeButton = new JButton("Resize");
        resizeButton.addActionListener(this);
        closeButton = new JButton("Exit");
        closeButton.addActionListener(this);

        // Adding all buttons to Grid panel
        buttonsPanel.add(this.selectFileButton);
        buttonsPanel.add(this.showImageButton);
        buttonsPanel.add(this.brightnessButton);
        buttonsPanel.add(this.grayscaleButton);
        buttonsPanel.add(this.resizeButton);
        buttonsPanel.add(this.closeButton);

        // add Grid panel that contains 6 buttons to main panel
        mainPanel.add(ImageViewerLabel);
        mainPanel.add(buttonsPanel);

        // add main panel to our frame
        this.add(mainPanel);
    }
    
    public void chooseFileImage(){
    	fileChooser.setAcceptAllFileFilterUsed(false);
    	int option = fileChooser.showOpenDialog(ImageViewerGUI.this);
    	if(option == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
		}
    }
    
    public void showOriginalImage(){
        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel();
    	JLabel pictureLabel = new JLabel();
           
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(String.valueOf(file)).getImage().getScaledInstance(1400,800, Image.SCALE_DEFAULT));
		pictureLabel.setIcon(imageIcon);
		pictureLabel.setBounds(70,0,1400,800);
        
        tempPanel.setSize(1800, 1000);
        tempPanel.setLayout(null);
        tempPanel.add(pictureLabel);
        
        tempFrame.setTitle("Image Viewer");
        tempFrame.setSize(1800, 1000);
        tempFrame.getContentPane().setBackground(Color.gray);
        tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tempFrame.setLayout(null);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);
        tempFrame.add(tempPanel);
    }

    public void brightnessPanel(){
        JPanel brightnessPanel = new JPanel();
    	JLabel brightnesslabel = new JLabel();
    	brightnessTextField = new JTextField();
    	showBrightnessButton = new JButton("Result");
        showBrightnessButton.addActionListener(this);
    	backButton = new JButton("Back");
    	backButton.addActionListener(this);
        
        brightnessPanel.setBackground(Color.gray);
        brightnessPanel.setLayout(null);
        
        brightnesslabel.setText("Enter f (must be between 0 and 1): ");
        brightnesslabel.setBounds(30, 100, 300, 50);
        brightnesslabel.setForeground(Color.BLACK);
        brightnesslabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        
        brightnessTextField.setPreferredSize(new Dimension(250, 50));
        brightnessTextField.setFont(new Font("Consolas", Font.PLAIN,35));
        brightnessTextField.setBounds(330, 105, 300, 40);
        
        showBrightnessButton.setBounds(450, 200, 100, 40);
        backButton.setBounds(150, 200, 100, 40);
        
        brightnessPanel.add(showBrightnessButton);
        brightnessPanel.add(backButton);
        brightnessPanel.add(brightnessTextField);
        brightnessPanel.add(brightnesslabel);
        this.add(brightnessPanel);
    }
    
    public void resizePanel(){
        JPanel resizePanel = new JPanel();
        resizePanel.setBackground(Color.gray);
        resizePanel.setLayout(null);
        
        JLabel resizeLabel = new JLabel();
        JLabel widthLabel = new JLabel();
        JLabel heightLabel = new JLabel();
        
        widthTextField = new JTextField();
        heightTextField = new JTextField();
        
        showResizeButton = new JButton("Show Result");
        showResizeButton.addActionListener(this);
    	backButton = new JButton("Back");
    	backButton.addActionListener(this);
    	
    	resizeLabel.setText("Resize Section");
    	resizeLabel.setBounds(250, 50, 300, 50);
    	resizeLabel.setForeground(Color.BLACK);
    	resizeLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
    	
    	widthLabel.setText("Width");
    	widthLabel.setBounds(100, 100, 300, 50);
    	widthLabel.setForeground(Color.BLACK);
    	widthLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
    	
    	heightLabel.setText("Height");
    	heightLabel.setBounds(100, 150, 300, 50);
    	heightLabel.setForeground(Color.BLACK);
    	heightLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));	
    	
    	widthTextField.setPreferredSize(new Dimension(250, 50));
    	widthTextField.setFont(new Font("Consolas", Font.PLAIN,35));
    	widthTextField.setBounds(240, 105, 300, 40);
    	
    	heightTextField.setPreferredSize(new Dimension(250, 50));
    	heightTextField.setFont(new Font("Consolas", Font.PLAIN,35));
    	heightTextField.setBounds(240, 155, 300, 40);
    	
    	showResizeButton.setBounds(450, 200, 150, 40);
        backButton.setBounds(150, 200, 100, 40);
        
        resizePanel.add(resizeLabel);
    	resizePanel.add(widthLabel);
    	resizePanel.add(heightLabel);
    	resizePanel.add(showResizeButton);
    	resizePanel.add(backButton);
    	resizePanel.add(widthTextField);
    	resizePanel.add(heightTextField);
        this.add(resizePanel);
    }
    
    
    public void showBrightnessImage(float f) throws IOException{
        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel();

        BufferedImage originalImage = ImageIO.read(new File(filePath));
        BufferedImage adjustedImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), originalImage.getType());
        Graphics2D g2d = adjustedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, null);
        g2d.dispose();
        
        for (int i = 0; i < adjustedImage.getWidth(); i++) {
            for (int j = 0; j < adjustedImage.getHeight(); j++) {
                int rgb[] = adjustedImage.getRaster().getPixel(i, j, new int[3]);
                int red = (int) Truncate(rgb[0] + (f * 255));
                int green = (int) Truncate(rgb[1] + (f * 255));
                int blue = (int) Truncate(rgb[2] + (f * 255));
                int arr[] = { red, green, blue };
                adjustedImage.getRaster().setPixel(i, j, arr);
            }
        }
        
        tempFrame.setTitle("Adjusted Image");
        tempFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tempFrame.setSize(originalImage.getWidth(), originalImage.getHeight());
        
        JLabel adjustedLabel = new JLabel(new ImageIcon(adjustedImage));
        
        tempPanel.setSize(1800, 1000);
        tempPanel.add(adjustedLabel);
        tempFrame.setTitle("Image Viewer");
        tempFrame.setSize(1800, 1000);
        tempFrame.getContentPane().setBackground(Color.gray);
        tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tempFrame.setLayout(null);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);
        tempFrame.add(tempPanel);
        
    }
    public static float Truncate(float f) {
        if (f < 0) {
            f = 0;
        } else if (f > 255) {
            f = 255;
        }
        return f;
    }
    
    public void grayScaleImage(){
        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel();
        JLabel imageLabel;
        BufferedImage originalImage;
        BufferedImage grayscaleImage;

     // Load the original image
        try {
            originalImage = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
            return;
        }
        
     // Create a grayscale version of the image
        grayscaleImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        grayscaleImage.getGraphics().drawImage(originalImage, 0, 0, null);
        
     // Create a label to display the image
        imageLabel = new JLabel(new ImageIcon(originalImage));
        tempFrame.getContentPane().add(imageLabel, BorderLayout.CENTER);if (imageLabel.getIcon() instanceof ImageIcon) {
            ImageIcon icon = (ImageIcon) imageLabel.getIcon();
            BufferedImage image = icon.getImage() instanceof BufferedImage? (BufferedImage) icon.getImage() : null;
            if (image == originalImage) {
                imageLabel.setIcon(new ImageIcon(grayscaleImage));
            } else {
                imageLabel.setIcon(new ImageIcon(originalImage));
            }
        }
            
        tempPanel.setSize(1800, 1000);
        tempFrame.setTitle("Image Viewer");
        tempFrame.setSize(1800, 1000);
        tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);
        tempFrame.add(tempPanel);
    }

    
    public void showResizeImage(int w, int h) throws IOException{
        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel();
        BufferedImage originalImage = ImageIO.read(new File(filePath));

        BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, w, h, null);
        graphics2D.dispose();
        
        JLabel resizedLabel = new JLabel(new ImageIcon(resizedImage));
        tempFrame.getContentPane().add(resizedLabel, BorderLayout.CENTER);
               
        tempPanel.setSize(1800, 1000);
        tempFrame.setTitle("Image Viewer");
        tempFrame.setSize(1800, 1000);
        tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);
        tempFrame.add(tempPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == selectFileButton){
        	chooseFileImage();

        }else if(e.getSource() == showImageButton){
        	showOriginalImage();
        	
        }else if(e.getSource() == brightnessButton){
        	this.getContentPane().removeAll();
            this.brightnessPanel();
            this.revalidate();
            this.repaint();

        }else if(e.getSource() == showBrightnessButton){
        	float f = Float.valueOf(brightnessTextField.getText()).floatValue();
        	try {
				showBrightnessImage(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

        }else if(e.getSource() == backButton){
            this.getContentPane().removeAll();
            this.mainPanel();
            this.revalidate();
            this.repaint();
        }else if(e.getSource() == grayscaleButton){
        	grayScaleImage();

        }else if(e.getSource() == resizeButton){
        	this.getContentPane().removeAll();
            this.resizePanel();
            this.revalidate();
            this.repaint();

        }else if(e.getSource() == showResizeButton){
        	int w = Integer.parseInt(widthTextField.getText());
        	int h = Integer.parseInt(heightTextField.getText());
        	try {
				showResizeImage(w, h);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

        }else if(e.getSource() == closeButton){
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        
    }
}