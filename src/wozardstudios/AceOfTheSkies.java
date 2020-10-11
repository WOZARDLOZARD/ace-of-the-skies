/*

╔═══╗────── ────╔═╗─ ╔╗╔╗───── ╔═══╦╗
║╔═╗║────── ────║╔╝ ╔╝╚╣║───── ║╔═╗║║
║║─║╠══╦══╗ ╔══╦╝╚╗ ╚╗╔╣╚═╦══╗ ║╚══╣║╔╦╦══╦══╗
║╚═╝║╔═╣║═╣ ║╔╗╠╗╔╝─ ║║║╔╗║║═╣ ╚══╗║╚╝╬╣║═╣══╣
║╔═╗║╚═╣║═╣ ║╚╝║║║── ║╚╣║║║║═╣ ║╚═╝║╔╗╣║║═╬══║
╚╝─╚╩══╩══╝ ╚══╝╚╝── ╚═╩╝╚╩══╝ ╚═══╩╝╚╩╩══╩══╝

By: Jeremy Liu (Wozard Studios)

 */

package wozardstudios;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;
import processing.core.PFont;

import ddf.minim.Minim;
import ddf.minim.AudioPlayer;

public class AceOfTheSkies extends PApplet {
    // public static Client client = new Client();

    public static PApplet processing;
    public static Minim minim;
    public static AudioPlayer audioPlayer;

    public static void main(String[] args) {
        // client.start(3);

        PApplet.main("wozardstudios.AceOfTheSkies", args);
    }

    PFont font;

    HomePage homePage;
    GameSelect gameSelect;
    Game game;
    Player player;
    GameOver gameOver;

    public static int[] bgColor = {30, 160, 200};

    public static int i, j;

    public static Scanner scanner;
    public static String password;

    public static int launchTime;

    public static BufferedReader reader;
    public static BufferedWriter writer;

    public static String highScore;

    public static int gameState;
    public static int transparency, textTransparency, buttonTransparency;
    public static boolean transitioning;

    public static int startText, startTextSpeed;
    public static int birdY, birdSpeed;

    public static int mode;

    public static int loadTime;
    public static String[] tips = {
            "Remember to take occasional breaks!",
            "1, 2, and 4 player gamemodes are supported.",
            "In 1 player mode, the game is over as soon as you hit an obstacle!",
            "In multiplayer modes, the game is over for you if you go off the screen!",
            "In 1 player mode, press W, the up arrow key, and the space bar to jump.",
            "In 2 player mode, press W and the up arrow key to jump, respectively.",
            "In 4 player mode, press W, P, X, and the up arrow key to jump, respectively.",
            "In 1 player mode, left click for endless mode and right click for\nadventure mode!",
            "Adventure mode offers many new obstacles, including meteors, lasers, and a\nfinal boss!",
            "Highscores will only be recorded in 1 player modes."
    };
    public static int randomTip;

    public static boolean gameStarted;

    public static float[] blockX, blockY1, blockY2;
    public static int blockSpeed;
    public static int blockIndex, meteorIndex;
    public static float[] meteorX, meteorY, meteorSize;
    public static ArrayList<Float> meteorTrailX, meteorTrailY, meteorTrailSize, meteorTrailTransparency;
    public static float[] laserY;
    public static int laserTime;
    public static float laserPercent;
    public static float wallX, wallSpeed;
    public static int wallTimer;
    public static float[] boostX, boostY;
    public static boolean[] boostPicked;
    public static int boostSpeed, boostIndex;

    public static PVector gravity = new PVector(0, 0);
    public static PVector gravity1 = new PVector(0, 0), gravity2 = new PVector(0, 0), gravity3 = new PVector(0, 0), gravity4 = new PVector(0, 0);
    public static PVector pLocation, pVelocity = new PVector(0, 0);
    public static ArrayList<Float> pTrailX, pTrailY, pTrailWing, pTrailTransparency;
    public static boolean pAlive;
    public static int pJumps, pTimer, pSeconds, pMinutes;
    public static String pSecondString;
    public static int pExplode;
    public static float pWing, pWingSpeed;
    public static boolean pJumping;
    public static int pScore;
    public static PVector[] pLocations;
    public static PVector[] pVelocities = {new PVector(0, 0), new PVector(0, 0), new PVector(0, 0), new PVector(0, 0)};
    public static float[] pWings, pWingSpeeds;
    public static boolean[] pJumpings, pFlappings;
    public static PVector p1Location, p2Location, p3Location, p4Location;
    public static PVector p1Velocity = new PVector(0, 0), p2Velocity = new PVector(0, 0), p3Velocity = new PVector(0, 0), p4Velocity = new PVector(0, 0);
    public static float p1Wing, p2Wing, p3Wing, p4Wing, p1WingSpeed, p2WingSpeed, p3WingSpeed, p4WingSpeed;
    public static boolean p1Jumping, p2Jumping, p3Jumping, p4Jumping, p1Flapping, p2Flapping, p3Flapping, p4Flapping;

