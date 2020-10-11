package wozardstudios;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import processing.core.PVector;

public class GameOver {
    void fadeIn() {
        if (AceOfTheSkies.bgColor[0] != 30) AceOfTheSkies.bgColor[0] = 30;
        if (AceOfTheSkies.bgColor[1] != 160) AceOfTheSkies.bgColor[1] = 160;
        if (AceOfTheSkies.bgColor[2] != 200) AceOfTheSkies.bgColor[2] = 200;

        if (AceOfTheSkies.pExplode > 0) {
            AceOfTheSkies.pExplode -= 3;

            AceOfTheSkies.processing.fill(255, 255, 255, AceOfTheSkies.pExplode);
            AceOfTheSkies.processing.rectMode(AceOfTheSkies.processing.CORNER);
            AceOfTheSkies.processing.rect(0, 0, AceOfTheSkies.processing.width, AceOfTheSkies.processing.height);
        }
    }

    void fadeOut() {
        if (AceOfTheSkies.transitioning) {
            if (AceOfTheSkies.transparency < 255) {
                AceOfTheSkies.transparency += 5;
            } else {
                if (AceOfTheSkies.mode == 0 || AceOfTheSkies.mode == 1) {
                    AceOfTheSkies.pScore = 0;

                    AceOfTheSkies.transitioning = false;

                    AceOfTheSkies.gameState = 2;
                } else if (AceOfTheSkies.mode == 2) {
                    AceOfTheSkies.gameState = 1;
                } else if (AceOfTheSkies.mode == 3) {
                    AceOfTheSkies.transitioning = false;

                    AceOfTheSkies.gameState = 0;
                }
            }
        }

        AceOfTheSkies.processing.fill(30, 160, 200, AceOfTheSkies.transparency);
        AceOfTheSkies.processing.noStroke();
        AceOfTheSkies.processing.rectMode(AceOfTheSkies.processing.CORNER);
        AceOfTheSkies.processing.rect(0, 0, AceOfTheSkies.processing.width, AceOfTheSkies.processing.height);
    }

    void display() {
        AceOfTheSkies.processing.fill(255);
        AceOfTheSkies.processing.noStroke();
        AceOfTheSkies.processing.textAlign(AceOfTheSkies.processing.CENTER, AceOfTheSkies.processing.CENTER);

        AceOfTheSkies.processing.textSize(50);
        AceOfTheSkies.processing.text("GAME OVER", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 - 250);

        if (AceOfTheSkies.mode == 0 || AceOfTheSkies.mode == 1) {
            AceOfTheSkies.processing.textSize(30);
            AceOfTheSkies.processing.text("Your score was: " + AceOfTheSkies.pScore, AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 - 170);

            if (AceOfTheSkies.pScore > Integer.parseInt(AceOfTheSkies.highScore)) {
                AceOfTheSkies.processing.textSize(26);
                AceOfTheSkies.processing.text("New record!", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 - 40);
            }
        }

        AceOfTheSkies.processing.textSize(30);

        AceOfTheSkies.processing.text("Restart", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 + 100);
        AceOfTheSkies.processing.text("Change mode", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 + 180);
        AceOfTheSkies.processing.text("Homepage", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 + 260);
    }

