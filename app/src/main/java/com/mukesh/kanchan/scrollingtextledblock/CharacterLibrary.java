package com.mukesh.kanchan.scrollingtextledblock;



class CharacterLibrary {

    private char [] data = {0,0,0,0,0,0,0,0};

    char [] setLetter(char let) {
        // 'Database for 5x5 letters'
        if (let == 'A') {
            data = new char []{0, 0B011100, 0B100010, 0B111110, 0B100010, 0B100010, 0, 0};
        } else if (let=='B') {
            data = new char [] {0, 0B111100, 0B100010, 0B111100, 0B100010, 0B111100, 0, 0};
        } else if (let=='C') {
            data = new char [] {0, 0B011110, 0B100000, 0B100000, 0B100000, 0B011110, 0, 0};
        } else if (let=='D') {
            data = new char [] {0, 0B111100, 0B100010, 0B100010, 0B100010, 0B111100, 0, 0};
        } else if (let=='E') {
            data = new char [] {0, 0B111110, 0B100000, 0B111000, 0B100000, 0B111110, 0, 0};
        } else if (let=='F') {
            data = new char [] {0, 0B111110, 0B100000, 0B111000, 0B100000, 0B100000, 0, 0};
        } else if (let=='G') {
            data = new char [] {0, 0B011110, 0B100000, 0B101110, 0B100010, 0B011100, 0, 0};
        } else if (let=='H') {
            data = new char [] {0, 0B100010, 0B100010, 0B111110, 0B100010, 0B100010, 0, 0};
        } else if (let=='I') {
            data = new char [] {0, 0B111110, 0B001000, 0B001000, 0B001000, 0B111110, 0, 0};
        } else if (let=='J') {
            data = new char [] {0, 0B000010, 0B000010, 0B000010, 0B100010, 0B011100, 0, 0};
        } else if (let=='K') {
            data = new char [] {0, 0B100010, 0B100100, 0B111000, 0B100100, 0B100010, 0, 0};
        } else if (let=='L') {
            data = new char [] {0, 0B100000, 0B100000, 0B100000, 0B100000, 0B111110, 0, 0};
        } else if (let=='M') {
            data = new char [] {0, 0B100010, 0B110110, 0B101010, 0B100010, 0B100010, 0, 0};
        } else if (let=='N') {
            data = new char [] {0, 0B100010, 0B110010, 0B101010, 0B100110, 0B100010, 0, 0};
        } else if (let=='O') {
            data = new char [] {0, 0B011100, 0B100010, 0B100010, 0B100010, 0B011100, 0, 0};
        } else if (let=='P') {
            data = new char [] {0, 0B111100, 0B100010, 0B111100, 0B100000, 0B100000, 0, 0};
        } else if (let=='Q') {
            data = new char [] {0, 0B011100, 0B100010, 0B101010, 0B100100, 0B011010, 0, 0};
        } else if (let=='R') {
            data = new char [] {0, 0B111100, 0B100010, 0B111100, 0B100010, 0B100010, 0, 0};
        } else if (let=='S') {
            data = new char [] {0, 0B011110, 0B100000, 0B011100, 0B000010, 0B111100, 0, 0};
        } else if (let=='T') {
            data = new char [] {0, 0B111110, 0B001000, 0B001000, 0B001000, 0B001000, 0, 0};
        } else if (let=='U') {
            data = new char [] {0, 0B100010, 0B100010, 0B100010, 0B100010, 0B011100, 0, 0};
        } else if (let=='V') {
            data = new char [] {0, 0B100010, 0B100010, 0B100010, 0B010100, 0B001000, 0, 0};
        } else if (let=='W') {
            data = new char [] {0, 0B100010, 0B100010, 0B101010, 0B110110, 0B100010, 0, 0};
        } else if (let=='X') {
            data = new char [] {0, 0B100010, 0B010100, 0B001000, 0B010100, 0B100010, 0, 0};
        } else if (let=='Y') {
            data = new char [] {0, 0B100010, 0B010100, 0B001000, 0B001000, 0B001000, 0, 0};
        } else if (let=='Z') {
            data = new char [] {0, 0B111110, 0B000100, 0B001000, 0B010000, 0B111110, 0, 0};
        } else if (let=='!') {
            data = new char [] {0, 0B001000, 0B001000, 0B001000, 0B000000, 0B001000, 0, 0};
        } else if (let=='?') {
            data = new char [] {0, 0B011100, 0B100010, 0B001100, 0B000000, 0B001000, 0, 0};
        } else if (let==' ') {
            data = new char[]{0, 0, 0, 0, 0, 0, 0, 0};
        }
        return data;
    }