    public void setup() {
        processing = this;

        minim = new Minim(this);

        frameRate(60);

        font = createFont("wozardstudios/CaviarDreams.ttf", 20);
        textFont(font);

        audioPlayer = minim.loadFile("wozardstudios/Music.mp3", 1024);

        try {
            AceOfTheSkies.reader = new BufferedReader(new FileReader("src/wozardstudios/HighScores.txt"));
            AceOfTheSkies.writer = new BufferedWriter(new FileWriter("src/wozardstudios/HighScores.txt", true));

            AceOfTheSkies.highScore = AceOfTheSkies.reader.readLine();
            AceOfTheSkies.reader.close();

            if (AceOfTheSkies.highScore == null) {
                AceOfTheSkies.writer.write("0");
                AceOfTheSkies.writer.close();

                AceOfTheSkies.reader = new BufferedReader(new FileReader("src/wozardstudios/HighScores.txt"));
                AceOfTheSkies.highScore = AceOfTheSkies.reader.readLine();
                AceOfTheSkies.reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void settings() {
        size(900, 700);
        smooth();

        homePage = new HomePage();
        gameSelect = new GameSelect();
        game = new Game();
        player = new Player();
        gameOver = new GameOver();

        gameState = 0;
        transparency = 225;
        transitioning = false;
    }

    public void draw() {
        background(bgColor[0], bgColor[1], bgColor[2]);

        if (gameState == 0) {
            homePage.display();

            if (!transitioning) {
                homePage.fadeIn();
            } else {
                homePage.fadeOut();
            }
        } else if (gameState == 1) {
            gameSelect.display();

            if (transparency == 0) {
                gameSelect.selectMode();
            }

            if (transitioning) {
                gameSelect.fadeIn();
            }
        } else if (gameState == 2) {
            gameSelect.display();
            gameSelect.fadeOut();

            if (loadTime <= 240) game.load();
        } else if (gameState == 3 || gameState == 4 || gameState == 5) {
            if (gameStarted) {
                game.playMusic();

                game.updateObstacles();
                game.updateDifficulty();
            }

            if (gameState == 4 || gameState == 5) {
                game.splitScreen();
            }

            game.displayObstacles();

            player.display();
            player.update();

            game.displayStats();

            if (transitioning) {
                game.fadeIn();
            }
        } else if (gameState == 6) {
            gameOver.display();

            if (pExplode == 0 && !transitioning) {
                gameOver.selectOption();
            }

            if (pExplode > 0) {
                gameOver.fadeIn();
            } else if (transitioning) {
                gameOver.fadeOut();
            }
        }
    }

    public void mouseReleased() {
        if (gameState == 0 && transparency == 0) {
            homePage.click();
        } else if (gameState == 1 && transparency == 0) {
            gameSelect.click();
        } else if (gameState == 3 && pJumping) {
            pJumping = false;
        } else if (gameState == 6 && transparency == 0) {
            gameOver.click();
        }
    }

    public void mousePressed() {
        if (gameState == 3 && !pJumping && pAlive) {
            player.jump();
        }
    }

    public void keyPressed() {
        if (gameState == 3 && !pJumping && pAlive) {
            if (keyCode == 32 || key == 'w' || key == 'W' || keyCode == UP) {
                player.jump();
            }
        } else if (gameState == 4) {
            if (!p1Jumping) {
                if (key == 'w' || key == 'W') {
                    player.jump();
                }
            }

            if (!p2Jumping) {
                if (keyCode == UP) {
                    player.jump();
                }
            }
        }
    }

    public void keyReleased() {
        if (gameState == 3 && pJumping) {
            if (keyCode == 32 || key == 'w' || key == 'W' || keyCode == ENTER || keyCode == RETURN || keyCode == SHIFT) {
                pJumping = false;
            }
        } else if (gameState == 4) {
            if (key == 'w' || key == 'W') {
                if (p1Jumping) {
                    p1Jumping = false;
                }
            }

            if (keyCode == UP) {
                if (p2Jumping) {
                    p2Jumping = false;
                }
            }
        }
    }

    public void start() {
        super.start();

        // client.launch(launchTime, (int) new Date().getTime());
    }

    public void exit() {
        super.exit();

        // client.exit();

        System.exit(0);
    }
}
