package com.mukesh.kanchan.scrollingtextledblock;

import android.util.Log;

import net.calit2.mooc.iot_db410c.db410c_gpiolib.GpioProcessor;
import net.calit2.mooc.iot_db410c.db410c_gpiolib.GpioProcessor.Gpio;
import java.util.Arrays;



class LEDProcessor {

    private final static char NO_OP=0x0000;
    private final static char OP_DIGIT0 = 0x0100;
    private final static char OP_DIGIT1 = 0x0200;
    private final static char OP_DIGIT2 = 0x0300;
    private final static char OP_DIGIT3 = 0x0400;
    private final static char OP_DIGIT4 = 0x0500;
    private final static char OP_DIGIT5 = 0x0600;
    private final static char OP_DIGIT6 = 0x0700;
    private final static char OP_DIGIT7 = 0x0800;
    private final static char OP_INTENSITY = 0x0A00;
    private final static char OP_SCANLIMIT = 0x0B00;
    private final static char OP_SHUTDOWN = 0x0C00;
    private static final String TAG = "LEDProcessor";

    private Gpio DIN;
    private Gpio CS;
    private Gpio CLK;
    private char[] data;
    private int numOfDevices;


    private char [][] status;
    private char [] intensityStatus;
    private char [] shutdownStatus;
    private char [] scanStatus;

    private int TOTAL;

    private CharacterLibrary character;

    LEDProcessor(int devices) {

        //Constructor
        //ScanLimit set to 7
        //Intensity set to 5 out of 0:15
        //Uses GPIOs 23, 24 25 as DIN, CS, and CLK respectively

        char scanlimit = (char) 7;
        char intensity = (char) 5;
        numOfDevices = devices;
        data = new char[numOfDevices];
        TOTAL = 0xFF;

        //shutdownStatus = new char []{'0', '0', '0', '0', '0', '0', '0', '0'};
        //scanStatus = new char[]{'0', '0', '0', '0', '0', '0', '0', '0'};
        //intensityStatus = new char[]{'0', '0', '0', '0', '0', '0', '0', '0'};
        status = new char[][]{{'0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0'}};

        GpioProcessor gpioProcessor = new GpioProcessor();
        DIN = gpioProcessor.getPin23();
        CS = gpioProcessor.getPin24();
        CLK = gpioProcessor.getPin25();
        DIN.out();
        CS.out();
        CLK.out();

        Log.v(TAG,"Shutdown...");
        for (int i=0; i<numOfDevices; i++)
            shutDown((char) 1, i+1);
        Log.v(TAG,"Scanlimit...");
        for (int i=0; i<numOfDevices; i++)
            setScanLimit(scanlimit,i+1);
        Log.v(TAG,"Intensity...");
        for (int i=0; i<numOfDevices; i++)
            setIntensity(intensity,i+1);
        clearDisplays();

        character = new CharacterLibrary();
        Log.v(TAG,"Initialization done...");

    }

    private void shutDown(char dataCode, int  device) {
        // 'Brings the block into power saving mode.'
        createInstruction(device, OP_SHUTDOWN, dataCode);
        transferInstruction(data);

    }

    private void createInstruction(int device, char opCode, char dataCode) {
        // 'Create an instruction'

        data[device-1] = (char) (opCode | dataCode);


    }

    private void transferInstruction(char[] instruction) {
        //'Shifts in the instructions'
        // int hex = (int) instruction[0];
        //System.out.println("Instruction:-----------------:"+ hex + " <> " + instruction[0]);
        Log.v(TAG,"transferInstruction:0>>"+Integer.toHexString(instruction[0]));
        Log.v(TAG,"transferInstruction:1>>>"+Integer.toHexString(instruction[1]));

        DIN.low();
        CLK.low();
        CS.low();
/*
        for (int j=0; j<numOfDevices; j++) {
            char bitmask = 0x8000;
            for (int i=0; i<16; i++) {
                CLK.low();
                if ((char)(instruction[j] & bitmask) == bitmask) {
                    DIN.high();
                } else {
                    DIN.low();
                }
                CLK.high();
                bitmask = (char) (bitmask >> 1);
            }
        }
*/
        for (int j=numOfDevices-1; j>=0; j--) {
            char bitmask = 0x8000;
            for (int i=15; i>=0; i--) {
                CLK.low();
                if ((char)(instruction[j] & bitmask) == bitmask) {
                    DIN.high();
                } else {
                    DIN.low();
                }
                CLK.high();
                bitmask = (char) (bitmask >> 1);
            }
        }
        CS.high();

    }

    private void setScanLimit(char dataCode, int device) {
        //The limit should be an integer: 0-7.'
        createInstruction(device, OP_SCANLIMIT, dataCode);
        transferInstruction(data);
    }

