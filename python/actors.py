#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
File name: actors.py
Author: Lucas Melin
Date created: Nov 15, 2018
Date last modified: Nov 20, 2018
Python version: 3.7

This file contains all the actors used in the photography game, such as the Creature
type and all its sub types.
"""
import random


class Creature:
    """
    Models a base Creature class which contains a name and speed.
    """
    def __init__(self, name, speed):
        """
        Default Creature initializer
        :param name: the creature's name
        :param speed: the speed of the creature
        """
        self.name = name
        self.speed = speed

    def __repr__(self):
        """
        Re-declares the method that will be called when invoking the `repr` function
        on a Creature object
        :return: a string representation of the creature's name and speed
        """
        return 'Creature {} with a speed of {}'.format(self.name, self.speed)

    def get_total_speed(self):
        """
        Multiplies the creature's speed by a random number from 1-20 inclusive
        :return: an integer representing the creature's total speed
        """
        return random.randint(1, 20) * self.speed


class Human(Creature):
    """
    Models a sub class Human which inherits from Creature.
    """
    def __init__(self, name, speed):
        # Directly invokes the base class (Creature) initializer. If this method
        # were omitted, this would be the default behaviour of the `__init__` method.
        super().__init__(name, speed)

    def photograph(self, creature):
        """
        Attempt to photograph the creature by comparing the human's shutter speed and the creature speed.
        :param creature: the creature to photograph
        :return: true if the picture was taken successfully, false otherwise
        """
        # We can refer to `self.name` without having to reference the base type first
        print("{} attempts to photograph {}".format(self.name, creature.name))

        # Calls the base type's `get_total_speed` method
        shutter_speed = self.get_total_speed()
        # Calls the `get_total_speed` method if present in the creature type's class, otherwise
        # will call the `get_total_speed` method in the Creature base type
        evasion_speed = creature.get_total_speed()

        print('You snap a picture with a speed of {}'.format(self.speed))
        print('{} runs away with a speed of {}'.format(creature.name, creature.speed))

        if shutter_speed >= evasion_speed:
            print('You check your camera, and you have a clear picture of the {}!'.format(creature.name))
            return True
        else:
            print('You check your camera, but the picture is blurry.')
            return False


class SmallAnimal(Creature):
    """
    Models a sub class SmallAnimal which inherits from Creature.
    """
    # Omitted the __init__ method, but the super class initializer
    # will still be called, the same as in the Human class

    def get_total_speed(self):
        """
        Re-declared the method `get_total_speed` inherited from `Creature` and returns
        the speed obtained from the base method, divided by 2, since smaller creatures
        cannot move as quickly.
        :return: the speed calculated from the base type divided by 2
        """
        base_speed = super().get_total_speed()
        return base_speed / 2


class CamouflagedAnimal(Creature):
    """
    Models a sub class CamouflagedAnimal which inherits from Creature.
    """
    def __init__(self, name, speed, camouflage_ability, active_camouflage):
        """
        Default constructor.
        :param name: the animal's name
        :param speed: the animal's speed
        :param camouflage_ability: the animal's natural ability to camouflage
        :param active_camouflage: indicates if the animal's camouflage is active or passive
        """
        # Invoke the base type (Creature) initializer
        super().__init__(name, speed)
        # Set the fields belonging to the sub class (CamouflagedAnimal)
        self.active_camouflage = active_camouflage
        self.camouflage_ability = camouflage_ability

    def get_total_speed(self):
        """
        Re-declares the method `get_total_speed` inherited from `Creature` and returns
        the speed obtained from the base method, multiplied by the camouflage bonus,
        since camouflaged animals are more difficult to spot and photograph.
        :return: the speed calculated from the base class multiplied by the camouflage bonus
        """
        # Get the total speed calculated from the Creature class
        base_speed = super().get_total_speed()
        # If the creature has active camouflage, add a x3 multiplier
        camouflage_modifier = 3 if self.active_camouflage else 1
        return base_speed * camouflage_modifier * self.camouflage_ability
