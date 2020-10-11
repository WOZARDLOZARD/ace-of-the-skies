package wozardstudios;

import java.util.ArrayList;

public class Player {
    Player() {
        AceOfTheSkies.pTrailX = new ArrayList<>();
        AceOfTheSkies.pTrailY = new ArrayList<>();
        AceOfTheSkies.pTrailWing = new ArrayList<>();
        AceOfTheSkies.pTrailTransparency = new ArrayList<>();
    }

    void display() {
        if (AceOfTheSkies.gameState == 3) {
            if (AceOfTheSkies.pAlive) {
                AceOfTheSkies.processing.noFill();
                AceOfTheSkies.processing.strokeWeight(4);

                for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.pTrailX.size(); AceOfTheSkies.i++) {
                    AceOfTheSkies.processing.stroke(255, 255, 255, AceOfTheSkies.pTrailTransparency.get(AceOfTheSkies.i));

                    AceOfTheSkies.processing.beginShape();
                    AceOfTheSkies.processing.vertex(AceOfTheSkies.pTrailX.get(AceOfTheSkies.i) - 50, AceOfTheSkies.pTrailY.get(AceOfTheSkies.i) - 30);
                    AceOfTheSkies.processing.vertex(AceOfTheSkies.pTrailX.get(AceOfTheSkies.i) - 20, AceOfTheSkies.pTrailY.get(AceOfTheSkies.i) + 30);
                    AceOfTheSkies.processing.vertex(AceOfTheSkies.pTrailX.get(AceOfTheSkies.i) + 20, AceOfTheSkies.pTrailY.get(AceOfTheSkies.i) + 30);
                    AceOfTheSkies.processing.vertex(AceOfTheSkies.pTrailX.get(AceOfTheSkies.i) + 30, AceOfTheSkies.pTrailY.get(AceOfTheSkies.i));
                    AceOfTheSkies.processing.vertex(AceOfTheSkies.pTrailX.get(AceOfTheSkies.i) + 50, AceOfTheSkies.pTrailY.get(AceOfTheSkies.i) + 20);
                    AceOfTheSkies.processing.vertex(AceOfTheSkies.pTrailX.get(AceOfTheSkies.i) + 30, AceOfTheSkies.pTrailY.get(AceOfTheSkies.i) - 30);
                    AceOfTheSkies.processing.vertex(AceOfTheSkies.pTrailX.get(AceOfTheSkies.i) + 20, AceOfTheSkies.pTrailY.get(AceOfTheSkies.i));
                    AceOfTheSkies.processing.vertex(AceOfTheSkies.pTrailX.get(AceOfTheSkies.i), AceOfTheSkies.pTrailY.get(AceOfTheSkies.i) - 40 + AceOfTheSkies.pTrailWing.get(AceOfTheSkies.i));
                    AceOfTheSkies.processing.vertex(AceOfTheSkies.pTrailX.get(AceOfTheSkies.i) - 20, AceOfTheSkies.pTrailY.get(AceOfTheSkies.i));
                    AceOfTheSkies.processing.vertex(AceOfTheSkies.pTrailX.get(AceOfTheSkies.i) + 20, AceOfTheSkies.pTrailY.get(AceOfTheSkies.i));
                    AceOfTheSkies.processing.vertex(AceOfTheSkies.pTrailX.get(AceOfTheSkies.i), AceOfTheSkies.pTrailY.get(AceOfTheSkies.i) - 40 + AceOfTheSkies.pTrailWing.get(AceOfTheSkies.i));
                    AceOfTheSkies.processing.vertex(AceOfTheSkies.pTrailX.get(AceOfTheSkies.i) - 20, AceOfTheSkies.pTrailY.get(AceOfTheSkies.i));
                    AceOfTheSkies.processing.endShape();
                }

                AceOfTheSkies.processing.fill(255);
                AceOfTheSkies.processing.noStroke();

                AceOfTheSkies.processing.beginShape();
                AceOfTheSkies.processing.vertex(AceOfTheSkies.pLocation.x - 50, AceOfTheSkies.pLocation.y - 30);
                AceOfTheSkies.processing.vertex(AceOfTheSkies.pLocation.x - 20, AceOfTheSkies.pLocation.y + 30);
                AceOfTheSkies.processing.vertex(AceOfTheSkies.pLocation.x + 20, AceOfTheSkies.pLocation.y + 30);
                AceOfTheSkies.processing.vertex(AceOfTheSkies.pLocation.x + 30, AceOfTheSkies.pLocation.y);
                AceOfTheSkies.processing.vertex(AceOfTheSkies.pLocation.x + 50, AceOfTheSkies.pLocation.y + 20);
                AceOfTheSkies.processing.vertex(AceOfTheSkies.pLocation.x + 30, AceOfTheSkies.pLocation.y - 30);
                AceOfTheSkies.processing.vertex(AceOfTheSkies.pLocation.x + 20, AceOfTheSkies.pLocation.y);
                AceOfTheSkies.processing.vertex(AceOfTheSkies.pLocation.x, AceOfTheSkies.pLocation.y - 40 + AceOfTheSkies.pWing);
                AceOfTheSkies.processing.vertex(AceOfTheSkies.pLocation.x - 20, AceOfTheSkies.pLocation.y);
                AceOfTheSkies.processing.vertex(AceOfTheSkies.pLocation.x + 20, AceOfTheSkies.pLocation.y);
                AceOfTheSkies.processing.vertex(AceOfTheSkies.pLocation.x, AceOfTheSkies.pLocation.y - 40 + AceOfTheSkies.pWing);
                AceOfTheSkies.processing.vertex(AceOfTheSkies.pLocation.x - 20, AceOfTheSkies.pLocation.y);
                AceOfTheSkies.processing.endShape();

                AceOfTheSkies.processing.stroke(0);
                AceOfTheSkies.processing.noFill();
                AceOfTheSkies.processing.strokeWeight(1);
                AceOfTheSkies.processing.line(AceOfTheSkies.pLocation.x - 20, AceOfTheSkies.pLocation.y, AceOfTheSkies.pLocation.x, AceOfTheSkies.pLocation.y - 40 + AceOfTheSkies.pWing);
                AceOfTheSkies.processing.line(AceOfTheSkies.pLocation.x + 20, AceOfTheSkies.pLocation.y, AceOfTheSkies.pLocation.x, AceOfTheSkies.pLocation.y - 40 + AceOfTheSkies.pWing);
            }
        } else if (AceOfTheSkies.gameState == 4) {
            AceOfTheSkies.processing.noStroke();

            AceOfTheSkies.processing.fill(255);

            AceOfTheSkies.processing.beginShape();
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p1Location.x - 50, AceOfTheSkies.p1Location.y - 30);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p1Location.x - 20, AceOfTheSkies.p1Location.y + 30);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p1Location.x + 20, AceOfTheSkies.p1Location.y + 30);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p1Location.x + 30, AceOfTheSkies.p1Location.y);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p1Location.x + 50, AceOfTheSkies.p1Location.y + 20);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p1Location.x + 30, AceOfTheSkies.p1Location.y - 30);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p1Location.x + 20, AceOfTheSkies.p1Location.y);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p1Location.x, AceOfTheSkies.p1Location.y - 45 + AceOfTheSkies.p1Wing);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p1Location.x - 20, AceOfTheSkies.p1Location.y);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p1Location.x + 20, AceOfTheSkies.p1Location.y);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p1Location.x, AceOfTheSkies.p1Location.y - 45 + AceOfTheSkies.p1Wing);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p1Location.x - 20, AceOfTheSkies.p1Location.y);
            AceOfTheSkies.processing.endShape();

            AceOfTheSkies.processing.fill(0);

            AceOfTheSkies.processing.beginShape();
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p2Location.x - 50, AceOfTheSkies.p2Location.y - 30);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p2Location.x - 20, AceOfTheSkies.p2Location.y + 30);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p2Location.x + 20, AceOfTheSkies.p2Location.y + 30);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p2Location.x + 30, AceOfTheSkies.p2Location.y);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p2Location.x + 50, AceOfTheSkies.p2Location.y + 20);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p2Location.x + 30, AceOfTheSkies.p2Location.y - 30);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p2Location.x + 20, AceOfTheSkies.p2Location.y);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p2Location.x, AceOfTheSkies.p2Location.y - 45 + AceOfTheSkies.p2Wing);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p2Location.x - 20, AceOfTheSkies.p2Location.y);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p2Location.x + 20, AceOfTheSkies.p2Location.y);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p2Location.x, AceOfTheSkies.p2Location.y - 45 + AceOfTheSkies.p2Wing);
            AceOfTheSkies.processing.vertex(AceOfTheSkies.p2Location.x - 20, AceOfTheSkies.p2Location.y);
            AceOfTheSkies.processing.endShape();
        }
    }

    void update() {
        if (AceOfTheSkies.gameState == 3) {
            if (AceOfTheSkies.pAlive) {
                if (AceOfTheSkies.gameStarted) {
                    physics();

                    if (AceOfTheSkies.mode == 1) {
                        if (isCollided()) {
                            AceOfTheSkies.pAlive = false;
                            AceOfTheSkies.gameStarted = false;
                            AceOfTheSkies.pExplode = 255;
                            AceOfTheSkies.gameState = 6;
                            AceOfTheSkies.audioPlayer.pause();

                            return;
                        }

                        updateVars();
                    }
                } else {
                    if (AceOfTheSkies.pWing >= 90) {
                        AceOfTheSkies.pWingSpeed = -2;
                    } else if (AceOfTheSkies.pWing <= 0) {
                        AceOfTheSkies.pWingSpeed = 2;
                    }

                    AceOfTheSkies.pWing += AceOfTheSkies.pWingSpeed;
                }

                playerEffects();
            }
        } else if (AceOfTheSkies.gameState == 4) {
            AceOfTheSkies.p1Location.add(AceOfTheSkies.gravity1);
            AceOfTheSkies.p2Location.add(AceOfTheSkies.gravity2);

            if (!AceOfTheSkies.p1Flapping) {
                AceOfTheSkies.p1Wing = 0;
            } else {
                if (AceOfTheSkies.p1Wing >= 100) {
                    AceOfTheSkies.p1WingSpeed = -5;
                } else if (AceOfTheSkies.p1Wing <= 0) {
                    AceOfTheSkies.p1Flapping = false;

                    AceOfTheSkies.p1WingSpeed = 0;
                }

                AceOfTheSkies.p1Wing += AceOfTheSkies.p1WingSpeed;
            }

            if (!AceOfTheSkies.p2Flapping) {
                AceOfTheSkies.p2Wing = 0;
            } else {
                if (AceOfTheSkies.p2Wing >= 100) {
                    AceOfTheSkies.p2WingSpeed = -5;
                } else if (AceOfTheSkies.p2Wing <= 0) {
                    AceOfTheSkies.p2Flapping = false;

                    AceOfTheSkies.p2WingSpeed = 0;
                }

                AceOfTheSkies.p2Wing += AceOfTheSkies.p2WingSpeed;
            }

            AceOfTheSkies.gravity1.y += 0.1;
            AceOfTheSkies.gravity2.y += 0.1;

            if (AceOfTheSkies.p1Velocity.y < 0) {
                AceOfTheSkies.p1Location.add(AceOfTheSkies.p1Velocity);
                AceOfTheSkies.p1Velocity.y += 0.5;
            }

            if (AceOfTheSkies.p2Velocity.y < 0) {
                AceOfTheSkies.p2Location.add(AceOfTheSkies.p2Velocity);
                AceOfTheSkies.p2Velocity.y += 0.5;
            }

            if (AceOfTheSkies.p1Location.y + 20 > AceOfTheSkies.processing.height) {
                AceOfTheSkies.p1Location.y = AceOfTheSkies.processing.height - 21;
            } else if (AceOfTheSkies.p1Location.y - 20 < 0) {
                AceOfTheSkies.p1Location.y = 21;
            }

            if (AceOfTheSkies.p2Location.y + 30 > AceOfTheSkies.processing.height) {
                AceOfTheSkies.p2Location.y = AceOfTheSkies.processing.height - 31;
            } else if (AceOfTheSkies.p2Location.y - 30 < 0) {
                AceOfTheSkies.p2Location.y = 31;
            }
        }
    }

    void jump() {
        if (AceOfTheSkies.gameState == 3) {
            if (AceOfTheSkies.pAlive) {
                AceOfTheSkies.pVelocity.y = (float) -15.5;
                AceOfTheSkies.gravity.y = 5;

                AceOfTheSkies.pJumping = true;
                AceOfTheSkies.pWing = 1;
                AceOfTheSkies.pWingSpeed = 5;

                AceOfTheSkies.pJumps++;

                if (!AceOfTheSkies.gameStarted) {
                    AceOfTheSkies.blockSpeed = 3;

                    AceOfTheSkies.gameStarted = true;
                }
            }
        } else if (AceOfTheSkies.gameState == 4) {
            if (AceOfTheSkies.processing.key == 'w' || AceOfTheSkies.processing.key == 'W') {
                AceOfTheSkies.p1Velocity.y = -15;
                AceOfTheSkies.gravity1.y = 3;

                AceOfTheSkies.p1Jumping = true;
                AceOfTheSkies.p1Flapping = true;
                AceOfTheSkies.p1Wing = 1;
                AceOfTheSkies.p1WingSpeed = 5;
            } else if (AceOfTheSkies.processing.keyCode == AceOfTheSkies.processing.UP) {
                AceOfTheSkies.p2Velocity.y = -15;
                AceOfTheSkies.gravity2.y = 3;

                AceOfTheSkies.p2Jumping = true;
                AceOfTheSkies.p2Flapping = true;
                AceOfTheSkies.p2Wing = 1;
                AceOfTheSkies.p2WingSpeed = 5;
            }
        }
    }

    void physics() {
        AceOfTheSkies.pLocation.add(AceOfTheSkies.gravity);
        AceOfTheSkies.gravity.y += 0.1;

        if (AceOfTheSkies.pWing > 0) {
            if (AceOfTheSkies.pWing >= 90) {
                AceOfTheSkies.pWingSpeed = -5;
            }

            AceOfTheSkies.pWing += AceOfTheSkies.pWingSpeed;
        } else if (AceOfTheSkies.pWing <= 0) {
            AceOfTheSkies.pWing = 0;
            AceOfTheSkies.pWingSpeed = 0;
        }

        if (AceOfTheSkies.pVelocity.y < 0) {
            AceOfTheSkies.pLocation.add(AceOfTheSkies.pVelocity);
            AceOfTheSkies.pVelocity.y += 0.5;
        }

        if (AceOfTheSkies.pLocation.y + 20 > AceOfTheSkies.processing.height) {
            AceOfTheSkies.pLocation.y = AceOfTheSkies.processing.height - 21;
        } else if (AceOfTheSkies.pLocation.y - 20 < 0) {
            AceOfTheSkies.pLocation.y = 21;
            AceOfTheSkies.pVelocity.y = 0;
        }
    }

    boolean isCollided() {
        if (AceOfTheSkies.pScore < 200) {
            return AceOfTheSkies.pLocation.x + 40 > AceOfTheSkies.blockX[AceOfTheSkies.blockIndex] && AceOfTheSkies.pLocation.x - 45 < AceOfTheSkies.blockX[AceOfTheSkies.blockIndex] + 20 && AceOfTheSkies.pLocation.y - 30 < AceOfTheSkies.blockY1[AceOfTheSkies.blockIndex] || AceOfTheSkies.pLocation.x + 40 > AceOfTheSkies.blockX[AceOfTheSkies.blockIndex] && AceOfTheSkies.pLocation.x - 45 < AceOfTheSkies.blockX[AceOfTheSkies.blockIndex] + 20 && AceOfTheSkies.pLocation.y + 30 > AceOfTheSkies.blockY2[AceOfTheSkies.blockIndex];
        } else if (AceOfTheSkies.pScore < 400) {
            return AceOfTheSkies.pLocation.x + 40 > AceOfTheSkies.meteorX[AceOfTheSkies.meteorIndex] - AceOfTheSkies.meteorSize[AceOfTheSkies.meteorIndex] / 2 && AceOfTheSkies.pLocation.x - 45 < AceOfTheSkies.meteorX[AceOfTheSkies.meteorIndex] + AceOfTheSkies.meteorSize[AceOfTheSkies.meteorIndex] / 2 && AceOfTheSkies.pLocation.y - 30 < AceOfTheSkies.meteorY[AceOfTheSkies.meteorIndex] + AceOfTheSkies.meteorSize[AceOfTheSkies.meteorIndex] / 2 && AceOfTheSkies.pLocation.y + 30 > AceOfTheSkies.meteorY[AceOfTheSkies.meteorIndex] - AceOfTheSkies.meteorSize[AceOfTheSkies.meteorIndex] / 2;
        } else if (AceOfTheSkies.pScore < 600) {
            if (AceOfTheSkies.pScore < 450) {
                return AceOfTheSkies.pLocation.y - 30 < AceOfTheSkies.laserY[0] + 35 && AceOfTheSkies.pLocation.y + 30 > AceOfTheSkies.laserY[0] - 35 && AceOfTheSkies.laserTime >= 120 && AceOfTheSkies.laserTime < 241 || AceOfTheSkies.pLocation.y - 30 < AceOfTheSkies.laserY[1] + 45 && AceOfTheSkies.pLocation.y + 30 > AceOfTheSkies.laserY[1] - 45 && AceOfTheSkies.laserTime >= 120 && AceOfTheSkies.laserTime < 241 || AceOfTheSkies.pLocation.y - 30 < AceOfTheSkies.laserY[2] + 35 && AceOfTheSkies.pLocation.y + 30 > AceOfTheSkies.laserY[2] - 35 && AceOfTheSkies.laserTime >= 120 && AceOfTheSkies.laserTime < 241;
            } else if (AceOfTheSkies.pScore < 550) {
                return AceOfTheSkies.pLocation.y - 30 < AceOfTheSkies.laserY[0] + 35 && AceOfTheSkies.pLocation.y + 30 > AceOfTheSkies.laserY[0] - 35 && AceOfTheSkies.laserTime >= 90 && AceOfTheSkies.laserTime < 211 || AceOfTheSkies.pLocation.y - 30 < AceOfTheSkies.laserY[1] + 45 && AceOfTheSkies.pLocation.y + 30 > AceOfTheSkies.laserY[1] - 45 && AceOfTheSkies.laserTime >= 90 && AceOfTheSkies.laserTime < 211 || AceOfTheSkies.pLocation.y - 30 < AceOfTheSkies.laserY[2] + 35 && AceOfTheSkies.pLocation.y + 30 > AceOfTheSkies.laserY[2] - 35 && AceOfTheSkies.laserTime >= 90 && AceOfTheSkies.laserTime < 211;
            } else {
                return AceOfTheSkies.pLocation.y - 30 < AceOfTheSkies.laserY[0] + 35 && AceOfTheSkies.pLocation.y + 30 > AceOfTheSkies.laserY[0] - 35 && AceOfTheSkies.laserTime >= 60 && AceOfTheSkies.laserTime < 181 || AceOfTheSkies.pLocation.y - 30 < AceOfTheSkies.laserY[1] + 45 && AceOfTheSkies.pLocation.y + 30 > AceOfTheSkies.laserY[1] - 45 && AceOfTheSkies.laserTime >= 60 && AceOfTheSkies.laserTime < 181 || AceOfTheSkies.pLocation.y - 30 < AceOfTheSkies.laserY[2] + 35 && AceOfTheSkies.pLocation.y + 30 > AceOfTheSkies.laserY[2] - 35 && AceOfTheSkies.laserTime >= 60 && AceOfTheSkies.laserTime < 181;
            }
        }

        return false;
    }

    void updateVars() {
        if (AceOfTheSkies.pScore < 200) {
            if (!isCollided() && AceOfTheSkies.pLocation.x - 45 > AceOfTheSkies.blockX[AceOfTheSkies.blockIndex] + 20) {
                if (AceOfTheSkies.blockIndex < AceOfTheSkies.blockX.length - 1) {
                    AceOfTheSkies.blockIndex++;
                } else {
                    AceOfTheSkies.blockIndex = 0;
                }

                if (AceOfTheSkies.blockSpeed > 0 && AceOfTheSkies.blockSpeed < 5) {
                    AceOfTheSkies.pScore += 10;
                } else if (AceOfTheSkies.blockSpeed >= 5) {
                    AceOfTheSkies.pScore += 2;
                }
            }
        } else if (AceOfTheSkies.pScore < 400) {
            if (!isCollided() && AceOfTheSkies.pLocation.x - 45 > AceOfTheSkies.meteorX[AceOfTheSkies.meteorIndex] + AceOfTheSkies.meteorSize[AceOfTheSkies.meteorIndex] / 2) {
                if (AceOfTheSkies.meteorIndex < AceOfTheSkies.meteorX.length - 1) {
                    AceOfTheSkies.meteorIndex++;
                } else {
                    AceOfTheSkies.meteorIndex = 0;
                }

                if (AceOfTheSkies.blockSpeed > 0 && AceOfTheSkies.blockSpeed < 8) {
                    AceOfTheSkies.pScore += 10;
                } else if (AceOfTheSkies.blockSpeed >= 8) {
                    AceOfTheSkies.pScore += 2;
                }
            }
        } else if (AceOfTheSkies.pScore < 600) {
            if (AceOfTheSkies.pScore < 450) {
                if (!isCollided() && AceOfTheSkies.laserTime == 241) {
                    AceOfTheSkies.pScore += 10;
                }
            } else if (AceOfTheSkies.pScore < 550) {
                if (!isCollided() && AceOfTheSkies.laserTime == 211) {
                    AceOfTheSkies.pScore += 10;
                }
            } else {
                if (!isCollided() && AceOfTheSkies.laserTime == 181) {
                    AceOfTheSkies.pScore += 10;
                }
            }
        } else if (AceOfTheSkies.pScore < 800) {
            if (AceOfTheSkies.pLocation.x - 45 < AceOfTheSkies.wallX) {
                AceOfTheSkies.pAlive = false;
                AceOfTheSkies.gameStarted = false;
                AceOfTheSkies.pExplode = 255;
                AceOfTheSkies.gameState = 6;

                AceOfTheSkies.audioPlayer.pause();
            }

            if (AceOfTheSkies.pLocation.x + 40 > AceOfTheSkies.boostX[AceOfTheSkies.boostIndex] - 20 && AceOfTheSkies.pLocation.x - 45 < AceOfTheSkies.boostX[AceOfTheSkies.boostIndex] + 20 && AceOfTheSkies.pLocation.y - 30 < AceOfTheSkies.boostY[AceOfTheSkies.boostIndex] + 20 && AceOfTheSkies.pLocation.y + 30 > AceOfTheSkies.boostY[AceOfTheSkies.boostIndex] && !AceOfTheSkies.boostPicked[AceOfTheSkies.boostIndex]) {
                AceOfTheSkies.boostPicked[AceOfTheSkies.boostIndex] = true;
                AceOfTheSkies.wallTimer = 60;

                AceOfTheSkies.pScore += 10;

                if (AceOfTheSkies.boostIndex < AceOfTheSkies.boostX.length - 1) {
                    AceOfTheSkies.boostIndex++;
                } else {
                    AceOfTheSkies.boostIndex = 0;
                }
            } else if (AceOfTheSkies.pLocation.x - 45 > AceOfTheSkies.boostX[AceOfTheSkies.boostIndex] + 20) {
                AceOfTheSkies.pScore += 10;

                if (AceOfTheSkies.boostIndex < AceOfTheSkies.boostX.length - 1) {
                    AceOfTheSkies.boostIndex++;
                } else {
                    AceOfTheSkies.boostIndex = 0;
                }
            }
        }
    }

    void playerEffects() {
        AceOfTheSkies.pTrailX.add(AceOfTheSkies.pLocation.x);
        AceOfTheSkies.pTrailY.add(AceOfTheSkies.pLocation.y);
        AceOfTheSkies.pTrailWing.add(AceOfTheSkies.pWing);
        AceOfTheSkies.pTrailTransparency.add((float) 127.5);

        for (AceOfTheSkies.i = 0; AceOfTheSkies.i < AceOfTheSkies.pTrailY.size(); AceOfTheSkies.i++) {
            AceOfTheSkies.pTrailX.set(AceOfTheSkies.i, AceOfTheSkies.pTrailX.get(AceOfTheSkies.i) - 3);
            AceOfTheSkies.pTrailTransparency.set(AceOfTheSkies.i, AceOfTheSkies.pTrailTransparency.get(AceOfTheSkies.i) - 8);

            if (AceOfTheSkies.pTrailTransparency.get(AceOfTheSkies.i) <= 0) {
                AceOfTheSkies.pTrailX.remove(AceOfTheSkies.i);
                AceOfTheSkies.pTrailY.remove(AceOfTheSkies.i);
                AceOfTheSkies.pTrailWing.remove(AceOfTheSkies.i);
                AceOfTheSkies.pTrailTransparency.remove(AceOfTheSkies.i);
            }
        }
    }
}
