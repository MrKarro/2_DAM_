import pygame
from pygame.locals import *

# Inicializar pygame
pygame.init()

# Definir colores
BRONZE = (255, 167, 0)
BLACK = (0, 0, 0)

LIGHT_BROWN = (205, 133, 63)
RED = (255, 0, 0)


# Definir tamaño de la ventana
WIDTH = 800
HEIGHT = 600

# Crear ventana
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption('Tienda de Paquetes')

# Definir clases
class Button:
    def __init__(self, x, y, width, height, color, text=''):
        self.rect = pygame.Rect(x, y, width, height)
        self.color = color
        self.text = text

    def draw(self, screen):
        pygame.draw.rect(screen, self.color, self.rect)

        if self.text != '':
            font = pygame.font.Font(None, 36)
            text = font.render(self.text, 1, BLACK)
            screen.blit(text, (self.rect.x + 10, self.rect.y + 10))

class StoreInterface:
    def __init__(self):
        self.buttons = []
        self.buttons.append(Button(100, 100, 200, 50, LIGHT_BROWN, 'Pack 1 ($10)'))
        self.buttons.append(Button(100, 200, 200, 50, LIGHT_BROWN, 'Pack 2 ($20)'))
        self.buttons.append(Button(100, 300, 200, 50, LIGHT_BROWN, 'Pack 3 ($15)'))
        self.buttons.append(Button(100, 400, 200, 50, LIGHT_BROWN, 'Pack 4 ($25)'))
        self.exit_button = Button(WIDTH - 250, HEIGHT - 100, 200, 50, RED, 'Salir')

    def draw(self, screen):
        for button in self.buttons:
            button.draw(screen)
        self.exit_button.draw(screen)

# Crear interfaz
interface = StoreInterface()

# Bucle principal
running = True
while running:
    for event in pygame.event.get():
        if event.type == QUIT:
            running = False

    # Dibujar fondo
    screen.fill(BRONZE)

    # Dibujar interfaz
    interface.draw(screen)

    # Actualizar pantalla
    pygame.display.flip()

# Finalizar pygame
pygame.quit()