    char[] setLetterR(char let) {
        // 'Database for 5x5 letters'
        if (let == 'A') {
            data = new char []{0,0,0B111100,0B001010,0B001010,0B001010,0B111100,0};
        } else if (let=='B') {
            data = new char [] {0,0,0B111110,0B101010,0B101010,0B101010,0B010100,0};
        } else if (let=='C') {
            data = new char [] {0,0,0B011100,0B100010,0B100010,0B100010,0B100010,0};
        } else if (let=='D') {
            data = new char [] {0,0,0B111110,0B100010,0B100010,0B100010,0B011100,0};
        } else if (let=='E') {
            data = new char [] {0,0,0B111110,0B101010,0B101010,0B100010,0B100010,0};
        } else if (let=='F') {
            data = new char [] {0,0,0B111110,0B001010,0B001010,0B000010,0B000010,0};
        } else if (let=='G') {
            data = new char [] {0,0,0B011100,0B100010,0B101010,0B101010,0B011010,0};
        } else if (let=='H') {
            data = new char [] {0,0,0B111110,0B001000,0B001000,0B001000,0B111110,0};
        } else if (let=='I') {
            data = new char [] {0,0,0B100010,0B100010,0B111110,0B100010,0B100010,0};
        } else if (let=='J') {
            data = new char [] {0,0,0B010000,0B100000,0B100000,0B100000,0B011110,0};
        } else if (let=='K') {
            data = new char [] {0,0,0B111110,0B001000,0B001000,0B010100,0B100010,0};
        } else if (let=='L') {
            data = new char [] {0,0,0B111110,0B100000,0B100000,0B100000,0B100000,0};
        } else if (let=='M') {
            data = new char [] {0,0,0B111110,0B000100,0B001000,0B000100,0B111110,0};
        } else if (let=='N') {
            data = new char [] {0,0,0B111110,0B000100,0B001000,0B010000,0B111110,0};
        } else if (let=='O') {
            data = new char [] {0,0,0B011100,0B100010,0B100010,0B100010,0B011100,0};
        } else if (let=='P') {
            data = new char [] {0,0,0B111110,0B001010,0B001010,0B001010,0B000100,0};
        } else if (let=='Q') {
            data = new char [] {0,0,0B011100,0B100010,0B101010,0B010010,0B101100,0};
        } else if (let=='R') {
            data = new char [] {0,0,0B111110,0B001010,0B001010,0B001010,0B110100,0};
        } else if (let=='S') {
            data = new char [] {0,0,0B100100,0B101010,0B101010,0B101010,0B010010,0};
        } else if (let=='T') {
            data = new char [] {0,0,0B000010,0B000010,0B111110,0B000010,0B000010,0};
        } else if (let=='U') {
            data = new char [] {0,0,0B011110,0B100000,0B100000,0B100000,0B011110,0};
        } else if (let=='V') {
            data = new char [] {0,0,0B001110,0B010000,0B100000,0B010000,0B001110,0};
        } else if (let=='W') {
            data = new char [] {0,0,0B111110,0B010000,0B001000,0B010000,0B111110,0};
        } else if (let=='X') {
            data = new char [] {0,0,0B100010,0B010100,0B001000,0B010100,0B100010,0};
        } else if (let=='Y') {
            data = new char [] {0,0,0B000010,0B000100,0B111000,0B000100,0B000010,0};
        } else if (let=='Z') {
            data = new char [] {0,0,0B100010,0B110010,0B101010,0B100110,0B100010,0};
        } else if (let=='!') {
            data = new char [] {0,0,0B000000,0B000000,0B101110,0B000000,0B000000,0};
        } else if (let=='?') {
            data = new char [] {0,0,0B000100,0B000010,0B101010,0B001010,0B000100,0};
        } else if (let==' ') {
            data = new char[]{0,0,0,0,0,0,0,0};
        }
        return data;
    }


