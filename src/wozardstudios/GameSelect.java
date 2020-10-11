package wozardstudios;

import processing.core.PVector;

public class GameSelect {
    GameSelect() {
        AceOfTheSkies.buttonTransparency = 0;
        AceOfTheSkies.textTransparency = 0;
    }

    void fadeIn() {
        if (AceOfTheSkies.transparency > 0) {
            AceOfTheSkies.transparency -= 5;

            AceOfTheSkies.processing.fill(30, 161, 201, AceOfTheSkies.transparency);
            AceOfTheSkies.processing.noStroke();
            AceOfTheSkies.processing.rectMode(AceOfTheSkies.processing.CORNER);
            AceOfTheSkies.processing.rect(0, 0, AceOfTheSkies.processing.width, AceOfTheSkies.processing.height);
        } else {
            AceOfTheSkies.transitioning = false;
        }
    }

    void fadeOut() {
        if (AceOfTheSkies.transparency < 255) {
            AceOfTheSkies.transparency += 5;
        } else {
            AceOfTheSkies.transitioning = true;
        }

        AceOfTheSkies.processing.fill(30, 161, 201, AceOfTheSkies.transparency);
        AceOfTheSkies.processing.noStroke();
        AceOfTheSkies.processing.rectMode(AceOfTheSkies.processing.CORNER);
        AceOfTheSkies.processing.rect(0, 0, AceOfTheSkies.processing.width, AceOfTheSkies.processing.height);
    }

    void display() {
        AceOfTheSkies.processing.textAlign(AceOfTheSkies.processing.CENTER, AceOfTheSkies.processing.CENTER);
        AceOfTheSkies.processing.fill(255);
        AceOfTheSkies.processing.noStroke();

        AceOfTheSkies.processing.textSize(50);
        AceOfTheSkies.processing.text("GAME SELECT", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 - 250);

        AceOfTheSkies.processing.textSize(26);
        AceOfTheSkies.processing.text("Choose one of the following gamemodes.", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 - 160);

        AceOfTheSkies.processing.textSize(30);
        AceOfTheSkies.processing.text("Singleplayer", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 - 60);
        AceOfTheSkies.processing.text("Multiplayer 2", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 + 10);
        AceOfTheSkies.processing.text("Multiplayer 4", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 + 80);
    }

    void selectMode() {
        AceOfTheSkies.processing.noFill();
        AceOfTheSkies.processing.stroke(255, 255, 255, AceOfTheSkies.buttonTransparency);
        AceOfTheSkies.processing.strokeWeight(2);
        AceOfTheSkies.processing.rectMode(AceOfTheSkies.processing.CENTER);

        if (AceOfTheSkies.processing.mouseX >= AceOfTheSkies.processing.width / 2 - 100 && AceOfTheSkies.processing.mouseX <= AceOfTheSkies.processing.width / 2 + 100 && AceOfTheSkies.processing.mouseY >= AceOfTheSkies.processing.height / 2 - 80 && AceOfTheSkies.processing.mouseY <= AceOfTheSkies.processing.height / 2 - 40) {
            if (AceOfTheSkies.buttonTransparency < 255) AceOfTheSkies.buttonTransparency += 15;

            AceOfTheSkies.processing.rect(AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 - 55, 200, 40);

            AceOfTheSkies.processing.noStroke();
            AceOfTheSkies.processing.fill(255, 255, 255, AceOfTheSkies.buttonTransparency);
            AceOfTheSkies.processing.textSize(26);
            AceOfTheSkies.processing.textAlign(AceOfTheSkies.processing.CENTER, AceOfTheSkies.processing.CENTER);

            AceOfTheSkies.processing.text("Left click for endless mode, and right click for adventure mode.", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 + 155);

            AceOfTheSkies.processing.noFill();
            AceOfTheSkies.processing.stroke(255, 255, 255, AceOfTheSkies.buttonTransparency);
            AceOfTheSkies.processing.strokeWeight(2);
            AceOfTheSkies.processing.rectMode(AceOfTheSkies.processing.CENTER);
        } else if (AceOfTheSkies.processing.mouseX >= AceOfTheSkies.processing.width / 2 - 100 && AceOfTheSkies.processing.mouseX <= AceOfTheSkies.processing.width / 2 + 100 && AceOfTheSkies.processing.mouseY >= AceOfTheSkies.processing.height / 2 - 10 && AceOfTheSkies.processing.mouseY <= AceOfTheSkies.processing.height / 2 + 30) {
            if (AceOfTheSkies.buttonTransparency < 255) AceOfTheSkies.buttonTransparency += 15;

            AceOfTheSkies.processing.rect(AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 + 15, 200, 40);
        } else if (AceOfTheSkies.processing.mouseX >= AceOfTheSkies.processing.width / 2 - 100 && AceOfTheSkies.processing.mouseX <= AceOfTheSkies.processing.width / 2 + 100 && AceOfTheSkies.processing.mouseY >= AceOfTheSkies.processing.height / 2 + 60 && AceOfTheSkies.processing.mouseY <= AceOfTheSkies.processing.height / 2 + 100) {
            if (AceOfTheSkies.buttonTransparency < 255) AceOfTheSkies.buttonTransparency += 15;

            AceOfTheSkies.processing.rect(AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 + 85, 200, 40);
        } else {
            if (AceOfTheSkies.buttonTransparency != 0) AceOfTheSkies.buttonTransparency = 0;
        }

        AceOfTheSkies.processing.noStroke();
    }

