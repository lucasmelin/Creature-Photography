import random
import time

from actors import Human, Creature


def main():
    print_header()
    game_loop()


def print_header():
    print('-------------------')
    print(' PHOTOGRAPHY GAME')
    print('-------------------')
    print()


def game_loop():
    creatures = [
        Creature('Sloth', 1),
        Creature('Tree frog', 6),
        Creature('Chimpanzee', 20),
        Creature('Zebra', 45),
        Creature('Cheetah', 100),
    ]
    print(creatures)
    photographer = Human("Lucas", 80)

    while True:
        active_creature = random.choice(creatures)
        print('A {} with a speed of {} has emerged from the jungle...'.format(active_creature.name,
                                                                              active_creature.speed))

        action = input('Do you [p]hotograph, [r]un away, or [l]ook around?')
        if action == 'p':
            if photographer.photograph(active_creature):
                creatures.remove(active_creature)
            else:
                print("You've been spotted! You get up and move to a different position.")
                time.sleep(5)
                print("You settle in with your camera at the ready.")
        elif action == 'r':
            print('Run away')
        elif action == 'l':
            print("The photographer {} scans the area and spots:".format(photographer.name))
            for c in creatures:
                print(" * A {} with a speed of {}".format(c.name, c.speed))
        else:
            print("Exiting game")
            break


if __name__ == '__main__':
    main()