    char[] setNumber(int num) {
        // 'Database for 5x5 numbers'

        if (num == 0)
            data = new char [] {0, 0B011100, 0B100110, 0B101010, 0B110010, 0B011100, 0, 0};
        else if (num == 1)
            data = new char [] {0, 0B111000, 0B001000, 0B001000, 0B001000, 0B111110, 0, 0};
        else if (num == 2)
            data = new char [] {0, 0B111100, 0B000010, 0B011100, 0B100000, 0B111110, 0, 0};
        else if (num == 3)
            data = new char [] {0, 0B111100, 0B000010, 0B001100, 0B000010, 0B111100, 0, 0};
        else if (num == 4)
            data = new char [] {0, 0B100100, 0B100100, 0B100100, 0B111110, 0B000100, 0, 0};
        else if (num == 5)
            data = new char [] {0, 0B111110, 0B100000, 0B111100, 0B000010, 0B111100, 0, 0};
        else if (num == 6)
            data = new char [] {0, 0B011110, 0B100000, 0B111100, 0B100010, 0B011100, 0, 0};
        else if (num == 7)
            data = new char [] {0, 0B111110, 0B000010, 0B000100, 0B001000, 0B001000, 0, 0};
        else if (num == 8)
            data = new char [] {0, 0B011100, 0B100010, 0B011100, 0B100010, 0B011100, 0, 0};
        else if (num == 9)
            data = new char [] {0, 0B011100, 0B100010, 0B011110, 0B000010, 0B111100, 0, 0};
        return data;
    }

    char[] setNumberR(int num) {
        // 'Database for 5x5 numbers'

        if (num == 0)
            data = new char [] {0, 0, 0B011100,	0B110010, 0B101010, 0B100110, 0B011100,	0};
        else if (num == 1)
            data = new char [] {0, 0, 0B100010,	0B100010, 0B111110, 0B100000, 0B100000,	0};
        else if (num == 2)
            data = new char [] {0, 0, 0B110010,	0B101010, 0B101010, 0B101010, 0B100100,	0};
        else if (num == 3)
            data = new char [] {0, 0, 0B100010,	0B100010, 0B101010, 0B101010, 0B010100,	0};
        else if (num == 4)
            data = new char [] {0, 0, 0B011110,	0B010000, 0B010000, 0B111110, 0B010000,	0};
        else if (num == 5)
            data = new char [] {0, 0, 0B101110,	0B101010, 0B101010, 0B101010, 0B010010,	0};
        else if (num == 6)
            data = new char [] {0, 0, 0B011100,	0B101010, 0B101010, 0B101010, 0B010010,	0};
        else if (num == 7)
            data = new char [] {0, 0, 0B000010,	0B000010, 0B110010, 0B001010, 0B000110,	0};
        else if (num == 8)
            data = new char [] {0, 0, 0B010100,	0B101010, 0B101010, 0B101010, 0B010100,	0};
        else if (num == 9)
            data = new char [] {0, 0, 0B100100,	0B101010, 0B101010, 0B101010, 0B010100,	0};
        return data;
    }

    char[] setDiceNumber(int num) {
        // 'Database for 5x5 Dice numbers'

        if (num == 1)
            data = new char [] {0,0B00000000,0B00000000,0B00011000,0B00011000,0B00000000,0B00000000,0};
        else if (num == 2)
            data = new char [] {0,0B00000110,0B00000110,0B00000000,0B00000000,0B01100000,0B01100000,0};
        else if (num == 3)
            data = new char [] {0,0B00000011,0B00000011,0B00011000,0B00011000,0B11000000,0B11000000,0};
        else if (num == 4)
            data = new char [] {0,0B01100110,0B01100110,0B00000000,0B00000000,0B01100110,0B01100110,0};
        else if (num == 5)
            data = new char [] {0,0B11000011,0B11000011,0B00011000,0B00011000,0B11000011,0B11000011,0};
        else if (num == 6)
            data = new char [] {0,0B11011011,0B11011011,0B00000000,0B00000000,0B11011011,0B11011011,0};
        return data;
    }

}
