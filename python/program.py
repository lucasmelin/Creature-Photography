#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
File name: program.py
Author: Lucas Melin
Date created: Nov 15, 2018
Date last modified: Nov 20, 2018
Python version: 3.7

This file contains the photography game logic that drives the application.
"""
import random
import time

from actors import Human, Creature, SmallAnimal, CamouflagedAnimal


def main():
    """
    Entry-point to the program. Calls the header to print, then enters the game loop.
    :return:
    """
    print_header()
    game_loop()


def print_header():
    """
    Prints the game header to the console.
    Ascii camera adapted from hjw. https://asciiart.website/index.php?art=objects/cameras
    """
    print('--------------------------')
    print("      LUCAS MELIN'S")
    print(' JUNGLE PHOTOGRAPHY GAME')
    print('--------------------------')
    print('        .---.')
    print('        |[0]|')
    print(' _.==._.""""".___n__')
    print("d __ ___.-''-. _____b")
    print('|[__]  /."""".\ _   |')
    print('|     // /""\ \\\_)  |')
    print('|     \\\ \__/ //    |')
    print("|      \`.__.'/     |")
    print("\=======`-..-'======/")
    print(" `-----------------' ")
    print('--------------------------')
    print()


def game_loop():
    """
    Receives input from the command line to determine which action to take. Once all the
    creatures have been successfully photographed, exits the game loop.
    """

    # This list contains all the creatures to photograph
    creatures = [
        # Base type object
        Creature('Sloth', 1),
        # Sub type object
        SmallAnimal('Tree frog', 6),
        Creature('Chimpanzee', 20),
        CamouflagedAnimal('Zebra', 45, 2, False),
        CamouflagedAnimal('Cheetah', 100, 6, False),
        CamouflagedAnimal("Chameleon", 2, 10, True)
    ]
    # Humans also inherit from the base type Creature
    photographer = Human("Lucas", 80)

    while True:
        # Randomly choose the active creature from the creatures left in the List
        active_creature = random.choice(creatures)
        # Print the creature's information using inherited fields name and speed
        print('A {} with a speed of {} has emerged from the jungle...'.format(active_creature.name,
                                                                              active_creature.speed))

        # Prompt the user to select an action to take
        action = input('Do you [p]hotograph, [r]eposition, or [l]ook around?')
        if action == 'p':
            if photographer.photograph(active_creature):
                # Taking a picture succeeded, remove that creature from the list
                creatures.remove(active_creature)
            else:
                # Taking a picture failed, sleep for 5 seconds before prompting the user again
                print("You've been spotted! You get up and move to a different position.")
                time.sleep(5)
                print("You settle in with your camera at the ready.")
        elif action == 'r':
            # Print a repositioning message and loop again
            print("You're not sure you can get a clear picture, so you get up and reposition yourself.")
        elif action == 'l':
            # Print everything still present in the creatures list
            print("The photographer {} scans the area and spots:".format(photographer.name))
            for c in creatures:
                print(" * A {} with a speed of {}".format(c.name, c.speed))
        else:
            # If something else is entered, assume the user wants to quit
            print("Exiting game")
            break

        if not creatures:
            # All creatures have been photographed and removed from the List. The game has been won.
            print("You've photographed all the creatures! Congratulations!")
            break


if __name__ == '__main__':
    # If invoked directly, call the entry-point to the application
    main()