    private void setIntensity(char dataCode, int device) {
        //'Sets intensity of LED. min: 0  --- max : 15'
        createInstruction(device, OP_INTENSITY, dataCode);
        transferInstruction(data);
    }

    private void clearDisplay(int device) {
        //'Clears the Display choosen'
        for (int i=1; i<9; i++)
            setRow(i,(char)0,device);
    }

    public void clearDisplays() {
        //Clears all of the Displays'
        for (int i=0; i<numOfDevices; i++)
            clearDisplay(i+1);
    }
    private void setLED(int row, int col, boolean value, int device) {
        //'Choose row and column of LED to turn on or off, with TRUE or FALSE'
        int tData = (int) Math.pow(2, (8-col));
        Log.v(TAG,"tData:"+tData);
        if (value) {
            tData = tData | status[row-1][device-1];
        } else {
            tData = TOTAL - tData;
            tData = tData & status[row-1][device-1];
        }
        setRow(row, (char)tData, device);
    }

    private void setRow(int row, char dataCode, int device) {
        //'Choose row 1-8 and send data for LEDs in that row'
        status[row-1][device-1] = dataCode;
        char opCode;
        switch (row-1){
            case 0: opCode = OP_DIGIT0;
                break;
            case 1: opCode = OP_DIGIT1;
                break;
            case 2: opCode = OP_DIGIT2;
                break;
            case 3: opCode = OP_DIGIT3;
                break;
            case 4: opCode = OP_DIGIT4;
                break;
            case 5: opCode = OP_DIGIT5;
                break;
            case 6: opCode = OP_DIGIT6;
                break;
            case 7: opCode = OP_DIGIT7;
                break;
            default: opCode = NO_OP;
                break;
        }
        createInstruction(device, opCode, dataCode);
        transferInstruction(data);
    }

    void printLetter(char letter, boolean rotate, int device) {
        //'Displays the given letter'
        letter = Character.toUpperCase(letter);
        char [] let;
        if (rotate)
            let = character.setLetterR(letter);
        else
            let = character.setLetter(letter);
        for (int i=0; i<8; i++) {
            Log.v(TAG,"let[i]:"+let[i]);
            setRow(i + 1, let[i], device);
        }
    }

    void printNumber(char number, int device) {
        //'Displays the given number'
        char [] num = character.setNumber(Character.getNumericValue(number));
        for (int i=0; i<8; i++) {
            setRow(i + 1, num[i], device);
        }
    }

    void  printDice(int number, int device) {
        //'Displays the given dice number'
        char [] num = character.setDiceNumber(number);
        for (int i=0; i<8; i++) {
            setRow(i + 1, num[i], device);
        }
    }

    void sixtyFour(int device) {
        //'Lights up each of the 64 LEDs individually'
        int tData;
        for (int i=1; i<9; i++) {
            for (int j=0; j<8; j++) {
                tData = (int)Math.pow(2, (7-j));
                setRow(i, (char)tData, device);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setRow(i, (char)0, device);
            }
        }
    }

    void diagonal(int device) {
        //'Lights up a wave around the diagonal'
        for (int j=0; j<1; j++) {
            char a = 0B1;
            for (int i=1; i<9; i++) {
                setRow(i, a, device);
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setRow(i, (char)0, device);
                a = (char) (a << 1);
                a = (char) (a + 1);
            }
            a = 0B10000000;
            for (int i=1; i<9; i++) {
                setRow(9-i, a, device);
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setRow(9-i, (char)0, device);
                a = (char) (a >> 1);
                a = (char)(a + 0B10000000);
            }
        }
    }


    void swirl(int device) {
        //'Lights up the Leds in a clockwise swirl pattern'
        long Time = 25;
        for (int i=1; i<5; i++) {
            for (int j = i; j < 10 - i; j++) {
                setLED(i, j, true, device);
                try {
                    Thread.sleep(Time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (i < 4) {
                for (int j = i + 1; j < 9 - i; j++) {
                    setLED(j, 9 - i, true, device);
                    try {
                        Thread.sleep(Time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            for (int j = i; j < 10 - i; j++) {
                setLED(9 - i, 9 - j, true, device);
                try {
                    Thread.sleep(Time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (i < 4) {
                for (int j = i + 1; j < 9 - i; j++) {
                    setLED(9 - j, i, true, device);
                    try {
                        Thread.sleep(Time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clearDisplay(device);
    }

    void  allOnOff(int device) {
        //'Turns all LEDs on one by one and then off'
        Log.v(TAG,"ALL ON OFF");
        boolean [] listvalue = {true, false};
        for (boolean k: listvalue) {
            for (int i=1; i<9; i++) {
                for (int j=1; j<9; j++) {
                    setLED(i,j,k, device);
                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }


}

