import pygame
import sys

# Initialize Pygame
pygame.init()

# Set up some constants
WIDTH, HEIGHT = 800, 600
FPS = 60

# Set up the game screen
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Settings Example")
clock = pygame.time.Clock()

# Colors
BRONZE = (255, 167, 0)
DARK_BROWN = (139, 69, 19)
LIGHT_BROWN = (205, 133, 63)
WHITE = (255, 255, 255)

# Set up the button class
class Button():
    def __init__(self, x, y, width, height, label, color=DARK_BROWN, text_color=WHITE):
        self.x = x
        self.y = y
        self.width = width
        self.height = height
        self.label = label
        self.color = color
        self.text_color = text_color
        self.font = pygame.font.Font(None, 24)
        self.rect = pygame.Rect(x, y, width, height)

    def draw(self, screen):
        pygame.draw.rect(screen, self.color, self.rect)
        label_surface = self.font.render(self.label, True, self.text_color)
        label_rect = label_surface.get_rect(center=self.rect.center)
        screen.blit(label_surface, label_rect)

    def check_click(self, pos):
        if self.rect.collidepoint(pos):
            return True
        return False

# Set up the buttons
difficulty_button = Button(50, 50, 150, 50, "Easy", color=BRONZE)
music_volume_button = Button(50, 120, 150, 50, "Music Volume", color=BRONZE)
sound_effects_volume_button = Button(50, 190, 150, 50, "Sound Effects Volume", color=BRONZE)
graphics_quality_button = Button(50, 260, 150, 50, "Graphics Quality", color=BRONZE)
controls_button = Button(50, 330, 150, 50, "Controls", color=BRONZE)
back_button = Button(50, 400, 150, 50, "Back", color=BRONZE)
exit_button = Button(WIDTH - 250, HEIGHT - 100, 200, 50, "Salir", color=BRONZE, text_color=(255, 0, 0))

# Set up the settings screen function
def settings_screen():
    screen.fill(LIGHT_BROWN)
    pygame.draw.rect(screen, DARK_BROWN, (50, 50, 700, 300))
    difficulty_button.draw(screen)
    music_volume_button.draw(screen)
    sound_effects_volume_button.draw(screen)
    graphics_quality_button.draw(screen)
    controls_button.draw(screen)
    back_button.draw(screen)
    exit_button.draw(screen)
    pygame.display.flip()

# Set up the game loop
running = True
while running:
    clock.tick(FPS)
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        elif event.type == pygame.MOUSEBUTTONDOWN:
            pos = pygame.mouse.get_pos()
            if difficulty_button.check_click(pos):
                difficulty += 1
                if difficulty > 3:difficulty = 1
            elif music_volume_button.check_click(pos):
                music_volume += 0.1
                if music_volume > 1:
                    music_volume = 0
            elif sound_effects_volume_button.check_click(pos):
                sound_effects_volume += 0.1
                if sound_effects_volume > 1:
                    sound_effects_volume = 0
            elif graphics_quality_button.check_click(pos):
                # Add code to change graphics quality
                pass
            elif controls_button.check_click(pos):
                # Add code to display controls menu
                pass
            elif back_button.check_click(pos):
                # Add code to go back to main menu
                pass
            elif exit_button.check_click(pos):
                running = False
    screen.fill(LIGHT_BROWN)
    settings_screen()

# Quit Pygame
pygame.quit()
sys.exit()