    void selectOption() {
        AceOfTheSkies.processing.noFill();
        AceOfTheSkies.processing.stroke(255, 255, 255, AceOfTheSkies.buttonTransparency);
        AceOfTheSkies.processing.strokeWeight(2);
        AceOfTheSkies.processing.rectMode(AceOfTheSkies.processing.CENTER);

        if (AceOfTheSkies.processing.mouseX > AceOfTheSkies.processing.width / 2 - 80 && AceOfTheSkies.processing.mouseX < AceOfTheSkies.processing.width / 2 + 80 && AceOfTheSkies.processing.mouseY > AceOfTheSkies.processing.height / 2 + 80 && AceOfTheSkies.processing.mouseY < AceOfTheSkies.processing.height / 2 + 120) {
            if (AceOfTheSkies.buttonTransparency < 255) AceOfTheSkies.buttonTransparency += 15;

            AceOfTheSkies.processing.rect(AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 + 105, 160, 40);
        } else if (AceOfTheSkies.processing.mouseX > AceOfTheSkies.processing.width / 2 - 100 && AceOfTheSkies.processing.mouseX < AceOfTheSkies.processing.width / 2 + 100 && AceOfTheSkies.processing.mouseY > AceOfTheSkies.processing.height / 2 + 160 && AceOfTheSkies.processing.mouseY < AceOfTheSkies.processing.height / 2 + 200) {
            if (AceOfTheSkies.buttonTransparency < 255) AceOfTheSkies.buttonTransparency += 15;

            AceOfTheSkies.processing.rect(AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 + 185, 200, 40);
        } else if (AceOfTheSkies.processing.mouseX > AceOfTheSkies.processing.width / 2 - 80 && AceOfTheSkies.processing.mouseX < AceOfTheSkies.processing.width / 2 + 80 && AceOfTheSkies.processing.mouseY > AceOfTheSkies.processing.height / 2 + 240 && AceOfTheSkies.processing.mouseY < AceOfTheSkies.processing.height / 2 + 280) {
            if (AceOfTheSkies.buttonTransparency < 255) AceOfTheSkies.buttonTransparency += 15;

            AceOfTheSkies.processing.rect(AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 + 265, 160, 40);
        } else {
            if (AceOfTheSkies.buttonTransparency != 0) AceOfTheSkies.buttonTransparency = 0;
        }

        AceOfTheSkies.processing.noStroke();
    }

