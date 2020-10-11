package wozardstudios;

public class HomePage {
    HomePage() {
        AceOfTheSkies.startText = 1;
        AceOfTheSkies.startTextSpeed = 5;

        AceOfTheSkies.birdY = 251;
        AceOfTheSkies.birdSpeed = 3;
    }

    void fadeIn() {
        if (AceOfTheSkies.transparency > 0) {
            AceOfTheSkies.transparency -= 3;

            AceOfTheSkies.processing.rectMode(AceOfTheSkies.processing.CORNER);
            AceOfTheSkies.processing.fill(30, 161, 201, AceOfTheSkies.transparency);
            AceOfTheSkies.processing.noStroke();
            AceOfTheSkies.processing.rect(0, 0, AceOfTheSkies.processing.width, AceOfTheSkies.processing.height);
        }
    }

    void fadeOut() {
        if (AceOfTheSkies.transparency < 255) {
            AceOfTheSkies.transparency += 5;

            AceOfTheSkies.processing.fill(30, 161, 201, AceOfTheSkies.transparency);
        } else {
            AceOfTheSkies.gameState = 1;
            AceOfTheSkies.processing.fill(30, 161, 201);
        }
        AceOfTheSkies.processing.rectMode(AceOfTheSkies.processing.CORNER);
        AceOfTheSkies.processing.rect(0, 0, AceOfTheSkies.processing.width, AceOfTheSkies.processing.height);
    }

    void display() {
        AceOfTheSkies.processing.textAlign(AceOfTheSkies.processing.CENTER, AceOfTheSkies.processing.CENTER);
        AceOfTheSkies.processing.fill(255);
        AceOfTheSkies.processing.noStroke();

        AceOfTheSkies.processing.textSize(60);
        AceOfTheSkies.processing.text("ACE OF THE SKIES", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 - 250);

        AceOfTheSkies.processing.textSize(35);
        AceOfTheSkies.processing.text("Highscore: " + AceOfTheSkies.highScore, AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 - 150);

        AceOfTheSkies.processing.fill(255);
        AceOfTheSkies.processing.noStroke();

        AceOfTheSkies.processing.beginShape();
        AceOfTheSkies.processing.vertex(AceOfTheSkies.processing.width / 2 - 140, AceOfTheSkies.processing.height / 2 - 50);
        AceOfTheSkies.processing.vertex(AceOfTheSkies.processing.width / 2 - 40, AceOfTheSkies.processing.height / 2 + 50);
        AceOfTheSkies.processing.vertex(AceOfTheSkies.processing.width / 2 + 40, AceOfTheSkies.processing.height / 2 + 50);
        AceOfTheSkies.processing.vertex(AceOfTheSkies.processing.width / 2 + 100, AceOfTheSkies.processing.height / 2 - 30);
        AceOfTheSkies.processing.vertex(AceOfTheSkies.processing.width / 2 + 120, AceOfTheSkies.processing.height / 2 + 10);
        AceOfTheSkies.processing.vertex(AceOfTheSkies.processing.width / 2 + 110, AceOfTheSkies.processing.height / 2 - 40);
        AceOfTheSkies.processing.vertex(AceOfTheSkies.processing.width / 2 + 80, AceOfTheSkies.processing.height / 2 - 40);
        AceOfTheSkies.processing.vertex(AceOfTheSkies.processing.width / 2 + 40, AceOfTheSkies.processing.height / 2 + 20);
        AceOfTheSkies.processing.vertex(AceOfTheSkies.processing.width / 2, AceOfTheSkies.birdY);
        AceOfTheSkies.processing.vertex(AceOfTheSkies.processing.width / 2 - 40, AceOfTheSkies.processing.height / 2 + 20);
        AceOfTheSkies.processing.vertex(AceOfTheSkies.processing.width / 2 + 40, AceOfTheSkies.processing.height / 2 + 20);
        AceOfTheSkies.processing.vertex(AceOfTheSkies.processing.width / 2, AceOfTheSkies.birdY);
        AceOfTheSkies.processing.vertex(AceOfTheSkies.processing.width / 2 - 40, AceOfTheSkies.processing.height / 2 + 20);
        AceOfTheSkies.processing.vertex(AceOfTheSkies.processing.width / 2 - 140, AceOfTheSkies.processing.height / 2 - 50);
        AceOfTheSkies.processing.endShape();

        AceOfTheSkies.processing.stroke(0);
        AceOfTheSkies.processing.strokeWeight(1);
        AceOfTheSkies.processing.noFill();
        AceOfTheSkies.processing.line(AceOfTheSkies.processing.width / 2 + 40, AceOfTheSkies.processing.height / 2 + 20, AceOfTheSkies.processing.width / 2, AceOfTheSkies.birdY);
        AceOfTheSkies.processing.line(AceOfTheSkies.processing.width / 2 - 40, AceOfTheSkies.processing.height / 2 + 20, AceOfTheSkies.processing.width / 2, AceOfTheSkies.birdY);

        AceOfTheSkies.processing.noStroke();

        AceOfTheSkies.birdY += AceOfTheSkies.birdSpeed;
        if (AceOfTheSkies.birdY >= AceOfTheSkies.processing.height / 2 + 130) {
            AceOfTheSkies.birdSpeed = -3;
        } else if (AceOfTheSkies.birdY <= AceOfTheSkies.processing.height / 2 - 100) {
            AceOfTheSkies.birdSpeed = 3;
        }

        if (AceOfTheSkies.transparency == 0) {
            AceOfTheSkies.processing.fill(255, 255, 255, AceOfTheSkies.startText);
            AceOfTheSkies.processing.textSize(40);
            AceOfTheSkies.processing.noStroke();

            AceOfTheSkies.processing.text("Click to start", AceOfTheSkies.processing.width / 2, AceOfTheSkies.processing.height / 2 + 180);

            if (AceOfTheSkies.startText >= 255) {
                AceOfTheSkies.startTextSpeed = -5;
            } else if (AceOfTheSkies.startText <= 0) {
                AceOfTheSkies.startTextSpeed = 5;
            }

            AceOfTheSkies.startText += AceOfTheSkies.startTextSpeed;
        }
    }

    void click() {
        AceOfTheSkies.transitioning = true;
    }
}
