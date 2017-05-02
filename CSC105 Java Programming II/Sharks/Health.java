import greenfoot.*;
public class Health extends Actor
{
    public int barWidth = 100; // the width of the color portion of the bar
    public int barHeight = 10; // the height of the color portion of the bar
    public int breakPercent = 20; // the percentage amount that changes the color of the bar
    public int breakValue = 20; // in tandem with breakPercent
    public boolean usingBreakValue = false;
    public boolean breakLow = true; // when true, with low-percent values bar is dangerColor, else safeColor; reversed when false
    public Color backgroundColor = new Color(0, 0, 0, 0); // the background color of the entire object
    public Color textColor = Color.BLACK; // the color of all text and the frame of the bar itself
    public Color safeColor = Color.GREEN; // the color of the bar while in the safe range
    public Color dangerColor = Color.RED; // the color of the bar while in the danger range
//  The color of the bar AT the breakpoint will be the average color between the safe color and the danger color
    public float fontSize = 18.0f; // the size of the text
    public int value = 0; // the current value of the bar
    public int maximumValue = 0; // the maximum value of the bar
    public static int minimumValue = 0; // the minimum value of the bar
    public String referenceText = ""; // the title string (who or what the meter/bar is for)
    public String unitOfMeasure = ""; // the unit of measure of the bar (any quantitative standard of measurement) 
    public boolean showTextualUnits = true; // determines whether or not the textual quantity of the bar is to show   
    /**
     * Bar Constructor: saves the initial values that are brought in and creates the bar image through the 'add(int)' call,
     * which sets the initial value of the bar and calls the 'newImage' method to build and set a new image for the bar.
     *
     * @param 'refText': a text string to specify what the bar is for (be specific enough so that all bars can be distinguished one from another)
     * @param 'unitType': a text string to specify what measure is being used in the bar ("percentage", "points", "frames per second", or whatever)
     * @param 'initValue': the value the bar should be initially set to
     * @param 'maxValue': the highest value the bar is allowed to hold
     */
    
    public Health(String refText, String unitType, int initValue, int maxValue)
    {
        referenceText = refText;
        unitOfMeasure = unitType;
        maximumValue = maxValue;
        add(initValue);
    }
    public void newImage()
    {
        int barValue = (int) (barWidth * (value - minimumValue) / (maximumValue - minimumValue));
        GreenfootImage leftImg = new GreenfootImage(referenceText + " ", (int) fontSize, textColor, backgroundColor);
        GreenfootImage rightImg = (showTextualUnits) ? new GreenfootImage(" " + (value/10) + " " + unitOfMeasure, (int) fontSize, textColor, backgroundColor) : new GreenfootImage(1, 1);
        int maxX = (leftImg.getWidth() > rightImg.getWidth()) ? leftImg.getWidth() : rightImg.getWidth();
        GreenfootImage barImg = new GreenfootImage(barWidth + 4, barHeight + 4);
        barImg.setColor(backgroundColor);
        barImg.fill();
        barImg.setColor(textColor);
        barImg.drawRect(0, 0, barImg.getWidth() - 1, barImg.getHeight() - 1);
        if (value > minimumValue)
        {
            if (breakLow)
            {
                if (value > (usingBreakValue ? breakValue : (int) (breakPercent * (maximumValue - minimumValue) / 100 + minimumValue))) 
                barImg.setColor(safeColor);
                else barImg.setColor(dangerColor);
            }
            else
            {
                if (value < (usingBreakValue ? breakValue : (int) (breakPercent * (maximumValue - minimumValue) / 100 + minimumValue))) 
                barImg.setColor(safeColor);
                else barImg.setColor(dangerColor);
            }
            if (value == (usingBreakValue ? breakValue : (int) (breakPercent * (maximumValue - minimumValue) / 100 + minimumValue)))
            {
                int r = (int) ((safeColor.getRed() + dangerColor.getRed()) / 2);
                int g = (int) ((safeColor.getGreen() + dangerColor.getGreen()) / 2);
                int b = (int) ((safeColor.getBlue() + dangerColor.getBlue()) / 2);
                barImg.setColor(new Color(r, g, b));
            }
            barImg.fillRect(2, 2, barValue, barHeight);
        }
        int sumX = 2 * maxX + barImg.getWidth();
        int maxY = 0;
        if (leftImg.getHeight() > maxY) maxY = leftImg.getHeight();
        if (barImg.getHeight() > maxY) maxY = barImg.getHeight();
        if (rightImg.getHeight() > maxY) maxY = rightImg.getHeight();
        GreenfootImage image = new GreenfootImage(sumX, maxY);
        image.setColor(backgroundColor);
        image.fill();
        image.drawImage(leftImg, maxX - leftImg.getWidth(), (image.getHeight() - leftImg.getHeight()) / 2);
        image.drawImage(barImg, maxX, (image.getHeight() - barImg.getHeight()) / 2);
        image.drawImage(rightImg, maxX + barImg.getWidth(), (image.getHeight() - rightImg.getHeight()) / 2);
        setImage(image);
    }
    public void add(int amount)
    {
        value += amount;
        newImage();
    }
    public void subtract(int amount)
    {
        value -= amount;
        newImage();
    }
}
