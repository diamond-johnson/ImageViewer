# Image Viewer GUI

This Java Swing-based application provides a simple graphical user interface (GUI) for viewing and manipulating images. Users can select an image file, display it in a new window, resize it by specifying width and height, adjust its brightness with a scaling factor (between 0 and 1), and convert it to grayscale. The app uses a main panel with buttons to navigate to sub-panels for resize and brightness operations.

## Features
- **File Selection**: Use a file chooser to select image files (e.g., JPG, PNG).
- **Image Display**: View the original image in a resizable viewer window (scaled to fit 1400x800 by default).
- **Resize**: Enter custom width and height to generate and display a resized version of the image.
- **Brightness Adjustment**: Input a factor (0-1) to brighten/darken the image pixel-by-pixel (clamped to 0-255 RGB values).
- **Grayscale Conversion**: Convert the loaded image to grayscale and display it.
- **Navigation**: Back buttons to return to the main menu; exit button to close the app.
- **Default Image**: Hardcoded path to a sample image (`Girl.jpg`) for testing.

Note: The app assumes images are in a supported format (e.g., JPG). Brightness uses a simple pixel manipulation loop, and grayscale leverages `BufferedImage.TYPE_BYTE_GRAY`.

## Different parts
- Main Menu: Buttons for choosing image, showing, resizing, grayscale, brightness, and exit.
- Resize Panel: Input fields for width/height and buttons to show result or go back.
- Brightness Panel: Input field for factor and buttons to apply or go back.
- Image Viewer: Full-screen display of original, resized, brightened, or grayscale image.

## How It Works
1. **Main Panel**: Displays a grid of buttons for core actions. Clicking "Choose Image" opens a file chooser (defaults to a specific directory).
2. **Show Image**: Loads the selected file and displays it scaled in a new JFrame (1800x1000 window).
3. **Resize**:
   - Switches to a sub-panel with text fields for width/height.
   - On "Show Result", creates a new `BufferedImage` with the specified dimensions and draws the original image onto it using `Graphics2D`.
   - Displays the resized image in a new window.
4. **Brightness**:
   - Switches to a sub-panel with a text field for the factor `f` (e.g., 0.5 for half brightness).
   - On "Result", iterates over each pixel, adjusts RGB values by adding `f * 255` (clamped via `Truncate` method), and displays the modified image.
5. **Grayscale**:
   - Loads the image, creates a new `BufferedImage` in `TYPE_BYTE_GRAY` mode, draws the original onto it, and displays in a new window.
6. **Event Handling**: All buttons implement `ActionListener` to trigger methods like `chooseFileImage()`, `showOriginalImage()`, etc.
7. **Panel Switching**: Uses `removeAll()`, `add()`, `revalidate()`, and `repaint()` to dynamically change content.

The app uses absolute positioning (`setBounds()`) and null layouts for simplicity, with a gray background theme and custom fonts (e.g., MV Boli for labels).

## Building and Running
### Prerequisites
- Java Development Kit (JDK) 8 or later installed.
- An IDE like IntelliJ IDEA, Eclipse, or VS Code with Java extensions (optional; can use command line).
- Sample image file (e.g., `Girl.jpg`) at the hardcoded path `D:\\Amirkabir\\Java\\new java\\ImageViewer\\Girl.jpg` for default testing, or select any image via the chooser.

### Compilation
1. Save the code as `ImageViewerGUI.java` in a directory (e.g., `src/ImageViewer/`).
2. Open a terminal/command prompt in the source directory.
3. Compile:
   ```bash
   javac ImageViewer/ImageViewerGUI.java
   ```
   (Adjust path if needed; ensures the package ImageViewer matches the directory structure.)
4. Execution:
   Run the compiled class:
   ```bash
   java ImageViewer.ImageViewerGUI
   ```
   The GUI window (700x300) will open. Use buttons to interact.
   For custom images, click "Choose Image" and select a file.
5. Example Usage
   Select an image → Click "Show Image" to view.
   Click "Resize" → Enter width=500, height=300 → "Show Result" to see resized version.
   Click "Brightness" → Enter 0.8 → "Result" to brighten. 
   Click "Gray Scale" to convert and view in grayscale.
   Use "Back" to return to main menu; "Exit" to close.