    void click() {
        if (AceOfTheSkies.processing.mouseX > AceOfTheSkies.processing.width / 2 - 80 && AceOfTheSkies.processing.mouseX < AceOfTheSkies.processing.width / 2 + 80 && AceOfTheSkies.processing.mouseY > AceOfTheSkies.processing.height / 2 + 80 && AceOfTheSkies.processing.mouseY < AceOfTheSkies.processing.height / 2 + 120) {
            AceOfTheSkies.buttonTransparency = 0;

            AceOfTheSkies.transitioning = true;

            AceOfTheSkies.blockIndex = 0;
            AceOfTheSkies.loadTime = 0;
            AceOfTheSkies.textTransparency = 0;
            AceOfTheSkies.randomTip = AceOfTheSkies.processing.floor(AceOfTheSkies.processing.random(AceOfTheSkies.tips.length));

            if (AceOfTheSkies.mode == 0 || AceOfTheSkies.mode == 1) {
                if (AceOfTheSkies.pScore > Integer.parseInt(AceOfTheSkies.highScore)) {
                    try {
                        new FileWriter("src/wozardstudios/HighScores.txt", false).close();

                        AceOfTheSkies.reader = new BufferedReader(new FileReader("src/wozardstudios/HighScores.txt"));
                        AceOfTheSkies.writer = new BufferedWriter(new FileWriter("src/wozardstudios/HighScores.txt", true));

                        AceOfTheSkies.writer.write(String.valueOf(AceOfTheSkies.pScore));
                        AceOfTheSkies.writer.close();
                        AceOfTheSkies.highScore = AceOfTheSkies.reader.readLine();
                        AceOfTheSkies.reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                AceOfTheSkies.audioPlayer.rewind();

                AceOfTheSkies.gameStarted = false;

                AceOfTheSkies.pAlive = true;
                AceOfTheSkies.pJumping = false;
                AceOfTheSkies.pJumps = 0;
                AceOfTheSkies.pWing = 0;
                AceOfTheSkies.pWingSpeed = 2;
                AceOfTheSkies.pExplode = 0;

                AceOfTheSkies.pTimer = 0;
                AceOfTheSkies.pSeconds = 0;
                AceOfTheSkies.pMinutes = 0;
                AceOfTheSkies.pSecondString = "00";

                AceOfTheSkies.blockIndex = 0;
                AceOfTheSkies.meteorIndex = 0;

                AceOfTheSkies.pLocation = new PVector(250, AceOfTheSkies.processing.height / 2);
                AceOfTheSkies.pVelocity = new PVector(0, 0);

                AceOfTheSkies.pTrailX.removeAll(AceOfTheSkies.pTrailX);
                AceOfTheSkies.pTrailY.removeAll(AceOfTheSkies.pTrailY);
                AceOfTheSkies.pTrailWing.removeAll(AceOfTheSkies.pTrailWing);
                AceOfTheSkies.pTrailTransparency.removeAll(AceOfTheSkies.pTrailTransparency);

                AceOfTheSkies.blockX[0] = AceOfTheSkies.processing.width + 225;
                AceOfTheSkies.blockX[1] = AceOfTheSkies.processing.width + 450;
                AceOfTheSkies.blockX[2] = AceOfTheSkies.processing.width + 675;
                AceOfTheSkies.blockX[3] = AceOfTheSkies.processing.width + 900;
                AceOfTheSkies.blockY1[0] = AceOfTheSkies.processing.random(0, AceOfTheSkies.processing.height / 2);
                AceOfTheSkies.blockY1[1] = AceOfTheSkies.processing.random(0, AceOfTheSkies.processing.height / 2);
                AceOfTheSkies.blockY1[2] = AceOfTheSkies.processing.random(0, AceOfTheSkies.processing.height / 2);
                AceOfTheSkies.blockY1[3] = AceOfTheSkies.processing.random(0, AceOfTheSkies.processing.height / 2);
                AceOfTheSkies.blockY2[0] = AceOfTheSkies.blockY1[0] + AceOfTheSkies.processing.height / 2;
                AceOfTheSkies.blockY2[1] = AceOfTheSkies.blockY1[1] + AceOfTheSkies.processing.height / 2;
                AceOfTheSkies.blockY2[2] = AceOfTheSkies.blockY1[2] + AceOfTheSkies.processing.height / 2;
                AceOfTheSkies.blockY2[3] = AceOfTheSkies.blockY1[3] + AceOfTheSkies.processing.height / 2;

                AceOfTheSkies.meteorSize[0] = AceOfTheSkies.processing.random(30, 60);
                AceOfTheSkies.meteorSize[1] = AceOfTheSkies.processing.random(30, 60);
                AceOfTheSkies.meteorSize[2] = AceOfTheSkies.processing.random(30, 60);
                AceOfTheSkies.meteorSize[3] = AceOfTheSkies.processing.random(30, 60);
                AceOfTheSkies.meteorSize[4] = AceOfTheSkies.processing.random(30, 60);
                AceOfTheSkies.meteorSize[5] = AceOfTheSkies.processing.random(30, 60);

                AceOfTheSkies.meteorTrailX.removeAll(AceOfTheSkies.meteorTrailX);
                AceOfTheSkies.meteorTrailY.removeAll(AceOfTheSkies.meteorTrailY);
                AceOfTheSkies.meteorTrailSize.removeAll(AceOfTheSkies.meteorTrailSize);
                AceOfTheSkies.meteorTrailTransparency.removeAll(AceOfTheSkies.meteorTrailTransparency);

                AceOfTheSkies.meteorX[0] = AceOfTheSkies.processing.width + 150;
                AceOfTheSkies.meteorX[1] = AceOfTheSkies.processing.width + 300;
                AceOfTheSkies.meteorX[2] = AceOfTheSkies.processing.width + 450;
                AceOfTheSkies.meteorX[3] = AceOfTheSkies.processing.width + 600;
                AceOfTheSkies.meteorX[4] = AceOfTheSkies.processing.width + 750;
                AceOfTheSkies.meteorX[5] = AceOfTheSkies.processing.width + 900;
                AceOfTheSkies.meteorY[0] = AceOfTheSkies.processing.random(60, AceOfTheSkies.processing.height / 2 - 30);
                AceOfTheSkies.meteorY[1] = AceOfTheSkies.processing.random(AceOfTheSkies.processing.height / 2 + 30, AceOfTheSkies.processing.height - 60);
                AceOfTheSkies.meteorY[2] = AceOfTheSkies.processing.random(60, AceOfTheSkies.processing.height / 2 - 30);
                AceOfTheSkies.meteorY[3] = AceOfTheSkies.processing.random(AceOfTheSkies.processing.height / 2 + 30, AceOfTheSkies.processing.height - 60);
                AceOfTheSkies.meteorY[4] = AceOfTheSkies.processing.random(60, AceOfTheSkies.processing.height / 2 - 30);
                AceOfTheSkies.meteorY[5] = AceOfTheSkies.processing.random(AceOfTheSkies.processing.height / 2 + 30, AceOfTheSkies.processing.height - 60);

                AceOfTheSkies.meteorSize[0] = AceOfTheSkies.processing.random(30, 50);
                AceOfTheSkies.meteorSize[1] = AceOfTheSkies.processing.random(30, 50);
                AceOfTheSkies.meteorSize[2] = AceOfTheSkies.processing.random(30, 50);
                AceOfTheSkies.meteorSize[3] = AceOfTheSkies.processing.random(30, 50);
                AceOfTheSkies.meteorSize[4] = AceOfTheSkies.processing.random(30, 50);
                AceOfTheSkies.meteorSize[5] = AceOfTheSkies.processing.random(30, 50);

                AceOfTheSkies.laserY[0] = 40;
                AceOfTheSkies.laserY[1] = AceOfTheSkies.processing.random(140, AceOfTheSkies.processing.height - 140);
                AceOfTheSkies.laserY[2] = AceOfTheSkies.processing.height - 40;
                AceOfTheSkies.laserTime = 0;
                AceOfTheSkies.laserPercent = 0;

                AceOfTheSkies.wallX = 0;
                AceOfTheSkies.wallSpeed = (float) 0.5;
                AceOfTheSkies.wallTimer = 0;
                AceOfTheSkies.boostX[0] = AceOfTheSkies.processing.width + AceOfTheSkies.processing.width / 2;
                AceOfTheSkies.boostX[1] = AceOfTheSkies.processing.width * 2;
                AceOfTheSkies.boostY[0] = AceOfTheSkies.processing.random(80, AceOfTheSkies.processing.height / 2 - 40);
                AceOfTheSkies.boostY[1] = AceOfTheSkies.processing.random(AceOfTheSkies.processing.height / 2 + 40, AceOfTheSkies.processing.height - 80);
                AceOfTheSkies.boostPicked[0] = false;
                AceOfTheSkies.boostPicked[1] = false;
                AceOfTheSkies.boostSpeed = 4;
                AceOfTheSkies.boostIndex = 0;
            }
        } else if (AceOfTheSkies.processing.mouseX > AceOfTheSkies.processing.width / 2 - 80 && AceOfTheSkies.processing.mouseX < AceOfTheSkies.processing.width / 2 + 80 && AceOfTheSkies.processing.mouseY > AceOfTheSkies.processing.height / 2 + 160 && AceOfTheSkies.processing.mouseY < AceOfTheSkies.processing.height / 2 + 200 || AceOfTheSkies.processing.mouseX > AceOfTheSkies.processing.width / 2 - 80 && AceOfTheSkies.processing.mouseX < AceOfTheSkies.processing.width / 2 + 80 && AceOfTheSkies.processing.mouseY > AceOfTheSkies.processing.height / 2 + 240 && AceOfTheSkies.processing.mouseY < AceOfTheSkies.processing.height / 2 + 280) {
            AceOfTheSkies.buttonTransparency = 0;

            AceOfTheSkies.transitioning = true;

            if (AceOfTheSkies.processing.mouseX > AceOfTheSkies.processing.width / 2 - 80 && AceOfTheSkies.processing.mouseX < AceOfTheSkies.processing.width / 2 + 80 && AceOfTheSkies.processing.mouseY > AceOfTheSkies.processing.height / 2 + 160 && AceOfTheSkies.processing.mouseY < AceOfTheSkies.processing.height / 2 + 200) {
                AceOfTheSkies.mode = 2;
            } else if (AceOfTheSkies.processing.mouseX > AceOfTheSkies.processing.width / 2 - 80 && AceOfTheSkies.processing.mouseX < AceOfTheSkies.processing.width / 2 + 80 && AceOfTheSkies.processing.mouseY > AceOfTheSkies.processing.height / 2 + 240 && AceOfTheSkies.processing.mouseY < AceOfTheSkies.processing.height / 2 + 280) {
                AceOfTheSkies.mode = 3;

                AceOfTheSkies.startText = 1;
                AceOfTheSkies.startTextSpeed = 5;

                AceOfTheSkies.birdY = 251;
                AceOfTheSkies.birdSpeed = 3;

                if (AceOfTheSkies.pScore > Integer.parseInt(AceOfTheSkies.highScore)) {
                    try {
                        new FileWriter("src/wozardstudios/HighScores.txt", false).close();

                        AceOfTheSkies.reader = new BufferedReader(new FileReader("src/wozardstudios/HighScores.txt"));
                        AceOfTheSkies.writer = new BufferedWriter(new FileWriter("src/wozardstudios/HighScores.txt", true));

                        AceOfTheSkies.writer.write(String.valueOf(AceOfTheSkies.pScore));
                        AceOfTheSkies.writer.close();
                        AceOfTheSkies.highScore = AceOfTheSkies.reader.readLine();
                        AceOfTheSkies.reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