    void click() {
        if (AceOfTheSkies.processing.mouseX >= AceOfTheSkies.processing.width / 2 - 100 && AceOfTheSkies.processing.mouseX <= AceOfTheSkies.processing.width / 2 + 100 && AceOfTheSkies.processing.mouseY >= AceOfTheSkies.processing.height / 2 - 80 && AceOfTheSkies.processing.mouseY <= AceOfTheSkies.processing.height / 2 - 40 || AceOfTheSkies.processing.mouseX >= AceOfTheSkies.processing.width / 2 - 100 && AceOfTheSkies.processing.mouseX <= AceOfTheSkies.processing.width / 2 + 100 && AceOfTheSkies.processing.mouseY >= AceOfTheSkies.processing.height / 2 - 10 && AceOfTheSkies.processing.mouseY <= AceOfTheSkies.processing.height / 2 + 30 || AceOfTheSkies.processing.mouseX >= AceOfTheSkies.processing.width / 2 - 100 && AceOfTheSkies.processing.mouseX <= AceOfTheSkies.processing.width / 2 + 100 && AceOfTheSkies.processing.mouseY >= AceOfTheSkies.processing.height / 2 + 60 && AceOfTheSkies.processing.mouseY <= AceOfTheSkies.processing.height / 2 + 100) {
            AceOfTheSkies.buttonTransparency = 0;
            AceOfTheSkies.gameState = 2;
            AceOfTheSkies.blockIndex = 0;
            AceOfTheSkies.loadTime = 0;
            AceOfTheSkies.textTransparency = 0;
            AceOfTheSkies.randomTip = AceOfTheSkies.processing.floor(AceOfTheSkies.processing.random(AceOfTheSkies.tips.length));

            if (AceOfTheSkies.processing.mouseX >= AceOfTheSkies.processing.width / 2 - 100 && AceOfTheSkies.processing.mouseX <= AceOfTheSkies.processing.width / 2 + 100 && AceOfTheSkies.processing.mouseY >= AceOfTheSkies.processing.height / 2 - 80 && AceOfTheSkies.processing.mouseY <= AceOfTheSkies.processing.height / 2 - 40) {
                if (AceOfTheSkies.processing.mouseButton == AceOfTheSkies.processing.LEFT) {
                    AceOfTheSkies.mode = 0;
                } else if (AceOfTheSkies.processing.mouseButton == AceOfTheSkies.processing.RIGHT) {
                    AceOfTheSkies.mode = 1;
                }

                AceOfTheSkies.gameStarted = false;

                AceOfTheSkies.pAlive = true;
                AceOfTheSkies.pScore = 0;
                AceOfTheSkies.pJumping = false;
                AceOfTheSkies.pJumps = 0;
                AceOfTheSkies.pWing = 0;
                AceOfTheSkies.pWingSpeed = 2;
                AceOfTheSkies.pExplode = 0;

                AceOfTheSkies.pTimer = 0;
                AceOfTheSkies.pSeconds = 0;
                AceOfTheSkies.pMinutes = 0;
                AceOfTheSkies.pSecondString = "00";

                AceOfTheSkies.audioPlayer.rewind();

                AceOfTheSkies.pLocation = new PVector(250, AceOfTheSkies.processing.height / 2);
                AceOfTheSkies.pVelocity = new PVector(0, 0);

                AceOfTheSkies.blockIndex = 0;
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

                if (AceOfTheSkies.processing.mouseButton == AceOfTheSkies.processing.RIGHT) {
                    AceOfTheSkies.meteorIndex = 0;
                    AceOfTheSkies.meteorX[0] = AceOfTheSkies.processing.width + 150;
                    AceOfTheSkies.meteorX[1] = AceOfTheSkies.processing.width + 300;
                    AceOfTheSkies.meteorX[2] = AceOfTheSkies.processing.width + 450;
                    AceOfTheSkies.meteorX[3] = AceOfTheSkies.processing.width + 600;
                    AceOfTheSkies.meteorX[4] = AceOfTheSkies.processing.width + 750;
                    AceOfTheSkies.meteorX[5] = AceOfTheSkies.processing.width + 900;
                    AceOfTheSkies.meteorY[0] = AceOfTheSkies.processing.random(60, AceOfTheSkies.processing.height / 4 - 30);
                    AceOfTheSkies.meteorY[1] = AceOfTheSkies.processing.random(AceOfTheSkies.processing.height / 2 + AceOfTheSkies.processing.height / 4 + 30, AceOfTheSkies.processing.height - 60);
                    AceOfTheSkies.meteorY[2] = AceOfTheSkies.processing.random(60, AceOfTheSkies.processing.height / 2 - 30);
                    AceOfTheSkies.meteorY[3] = AceOfTheSkies.processing.random(AceOfTheSkies.processing.height / 2 + 30, AceOfTheSkies.processing.height - 60);
                    AceOfTheSkies.meteorY[4] = AceOfTheSkies.processing.random(60, AceOfTheSkies.processing.height / 4 - 30);
                    AceOfTheSkies.meteorY[5] = AceOfTheSkies.processing.random(AceOfTheSkies.processing.height / 2 + AceOfTheSkies.processing.height / 4 + 30, AceOfTheSkies.processing.height - 60);

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
            } else if (AceOfTheSkies.processing.mouseX >= AceOfTheSkies.processing.width / 2 - 100 && AceOfTheSkies.processing.mouseX <= AceOfTheSkies.processing.width / 2 + 100 && AceOfTheSkies.processing.mouseY >= AceOfTheSkies.processing.height / 2 - 10 && AceOfTheSkies.processing.mouseY <= AceOfTheSkies.processing.height / 2 + 30) {
                AceOfTheSkies.mode = 2;

                AceOfTheSkies.p1Jumping = false;
                AceOfTheSkies.p2Jumping = false;
                AceOfTheSkies.p1Wing = 0;
                AceOfTheSkies.p2Wing = 0;
                AceOfTheSkies.p1Flapping = false;
                AceOfTheSkies.p2Flapping = false;

                AceOfTheSkies.p1Location = new PVector(125, AceOfTheSkies.processing.height / 2);
                AceOfTheSkies.p2Location = new PVector(AceOfTheSkies.processing.width / 2 + 125, AceOfTheSkies.processing.height / 2);

                AceOfTheSkies.blockX[0] = AceOfTheSkies.processing.width / 2 + 81;
                AceOfTheSkies.blockX[1] = AceOfTheSkies.processing.width / 2 + 236;
                AceOfTheSkies.blockX[2] = AceOfTheSkies.processing.width / 2 + 393;
                AceOfTheSkies.blockY1[0] = AceOfTheSkies.processing.random(0, AceOfTheSkies.processing.height / 2);
                AceOfTheSkies.blockY1[1] = AceOfTheSkies.processing.random(0, AceOfTheSkies.processing.height / 2);
                AceOfTheSkies.blockY1[2] = AceOfTheSkies.processing.random(0, AceOfTheSkies.processing.height / 2);
                AceOfTheSkies.blockY2[0] = AceOfTheSkies.blockY1[0] + AceOfTheSkies.processing.height / 2;
                AceOfTheSkies.blockY2[1] = AceOfTheSkies.blockY1[1] + AceOfTheSkies.processing.height / 2;
                AceOfTheSkies.blockY2[2] = AceOfTheSkies.blockY1[2] + AceOfTheSkies.processing.height / 2;
            } else if (AceOfTheSkies.processing.mouseX >= AceOfTheSkies.processing.width / 2 - 100 && AceOfTheSkies.processing.mouseX <= AceOfTheSkies.processing.width / 2 + 100 && AceOfTheSkies.processing.mouseY >= AceOfTheSkies.processing.height / 2 + 60 && AceOfTheSkies.processing.mouseY <= AceOfTheSkies.processing.height / 2 + 100) {
                AceOfTheSkies.mode = 3;

                AceOfTheSkies.p1Location = new PVector(125, AceOfTheSkies.processing.height / 4);
                AceOfTheSkies.p2Location = new PVector(AceOfTheSkies.processing.width / 2 + 125, AceOfTheSkies.processing.height / 4);
                AceOfTheSkies.p1Location = new PVector(125, AceOfTheSkies.processing.height / 2 + AceOfTheSkies.processing.height / 4);
                AceOfTheSkies.p1Location = new PVector(AceOfTheSkies.processing.width / 2 + 125, AceOfTheSkies.processing.height / 2 + AceOfTheSkies.processing.height / 4);
            }
        }
    }
}
