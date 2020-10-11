package wozardstudios;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    Game() {
        AceOfTheSkies.blockX = new float[4];
        AceOfTheSkies.blockY1 = new float[4];
        AceOfTheSkies.blockY2 = new float[4];

        AceOfTheSkies.meteorX = new float[6];
        AceOfTheSkies.meteorY = new float[6];
        AceOfTheSkies.meteorSize = new float[6];

        AceOfTheSkies.meteorTrailX = new ArrayList<>();
        AceOfTheSkies.meteorTrailY = new ArrayList<>();
        AceOfTheSkies.meteorTrailSize = new ArrayList<>();
        AceOfTheSkies.meteorTrailTransparency = new ArrayList<>();

        AceOfTheSkies.laserY = new float[3];

        AceOfTheSkies.boostX = new float[2];
        AceOfTheSkies.boostY = new float[2];
        AceOfTheSkies.boostPicked = new boolean[2];
    }

    void load() {
        if (AceOfTheSkies.loadTime < 240) {
            AceOfTheSkies.loadTime++;

            AceOfTheSkies.processing.fill(255, 255, 255, AceOfTheSkies.textTransparency);
            AceOfTheSkies.processing.noStroke();
            AceOfTheSkies.processing.textAlign(AceOfTheSkies.processing.CENTER, AceOfTheSkies.processing.CENTER);

            AceOfTheSkies.processing.textSize(45);
            AceOfTheSkies.processing.text("CREATING WORLD", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 - 100);

            AceOfTheSkies.processing.textSize(30);
            if (AceOfTheSkies.mode == 0) {
                AceOfTheSkies.processing.text("1 Player | Endless Mode", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 - 20);
            } else if (AceOfTheSkies.mode == 1) {
                AceOfTheSkies.processing.text("1 Player | Adventure Mode", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 - 20);
            } else if (AceOfTheSkies.mode == 2) {
                AceOfTheSkies.processing.text("Multiplayer | 2 Player", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 - 20);
            } else if (AceOfTheSkies.mode == 3) {
                AceOfTheSkies.processing.text("Multiplayer | 4 Player", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 - 20);
            }

            AceOfTheSkies.processing.textSize(26);
            AceOfTheSkies.processing.text("TIP", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 + 250);
            AceOfTheSkies.processing.textSize(22);
            AceOfTheSkies.processing.text(AceOfTheSkies.tips[AceOfTheSkies.randomTip], AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 + 300);
        }

        if (AceOfTheSkies.loadTime >= 60 && AceOfTheSkies.loadTime < 180) {
            if (AceOfTheSkies.textTransparency < 255) AceOfTheSkies.textTransparency += 5;
        } else if (AceOfTheSkies.loadTime < 240) {
            if (AceOfTheSkies.textTransparency > 0) AceOfTheSkies.textTransparency -= 5;
        } else {
            if (AceOfTheSkies.mode == 0 || AceOfTheSkies.mode == 1) {
                AceOfTheSkies.gameState = 3;
            } else if (AceOfTheSkies.mode == 2) {
                AceOfTheSkies.gameState = 4;
            } else if (AceOfTheSkies.mode == 3) {
                AceOfTheSkies.gameState = 5;
            }
        }
    }

    void fadeIn() {
        if (AceOfTheSkies.transparency > 0) {
            AceOfTheSkies.transparency -= 3;

            AceOfTheSkies.processing.rectMode(AceOfTheSkies.processing.CORNER);
            AceOfTheSkies.processing.fill(30, 161, 201, AceOfTheSkies.transparency);
            AceOfTheSkies.processing.noStroke();
            AceOfTheSkies.processing.rect(0, 0, AceOfTheSkies.processing.width, AceOfTheSkies.processing.height);
        } else {
            AceOfTheSkies.transitioning = false;
        }
    }

    void displayObstacles() {
        if (AceOfTheSkies.gameState == 3) {
            if (AceOfTheSkies.mode == 1) {
                if (AceOfTheSkies.pScore < 200) {
                    AceOfTheSkies.processing.fill(255);
                    AceOfTheSkies.processing.noStroke();
                    AceOfTheSkies.processing.rectMode(AceOfTheSkies.processing.CORNER);

                    for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.blockX.length; AceOfTheSkies.i++) {
                        AceOfTheSkies.processing.rect(AceOfTheSkies.blockX[AceOfTheSkies.i], 0, 40, AceOfTheSkies.blockY1[AceOfTheSkies.i]);
                        AceOfTheSkies.processing.rect(AceOfTheSkies.blockX[AceOfTheSkies.i], AceOfTheSkies.blockY2[AceOfTheSkies.i], 40, AceOfTheSkies.processing.height - AceOfTheSkies.blockY2[AceOfTheSkies.i]);
                    }

                    AceOfTheSkies.processing.noFill();
                    AceOfTheSkies.processing.stroke(255);

                    AceOfTheSkies.processing.strokeWeight(1);

                    for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.blockX.length; AceOfTheSkies.i++) {
                        AceOfTheSkies.processing.line(AceOfTheSkies.blockX[AceOfTheSkies.i] + 20, AceOfTheSkies.blockY1[AceOfTheSkies.i], AceOfTheSkies.blockX[AceOfTheSkies.i] + 20, AceOfTheSkies.blockY1[AceOfTheSkies.i] + 30);
                        AceOfTheSkies.processing.line(AceOfTheSkies.blockX[AceOfTheSkies.i] + 20, AceOfTheSkies.blockY2[AceOfTheSkies.i] - 30, AceOfTheSkies.blockX[AceOfTheSkies.i] + 20, AceOfTheSkies.blockY2[AceOfTheSkies.i]);
                    }

                    AceOfTheSkies.processing.strokeWeight(3);
                    AceOfTheSkies.processing.ellipseMode(AceOfTheSkies.processing.CENTER);

                    for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.blockX.length; AceOfTheSkies.i++) {
                        AceOfTheSkies.processing.ellipse(AceOfTheSkies.blockX[AceOfTheSkies.i] + 20, AceOfTheSkies.blockY1[AceOfTheSkies.i] + 30, AceOfTheSkies.audioPlayer.mix.level() * 60, AceOfTheSkies.audioPlayer.mix.level() * 60);
                        AceOfTheSkies.processing.ellipse(AceOfTheSkies.blockX[AceOfTheSkies.i] + 20, AceOfTheSkies.blockY2[AceOfTheSkies.i] - 30, AceOfTheSkies.audioPlayer.mix.level() * 60, AceOfTheSkies.audioPlayer.mix.level() * 60);
                    }

                    AceOfTheSkies.processing.noStroke();
                } else if (AceOfTheSkies.pScore < 400) {
                    if (AceOfTheSkies.blockX[AceOfTheSkies.blockX.length - 1] > -40) {
                        AceOfTheSkies.processing.fill(255);
                        AceOfTheSkies.processing.noStroke();
                        AceOfTheSkies.processing.rectMode(AceOfTheSkies.processing.CORNER);

                        for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.blockX.length; AceOfTheSkies.i++) {
                            AceOfTheSkies.processing.rect(AceOfTheSkies.blockX[AceOfTheSkies.i], 0, 40, AceOfTheSkies.blockY1[AceOfTheSkies.i]);
                            AceOfTheSkies.processing.rect(AceOfTheSkies.blockX[AceOfTheSkies.i], AceOfTheSkies.blockY2[AceOfTheSkies.i], 40, AceOfTheSkies.processing.height - AceOfTheSkies.blockY2[AceOfTheSkies.i]);
                        }

                        AceOfTheSkies.processing.noFill();
                        AceOfTheSkies.processing.stroke(255);

                        AceOfTheSkies.processing.strokeWeight(1);

                        for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.blockX.length; AceOfTheSkies.i++) {
                            AceOfTheSkies.processing.line(AceOfTheSkies.blockX[AceOfTheSkies.i] + 20, AceOfTheSkies.blockY1[AceOfTheSkies.i], AceOfTheSkies.blockX[AceOfTheSkies.i] + 20, AceOfTheSkies.blockY1[AceOfTheSkies.i] + 30);
                            AceOfTheSkies.processing.line(AceOfTheSkies.blockX[AceOfTheSkies.i] + 20, AceOfTheSkies.blockY2[AceOfTheSkies.i] - 30, AceOfTheSkies.blockX[AceOfTheSkies.i] + 20, AceOfTheSkies.blockY2[AceOfTheSkies.i]);
                        }

                        AceOfTheSkies.processing.strokeWeight(3);
                        AceOfTheSkies.processing.ellipseMode(AceOfTheSkies.processing.CENTER);

                        for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.blockX.length; AceOfTheSkies.i++) {
                            AceOfTheSkies.processing.ellipse(AceOfTheSkies.blockX[AceOfTheSkies.i] + 20, AceOfTheSkies.blockY1[AceOfTheSkies.i] + 30, AceOfTheSkies.audioPlayer.mix.level() * 60, AceOfTheSkies.audioPlayer.mix.level() * 60);
                            AceOfTheSkies.processing.ellipse(AceOfTheSkies.blockX[AceOfTheSkies.i] + 20, AceOfTheSkies.blockY2[AceOfTheSkies.i] - 30, AceOfTheSkies.audioPlayer.mix.level() * 60, AceOfTheSkies.audioPlayer.mix.level() * 60);
                        }

                        AceOfTheSkies.processing.noStroke();
                    }

                    AceOfTheSkies.processing.fill(255);
                    AceOfTheSkies.processing.noStroke();
                    AceOfTheSkies.processing.ellipseMode(AceOfTheSkies.processing.CENTER);

                    for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.meteorX.length; AceOfTheSkies.i++) {
                        AceOfTheSkies.processing.ellipse(AceOfTheSkies.meteorX[AceOfTheSkies.i], AceOfTheSkies.meteorY[AceOfTheSkies.i], AceOfTheSkies.meteorSize[AceOfTheSkies.i], AceOfTheSkies.meteorSize[AceOfTheSkies.i]);
                    }

                    AceOfTheSkies.processing.fill(AceOfTheSkies.bgColor[0], AceOfTheSkies.bgColor[1], AceOfTheSkies.bgColor[2]);

                    for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.meteorX.length; AceOfTheSkies.i++) {
                        AceOfTheSkies.processing.ellipse(AceOfTheSkies.meteorX[AceOfTheSkies.i], AceOfTheSkies.meteorY[AceOfTheSkies.i], AceOfTheSkies.audioPlayer.mix.level() * AceOfTheSkies.meteorSize[AceOfTheSkies.i], AceOfTheSkies.audioPlayer.mix.level() * AceOfTheSkies.meteorSize[AceOfTheSkies.i]);
                    }

                    AceOfTheSkies.processing.noFill();
                    AceOfTheSkies.processing.strokeWeight(4);

                    for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.meteorTrailX.size(); AceOfTheSkies.i++) {
                        AceOfTheSkies.processing.stroke(255, 255, 255, AceOfTheSkies.meteorTrailTransparency.get(AceOfTheSkies.i));

                        AceOfTheSkies.processing.ellipse(AceOfTheSkies.meteorTrailX.get(AceOfTheSkies.i), AceOfTheSkies.meteorTrailY.get(AceOfTheSkies.i), AceOfTheSkies.meteorTrailSize.get(AceOfTheSkies.i), AceOfTheSkies.meteorTrailSize.get(AceOfTheSkies.i));
                    }

                    AceOfTheSkies.processing.noStroke();
                } else if (AceOfTheSkies.pScore < 600) {
                    if (AceOfTheSkies.meteorX[AceOfTheSkies.meteorX.length - 1] > AceOfTheSkies.meteorSize[AceOfTheSkies.meteorX.length - 1] / 2 * -1) {
                        AceOfTheSkies.processing.fill(255);
                        AceOfTheSkies.processing.noStroke();
                        AceOfTheSkies.processing.ellipseMode(AceOfTheSkies.processing.CENTER);

                        for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.meteorX.length; AceOfTheSkies.i++) {
                            AceOfTheSkies.processing.ellipse(AceOfTheSkies.meteorX[AceOfTheSkies.i], AceOfTheSkies.meteorY[AceOfTheSkies.i], AceOfTheSkies.meteorSize[AceOfTheSkies.i], AceOfTheSkies.meteorSize[AceOfTheSkies.i]);
                        }

                        AceOfTheSkies.processing.fill(AceOfTheSkies.bgColor[0], AceOfTheSkies.bgColor[1], AceOfTheSkies.bgColor[2]);

                        for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.meteorX.length; AceOfTheSkies.i++) {
                            AceOfTheSkies.processing.ellipse(AceOfTheSkies.meteorX[AceOfTheSkies.i], AceOfTheSkies.meteorY[AceOfTheSkies.i], (float) (AceOfTheSkies.audioPlayer.mix.level() * AceOfTheSkies.meteorSize[AceOfTheSkies.i] * 1.5), (float) (AceOfTheSkies.audioPlayer.mix.level() * AceOfTheSkies.meteorSize[AceOfTheSkies.i] * 1.5));
                        }
                    }

                    if (AceOfTheSkies.meteorTrailX.size() > 0) {
                        AceOfTheSkies.processing.noFill();
                        AceOfTheSkies.processing.strokeWeight(4);

                        for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.meteorTrailX.size(); AceOfTheSkies.i++) {
                            AceOfTheSkies.processing.stroke(255, 255, 255, AceOfTheSkies.meteorTrailTransparency.get(AceOfTheSkies.i));

                            AceOfTheSkies.processing.ellipse(AceOfTheSkies.meteorTrailX.get(AceOfTheSkies.i), AceOfTheSkies.meteorTrailY.get(AceOfTheSkies.i), AceOfTheSkies.meteorTrailSize.get(AceOfTheSkies.i), AceOfTheSkies.meteorTrailSize.get(AceOfTheSkies.i));
                        }

                        AceOfTheSkies.processing.noStroke();
                    }

                    AceOfTheSkies.processing.noFill();
                    AceOfTheSkies.processing.stroke(255);
                    AceOfTheSkies.processing.strokeWeight(2);
                    AceOfTheSkies.processing.ellipseMode(AceOfTheSkies.processing.CENTER);

                    for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.laserY.length; AceOfTheSkies.i++) {
                        AceOfTheSkies.processing.line(AceOfTheSkies.processing.width, AceOfTheSkies.laserY[AceOfTheSkies.i] - 50,  AceOfTheSkies.processing.width - AceOfTheSkies.laserPercent / 100 * AceOfTheSkies.processing.width, AceOfTheSkies.laserY[AceOfTheSkies.i] - 50);
                        AceOfTheSkies.processing.line(AceOfTheSkies.processing.width, AceOfTheSkies.laserY[AceOfTheSkies.i] + 50, AceOfTheSkies.processing.width - AceOfTheSkies.laserPercent / 100 * AceOfTheSkies.processing.width, AceOfTheSkies.laserY[AceOfTheSkies.i] + 50);

                        AceOfTheSkies.processing.ellipse(AceOfTheSkies.processing.width - AceOfTheSkies.laserPercent / 100 * AceOfTheSkies.processing.width, AceOfTheSkies.laserY[AceOfTheSkies.i] - 50, AceOfTheSkies.audioPlayer.mix.level() * 60, AceOfTheSkies.audioPlayer.mix.level() * 60);
                        AceOfTheSkies.processing.ellipse(AceOfTheSkies.processing.width - AceOfTheSkies.laserPercent / 100 * AceOfTheSkies.processing.width, AceOfTheSkies.laserY[AceOfTheSkies.i] + 50, AceOfTheSkies.audioPlayer.mix.level() * 60, AceOfTheSkies.audioPlayer.mix.level() * 60);
                    }

                    AceOfTheSkies.processing.noStroke();
                    AceOfTheSkies.processing.fill(255, 255, 255, AceOfTheSkies.laserPercent / 100 * 255);
                    AceOfTheSkies.processing.rectMode(AceOfTheSkies.processing.CORNER);

                    if (AceOfTheSkies.pScore < 450) {
                        if (AceOfTheSkies.laserTime >= 120 && AceOfTheSkies.laserTime < 240) {
                            AceOfTheSkies.processing.rect(0, AceOfTheSkies.laserY[0] - 35, AceOfTheSkies.processing.width, 70);
                            AceOfTheSkies.processing.rect(0, AceOfTheSkies.laserY[1] - 45, AceOfTheSkies.processing.width, 90);
                            AceOfTheSkies.processing.rect(0, AceOfTheSkies.laserY[2] - 35, AceOfTheSkies.processing.width, 70);
                        }
                    } else if (AceOfTheSkies.pScore < 550) {
                        if (AceOfTheSkies.laserTime >= 90 && AceOfTheSkies.laserTime < 210) {
                            AceOfTheSkies.processing.rect(0, AceOfTheSkies.laserY[0] - 35, AceOfTheSkies.processing.width, 70);
                            AceOfTheSkies.processing.rect(0, AceOfTheSkies.laserY[1] - 45, AceOfTheSkies.processing.width, 90);
                            AceOfTheSkies.processing.rect(0, AceOfTheSkies.laserY[2] - 35, AceOfTheSkies.processing.width, 70);
                        }
                    } else if (AceOfTheSkies.pScore < 600) {
                        if (AceOfTheSkies.laserTime >= 60 && AceOfTheSkies.laserTime < 180) {
                            AceOfTheSkies.processing.rect(0, AceOfTheSkies.laserY[0] - 35, AceOfTheSkies.processing.width, 70);
                            AceOfTheSkies.processing.rect(0, AceOfTheSkies.laserY[1] - 45, AceOfTheSkies.processing.width, 90);
                            AceOfTheSkies.processing.rect(0, AceOfTheSkies.laserY[2] - 35, AceOfTheSkies.processing.width, 70);
                        }
                    }
                } else if (AceOfTheSkies.pScore < 800) {
                    AceOfTheSkies.processing.fill(255);
                    AceOfTheSkies.processing.noStroke();

                    AceOfTheSkies.processing.rectMode(AceOfTheSkies.processing.CORNER);
                    AceOfTheSkies.processing.rect(0, 0, AceOfTheSkies.wallX, AceOfTheSkies.processing.height);

                    AceOfTheSkies.processing.ellipseMode(AceOfTheSkies.processing.CENTER);
                    for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.boostX.length; AceOfTheSkies.i++) {
                        if (!AceOfTheSkies.boostPicked[AceOfTheSkies.i]) {
                            AceOfTheSkies.processing.ellipse(AceOfTheSkies.boostX[AceOfTheSkies.i], AceOfTheSkies.boostY[AceOfTheSkies.i], 40, 40);
                        }
                    }

                    AceOfTheSkies.processing.fill(AceOfTheSkies.bgColor[0], AceOfTheSkies.bgColor[1], AceOfTheSkies.bgColor[2]);
                    for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.boostX.length; AceOfTheSkies.i++) {
                        if (!AceOfTheSkies.boostPicked[AceOfTheSkies.i]) {
                            AceOfTheSkies.processing.beginShape();
                            AceOfTheSkies.processing.vertex(AceOfTheSkies.boostX[AceOfTheSkies.i] - 25 * AceOfTheSkies.audioPlayer.mix.level(), AceOfTheSkies.boostY[AceOfTheSkies.i] - 25 * AceOfTheSkies.audioPlayer.mix.level());
                            AceOfTheSkies.processing.vertex(AceOfTheSkies.boostX[AceOfTheSkies.i] + 25 * AceOfTheSkies.audioPlayer.mix.level(), AceOfTheSkies.boostY[AceOfTheSkies.i]);
                            AceOfTheSkies.processing.vertex(AceOfTheSkies.boostX[AceOfTheSkies.i] - 25 * AceOfTheSkies.audioPlayer.mix.level(), AceOfTheSkies.boostY[AceOfTheSkies.i] + 25 * AceOfTheSkies.audioPlayer.mix.level());
                            AceOfTheSkies.processing.endShape();
                        }
                    }
                }
            }
        } else if (AceOfTheSkies.gameState == 4) {
            AceOfTheSkies.processing.fill(255);
            AceOfTheSkies.processing.noStroke();
            AceOfTheSkies.processing.rectMode(AceOfTheSkies.processing.CORNER);

            for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.blockX.length; AceOfTheSkies.i++) {
                AceOfTheSkies.processing.rect(AceOfTheSkies.blockX[AceOfTheSkies.i], 0, 40, AceOfTheSkies.blockY1[AceOfTheSkies.i]);
                AceOfTheSkies.processing.rect(AceOfTheSkies.blockX[AceOfTheSkies.i] + AceOfTheSkies.processing.width / 2, 0, 40, AceOfTheSkies.blockY1[AceOfTheSkies.i]);
                AceOfTheSkies.processing.rect(AceOfTheSkies.blockX[AceOfTheSkies.i], AceOfTheSkies.blockY2[AceOfTheSkies.i], 40, AceOfTheSkies.processing.height - AceOfTheSkies.blockY2[AceOfTheSkies.i]);
                AceOfTheSkies.processing.rect(AceOfTheSkies.blockX[AceOfTheSkies.i] + AceOfTheSkies.processing.width / 2, AceOfTheSkies.blockY2[AceOfTheSkies.i], 40, AceOfTheSkies.processing.height - AceOfTheSkies.blockY2[AceOfTheSkies.i]);
            }
        }
    }

    void displayStats() {
        if (AceOfTheSkies.gameState == 3) {
            AceOfTheSkies.processing.fill(0);
            AceOfTheSkies.processing.noStroke();
            AceOfTheSkies.processing.textAlign(AceOfTheSkies.processing.CENTER, AceOfTheSkies.processing.CENTER);

            AceOfTheSkies.processing.textSize(30);
            AceOfTheSkies.processing.text("Score", AceOfTheSkies.processing.width / 2, 20);
            AceOfTheSkies.processing.textSize(25);
            AceOfTheSkies.processing.text(AceOfTheSkies.pScore, AceOfTheSkies.processing.width / 2, 55);

            AceOfTheSkies.processing.textSize(25);
            AceOfTheSkies.processing.text("Jumps", AceOfTheSkies.processing.width / 2 - 100, 20);
            AceOfTheSkies.processing.textSize(22);
            if (AceOfTheSkies.pJumps < 1000) {
                AceOfTheSkies.processing.text(AceOfTheSkies.pJumps, AceOfTheSkies.processing.width / 2 - 100, 55);
            } else {
                AceOfTheSkies.processing.text((float) Math.floor(AceOfTheSkies.pJumps / 1000 * 10) / 10, AceOfTheSkies.processing.width / 2 - 100, 55);
            }

            AceOfTheSkies.processing.textSize(25);
            AceOfTheSkies.processing.text("Time", AceOfTheSkies.processing.width / 2 + 100, 20);
            AceOfTheSkies.processing.textSize(22);
            AceOfTheSkies.processing.text(AceOfTheSkies.pMinutes + ":" + AceOfTheSkies.pSecondString, AceOfTheSkies.processing.width / 2 + 100, 55);

            AceOfTheSkies.processing.textAlign(AceOfTheSkies.processing.RIGHT);
            AceOfTheSkies.processing.textSize(20);
            if (Math.round(AceOfTheSkies.processing.frameRate) > 55) {
                AceOfTheSkies.processing.text("FPS: " + Math.round(AceOfTheSkies.processing.frameRate), AceOfTheSkies.processing.width - 20, 20);
            } else {
                AceOfTheSkies.processing.text("(Low) FPS: " + Math.round(AceOfTheSkies.processing.frameRate), AceOfTheSkies.processing.width - 20, 20);
            }

            if (AceOfTheSkies.gameStarted) {
                AceOfTheSkies.pTimer++;

                if (AceOfTheSkies.pTimer == 60) {
                    AceOfTheSkies.pTimer = 0;

                    AceOfTheSkies.pSeconds++;

                    if (AceOfTheSkies.pSeconds == 60) {
                        AceOfTheSkies.pSeconds = 0;
                        AceOfTheSkies.pMinutes++;
                    }

                    if (AceOfTheSkies.pSeconds < 10) {
                        AceOfTheSkies.pSecondString = "0" + AceOfTheSkies.pSeconds;
                    } else {
                        AceOfTheSkies.pSecondString = "" + AceOfTheSkies.pSeconds;
                    }
                }
            }
        }
    }

    void updateObstacles() {
        if (AceOfTheSkies.gameState == 3) {
            if (AceOfTheSkies.pAlive) {
                if (AceOfTheSkies.pScore < 200) {
                    for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.blockX.length; AceOfTheSkies.i++) {
                        AceOfTheSkies.blockX[AceOfTheSkies.i] -= AceOfTheSkies.blockSpeed;

                        if (AceOfTheSkies.blockX[AceOfTheSkies.i] < -40 && AceOfTheSkies.pScore < 194) {
                            AceOfTheSkies.blockX[AceOfTheSkies.i] = AceOfTheSkies.processing.width;

                            if (AceOfTheSkies.pScore < 150) {
                                AceOfTheSkies.blockY1[AceOfTheSkies.i] = AceOfTheSkies.processing.random(0, AceOfTheSkies.processing.height / 2);
                            } else {
                                AceOfTheSkies.blockY1[AceOfTheSkies.i] = AceOfTheSkies.processing.random(20, AceOfTheSkies.processing.height / 2 - 20);
                            }

                            AceOfTheSkies.blockY2[AceOfTheSkies.i] = AceOfTheSkies.blockY1[AceOfTheSkies.i] + AceOfTheSkies.processing.height / 2;
                        }
                    }
                } else if (AceOfTheSkies.pScore < 400) {
                    if (AceOfTheSkies.blockX[AceOfTheSkies.blockX.length - 1] > -40) {
                        for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.blockX.length; AceOfTheSkies.i++) {
                            AceOfTheSkies.blockX[AceOfTheSkies.i] -= 5;
                        }
                    }

                    for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.meteorX.length; AceOfTheSkies.i++) {
                        AceOfTheSkies.meteorX[AceOfTheSkies.i] -= AceOfTheSkies.blockSpeed;

                        AceOfTheSkies.meteorTrailX.add(AceOfTheSkies.meteorX[AceOfTheSkies.i]);
                        AceOfTheSkies.meteorTrailY.add(AceOfTheSkies.meteorY[AceOfTheSkies.i]);
                        AceOfTheSkies.meteorTrailSize.add(AceOfTheSkies.meteorSize[AceOfTheSkies.i]);
                        AceOfTheSkies.meteorTrailTransparency.add((float) 127.5);

                        if (AceOfTheSkies.meteorX[AceOfTheSkies.i] < -30 && AceOfTheSkies.pScore < 394) {
                            AceOfTheSkies.meteorX[AceOfTheSkies.i] = AceOfTheSkies.processing.width + 30;
                            if (AceOfTheSkies.i == 0 || AceOfTheSkies.i == 4) {
                                AceOfTheSkies.meteorY[AceOfTheSkies.i] = AceOfTheSkies.processing.random(60, AceOfTheSkies.processing.height / 4 - 30);
                            } else if (AceOfTheSkies.i == 2) {
                                AceOfTheSkies.processing.random(60, AceOfTheSkies.processing.height / 2 - 30);
                            } else if (AceOfTheSkies.i == 1 || AceOfTheSkies.i == 5) {
                                AceOfTheSkies.processing.random(AceOfTheSkies.processing.height / 2 + AceOfTheSkies.processing.height / 4 + 30, AceOfTheSkies.processing.height - 60);
                            } else if (AceOfTheSkies.i == 3) {
                                AceOfTheSkies.processing.random(AceOfTheSkies.processing.height / 2 + 30, AceOfTheSkies.processing.height - 60);
                            }

                            AceOfTheSkies.meteorSize[AceOfTheSkies.i] = AceOfTheSkies.processing.random(30, 50);
                        }
                    }

                    for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.meteorTrailX.size(); AceOfTheSkies.i++) {
                        AceOfTheSkies.meteorTrailTransparency.set(AceOfTheSkies.i, AceOfTheSkies.meteorTrailTransparency.get(AceOfTheSkies.i) - 5);

                        if (AceOfTheSkies.meteorTrailTransparency.get(AceOfTheSkies.i) <= 0) {
                            AceOfTheSkies.meteorTrailX.remove(AceOfTheSkies.i);
                            AceOfTheSkies.meteorTrailY.remove(AceOfTheSkies.i);
                            AceOfTheSkies.meteorTrailSize.remove(AceOfTheSkies.i);
                            AceOfTheSkies.meteorTrailTransparency.remove(AceOfTheSkies.i);
                        }
                    }
                } else if (AceOfTheSkies.pScore < 600) {
                    if (AceOfTheSkies.meteorX[AceOfTheSkies.meteorX.length - 1] > AceOfTheSkies.meteorSize[AceOfTheSkies.meteorX.length - 1] / 2 * -1) {
                        for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.meteorX.length; AceOfTheSkies.i++) {
                            AceOfTheSkies.meteorX[AceOfTheSkies.i] -= 8;

                            AceOfTheSkies.meteorTrailX.add(AceOfTheSkies.meteorX[AceOfTheSkies.i]);
                            AceOfTheSkies.meteorTrailY.add(AceOfTheSkies.meteorY[AceOfTheSkies.i]);
                            AceOfTheSkies.meteorTrailSize.add(AceOfTheSkies.meteorSize[AceOfTheSkies.i]);
                            AceOfTheSkies.meteorTrailTransparency.add((float) 127.5);
                        }
                    }

                    if (AceOfTheSkies.meteorTrailX.size() > 0) {
                        for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.meteorTrailX.size(); AceOfTheSkies.i++) {
                            AceOfTheSkies.meteorTrailTransparency.set(AceOfTheSkies.i, AceOfTheSkies.meteorTrailTransparency.get(AceOfTheSkies.i) - 5);

                            if (AceOfTheSkies.meteorTrailTransparency.get(AceOfTheSkies.i) <= 0) {
                                AceOfTheSkies.meteorTrailX.remove(AceOfTheSkies.i);
                                AceOfTheSkies.meteorTrailY.remove(AceOfTheSkies.i);
                                AceOfTheSkies.meteorTrailSize.remove(AceOfTheSkies.i);
                                AceOfTheSkies.meteorTrailTransparency.remove(AceOfTheSkies.i);
                            }
                        }
                    }

                    if (AceOfTheSkies.pScore < 450) {
                        if (AceOfTheSkies.laserTime <= 240) {
                            AceOfTheSkies.laserTime++;

                            if (AceOfTheSkies.laserTime <= 120) {
                                AceOfTheSkies.laserPercent += 100.0 / 120.0;
                            } else if (AceOfTheSkies.laserTime <= 240) {
                                AceOfTheSkies.laserPercent -= 100.0 / 120.0;
                            }
                        } else if (AceOfTheSkies.laserTime == 241) {
                            AceOfTheSkies.laserTime = 0;

                            AceOfTheSkies.laserY[1] = AceOfTheSkies.processing.random(140, AceOfTheSkies.processing.height - 140);
                        }
                    } else if (AceOfTheSkies.pScore < 550) {
                        if (AceOfTheSkies.laserTime <= 210) {
                            AceOfTheSkies.laserTime++;

                            if (AceOfTheSkies.laserTime <= 90) {
                                AceOfTheSkies.laserPercent += 100.0 / 90.0;
                            } else if (AceOfTheSkies.laserTime <= 210) {
                                AceOfTheSkies.laserPercent -= 100.0 / 120.0;
                            }
                        } else if (AceOfTheSkies.laserTime == 211 || AceOfTheSkies.laserTime == 241) {
                            AceOfTheSkies.laserTime = 0;

                            AceOfTheSkies.laserY[1] = AceOfTheSkies.processing.random(140, AceOfTheSkies.processing.height - 140);
                        }
                    } else {
                        if (AceOfTheSkies.laserTime <= 180) {
                            AceOfTheSkies.laserTime++;

                            if (AceOfTheSkies.laserTime <= 60) {
                                AceOfTheSkies.laserPercent += 100.0 / 60.0;
                            } else if (AceOfTheSkies.laserTime <= 180) {
                                AceOfTheSkies.laserPercent -= 100.0 / 120.0;
                            }
                        } else if (AceOfTheSkies.laserTime == 181 || AceOfTheSkies.laserTime == 211) {
                            AceOfTheSkies.laserTime = 0;

                            AceOfTheSkies.laserY[1] = AceOfTheSkies.processing.random(140, AceOfTheSkies.processing.height - 140);
                        }
                    }
                } else if (AceOfTheSkies.pScore < 800) {
                    if (AceOfTheSkies.wallTimer == 0) {
                        AceOfTheSkies.wallX += AceOfTheSkies.wallSpeed;
                    } else {
                        if (AceOfTheSkies.wallTimer > 0) {
                            AceOfTheSkies.wallTimer--;

                            if (AceOfTheSkies.pScore < 650) {
                                AceOfTheSkies.wallX -= AceOfTheSkies.wallSpeed;
                            } else if (AceOfTheSkies.pScore < 750) {
                                AceOfTheSkies.wallX -= AceOfTheSkies.wallSpeed * 0.8;
                            } else {
                                AceOfTheSkies.wallX -= AceOfTheSkies.wallSpeed * 0.5;
                            }
                        }
                    }

                    for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.boostX.length; AceOfTheSkies.i++) {
                        AceOfTheSkies.boostX[AceOfTheSkies.i] -= AceOfTheSkies.boostSpeed;

                        if (AceOfTheSkies.boostX[AceOfTheSkies.i] + 20 < 0) {
                            AceOfTheSkies.boostX[AceOfTheSkies.i] = AceOfTheSkies.processing.width + 20;
                            AceOfTheSkies.boostPicked[AceOfTheSkies.i] = false;

                            if (AceOfTheSkies.i % 2 == 0) {
                                AceOfTheSkies.boostY[AceOfTheSkies.i] = AceOfTheSkies.processing.random(80, AceOfTheSkies.processing.height / 2 - 40);
                            } else {
                                AceOfTheSkies.boostY[AceOfTheSkies.i] = AceOfTheSkies.processing.random(AceOfTheSkies.processing.height / 2 + 40, AceOfTheSkies.processing.height - 80);
                            }
                        }
                    }
                } else if (AceOfTheSkies.pScore < 1000) {
                    // TODO: Boss fight

                    AceOfTheSkies.processing.fill(0);
                    AceOfTheSkies.processing.noStroke();


                }
            }
        } else if (AceOfTheSkies.gameState == 4) {
            for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.blockX.length; AceOfTheSkies.i++) {
                AceOfTheSkies.blockX[AceOfTheSkies.i] -= AceOfTheSkies.blockSpeed;

                if (AceOfTheSkies.blockX[AceOfTheSkies.i] <= -40) {
                    AceOfTheSkies.blockX[AceOfTheSkies.i] = AceOfTheSkies.processing.width / 2 + 1;

                    AceOfTheSkies.blockY1[AceOfTheSkies.i] = AceOfTheSkies.processing.random(0, AceOfTheSkies.processing.height / 2 + AceOfTheSkies.processing.height / 4);
                    AceOfTheSkies.blockY2[AceOfTheSkies.i] = AceOfTheSkies.blockY1[AceOfTheSkies.i] + AceOfTheSkies.processing.height / 4;
                }
            }
        } else if (AceOfTheSkies.gameState == 5) {

        }
    }

    void updateDifficulty() {
        if (AceOfTheSkies.gameState == 3) {
            if (AceOfTheSkies.pScore >= 50 && AceOfTheSkies.pScore < 150) {
                AceOfTheSkies.blockSpeed = 4;

                if (AceOfTheSkies.bgColor[1] > 120) AceOfTheSkies.bgColor[1]--;
            } else if (AceOfTheSkies.pScore >= 150 && AceOfTheSkies.pScore < 200) {
                AceOfTheSkies.blockSpeed = 5;

                if (AceOfTheSkies.bgColor[0] < 80) AceOfTheSkies.bgColor[0]++;
                if (AceOfTheSkies.bgColor[1] > 30) AceOfTheSkies.bgColor[1]--;
            } else if (AceOfTheSkies.pScore >= 200 && AceOfTheSkies.pScore < 250) {
                AceOfTheSkies.blockSpeed = 5;

                if (AceOfTheSkies.bgColor[0] > 30) AceOfTheSkies.bgColor[0]--;
                if (AceOfTheSkies.bgColor[1] < 160) AceOfTheSkies.bgColor[1]++;
            } else if (AceOfTheSkies.pScore >= 250 && AceOfTheSkies.pScore < 350) {
                AceOfTheSkies.blockSpeed = 6;

                if (AceOfTheSkies.bgColor[1] > 120) AceOfTheSkies.bgColor[1]--;
            } else if (AceOfTheSkies.pScore >= 350 && AceOfTheSkies.pScore < 400) {
                AceOfTheSkies.blockSpeed = 8;

                if (AceOfTheSkies.bgColor[0] < 80) AceOfTheSkies.bgColor[0]++;
                if (AceOfTheSkies.bgColor[1] > 30) AceOfTheSkies.bgColor[1]--;
            } else if (AceOfTheSkies.pScore >= 400 && AceOfTheSkies.pScore < 600) {
                AceOfTheSkies.blockSpeed = 0;

                if (AceOfTheSkies.pScore < 450) {
                    if (AceOfTheSkies.bgColor[0] > 30) AceOfTheSkies.bgColor[0]--;
                    if (AceOfTheSkies.bgColor[1] < 160) AceOfTheSkies.bgColor[1]++;
                } else if (AceOfTheSkies.pScore < 550) {
                    if (AceOfTheSkies.bgColor[1] > 120) AceOfTheSkies.bgColor[1]--;
                } else {
                    if (AceOfTheSkies.bgColor[0] < 80) AceOfTheSkies.bgColor[0]++;
                    if (AceOfTheSkies.bgColor[1] > 30) AceOfTheSkies.bgColor[1]--;
                }
            } else if (AceOfTheSkies.pScore >= 600 && AceOfTheSkies.pScore < 800) {
                AceOfTheSkies.blockSpeed = 0;

                if (AceOfTheSkies.pScore < 650) {
                    AceOfTheSkies.wallSpeed = (float) 0.6;
                    AceOfTheSkies.boostSpeed = 4;

                    if (AceOfTheSkies.bgColor[0] > 30) AceOfTheSkies.bgColor[0]--;
                    if (AceOfTheSkies.bgColor[1] < 160) AceOfTheSkies.bgColor[1]++;
                } else if (AceOfTheSkies.pScore < 750) {
                    AceOfTheSkies.wallSpeed = (float) 1.6;
                    AceOfTheSkies.boostSpeed = 5;

                    if (AceOfTheSkies.bgColor[1] > 120) AceOfTheSkies.bgColor[1]--;
                } else {
                    AceOfTheSkies.wallSpeed = (float) 2.8;
                    AceOfTheSkies.boostSpeed = 6;

                    if (AceOfTheSkies.bgColor[0] < 80) AceOfTheSkies.bgColor[0]++;
                    if (AceOfTheSkies.bgColor[1] > 30) AceOfTheSkies.bgColor[1]--;
                }
            } else if (AceOfTheSkies.pScore >= 800 && AceOfTheSkies.pScore < 1000) {
                AceOfTheSkies.blockSpeed = 0;
                AceOfTheSkies.wallSpeed = (float) 0.0;
                AceOfTheSkies.boostSpeed = 0;

                if (AceOfTheSkies.bgColor[0] > 30) AceOfTheSkies.bgColor[0]--;
                if (AceOfTheSkies.bgColor[1] < 160) AceOfTheSkies.bgColor[1]++;
            }
        }
    }

    void splitScreen() {
        if (AceOfTheSkies.gameState == 4) {
            AceOfTheSkies.processing.stroke(255);
            AceOfTheSkies.processing.noFill();
            AceOfTheSkies.processing.strokeWeight(5);

            AceOfTheSkies.processing.line(AceOfTheSkies.processing.width / 2, 0, AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height);

            AceOfTheSkies.processing.noStroke();
        }
    }

    void playMusic() {
        if (!AceOfTheSkies.audioPlayer.isPlaying()) {
            AceOfTheSkies.audioPlayer.loop();
        }
    }
}