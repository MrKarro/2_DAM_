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
BLUE = (0, 255, 255,  100)

# Set up the button class
class Button():
    def __init__(self, label, x, y, width, height, color=DARK_BROWN, text_color=BLUE):
        self.label = label
        self.x = x
        self.y = y
        self.width = width
        self.height = height
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
        return self.rect.collidepoint(pos)

# Function to create and add buttons
def create_buttons(num_rows, num_columns):
    buttons = []
    button_width = (700 - 50 * 2 - (num_columns - 1) * 10) // num_columns
    button_height = 40
    button_padding = 10
    start_x = 50
    start_y = 50

    for i in range(num_rows):
        for j in range(num_columns):
            x = start_x + j * (button_width + button_padding)
            y = start_y + i * (button_height + button_padding)
            label = f"Button {i * num_columns + j + 1}"
            buttons.append(Button(label, x, y, button_width, button_height))

    return buttons

# Set up the buttons
buttons = create_buttons(3, 4)
exit_button = Button("Salir", 650, 500, 100, 50)

# Set up the settings screen function
def settings_screen():
    screen.fill(LIGHT_BROWN)
    pygame.draw.rect(screen, DARK_BROWN, (50, 50, 700, 300))
    for button in buttons:
        button.draw(screen)
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
            for button in buttons:
                if button.check_click(pos):
                    print(f"Clicked: {button.label}")
                    # Add logic for button actions here
            if exit_button.check_click(pos):
                running = False

    screen.fill(LIGHT_BROWN)
    settings_screen()

# Quit Pygame
pygame.quit()
sys.exit()
